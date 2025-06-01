package com.praktikum.gui;

import com.praktikum.main.LoginSystem;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPane {
    private final Scene scene;
    private Control field1;
    private Control field2;

    public LoginPane(Stage stage) {
        ComboBox<String> caralogin = new ComboBox<>();
        caralogin.getItems().addAll("Admin", "Mahasiswa");
        caralogin.setValue("Mahasiswa");

        TextField inputNama = new TextField();
        inputNama.setPromptText("Nama");
        inputNama.setPrefWidth(250);

        TextField inputNIM = new TextField();
        inputNIM.setPromptText("NIM");
        inputNIM.setPrefWidth(250);

        TextField inputUsername = new TextField();
        inputUsername.setPromptText("Username");
        inputUsername.setPrefWidth(250);

        PasswordField inputPassword = new PasswordField();
        inputPassword.setPromptText("Password");
        inputPassword.setPrefWidth(250);

        field1 = inputNama;
        field2 = inputNIM;

        Button tombolLogin = new Button("Login");
        tombolLogin.setPrefWidth(50);

        Label labelPesanLogin = new Label();
        labelPesanLogin.setPrefWidth(250);
        labelPesanLogin.setAlignment(Pos.CENTER);
        labelPesanLogin.setStyle("-fx-text-fill: red;");

        HBox hboxtombol = new HBox(tombolLogin);
        hboxtombol.setAlignment(Pos.CENTER_RIGHT);
        hboxtombol.setPrefWidth(50);

        HBox hboxcaralogin = new HBox(caralogin);
        hboxcaralogin.setAlignment(Pos.CENTER_LEFT);
        hboxcaralogin.setPrefWidth(250);

        caralogin.setOnAction(e -> {
            String role = caralogin.getValue();
            VBox parent = (VBox) field1.getParent();

            parent.getChildren().remove(field1);
            if ("Admin".equals(role)) {
                field1 = inputUsername;
            } else {
                field1 = inputNama;
            }
            int idxField2 = parent.getChildren().indexOf(field2);
            parent.getChildren().add(idxField2, field1);

            parent.getChildren().remove(field2);
            if ("Admin".equals(role)) {
                field2 = inputPassword;
            } else {
                field2 = inputNIM;
            }
            int idxHBox = parent.getChildren().indexOf(hboxtombol);
            parent.getChildren().add(idxHBox, field2);

            ((TextInputControl) field1).clear();
            ((TextInputControl) field2).clear();
            labelPesanLogin.setText("");
        });

        tombolLogin.setOnAction(e -> {
            String role   = caralogin.getValue();
            String input1 = ((TextInputControl) field1).getText().trim();
            String input2 = ((TextInputControl) field2).getText().trim();
            User logged   = null;

            for (User u : LoginSystem.userList) {
                if ("Admin".equals(role) && u instanceof Admin && u.login(input1, input2)) {
                    logged = u;
                    break;
                }
                if ("Mahasiswa".equals(role) && u instanceof Mahasiswa && u.login(input1, input2)) {
                    logged = u;
                    break;
                }
            }
            if (logged != null) {
                if (logged instanceof Admin) {
                    stage.setScene(new AdminDashboard(stage, (Admin) logged).getScene());
                } else {
                    stage.setScene(new MahasiswaDashboard(stage, (Mahasiswa) logged).getScene());
                }
            } else {
                labelPesanLogin.setText("Login gagal, periksa kredensial");
            }
        });

        VBox root = new VBox(10,
                new Label("Login Sistem Lost & Found"),
                hboxcaralogin,
                field1,
                field2,
                hboxtombol,
                labelPesanLogin
        );
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        this.scene = new Scene(root, 360, 300);
    }

    public Scene getScene() {
        return scene;
    }
}
