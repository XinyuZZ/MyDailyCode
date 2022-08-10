<<<<<<< HEAD
package com.ex09;

/*
 * KKMultiServer.java
 *
 * Created on January 3, 2008, 7:53 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author vanting
 */
import java.net.*;
import java.io.*;

public class EchoMultiServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean listening = true;

        try {
            serverSocket = new ServerSocket(33333);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 33333.");
            System.exit(-1);
        }

        while (listening)
	    new EchoMultiServerThread(serverSocket.accept()).start();

        serverSocket.close();
    }
=======
package com.ex09;

/*
 * KKMultiServer.java
 *
 * Created on January 3, 2008, 7:53 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author vanting
 */
import java.net.*;
import java.io.*;

public class EchoMultiServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean listening = true;

        try {
            serverSocket = new ServerSocket(33333);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 33333.");
            System.exit(-1);
        }

        while (listening)
	    new EchoMultiServerThread(serverSocket.accept()).start();

        serverSocket.close();
    }
>>>>>>> 13eedf8f55122829bb6e261a489d63bcd721fa8e
}