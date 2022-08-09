package com.lab09;

/**
 *
 * @author vanting
 */
import java.io.*;
import java.net.*;

public class BasicHttpRequest {

    public static final String HOST = "www.cityu.edu.hk";
    public static final String CRLF = "\r\n";
    
    public static void main(String[] args) throws IOException {

        Socket socket = null;
        PrintWriter out = null, fileOut = null;;
        BufferedReader in = null;
        
        // Step 1
        try {
            socket = new Socket(HOST, 80);
            //echoSocket.setSoTimeout(3000);
            out = new PrintWriter(socket.getOutputStream(), true);
            fileOut = new PrintWriter(new File("index.html"));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about this server.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to server.");
            System.exit(1);
        }

        // Step 2
        String request = "GET / HTTP/1.1" + CRLF
                + "Host: " + HOST + CRLF
                + "Connection: close" + CRLF 
                + CRLF;
        
        out.println(request);
        if (out.checkError()) {
            System.out.println("Connection closed by server.");
            System.exit(1);
        }
        
        // Step 3
        String response;
        boolean startOfBody = false;
        while ((response = in.readLine()) != null) {
            System.out.println(response);
            if(startOfBody)
                fileOut.println(response);   // use this branch to redirect the output to a file 
            if(response.isEmpty())           // ""
                startOfBody = true;
        }

        socket.close();
    }
}