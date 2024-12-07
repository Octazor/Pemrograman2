package soal1;

import java.util.Scanner;

public class HewanPeliharaan {
    private String nama;
    private String ras;

    public HewanPeliharaan(String n, String r) {
        this.nama = n;
        this.ras = r;
    }

    public void display() {
    	System.out.println("");
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah : " + nama);
        System.out.println("Dengan ras : " + ras);
    }

    public static HewanPeliharaan inputHewanPeliharaan() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nama hewan peliharaan: ");
        String nama = scanner.nextLine();

        System.out.print("Ras: ");
        String ras = scanner.nextLine();

        return new HewanPeliharaan(nama, ras);
    }
}
