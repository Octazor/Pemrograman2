package Modul1;

import java.util.Scanner;

public class PRAK101_2310817310005_MuhammadNurwahyudiAdhitama {
    public static void main(String[] args) {
        
        String[] namaBulan = {
            "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Nama Lengkap: ");
        String Nama = scanner.nextLine();
        System.out.print("Masukkan Tempat Lahir: ");
        String tempat = scanner.nextLine();
        System.out.print("Masukkan Tanggal Lahir: ");
        int date = scanner.nextInt();
        System.out.print("Masukkan Bulan lahir: ");
        int nomorBulan = scanner.nextInt();
        System.out.print("Masukkan Tahun lahir: ");
        int tahun = scanner.nextInt();
        System.out.print("Masukkan Tinggi Badan: ");
        int height = scanner.nextInt();
        System.out.print("Masukkan Berat Badan: ");
        double weight = scanner.nextDouble();
        
        String output = String.format(
                "Nama Lengkap: %s, Lahir di %s pada Tanggal %d %s %d, Tinggi Badan: %d cm dan Berat Badan: %.2f kg", 
                Nama, tempat, date, namaBulan[nomorBulan - 1], tahun, height, weight);
        System.out.print(output);
        scanner.close();
    }
}