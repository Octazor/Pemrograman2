package application;
import javafx.beans.property.*;

public class Buku6 {
    private final IntegerProperty id;
    private final StringProperty judul;
    private final StringProperty penulis;
    private final IntegerProperty harga;
    private final IntegerProperty stok;

    public Buku6(int id, String judul, String penulis, int harga, int stok) {
        this.id = new SimpleIntegerProperty(id);
        this.judul = new SimpleStringProperty(judul);
        this.penulis = new SimpleStringProperty(penulis);
        this.harga = new SimpleIntegerProperty(harga);
        this.stok = new SimpleIntegerProperty(stok);
    }

    public IntegerProperty idProperty() { return id; }
    public StringProperty judulProperty() { return judul; }
    public StringProperty penulisProperty() { return penulis; }
    public IntegerProperty hargaProperty() { return harga; }
    public IntegerProperty stokProperty() { return stok; }

    public int getId() { return id.get(); }
    public String getJudul() { return judul.get(); }
    public String getPenulis() { return penulis.get(); }
    public int getHarga() { return harga.get(); }
    public int getstok() { return stok.get(); }
}