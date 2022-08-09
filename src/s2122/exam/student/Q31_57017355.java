/*==============================================================================

Student Name: ZHU Xinyu
Student ID: 57017355

================================================================================

(a) to (d) Complete the functions in this template according to the instructions.

- You should NOT modify any other parts of this template, except importing classes.
- You should NOT use any external libraries other than the JDK.
- You should catch all checked exceptions by yourself.

================================================================================

(e) Write down your answer in the blank space below:

65,535 bytes


A UDP packet can be as large as approximately 64k. So if you want to send a file that is larger than that you can fragment yourself into packets of 64k. That is the theoretical maximum.
A solution to use fragments of smaller chunks of 500 bytes.
IP is responsible for fragmentation and reassembly of the packets if you do use 64k packets. Smaller packets of 500 bytes are not likely to be fragmented because the mtu is usually around 1500 bytes. If you use larger packets that are fragmented, IP is going to drop them if one of those fragments is lost.






================================================================================

(f) Write down your answer in the blank space below:

In short, it can be defined as a servlet is a Java program that runs on a web server and acts as an intermediate layer between requests from HTTP clients and a database or application on the HTTP server. A JSP, on the other hand, is just a text document that contains two types of text: predefined static text and dynamic text that is rendered after a server response is received.

// Servlet
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class JavaTester extends HttpServlet {
   private String message;
   public void init() throws ServletException {
      // Do required initialization
      message = "Hello World";
   }
   public void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
      // Set response content type
      response.setContentType("text/html");
      // Actual logic goes here.
      PrintWriter out = response.getWriter();
      out.println(message);
   }
}

// Jsp
<html>
<head><title>First JSP</title></head>
<body>
  <%
    double num = Math.random();
    if (num > 0.95) {
  %>
      <h2>You'll have a luck day!</h2><p>(<%= num %>)</p>
  <%
    } else {
  %>
      <h2>Well, life goes on ... </h2><p>(<%= num %>)</p>
  <%
    }
  %>
  <a href="<%= request.getRequestURI() %>"><h3>Try Again</h3></a>
</body>
</html>






==============================================================================*/
package s2122.exam.student;

import java.io.*;
import java.net.*;
import java.util.*;

public class Q31_57017355 {

    // A driver function
    public static void main(String[] args) {

        // Create a list of Student objects
        System.out.println("=== Creating a student list: ===");
        List<Student> students = createList();
        System.out.println(students.size() + " students have been created.");

        System.out.println("");

        double[] coefficients = linearRegression(students);
        System.out.println("=== Linear Regression for All students ===");
        System.out.printf("∑x = %.0f\n", coefficients[0]);
        System.out.printf("∑y = %.0f\n", coefficients[1]);
        System.out.printf("∑x² = %.0f\n", coefficients[2]);
        System.out.printf("∑xy = %.0f\n", coefficients[3]);
        System.out.printf("Intercept a = %.3f\n", coefficients[4]);
        System.out.printf("Slope b = %.3f\n", coefficients[5]);
        System.out.println("");

        Map<String, Double[]> map = linearRegressionByGroup(students);
        System.out.println("=== Linear Regression for Boys only===");
        System.out.printf("Slope b = %.3f\n", map.get("male")[5]);
        System.out.println("");

        System.out.println("=== Linear Regression for Girls only ===");
        System.out.printf("Intercept a = %.3f\n", map.get("female")[4]);
        System.out.printf("Slope b = %.3f\n", map.get("female")[5]);
    }

    // Q31 (a)
    public static List<Student> createList() {
        List<Student> studentArrayList = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("StudentsPerformance.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(",");
            studentArrayList.add(new Student(split[0].toLowerCase(), Integer.parseInt(split[5]), Integer.parseInt(split[6]), Integer.parseInt(split[7])));
        }
        return studentArrayList;
    }

    // Q31 (b)
    public static double[] linearRegression(List<Student> list) {
        double sigmaX = 0.0;
        double sigmaY = 0.0;
        double sigmaX2 = 0.0;
        double sigmaXY = 0.0;
        double intercept = 0.0;
        double slope = 0.0;
        for (Student entry : list) {
            sigmaX += entry.reading();
            sigmaY += entry.writing();
            sigmaX2 += Math.pow(entry.reading(), 2);
            sigmaXY += entry.reading() * entry.writing();
        }
        intercept = (sigmaY * sigmaX2 - sigmaX * sigmaXY) / (list.size() * sigmaX2 - Math.pow(sigmaX, 2));
        slope = (list.size() * sigmaXY - sigmaX * sigmaY) / (list.size() * sigmaX2 - Math.pow(sigmaX, 2));
        return new double[]{sigmaX, sigmaY, sigmaX2, sigmaXY, intercept, slope};


//        double sigmaX = 0.0;
//        double sigmaY = 0.0;
//        double sigmaX2 = 0.0;
//        double sigmaXY = 0.0;
//        int n = list.size();
//
//        for (Student stu: list) {
//            double x = stu.reading();
//            double y = stu.writing();
//            sigmaX += x;
//            sigmaY += y;
//            sigmaX2 += (x*x);
//            sigmaXY += (x*y);
//        }
//
//        double a = 0.0;
//        double b = (n*sigmaXY-sigmaX*sigmaXY)/(n*sigmaX2-sigmaX*sigmaX);
//
//        double tmp1 = 0.0;
//        double tmp2 = 0.0;
//        for (Student stu: list) {
//            double x = stu.reading();
//            double y = stu.writing();
//            tmp1 += y*sigmaX2;
//            tmp2 += x*sigmaXY;
//        }
//        a = (tmp1-tmp2)/(n*sigmaX2-sigmaX*sigmaX);
//
//        return new double[]{sigmaX, sigmaY, sigmaX2, sigmaXY, a, b};
    }

    // Q31 (c)
    public static Map<String, Double[]> linearRegressionByGroup(List<Student> list) {

        List<Student> boysList = new ArrayList<>();
        List<Student> girlsList = new ArrayList<>();
        for (Student entry : list)
            if (entry.gender().equals("male"))
                boysList.add(entry);
            else
                girlsList.add(entry);
        HashMap<String, Double[]> map = new HashMap<>();
        Double[] maleRegression = new Double[linearRegression(boysList).length];
        Double[] femaleRegression = new Double[linearRegression(girlsList).length];
        for (int i = 0; i < linearRegression(boysList).length; i++)
            maleRegression[i] = linearRegression(boysList)[i];
        for (int i = 0; i < linearRegression(girlsList).length; i++)
            femaleRegression[i] = linearRegression(girlsList)[i];
        map.put("male", maleRegression);
        map.put("female", femaleRegression);
        return map;
//        List<Student> maleList = new ArrayList<>();
//        List<Student> femaleList = new ArrayList<>();
//        for (Student stu: list) {
//            String gender = stu.gender();
//            if (gender.equals("male")) {
//                maleList.add(stu);
//            } else {
//                femaleList.add(stu);
//            }
//        }
//        Map<String, Double[]> ans = new HashMap<>();
//        double[] maleArr = linearRegression(maleList);
//        double[] femaleArr = linearRegression(femaleList);
//        Double[] maleArrD = new Double[6];
//        Double[] femaleArrD = new Double[6];
//        for (int i=0; i<6; i++) {
//            maleArrD[i] = maleArr[i];
//            femaleArrD[i] = femaleArr[i];
//        }
//        ans.put("male", maleArrD);
//        ans.put("female", femaleArrD);
//        return ans;
    }

    // Q31 (d)
    public static void send(List<Student> list) {
        try {
            try (DatagramSocket datagramSocket = new DatagramSocket()) {
                InetAddress address = InetAddress.getByName("127.0.0.1");
                for (Student entry : list) {
                    byte[] bytes = null;
                    bytes = entry.toBytes();
                    DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, address, 55500);
                    datagramSocket.send(datagramPacket);
                    datagramSocket.close();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        DatagramSocket ds = null;
//        try {
//            ds = new DatagramSocket(8888);
//            for (Student stu : list) {
//                byte[] buf = stu.toBytes();
//                DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 5555);
//                ds.send(dp);
//                ds.close();
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    //==========================================================================

    /**
     * This immutable class represent a student from the CSV file. DO NOT modify
     * this class.
     */
    public static class Student {

        private final String gender;        // gender
        private final int math;             // math score
        private final int reading;          // reading score
        private final int writing;          // writing score

        public Student(String gender, int math, int reading, int writing) {
            this.gender = gender;
            this.math = math;
            this.reading = reading;
            this.writing = writing;
        }

        public String gender() {
            return gender;
        }

        public int math() {
            return math;
        }

        public int reading() {
            return reading;
        }

        public int writing() {
            return writing;
        }

        public byte[] toBytes() throws IOException {
            try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutputStream out = new ObjectOutputStream(bos)) {
                out.writeObject(this);
                out.flush();
                return bos.toByteArray();
            }
        }
    }
}
