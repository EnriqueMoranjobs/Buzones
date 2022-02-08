import java.util.ArrayList;

public class Consumidor extends Thread {
    ArrayList<Integer> arrayList;
    BufferMonitor monitor;
    int numeroVecinos;
    int posicionVecino;


    Consumidor(BufferMonitor monitor, int numeroVecinos) {
        this.monitor = monitor;
        this.numeroVecinos = numeroVecinos;

    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(350);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int posicionVecino = Productor.posVeci(numeroVecinos);
            monitor.get(numeroVecinos, posicionVecino);
        }
    }
}

