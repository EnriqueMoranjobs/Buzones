import java.util.ArrayList;

public class Consumidor extends Thread {
    ArrayList<Integer> arrayList;
    BufferMonitor monitor;
    int posicionVecinos;


    Consumidor(BufferMonitor monitor ) {
        this.monitor = monitor;

    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            monitor.get(posicionVecinos);

        }
    }
}

