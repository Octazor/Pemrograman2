package Soal1;
  
public class Buah {
	String nama;
	double berat;
	double harga;
	double total;
	double ratediskon = 0.02; // 2% diskon per 4 kilogram
	
	public Buah(String nama, double berat, double harga, double total) {
		this.nama = nama;
		this.berat = berat;
		this.harga = harga;
		this.total = total;
	}
	
	public double hargasebelumdiskon() {
		return total * (harga/berat);
	}
	
	public double hargadiskon() {
		double diskon = total/4 ;
		return Math.floor(diskon) * ratediskon * harga * 4 ;

	}
	
	public double hargasetelahdiskon() { 
		return hargasebelumdiskon() - hargadiskon();
	}
	
	public void tampilan() {
		  System.out.println("Nama Buah: " + nama);
	      System.out.println("Berat: " + berat + "kg");
	      System.out.println("Harga: Rp" + harga);
	      System.out.println("Jumlah Beli: " + total + "kg");
	      System.out.println("Harga Sebelum Diskon: Rp" + String.format("%.2f", hargasebelumdiskon()));
	      System.out.println("Total Diskon: Rp" + String.format("%.2f", hargadiskon()));
	      System.out.println("Harga Setelah Diskon: Rp" + String.format("%.2f", hargasetelahdiskon()));
	      System.out.println();
	}
}