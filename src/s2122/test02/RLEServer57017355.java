/*
 * Student Name:
 * Student ID:
 */
package s2122.test02;

// import packages as needed


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A multi-thread server program that encodes text message using RLE.
 */
class RLEServer57017355 implements Runnable {
    private Socket socket;

    public RLEServer57017355(Socket socket) {
        this.socket = socket;
    }
//    private Socket socket;
//
//    RLEServer57017355(Socket socket) {
//        this.socket = socket;
//    }


    /**
     * This method opens a server socket and listen at port 55500. It passes
     * each incoming connection to a separated thread to run, so that
     * multiple client requests can be handled concurrently.
     */
    public static void main(String[] args) {
        ExecutorService POOL = Executors.newCachedThreadPool();

        try (ServerSocket serverSocket = new ServerSocket(55500)) {
            while (true) {
                POOL.execute(new RLEServer57017355(serverSocket.accept()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        ExecutorService POOL = Executors.newCachedThreadPool();
//
//        ServerSocket serverSocket;
//        while (true) {
//            try {
//                serverSocket = new ServerSocket(55500);
//                POOL.execute(new RLEServer57017355(serverSocket.accept()));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//        }


    }

    /**
     * This method processes the original text message in each client request, encodes it and
     * sends the compressed text back to the client.
     */
    @Override
    public void run() {

        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println(encode(in.readLine()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        try {
//            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            String input = in.readLine();
//            out.println(encode(input));
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


    }

    /**
     * Encode the original message using Run-Length Encoding (RLE).
     *
     * @param original the original message sent by the client
     * @return the RLE-encoded message
     */
    public static String encode(String original) {
        StringBuffer buffer = new StringBuffer();
        char[] charArray = original.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            buffer.append(charArray[i]);
            boolean bo = true;
            int count = 1;
            while (bo) {
                if (i < charArray.length - 1 && charArray[i] == charArray[i + 1]) {
                    i++;
                    count++;
                } else {
                    bo = false;
                }
            }
            if (count > 1){
                buffer.append(charArray[i]);
                buffer.append(count);
            }
        }
        return buffer.toString();



//        String compressed = new String();
//        char[] charArray = original.toCharArray();
//        char before = 0;
//
//        int num = 0;
//        int i = 0;
//
//        for (char c : charArray) {
//            if (c != before && i != 0) {
//                if (num >= 2) {
//                    compressed += before;
//                    compressed += before;
//                    compressed += num;
//                } else {
//                    compressed += before;
//                }
//                num = 1;
//            } else {
//                num++;
//            }
//            before = c;
//            i++;
//        }
//        if (num >= 2) {
//            compressed += before;
//            compressed += before;
//            compressed += num;
//        } else {
//            compressed += before;
//        }
//        return compressed;


    }
}
