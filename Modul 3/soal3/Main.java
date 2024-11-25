package soal3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
            System.out.println("3. Cari Mahasiswa berdasarkan NIM");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            int pilihan = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (pilihan) {
                case 1: // Tambah Mahasiswa
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = sc.nextLine();
                    System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
                    String nim = sc.nextLine();
                    daftarMahasiswa.add(new Mahasiswa(nama, nim));
                    System.out.println("Mahasiswa berhasil ditambahkan.");
                    break;

                case 2: // Hapus Mahasiswa
                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                    String nimHapus = sc.nextLine();
                    boolean ditemukan = false;

                    for (int i = 0; i < daftarMahasiswa.size(); i++) {
                        if (daftarMahasiswa.get(i).getNim().equals(nimHapus)) {
                            daftarMahasiswa.remove(i);
                            System.out.println("Mahasiswa dengan NIM " + nimHapus + " dihapus.");
                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Mahasiswa dengan NIM " + nimHapus + " tidak ditemukan.");
                    }
                    break;

                case 3: // Cari Mahasiswa
                    System.out.print("Masukkan NIM Mahasiswa yang dicari: ");
                    String nimCari = sc.nextLine();
                    ditemukan = false;

                    for (Mahasiswa mhs : daftarMahasiswa) {
                        if (mhs.getNim().equals(nimCari)) {
                            System.out.println("Mahasiswa ditemukan:");
                            System.out.println("Nama: " + mhs.getNama());
                            System.out.println("NIM: " + mhs.getNim());
                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Mahasiswa dengan NIM " + nimCari + " tidak ditemukan.");
                    }
                    break;

                case 4: // Tampilkan Daftar Mahasiswa
                    if (daftarMahasiswa.isEmpty()) {
                        System.out.println("Daftar mahasiswa kosong.");
                    } else {
                        System.out.println("Daftar Mahasiswa:");
                        for (Mahasiswa mhs : daftarMahasiswa) {
                            System.out.println("Nama: " + mhs.getNama() + ", NIM: " + mhs.getNim());
                        }
                    }
                    break;

                case 0: // Keluar
                    System.out.println("Terima kasih!");
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang tersedia.");
            }
        }

        sc.close();
    }
}