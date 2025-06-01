package com.example.hellojavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

public class GuessTheNumberGame extends Application {

    private int angkaAcak;
    private int jumlahPercobaan;
    private Label labelUmpanBalik; // Label untuk menampilkan feedback (Terlalu kecil, dll.)
    private Label labelJumlahPercobaan; // Label untuk menampilkan jumlah percobaan
    private TextField kolomTebakan; // Kolom input untuk tebakan
    private Button tombolTebak; // Tombol "Coba Tebak!"
    private Button tombolMainLagi; // Tombol "Main Lagi"

    @Override
    public void start(Stage primaryStage) {
        // Inisialisasi status permainan
        inisialisasiPermainan();

        // Elemen-elemen UI
        Label judulLabel = new Label("Tebak Angka 1-100");
        judulLabel.setFont(new Font("Arial", 24));
        judulLabel.setTextFill(Color.web("#336699")); // Warna kebiruan

        Label instruksiLabel = new Label("Masukkan tebakanmu!");
        instruksiLabel.setFont(new Font("Arial", 14));

        kolomTebakan = new TextField();
        kolomTebakan.setPromptText("Masukkan angka di sini");
        kolomTebakan.setMaxWidth(150);

        tombolTebak = new Button("Coba Tebak!");
        tombolTebak.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;"); // Tombol hijau

        labelUmpanBalik = new Label("");
        labelUmpanBalik.setFont(new Font("Arial", 16));

        labelJumlahPercobaan = new Label("Jumlah percobaan: 0");
        labelJumlahPercobaan.setFont(new Font("Arial", 14));

        tombolMainLagi = new Button("Main Lagi");
        tombolMainLagi.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;"); // Tombol biru
        tombolMainLagi.setVisible(false); // Awalnya disembunyikan

        // Tata Letak (Layout)
        VBox root = new VBox(20); // Jarak antar elemen vertikal
        root.setPadding(new Insets(30)); // Padding di sekitar konten
        root.setAlignment(Pos.CENTER); // Pusatkan elemen
        root.setStyle("-fx-background-color: #d6e2ec;"); // Latar belakang biru muda

        HBox barisInput = new HBox(10); // Jarak antar elemen horizontal
        barisInput.setAlignment(Pos.CENTER); // Pusatkan elemen
        barisInput.getChildren().addAll(kolomTebakan, tombolTebak);

        root.getChildren().addAll(
                judulLabel,
                instruksiLabel,
                barisInput,
                labelUmpanBalik,
                labelJumlahPercobaan,
                tombolMainLagi
        );

        // Penanganan Kejadian (Event Handlers)
        tombolTebak.setOnAction(e -> tanganiTebakan());
        tombolMainLagi.setOnAction(e -> {
            inisialisasiPermainan();
            resetUI();
        });

        // Scene dan Stage
        Scene scene = new Scene(root, 400, 450); // Ukuran jendela
        primaryStage.setTitle("Tebak Angka Advance"); // Judul jendela
        primaryStage.setScene(scene);
        primaryStage.show(); // Tampilkan jendela
    }

    private void inisialisasiPermainan() {
        Random random = new Random();
        angkaAcak = random.nextInt(100) + 1; // Hasilkan angka acak antara 1 dan 100
        jumlahPercobaan = 0;
        System.out.println("Angka acak (untuk pengujian): " + angkaAcak); // Untuk debugging
    }

    private void tanganiTebakan() {
        try {
            int tebakan = Integer.parseInt(kolomTebakan.getText());
            jumlahPercobaan++;
            labelJumlahPercobaan.setText("Jumlah percobaan: " + jumlahPercobaan);

            if (tebakan < 1 || tebakan > 100) {
                labelUmpanBalik.setText("Tebakan harus antara 1 dan 100!");
                labelUmpanBalik.setTextFill(Color.RED);
            } else if (tebakan < angkaAcak) {
                labelUmpanBalik.setText("Terlalu kecil!");
                labelUmpanBalik.setTextFill(Color.ORANGE);
            } else if (tebakan > angkaAcak) {
                labelUmpanBalik.setText("Terlalu besar!");
                labelUmpanBalik.setTextFill(Color.ORANGE);
            } else {
                labelUmpanBalik.setText("Tebakan benar!");
                labelUmpanBalik.setTextFill(Color.GREEN);
                tombolTebak.setDisable(true); // Nonaktifkan tombol tebak
                kolomTebakan.setDisable(true); // Nonaktifkan kolom teks
                tombolMainLagi.setVisible(true); // Tampilkan tombol "Main Lagi"
            }
        } catch (NumberFormatException e) {
            labelUmpanBalik.setText("Masukkan angka yang valid!");
            labelUmpanBalik.setTextFill(Color.RED);
        }
        kolomTebakan.clear(); // Bersihkan kolom teks setelah setiap tebakan
    }

    private void resetUI() {
        kolomTebakan.clear();
        labelUmpanBalik.setText("");
        labelJumlahPercobaan.setText("Jumlah percobaan: 0");
        tombolTebak.setDisable(false);
        kolomTebakan.setDisable(false);
        tombolMainLagi.setVisible(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
