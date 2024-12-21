package application;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.*;

public class LoginTableViewApp extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        showTableViewPage();
    }

    private void showTableViewPage() {
        Label welcomeLabel = new Label("Selamat Datang!");

        TableView<Mahasiswa> tableView = new TableView<>();
        tableView.setItems(getMahasiswaData());

        TableColumn<Mahasiswa, Number> idColumn = new TableColumn<>("Id");
        idColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()));

        TableColumn<Mahasiswa, String> namaColumn = new TableColumn<>("Nama");
        namaColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNama()));

        TableColumn<Mahasiswa, String> nimColumn = new TableColumn<>("NIM");
        nimColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNim()));

        namaColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.3));
        nimColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.4));

        tableView.getColumns().addAll(namaColumn, nimColumn);

        VBox tableLayout = new VBox(10, welcomeLabel, tableView);
        VBox.setVgrow(tableView, Priority.ALWAYS);
        tableLayout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene tableScene = new Scene(tableLayout, 600, 400);
        primaryStage.setScene(tableScene);
        primaryStage.setTitle("Daftar Mahasiswa");
        primaryStage.show();
    }

    private ObservableList<Mahasiswa> getMahasiswaData() {
        return FXCollections.observableArrayList(
            new Mahasiswa(1201, "Dimas", "231011"),
            new Mahasiswa(1202, "Andi", "231012"),
            new Mahasiswa(1203, "Yanti", "231013"),
            new Mahasiswa(1204, "Agus", "231014"),
            new Mahasiswa(1205, "Himeko", "231015"),
            new Mahasiswa(1206, "Yuli", "231016"),
            new Mahasiswa(1207, "Yula", "231017"),
            new Mahasiswa(1208, "Udin", "231018"),
            new Mahasiswa(1209, "Asep", "231019"),
            new Mahasiswa(1210, "Galih", "231020")
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}
