package pinsarcampus.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private ObservableList<InventarisModelView> dataInventaris = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("PinSarCampus - Sistem Peminjaman Sarana Kampus (JavaFX)");

        // Inisialisasi Data Awal
        dataInventaris.add(new InventarisModelView("INV001", "Proyektor Epson", "Elektronik", "Tersedia"));
        dataInventaris.add(new InventarisModelView("INV002", "Kamera DSLR Canon", "Elektronik", "Tersedia"));
        dataInventaris.add(new InventarisModelView("INV003", "Aula Sekretariat HIMA", "Ruangan", "Tersedia"));

        // Pembuatan Komponen Tabel
        TableView<InventarisModelView> table = new TableView<>();
        table.setItems(dataInventaris);

        TableColumn<InventarisModelView, String> colId = new TableColumn<>("ID Barang");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colId.setPrefWidth(100);

        TableColumn<InventarisModelView, String> colNama = new TableColumn<>("Nama Barang");
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colNama.setPrefWidth(200);

        TableColumn<InventarisModelView, String> colJenis = new TableColumn<>("Jenis");
        colJenis.setCellValueFactory(new PropertyValueFactory<>("jenis"));
        colJenis.setPrefWidth(120);

        TableColumn<InventarisModelView, String> colStatus = new TableColumn<>("Status");
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colStatus.setPrefWidth(120);

        table.getColumns().addAll(colId, colNama, colJenis, colStatus);

        // Form Input
        GridPane formGrid = new GridPane();
        formGrid.setPadding(new Insets(10, 10, 10, 10));
        formGrid.setVgap(8);
        formGrid.setHgap(10);

        Label lblNama = new Label("Nama Barang/Ruangan:");
        TextField tfNama = new TextField();
        tfNama.setPromptText("Contoh: Speaker Aktif");

        Label lblJenis = new Label("Jenis Sarana:");
        ComboBox<String> cbJenis = new ComboBox<>();
        cbJenis.getItems().addAll("Elektronik", "Ruangan");
        cbJenis.setValue("Elektronik");

        Button btnTambah = new Button("Tambah Inventaris");
        Button btnHapus = new Button("Hapus Terpilih");

        formGrid.add(lblNama, 0, 0);
        formGrid.add(tfNama, 1, 0);
        formGrid.add(lblJenis, 0, 1);
        formGrid.add(cbJenis, 1, 1);
        formGrid.add(btnTambah, 1, 2);
        formGrid.add(btnHapus, 2, 2);

        // Event Handling & Validasi Alert
        btnTambah.setOnAction(e -> {
            try {
                String nama = tfNama.getText().trim();
                String jenis = cbJenis.getValue();

                if (nama.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Peringatan Validasi");
                    alert.setHeaderText(null);
                    alert.setContentText("Nama barang tidak boleh kosong!");
                    alert.showAndWait();
                    return;
                }

                String idBaru = "INV0" + (dataInventaris.size() + 1);
                dataInventaris.add(new InventarisModelView(idBaru, nama, jenis, "Tersedia"));
                tfNama.clear();

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Sukses");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Data inventaris berhasil ditambahkan!");
                successAlert.showAndWait();

            } catch (Exception ex) {
                Alert errAlert = new Alert(Alert.AlertType.ERROR);
                errAlert.setTitle("Error");
                errAlert.setContentText("Terjadi kesalahan sistem: " + ex.getMessage());
                errAlert.showAndWait();
            }
        });

        btnHapus.setOnAction(e -> {
            InventarisModelView selectedItem = table.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                dataInventaris.remove(selectedItem);
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Peringatan");
                alert.setHeaderText(null);
                alert.setContentText("Pilih baris pada tabel yang ingin dihapus terlebih dahulu!");
                alert.showAndWait();
            }
        });

        // Layout Utama
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));
        Label titleLabel = new Label("DASHBOARD MANAJEMEN INVENTARIS PINSARCAMPUS");
        titleLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        root.getChildren().addAll(titleLabel, table, formGrid);

        Scene scene = new Scene(root, 580, 480);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class InventarisModelView {
        private final String id;
        private final String nama;
        private final String jenis;
        private final String status;

        public InventarisModelView(String id, String nama, String jenis, String status) {
            this.id = id;
            this.nama = nama;
            this.jenis = jenis;
            this.status = status;
        }

        public String getId() { return id; }
        public String getNama() { return nama; }
        public String getJenis() { return jenis; }
        public String getStatus() { return status; }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
