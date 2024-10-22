package praktikum2.soal3; 
 
//Karena nama classnya Employee seharusnya menggunakan nama Pegawai seperti nama filenya
//public class Employee { 
public class Pegawai{
    public String nama; 
//char digunakan cuma untuk 1 karakter, seharusnya menggunakan String jika lebih dari 1 karakter
//public char asal; 
    public String asal; 
    public String jabatan; 
    public int umur; 
 
    public String getNama() { 
        return nama; 
    } 
 
    public String getAsal() { 
        return asal; 
    } 
 // menambahkan parameter (String j) 
    //public void setJabatan() { 
    public void setJabatan(String j) {
    	this.jabatan = j; 
    } 
            } 