package application;

public class Mahasiswa {
        private final int id;
        private final String nama;
        private final String nim;

        public Mahasiswa(int id, String nama, String nim) {
            this.id = id;
            this.nama = nama;
            this.nim = nim;
        }

        public int getId() {
            return id;
        }

        public String getNama() {
            return nama;
        }

        public String getNim() {
            return nim;
        }
    }

