import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroVecinos;

        System.out.println("Introduce cuantos vecinos tiene la comunidad");
        numeroVecinos = sc.nextInt();
        System.out.println("A continuacion se generaran las posiciones de los vecinos....");


        BufferMonitor monitor = new BufferMonitor(numeroVecinos);
        Productor p1 = new Productor(monitor, numeroVecinos);
        p1.start();

        for (int i = 0; i < numeroVecinos; i++) {
            new Consumidor(monitor, numeroVecinos).start();
        }
    }

}

