package praktikum2.soal3; 
 
public class Soal3Main { 
    public static void main(String[] args) { 
        Pegawai p1 = new Pegawai(); 
        //Tidak menggunakan tanda titik koma ";" 
        //p1.nama = "Roi" 
        p1.nama = "Roi";
        p1.asal = "Kingdom of Orvel"; 
        p1.setJabatan("Assasin"); 
        //Tidak menambahkan nilai atribut umur
        p1.umur = 17;
        //Kesalahan pada "Nama Pegawai" karena di output cuma meminta "Nama"
       // System.out.println("Nama Pegawai: " + p1.getNama()); 
        System.out.println("Nama: " + p1.getNama()); 
        System.out.println("Asal: " + p1.getAsal()); 
		System.out.println("Jabatan: " + p1.jabatan); 
		//Tidak menambahkan kata tahun pada output
		//System.out.println("Umur: " + p1.umur + " tahun"); 
		System.out.println("Umur: " + p1.umur + " tahun"); 
    } 
} 
