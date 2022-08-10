<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ex08;

/**
 *
 * @author vanting
 */
public class StringBufferVsStringBuilder {

    public static void main(String[] args) {
        int N = 77777777;
        long t;

        {
            // thread safe
            StringBuffer sb = new StringBuffer();
            t = System.currentTimeMillis();
            for (int i = N; i-- > 0;) {
                sb.append("");
            }
            System.out.print("Time used by StringBuffer (thread-safe): ");
            System.out.println(System.currentTimeMillis() - t);
        }

        {
            // not thread safe
            StringBuilder sb = new StringBuilder();
            t = System.currentTimeMillis();
            for (int i = N; i-- > 0;) {
                sb.append("");
            }
            System.out.print("Time used by StringBuilder: ");
            System.out.println(System.currentTimeMillis() - t);
        }
    }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ex08;

/**
 *
 * @author vanting
 */
public class StringBufferVsStringBuilder {

    public static void main(String[] args) {
        int N = 77777777;
        long t;

        {
            // thread safe
            StringBuffer sb = new StringBuffer();
            t = System.currentTimeMillis();
            for (int i = N; i-- > 0;) {
                sb.append("");
            }
            System.out.print("Time used by StringBuffer (thread-safe): ");
            System.out.println(System.currentTimeMillis() - t);
        }

        {
            // not thread safe
            StringBuilder sb = new StringBuilder();
            t = System.currentTimeMillis();
            for (int i = N; i-- > 0;) {
                sb.append("");
            }
            System.out.print("Time used by StringBuilder: ");
            System.out.println(System.currentTimeMillis() - t);
        }
    }
}
>>>>>>> 13eedf8f55122829bb6e261a489d63bcd721fa8e
