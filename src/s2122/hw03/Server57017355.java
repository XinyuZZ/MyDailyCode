package s2122.hw03;

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
 * @author vanting
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
    public static void main(String[] args) {
        start(33333);
    }

    /**
     * Start matrix server at the specified port. It should accept and handle
     * multiple client requests concurrently.
     *
     * @param port port number listened by the server
     */
    public static void start(int port) {

        Executor pool = Executors.newCachedThreadPool();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
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
            Matrix result ;

            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            Matrix matA = (Matrix) in.readObject();
            Matrix matB = (Matrix) in.readObject();
            result = multiThreadMultiply(matA, matB);

            if (result != null) {
                out.writeObject(result);
            }

        } catch (IOException e) {
            Logger.getLogger(Client57017355.class.getName()).log(Level.SEVERE, "IO exception", e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(Client57017355.class.getName()).log(Level.SEVERE, "Matrix class not found", e);
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
        RecursiveAction task = new ParallelMultiply(matA, matB, result);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
        product = new Matrix(result);
        return product;
    }
}

/**
 * Design a recursive and resultless ForkJoinTask. It splits the matrix multiplication
 * into multiple tasks to be executed in parallel.
 */
class ParallelMultiply extends RecursiveAction {
    Matrix matA;
    Matrix matB;
    long[][] result;


    public ParallelMultiply(Matrix matA, Matrix matB, long[][] result) {
        this.matA = matA;
        this.matB = matB;
        this.result = result;
    }


    @Override
    protected void compute() {
        ArrayList<RecursiveAction> tasks = new ArrayList<>();
        for (int i = 0; i < matA.row(); i++)
            for (int j = 0; j < matB.col(); j++)
                tasks.add(new MultiplyOneRow(i, j));

        invokeAll(tasks);
    }

    class MultiplyOneRow extends RecursiveAction {
        int i;
        int j;

        private MultiplyOneRow(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        protected void compute() {
            result[i][j] = 0;
            for (int k = 0; k < matA.col(); k++)
                result[i][j] = matA.at(i, k) * matB.at(k, j);
        }
    }

}
