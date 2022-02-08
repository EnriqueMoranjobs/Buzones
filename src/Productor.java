import java.util.ArrayList;

public class Productor extends Thread {
    BufferMonitor monitor;
    private int numCartas;
    private int numeroVecinos;
    private int posicionVecino;

    public Productor(BufferMonitor monitor, int numeroVecinos) {
        this.monitor = monitor;
        this.numeroVecinos = numeroVecinos;


    }


    public void run() {
        while (true) {
            numCartas = (int) (Math.random() * 3);
            monitor.put(numCartas);
        }


    }
}
