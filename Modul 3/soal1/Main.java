package soal1;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main (String[] Args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Dice> koleksiDadu = new LinkedList<>();

        System.out.print(" ");
        int jumlahDadu = scanner.nextInt();

        int totalnilai = 0;

        for(int i = 0; i < jumlahDadu; i++) {
            Dice dice = new Dice();
            koleksiDadu.add(dice);
            System.out.println("Dadu ke-" + (i+1) + " bernilai " + dice.getNilai());
            totalnilai += dice.getNilai();
        }

        System.out.println("Total nilai dadu keseluruhan " + totalnilai);

        scanner.close();
    }
}
