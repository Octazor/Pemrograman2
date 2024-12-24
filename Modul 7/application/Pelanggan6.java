package application;
import javafx.beans.property.*;

public class Pelanggan6 {
    private final IntegerProperty id;
    private final StringProperty nama;
    private final StringProperty email;
    private final LongProperty telepon;

    public Pelanggan6(int id, String nama, String email, Long telepon) {
        this.id = new SimpleIntegerProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.email = new SimpleStringProperty(email);
        this.telepon = new SimpleLongProperty(telepon);
    }

    public IntegerProperty idProperty() { return id; }
    public StringProperty namaProperty() { return nama; }
    public StringProperty emailProperty() { return email; }
    public LongProperty teleponProperty() { return telepon; }

    public int getId() { return id.get(); }
    public String getnama() { return nama.get(); }
    public String getemail() { return email.get(); }
    public Long gettelepon() { return telepon.get(); }

}