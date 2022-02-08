import java.util.ArrayList;

public class BufferMonitor {
    ArrayList<Integer> buzones = new ArrayList<>();
    int numVecinos;

    BufferMonitor(int numVecinos) {
        this.numVecinos = numVecinos;
        for (int i = 0; i < numVecinos + 1; i++) {
            buzones.add(0);
        }
    }

    public synchronized void put(int numeroCartas, int posicionVecino) {
        while (buzones.get(posicionVecino)==3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("cartas" + buzones);
        System.out.println("Cartero reparte...");
        buzones.set(posicionVecino, buzones.get(posicionVecino) + numeroCartas);
        System.out.println("Deja..." + numeroCartas + "....cartas para..." + " El vecino..." + posicionVecino);
        notifyAll();
    }

    public synchronized void get(int numVecinos, int posicionVecino) {
        while (buzones.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(buzones);
        System.out.println("El vecino " + posicionVecino + "... abre y lee " + buzones.get(posicionVecino));
        buzones.set(posicionVecino, 0);
        notifyAll();
    }



}
