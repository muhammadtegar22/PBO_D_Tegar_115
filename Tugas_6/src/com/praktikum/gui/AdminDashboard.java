package com.praktikum.gui;

import com.praktikum.data.Items;
import com.praktikum.main.LoginSystem;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.SplittableRandom;
import java.util.stream.Collectors;

public class AdminDashboard {
    private final Scene scene;

    public AdminDashboard(Stage stage, Admin adm) {
       Label labelwelcome = new Label("Halo, Admin "+adm.getNama());
       labelwelcome.setPadding(new Insets(10,0,10,15));

        TableView<Items> tableItems = new TableView<>();
        TableColumn<Items,String> kolomNama = new TableColumn<>("Nama");
        TableColumn<Items,String> kolomDeskripsi = new TableColumn<>("Deskripsi");
        TableColumn<Items,String> kolomLokasi = new TableColumn<>("Lokasi");
        TableColumn<Items,String> kolomStatus =  new TableColumn<>("Status");

        kolomNama.setCellValueFactory(new PropertyValueFactory<>("namaItem"));
        kolomDeskripsi.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));
        kolomLokasi.setCellValueFactory(new PropertyValueFactory<>("lokasi"));
        kolomStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tableItems.getColumns().setAll(kolomNama,kolomDeskripsi,kolomLokasi,kolomStatus);
        tableItems.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableItems.getColumns().forEach(col -> col.setReorderable(false));

        ObservableList<Items> dataItems = FXCollections.observableArrayList(LoginSystem.reportedItems);
        tableItems.setItems(dataItems);

        Button tombolclaim = new Button("Tandai Claim");
        tombolclaim.setOnAction(e->{
            Items dipilih = tableItems.getSelectionModel().getSelectedItem();
            if(dipilih != null && "Reported".equals(dipilih.getStatus())){
                dipilih.setStatus("Claimed");
                tableItems.refresh();
            }
        });

        VBox.setVgrow(tableItems, Priority.ALWAYS);

        VBox boxkiri = new VBox(10,tableItems,tombolclaim);
        boxkiri.setPadding(new Insets(10));

        TableView<User> tableUsers = new TableView<>();
        TableColumn<User,String> kolomUser = new TableColumn<>("Nama");
        TableColumn<User,String> kolomNIM = new TableColumn<>("NIM");

        kolomUser.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kolomNIM.setCellValueFactory(new PropertyValueFactory<>("nim"));

        tableUsers.getColumns().setAll(kolomUser,kolomNIM);
        tableUsers.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableUsers.getColumns().forEach(col-> col.setReorderable(false));

        ObservableList<User> dataUser =  FXCollections.observableArrayList(LoginSystem.userList.stream().filter(u->u instanceof Mahasiswa).collect(Collectors.toList()));

        tableUsers.setItems(dataUser);


        TextField tambahNama = new TextField();
        tambahNama.setPromptText("Nama Mahasiswa");
        TextField tambahNIM = new TextField();
        tambahNIM.setPromptText("NIM");

        Button tombolTambah = new Button("Tambah");
        Button tombolHapus = new Button("Hapus");

        tombolTambah.setOnAction(e->{
            String nama = tambahNama.getText().trim();
            String nim = tambahNIM.getText().trim();
            if(nama.isEmpty()||nim.isEmpty()) return;

            try{
                long panjangnim = Long.parseLong(nim);
                if (nim.length()!=15||panjangnim<0) {
                    throw new NumberFormatException();
                }
            }catch (NumberFormatException ex){
                return;
            }

            boolean exists = LoginSystem.userList.stream().filter(u->u instanceof Mahasiswa).anyMatch(u->u.getNim().equals(nim));
            if (!exists){
                Mahasiswa m = new Mahasiswa(nama,nim);
                LoginSystem.userList.add(m);

                dataUser.setAll(
                        LoginSystem.userList.stream().filter(u->u instanceof Mahasiswa).collect(Collectors.toList())
                );
                tambahNama.clear();
                tambahNIM.clear();
            }
        });

        tombolHapus.setOnAction(e->{
            User dipilih = tableUsers.getSelectionModel().getSelectedItem();
            if (dipilih instanceof Mahasiswa){
                LoginSystem.userList.remove(dipilih);

                dataUser.setAll(LoginSystem.userList.stream().filter(u->u instanceof Mahasiswa).collect(Collectors.toList()));
            }
        });

        HBox boxactions = new HBox(10,tambahNama,tambahNIM,tombolTambah,tombolHapus);
        boxactions.setAlignment(Pos.CENTER_LEFT);
        boxactions.setPadding(new Insets(0,0,10,0));

        VBox.setVgrow(tableUsers, Priority.ALWAYS);

        VBox boxKanan = new VBox(10,tableUsers,boxactions);
        boxKanan.setPadding(new Insets(10));

        HBox.setHgrow(boxkiri,Priority.ALWAYS);
        HBox.setHgrow(boxKanan,Priority.ALWAYS);

        HBox boxtengah = new HBox(20,boxkiri,boxKanan);
        boxtengah.setAlignment(Pos.CENTER);
        boxtengah.setPadding(new Insets(10));

        Button tombolLogout = new Button("Logout");
        tombolLogout.setOnAction(e-> stage.setScene(new LoginPane(stage).getScene()));
        BorderPane.setMargin(tombolLogout,new Insets(0,0,10,10));

        BorderPane root = new BorderPane();
        root.setTop(labelwelcome);
        root.setCenter(boxtengah);
        root.setBottom(tombolLogout);

        this.scene = new Scene(root,1000,500);
    }

    public Scene getScene() {
        return scene;
    }
}
