package application;

import java.awt.Label;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class MainController implements Initializable { 
//TAB BUKU
    @FXML
    private TextField idField;
    @FXML
    private TextField judulField;
    @FXML
    private TextField penulisField;

    @FXML
    private TextField hargaField;

    @FXML
    private TextField stokField;
  
    @FXML
    private Button insertButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;
    

    @FXML private Label welcomeLabel;
    @FXML private TableView<Buku6> TableView;
    @FXML private TableColumn<Buku6, Integer> idColumn;
    @FXML private TableColumn<Buku6, String> judulColumn;
    @FXML private TableColumn<Buku6, String> penulisColumn;
    @FXML private TableColumn<Buku6, Integer> hargaColumn;
    @FXML private TableColumn<Buku6, Integer> stokColumn;
    
 // Tab Pelanggan
    @FXML private TextField pelangganIdField, pelangganNamaField, pelangganEmailField, pelangganTeleponField;
    @FXML private Button insertPelangganButton, updatePelangganButton, deletePelangganButton;
    @FXML private TableView<Pelanggan6> pelangganTableView;
    @FXML private TableColumn<Pelanggan6, Integer> pelangganIdColumn;
    @FXML private TableColumn<Pelanggan6, String> pelangganNamaColumn;
    @FXML private TableColumn<Pelanggan6, String> pelangganEmailColumn;
    @FXML private TableColumn<Pelanggan6, Long> pelangganTeleponColumn;
    
    // Tab Penjualan
    @FXML private TextField jumlahField, totalHargaField, tanggalField, pelangganIdFieldPenjualan, bukuIdField, penjualanIdField;
    @FXML private Button insertPenjualanButton, updatePenjualanButton, deletePenjualanButton;
    @FXML private TableView<Penjualan6> penjualanTableView;
    @FXML private TableColumn<Penjualan6, Integer> jumlahColumn;
    @FXML private TableColumn<Penjualan6, Integer> totalHargaColumn;
    @FXML private TableColumn<Penjualan6, String> tanggalColumn;
    @FXML private TableColumn<Penjualan6, Integer> pelangganIdPenjualanColumn; 
    @FXML private TableColumn<Penjualan6, Integer> bukuIdPenjualanColumn; 
    @FXML private TableColumn<Penjualan6, Integer> penjualanIdColumn;

	

    // Handler untuk tab Buku
    @FXML
    private void insertButton(ActionEvent event) {
        // Tambahkan logika untuk tombol Insert di tab Buku
        String query = "INSERT INTO buku6 VALUES("
                + idField.getText() + ", '"
                + judulField.getText() + "', '"
                + penulisField.getText() + "', "
                + hargaField.getText() + ", "
                + stokField.getText() + ")";
        executeQuery(query);
        showBooks();
    }
    @FXML
    private void updateButton(ActionEvent event) {
        // Tambahkan logika untuk tombol Update di tab Buku
    	  String query = "UPDATE buku6 SET judul='" + judulField.getText()
          + "', penulis='" + penulisField.getText()
          + "', harga=" + hargaField.getText()
          + ", stok=" + stokField.getText()
          + " WHERE buku_id=" + idField.getText();
    	  executeQuery(query);
    	  showBooks();
    }
    @FXML
    private void deleteButton(ActionEvent event) {
        // Tambahkan logika untuk tombol Delete di tab Buku
    	  String query = "DELETE FROM buku6 WHERE buku_id=" + idField.getText();
          executeQuery(query);
          showBooks();
      }
    // Handler untuk tab Pelanggan
    @FXML
    private void insertPelangganButton(ActionEvent event) {
        // Tambahkan logika untuk tombol Insert di tab Pelanggan
        String query = "INSERT INTO pelanggan6 VALUES("
                + pelangganIdField.getText() + ", '"
                + pelangganNamaField.getText() + "', '"
                + pelangganEmailField.getText() + "', "
                + pelangganTeleponField.getText() + ")";
        executeQuery(query);
        showPelanggan();
    }

    @FXML
    private void updatePelangganButton(ActionEvent event) {
        // Tambahkan logika untuk tombol Update di tab Pelanggan
        String query = "UPDATE pelanggan6 SET nama='" + pelangganNamaField.getText()
        + "', email='" + pelangganEmailField.getText()
        + "', telepon=" + pelangganTeleponField.getText()
        + " WHERE pelanggan_id=" + pelangganIdField.getText();
        executeQuery(query);
        showPelanggan();
    }

    @FXML
    private void deletePelangganButton(ActionEvent event) {
        // Tambahkan logika untuk tombol Delete di tab Pelanggan
        String query = "DELETE FROM pelanggan6 WHERE pelanggan_id=" + pelangganIdField.getText();
        executeQuery(query);
        showPelanggan();
    }


    // Handler untuk tab Penjualan
    @FXML
    private void insertPenjualanButton(ActionEvent event) {
        // Validate that pelangganIdField is not empty
        if (pelangganIdFieldPenjualan.getText().isEmpty()) {
            System.out.println("Pelanggan ID is required!");
            // Show an error dialog or message to the user
            return;
        }
        String query = "INSERT INTO penjualan6 (penjualan_id, jumlah, total_harga, tanggal, pelanggan_id, buku_id) VALUES("
                + "'" + penjualanIdField.getText() + "', "
                + "'" + jumlahField.getText() + "', "
                + "'" + totalHargaField.getText() + "', "
                + "STR_TO_DATE('" + tanggalField.getText() + "', '%d %m %Y'), "
                + "'" + pelangganIdFieldPenjualan.getText() + "', "
                + "'" + bukuIdField.getText() + "')";

        executeQuery(query);
        showPenjualan();
    }

    @FXML
    private void updatePenjualanButton(ActionEvent event) {
        // Ensure the values are properly escaped to avoid SQL injection
        String query = "UPDATE penjualan6 SET jumlah=" + jumlahField.getText()
            + ", total_harga=" + totalHargaField.getText()
            + ", tanggal=STR_TO_DATE('" + tanggalField.getText() + "', '%d %m %Y')"
            + ", pelanggan_id=" + pelangganIdFieldPenjualan.getText()
            + ", buku_id=" + bukuIdField.getText()
            + " WHERE penjualan_id=" + penjualanIdField.getText();

        executeQuery(query);
        showPenjualan();
    }

    @FXML
    private void deletePenjualanButton(ActionEvent event) {
        String query = "DELETE FROM penjualan6 WHERE penjualan_id=" + penjualanIdField.getText();
        executeQuery(query);
        showPenjualan();
    }

    public void executeQuery(String query) {
    	Connection conn = getConnection();
    	Statement st;
    	try {
			st = conn.createStatement();
			st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	showBooks();
    	showPelanggan();
    	showPenjualan();
    }
    
    public Connection getConnection() {
    	Connection conn;
    	try {
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");
    		return conn;
    	}
    	catch (Exception e){
    		e.printStackTrace();
    		return null;
    	}
    }
    
    public ObservableList<Buku6> getBooksList(){
    	ObservableList<Buku6> booksList = FXCollections.observableArrayList();
    	Connection connection = getConnection();
    	String query = "SELECT * FROM buku6 ";
    	Statement st;
    	ResultSet rs;
    	
    	try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			Buku6 buku6;
			while(rs.next()) {
				buku6 = new Buku6(rs.getInt("Buku_Id"),rs.getString("Judul"),rs.getString("Penulis"),rs.getInt("Harga"),rs.getInt("Stok"));
				booksList.add(buku6);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return booksList;
    }
    
    // I had to change ArrayList to ObservableList I didn't find another option to do this but this works :)
    public void showBooks() {
    	ObservableList<Buku6> list = getBooksList();
    	
    	idColumn.setCellValueFactory(new PropertyValueFactory<Buku6,Integer>("id"));
    	judulColumn.setCellValueFactory(new PropertyValueFactory<Buku6,String>("judul"));
    	penulisColumn.setCellValueFactory(new PropertyValueFactory<Buku6,String>("penulis"));
    	hargaColumn.setCellValueFactory(new PropertyValueFactory<Buku6,Integer>("harga"));
    	stokColumn.setCellValueFactory(new PropertyValueFactory<Buku6,Integer>("stok"));
    	
    	TableView.setItems(list);
    }



public ObservableList<Pelanggan6> getPelangganList(){
	ObservableList<Pelanggan6> pelangganList = FXCollections.observableArrayList();
	Connection connection = getConnection();
	String query = "SELECT * FROM pelanggan6 ";
	Statement st;
	ResultSet rs;
	
	try {
		st = connection.createStatement();
		rs = st.executeQuery(query);
		Pelanggan6 pelanggan6;
		while(rs.next()) {
			pelanggan6 = new Pelanggan6(rs.getInt("pelanggan_Id"),rs.getString("Nama"),rs.getString("Email"),rs.getLong("Telepon"));
			pelangganList.add(pelanggan6);
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return pelangganList;
}

// I had to change ArrayList to ObservableList I didn't find another option to do this but this works :)
public void showPelanggan() {
    ObservableList<Pelanggan6> list = getPelangganList();
    // Correctly reference the property method names
    pelangganIdColumn.setCellValueFactory(new PropertyValueFactory<Pelanggan6, Integer>("id"));
    pelangganNamaColumn.setCellValueFactory(new PropertyValueFactory<Pelanggan6, String>("nama"));
    pelangganEmailColumn.setCellValueFactory(new PropertyValueFactory<Pelanggan6, String>("email"));
    pelangganTeleponColumn.setCellValueFactory(new PropertyValueFactory<Pelanggan6, Long>("telepon"));

    pelangganTableView.setItems(list);
	}

public ObservableList<Penjualan6> getPenjualanList() {
    ObservableList<Penjualan6> penjualanList = FXCollections.observableArrayList();
    Connection connection = getConnection();
    String query = "SELECT * FROM penjualan6";
    Statement st;
    ResultSet rs;

    try {
        st = connection.createStatement();
        rs = st.executeQuery(query);

        while (rs.next()) {
            Penjualan6 penjualan6 = new Penjualan6(
                    rs.getInt("penjualan_id"),
                    rs.getInt("jumlah"),
                    rs.getLong("total_harga"),
                    rs.getDate("tanggal"),
                    rs.getInt("pelanggan_id"), 
                    rs.getInt("buku_id")
            );
            penjualanList.add(penjualan6);
            System.out.println("Data retrieved: " + penjualan6.getPenjualanId());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return penjualanList;
}

public void showPenjualan() {
    ObservableList<Penjualan6> list = getPenjualanList();
    
    penjualanIdColumn.setCellValueFactory(new PropertyValueFactory<>("penjualanId"));
    jumlahColumn.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
    totalHargaColumn.setCellValueFactory(new PropertyValueFactory<>("totalHarga"));
    tanggalColumn.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
    pelangganIdPenjualanColumn.setCellValueFactory(new PropertyValueFactory<>("pelanggan"));
    bukuIdPenjualanColumn.setCellValueFactory(new PropertyValueFactory<>("buku"));

    penjualanTableView.setItems(list);
}

}