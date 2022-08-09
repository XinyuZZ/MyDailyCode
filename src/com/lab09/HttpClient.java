package com.lab09;

/**
 *
 * @author vanting
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class HttpClient {

    public static final String CRLF = "\r\n";

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private Scanner stdin;
    private String host = "nginx.org";
    private int port = 80;
    private Thread output;

    public static void main(String[] args) {

        HttpClient client = new HttpClient(System.in);
        System.out.println("Start of HTTP session:");
        while (true) {
            try {
                client.parseCommand();
            } catch (UnknownHostException e) {
                System.err.println("Don't know about this server.");
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection to server.");
                System.exit(1);
            }
        }
    }

    //---------------------------------------------------------------------
    public HttpClient(InputStream cmdSource) {
        stdin = new Scanner(cmdSource);
    }

    public void connect() throws IOException {
        socket = new Socket(host, port);
        //socket.connect(new InetSocketAddress(host, port));
        socket.setKeepAlive(true);
        //socket.setSoTimeout(0);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output();
        System.out.println("Connected.");
    }

    // Send a line
    public void send(String line) {
        out.print(line.trim());
        out.print(CRLF);
    }

    // End a HTTP request
    public void end() {
        out.print(CRLF);
        out.flush();
    }

    // Make a GET HTTP request for the path
    public void get(String path) {
        send("GET " + path + " HTTP/1.1");
        send("Host: " + host);
        end();
    }

    public void close() throws IOException {
        send("Connection: close");
        end();
        socket.close();     // will also close associated streams
        output.interrupt(); // stop the output thread
    }

    public void read() throws IOException {
        String temp = null;

        // readLine() returns null if reaching EOF e.g. connection closed by server
        while ((temp = in.readLine()) != null) {
            System.out.println(temp);
        }
    }

    public void parseCommand() throws IOException {
        String[] cmd = stdin.nextLine().split("\\s");

        switch (cmd[0]) {

            case "connect":

                if (cmd.length > 1) {
                    host = cmd[1];
                }
                if (cmd.length > 2) {
                    port = Integer.parseInt(cmd[2]);
                }

                connect();
                break;

            case "get":
                if (cmd.length > 1)
                    get(cmd[1]);
                break;

            case "close":
                close();
                break;

            case "quit":
                System.exit(0);

            default:
                System.out.println("The command is not known.");

        }
    }

    public void output() {
        output = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // wait for connection
                    while (!socket.isConnected()) {
                        Thread.sleep(1000);
                    }
                    System.out.println("Output is ON.");
                    read();
                } catch (IOException ex) {
                    System.out.println(ex);
                } catch (InterruptedException ex) {
                    System.out.println("Output is OFF.");
                } finally {
                    System.out.println("Connection is closed.");
                }
            }
        });
        output.start();
    }

}
