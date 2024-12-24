package application;

import javafx.beans.property.*;
import java.util.Date;

public class Penjualan6 {
    private final IntegerProperty penjualanId;
    private final IntegerProperty jumlah;
    private final LongProperty totalHarga; // Total harga dalam satuan terkecil (misalnya sen)
    private final ObjectProperty<Date> tanggal;
    private final IntegerProperty pelanggan; // Relasi ke Pelanggan6
    private final IntegerProperty buku; // Relasi ke Buku6

    public Penjualan6(int penjualanId, int jumlah, long totalHarga, Date tanggal, int pelanggan, int buku) {
        this.penjualanId = new SimpleIntegerProperty(penjualanId);
        this.jumlah = new SimpleIntegerProperty(jumlah);
        this.totalHarga = new SimpleLongProperty(totalHarga);
        this.tanggal = new SimpleObjectProperty<>(tanggal);
        this.pelanggan = new SimpleIntegerProperty(pelanggan);
        this.buku = new SimpleIntegerProperty(buku);
    }

    public IntegerProperty penjualanIdProperty() { return penjualanId; }
    public IntegerProperty jumlahProperty() { return jumlah; }
    public LongProperty totalHargaProperty() { return totalHarga; }
    public ObjectProperty<Date> tanggalProperty() { return tanggal; }
    public IntegerProperty pelangganProperty() { return pelanggan; }
    public IntegerProperty bukuProperty() { return buku; }

    public int getPenjualanId() { return penjualanId.get(); }
    public int getJumlah() { return jumlah.get(); }
    public long getTotalHarga() { return totalHarga.get(); }
    public Date getTanggal() { return tanggal.get(); }
    public int getPelanggan() { return pelanggan.get(); }
    public int getBuku() { return buku.get(); }

    public void setPenjualanId(int penjualanId) { this.penjualanId.set(penjualanId); }
    public void setJumlah(int jumlah) { this.jumlah.set(jumlah); }
    public void setTotalHarga(long totalHarga) { this.totalHarga.set(totalHarga); }
    public void setTanggal(Date tanggal) { this.tanggal.set(tanggal); }
    public void setPelanggan(int pelanggan) { this.pelanggan.set(pelanggan); }
    public void setBuku(int buku) { this.buku.set(buku); }
}
