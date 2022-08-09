package s11;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Multi-threaded server program that multiplies matrices using fork-join
 * framework.
 *
 * @author vanting, ZHU Xinyu
 */
public class Server57017355 implements Runnable {

    private Socket socket;

    public Server57017355() {
    }

    public Server57017355(Socket socket) {
        this.socket = socket;
    }

    /**
     * Driver function. Start this server at port 33333.
     */
    public static void main(String[] args) throws IOException {
        start(33333);
    }

    /**
     * Start matrix server at the specified port. It should accept and handle
     * multiple client requests concurrently.
     *
     * @param port port number listened by the server
     */
    public static void start(int port) throws IOException {

        // your implementation here
        
        Executor pool = Executors.newCachedThreadPool();
        try (ServerSocket serverSocket = new ServerSocket(port)){
            Server57017355 action = new Server57017355(serverSocket.accept());
            pool.execute(action);
            
        } catch (IOException e) {
            Logger.getLogger(Server57017355.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    /**
     * Handle a matrix client request. It reads two matrices from socket,
     * compute their product, and then send the product matrix back to the
     * client.
     */
    @Override
    public void run() {

        try {
            // your implementation here

            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            try {
                Matrix matA = (Matrix) in.readObject();
                Matrix matB = (Matrix) in.readObject();

                Matrix product = multiThreadMultiply(matA, matB);

                out.writeObject(product);

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Server57017355.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(Server57017355.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Compute A x B using fork-join framework.
     *
     * @param matA matrix A
     * @param matB matrix B
     * @return the matrix product of AxB
     */
    public static Matrix multiThreadMultiply(Matrix matA, Matrix matB) {

        Matrix product = null;
        long[][] result = new long[matA.row()][matB.col()];
        // your implementation here
        RecursiveAction task = new ParallelMultiply(matA, matB, result);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
        product = new Matrix(result);
        return product;
    }
}

/**
 * Design a recursive and resultless ForkJoinTask. It splits the matrix
 * multiplication into multiple tasks to be executed in parallel.
 *
 */
class ParallelMultiply extends RecursiveAction {

    // your implementation here
    private Matrix matA;
    private Matrix matB;
    private int row;
    private int col;
    private long[][] c;

    public ParallelMultiply(Matrix a, Matrix b, long[][] c) {
        this.matA = a;
        this.matB = b;
        this.c = c;
        this.row = matA.row();
        this.col = matB.col();
    }

    @Override
    public void compute() {
        ArrayList<RecursiveAction> tasks = new ArrayList<RecursiveAction>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                tasks.add(new MultiplyOneRow(i, j));
            }
        }

        invokeAll(tasks);

    }

    public class MultiplyOneRow extends RecursiveAction {

        int i;
        int j;

        public MultiplyOneRow(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public void compute() {
            c[i][j] = 0;
            int num = matA.col();
            for (int k = 0; k < num; k++) {
                c[i][j] += matA.at(i, k) * matB.at(k, j);
            }
        }

    }
}
