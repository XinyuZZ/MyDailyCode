<<<<<<< HEAD
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ex09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author vanting
 */
public class ClientSocket  {

    public static void main(String[] args) throws IOException {
        
        Socket s = new Socket("localhost", 33333);
        //Socket s = new Socket(args[0], Integer.parseInt(args[1]));

        BufferedReader in;
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String str = null;
        while ((str = in.readLine()) != null) {
            System.out.println(str);
        }
    }
}
=======
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ex09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author vanting
 */
public class ClientSocket  {

    public static void main(String[] args) throws IOException {
        
        Socket s = new Socket("localhost", 33333);
        //Socket s = new Socket(args[0], Integer.parseInt(args[1]));

        BufferedReader in;
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String str = null;
        while ((str = in.readLine()) != null) {
            System.out.println(str);
        }
    }
}
>>>>>>> 13eedf8f55122829bb6e261a489d63bcd721fa8e
