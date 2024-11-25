package soal2;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Scanner;

class Atri {
    private String nama;
    private String jenisKepemimpinan;
    private String namaPemimpin;
    private int tanggalKemerdekaan;
    private int bulanKemerdekaan;
    private int tahunKemerdekaan;

    // Constructor
    public Atri(String nama, String jenisKepemimpinan, String namaPemimpin, int tanggal, int bulan, int tahun) {
        this.nama = nama;
        this.jenisKepemimpinan = jenisKepemimpinan;
        this.namaPemimpin = namaPemimpin;
        this.tanggalKemerdekaan = tanggal;
        this.bulanKemerdekaan = bulan;
        this.tahunKemerdekaan = tahun;
    }

    public Atri(String nama, String jenisKepemimpinan, String namaPemimpin) {
        this.nama = nama;
        this.jenisKepemimpinan = jenisKepemimpinan;
        this.namaPemimpin = namaPemimpin;
        this.tanggalKemerdekaan = 0; // Tidak ada tanggal kemerdekaan untuk monarki
        this.bulanKemerdekaan = 0;
        this.tahunKemerdekaan = 0;
    }

    public void tampilkanDetail(HashMap<Integer, String> daftarBulan) {
        if (jenisKepemimpinan.equalsIgnoreCase("monarki")) {
            System.out.println("Negara " + nama + " mempunyai Raja bernama " + namaPemimpin);
        } else {
            String namaBulan = daftarBulan.get(bulanKemerdekaan);
            System.out.println("Negara " + nama + " mempunyai " + jenisKepemimpinan + " bernama " + namaPemimpin);
            System.out.println("Deklarasi Kemerdekaan pada Tanggal " + tanggalKemerdekaan + " " + namaBulan + " " + tahunKemerdekaan);
        }
    }
}

public class Negara {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Daftar nama bulan menggunakan HashMap
        HashMap<Integer, String> daftarBulan = new HashMap<>();
        daftarBulan.put(1, "Januari");
        daftarBulan.put(2, "Februari");
        daftarBulan.put(3, "Maret");
        daftarBulan.put(4, "April");
        daftarBulan.put(5, "Mei");
        daftarBulan.put(6, "Juni");
        daftarBulan.put(7, "Juli");
        daftarBulan.put(8, "Agustus");
        daftarBulan.put(9, "September");
        daftarBulan.put(10, "Oktober");
        daftarBulan.put(11, "November");
        daftarBulan.put(12, "Desember");

        // List untuk menyimpan objek negara
        LinkedList<Atri> daftarNegara = new LinkedList<>();

        // Input jumlah negara
        System.out.print(" ");
        int jumlahNegara = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Input data negara
        for (int i = 0; i < jumlahNegara; i++) {
            System.out.println(" ");
            System.out.print(" ");
            String nama = sc.nextLine();
            System.out.print(" ");
            String jenisKepemimpinan = sc.nextLine();
            System.out.print(" ");
            String namaPemimpin = sc.nextLine();

            if (jenisKepemimpinan.equalsIgnoreCase("monarki")) {
                // Untuk monarki, tidak ada input tanggal kemerdekaan
                daftarNegara.add(new Atri(nama, jenisKepemimpinan, namaPemimpin));
            } else {
                // Untuk selain monarki, input tanggal kemerdekaan
                System.out.print(" ");
                int tanggal = sc.nextInt();
                System.out.print(" ");
                int bulan = sc.nextInt();
                System.out.print(" ");
                int tahun = sc.nextInt();
                sc.nextLine(); // Consume newline
                daftarNegara.add(new Atri(nama, jenisKepemimpinan, namaPemimpin, tanggal, bulan, tahun));
            }
        }

        // Output data negara
        System.out.println(" ");
        for (Atri negara : daftarNegara) {
            negara.tampilkanDetail(daftarBulan);
            System.out.println();
        }

        sc.close();
    }
}
