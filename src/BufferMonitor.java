import java.util.ArrayList;

public class BufferMonitor {
    ArrayList<Integer> buzones = new ArrayList<>();
    int numVecinos;
    int posicionVecino;


    BufferMonitor(int numVecinos) {
        this.numVecinos = numVecinos;
        for (int i = 0; i < numVecinos + 1; i++) {
            buzones.add(0);
        }

    }

    public synchronized void put(int numeroCartas) {
        while (buzones.get(generaPos(posicionVecino)) == 3) {
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
        System.out.println("cartas" + buzones);
        notifyAll();
    }

    public synchronized void get(int posicionVecino) {
        while (buzones.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buzones.set(posicionVecino, 0);
        System.out.println("El vecino" + posicionVecino + "... abre y lee" + buzones.get(posicionVecino));
        System.out.println("Buzon" + buzones.size());
        System.out.println("cartas" + buzones);
        notifyAll();

    }

    public int generaPos(int numVecinos) {
        int posVeci = (int) Math.random() * numVecinos + 1;
        return posVeci;
    }

}
