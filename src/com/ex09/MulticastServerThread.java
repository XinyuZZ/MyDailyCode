<<<<<<< HEAD
package com.ex09;

/*
 * MulticastServerThread.java
 *
 * Created on January 6, 2018, 12:07 AM
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
import java.util.*;

public class MulticastServerThread extends QuoteServerThread {
    
    private long FIVE_SECONDS = 5000;
    
    public MulticastServerThread() throws IOException {
        super("MulticastServerThread");
    }
    
    public void run() {
        while (moreQuotes) {
            try {
                byte[] buf = new byte[256];
                
                // construct quote
                String dString = null;
                if (in == null)
                    dString = new Date().toString();
                else
                    dString = getNextQuote();
                buf = dString.getBytes();
                
                // send it
                InetAddress group = InetAddress.getByName("230.0.0.1");
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
                socket.send(packet);
                
                // sleep for a while
                try {
                    sleep((long)(Math.random() * FIVE_SECONDS));
                } catch (InterruptedException e) { }
            } catch (IOException e) {
                e.printStackTrace();
                moreQuotes = false;
            }
        }
        socket.close();
    }
}
=======
package com.ex09;

/*
 * MulticastServerThread.java
 *
 * Created on January 6, 2018, 12:07 AM
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
import java.util.*;

public class MulticastServerThread extends QuoteServerThread {
    
    private long FIVE_SECONDS = 5000;
    
    public MulticastServerThread() throws IOException {
        super("MulticastServerThread");
    }
    
    public void run() {
        while (moreQuotes) {
            try {
                byte[] buf = new byte[256];
                
                // construct quote
                String dString = null;
                if (in == null)
                    dString = new Date().toString();
                else
                    dString = getNextQuote();
                buf = dString.getBytes();
                
                // send it
                InetAddress group = InetAddress.getByName("230.0.0.1");
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
                socket.send(packet);
                
                // sleep for a while
                try {
                    sleep((long)(Math.random() * FIVE_SECONDS));
                } catch (InterruptedException e) { }
            } catch (IOException e) {
                e.printStackTrace();
                moreQuotes = false;
            }
        }
        socket.close();
    }
}
>>>>>>> 13eedf8f55122829bb6e261a489d63bcd721fa8e
