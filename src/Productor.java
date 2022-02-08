import java.util.ArrayList;

public class Productor extends Thread {
    BufferMonitor monitor;
    private int numCartas;
    private int numeroVecinos;
    private static int posicionVecino;

    public Productor(BufferMonitor monitor, int numeroVecinos) {
        this.monitor = monitor;
        this.numeroVecinos = numeroVecinos;


    }


    public void run() {
        while (true) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            numCartas = (int) (Math.random() * 3);
            int posicionVecino = posVeci(numeroVecinos);
            monitor.put(numCartas, posicionVecino);
        }


    }

    public static int posVeci(int numeroVecinos) {
        posicionVecino = (int) (Math.random() * numeroVecinos);
        return posicionVecino;
    }
}
