/*

This client program is for testing your server implementation only.
DO NOT submit this class.

*/

package s2122.test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * A client program that calls a server to encode text messages using RLE.
 */
public class RLEClient { 
    
    public static void main(String[] args) throws IOException {
        
        String original = "BWWWWWWWWWWBWBBBBBBBWBWW";
        String compressed = encodeByServer(original);
        System.out.println("Original string: " + original);
        System.out.println("Compressed string: " + compressed);
    }   
    
    public static String encodeByServer(String original) {
        
        String compressed = "";
        // the server runs locally
        try (
                Socket socket = new Socket("127.0.0.1", 55500);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println(original);
            compressed = in.readLine();
            
        } catch (UnknownHostException e) {
            System.err.println("Don't know about this server.");
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to server.");
        } 
        return compressed;
    }
}
