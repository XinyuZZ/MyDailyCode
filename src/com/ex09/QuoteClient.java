<<<<<<< HEAD
package com.ex09;

/*
 * QuoteClient.java
 *
 * Created on January 5, 2008, 11:16 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author vanting
 */
import java.io.*;
import java.net.*;

public class QuoteClient {
    public static void main(String[] args) throws IOException {
        
        if (args.length != 1) {
            System.out.println("Usage: java QuoteClient <hostname>");
            System.out.println("Default to 'localhost'");
            System.out.println("===================================");
            args = new String[] {"localhost"};
        }
        
        // get a datagram socket
        DatagramSocket socket = new DatagramSocket();
        
        // send request
        byte[] buf = new byte[256];
        InetAddress address = InetAddress.getByName(args[0]);
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
        socket.send(packet);
        
        // get response
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        
        // display response
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Packet Length: " + packet.getLength());
        System.out.println("Quote of the Moment: " + received);
        
        socket.close();
    }
=======
package com.ex09;

/*
 * QuoteClient.java
 *
 * Created on January 5, 2008, 11:16 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author vanting
 */
import java.io.*;
import java.net.*;

public class QuoteClient {
    public static void main(String[] args) throws IOException {
        
        if (args.length != 1) {
            System.out.println("Usage: java QuoteClient <hostname>");
            System.out.println("Default to 'localhost'");
            System.out.println("===================================");
            args = new String[] {"localhost"};
        }
        
        // get a datagram socket
        DatagramSocket socket = new DatagramSocket();
        
        // send request
        byte[] buf = new byte[256];
        InetAddress address = InetAddress.getByName(args[0]);
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
        socket.send(packet);
        
        // get response
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        
        // display response
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Packet Length: " + packet.getLength());
        System.out.println("Quote of the Moment: " + received);
        
        socket.close();
    }
>>>>>>> 13eedf8f55122829bb6e261a489d63bcd721fa8e
}