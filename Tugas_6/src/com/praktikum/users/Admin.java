package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.data.Items;
import com.praktikum.main.LoginSystem;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    Scanner input = new Scanner(System.in);
    private final String username;
    private  final String password;

    public Admin(String username, String password, String nama, String nim){
        super(nama,nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public void manageItems() {
        int pilihan = -1;
        do {
            System.out.println("\n--Kelola Laporan Barang --");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil");
            System.out.println("0. Kembali");
            System.out.print("Pilih Menu: ");
            try {
                pilihan = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input harus angka");
                input.nextLine();
                continue;
            }
            switch (pilihan){
                case 1:
                    int indeks = 0;
                    for(Items item : LoginSystem.reportedItems){
                        System.out.println("["+indeks+"] "+item.getItemname()+" ("+item.getStatus()+") -"+item.getLocation());
                        indeks++;
                    }
                    if(LoginSystem.reportedItems.isEmpty()){
                        System.out.println("Belum ada Laporan Barang");
                    }
                    break;
                case 2:
                    int idx = 0;
                    boolean adalaporan = false;
                    System.out.println("\nDaftar Barang Yang Berstatus Reported:");
                    if(LoginSystem.reportedItems.isEmpty()){
                        System.out.println("belum ada laporan barang");
                        break;
                    }
                    for(Items item : LoginSystem.reportedItems){
                        if("Reported".equals(item.getStatus())){
                            System.out.println("["+idx+"] "+item.getItemname()+" ("+item.getStatus()+") -"+item.getLocation());
                            idx++;
                            adalaporan = true;
                        }
                    }
                    if(!adalaporan){
                        System.out.println("tidak ada barang yang memiliki status Reported");
                        continue;
                    }
                    System.out.print("Masukkan indeks item yang ingin di-Claimed: ");
                    try {
                        int pilih=input.nextInt();
                        Items sel = LoginSystem.reportedItems.get(pilih);
                        sel.setStatus("Claimed");
                        System.out.println("Item berhasil di claim");
                    }catch (InputMismatchException e){
                        System.out.println("Input harus berupa angka");
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("Indeks tidak valid");
                    }
                    break;
                case 0:
                    System.out.println("Kembali Ke Menu Sebelumnya....");
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid");

            }
        }while (pilihan !=0 );
    }

    @Override
    public void manageUsers() {
        int pilihan = -1;
        do {
            System.out.println("\n-- Kelola Data Mahasiswa --");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

            try {
                pilihan = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka");
                continue;
            }
            switch (pilihan){
                case 1:
                    System.out.print("Nama Mahasiswa: ");
                    String nama = input.nextLine();
                    System.out.print("NIM Mahasiswa: ");
                    String NIM = input.nextLine();

                    try {
                        long nimNumber = Long.parseLong(NIM);
                        if (nimNumber < 0) {
                            System.out.println("NIM tidak boleh negatif.");
                            break;
                        }
                        if (NIM.length()!= 15){
                            System.out.println("NIM harus tediri dari 15 digit");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("NIM harus berupa angka.");
                        break;
                    }

                    boolean terdaftar = false;
                    for(User user : LoginSystem.userList){
                        if(user.getNim().equals(NIM)){
                            System.out.println("Mahasiswa tersebut telah terdaftar");
                            terdaftar = true;
                            break;
                        }
                    }
                    if(!terdaftar){
                        LoginSystem.userList.add(new Mahasiswa(nama,NIM));
                        System.out.println("Mahasiswa Berhasil di Tambahkan");
                    }
                    break;
                case 2:
                    System.out.println("--- Daftar Mahasiswa Yang Telah Terdaftar ---");
                    int nomer = 0;
                    for (User user : LoginSystem.userList){
                        if(user instanceof Mahasiswa){
                            System.out.println(nomer+". Nama: "+user.getNama()+" Nim: "+user.getNim());
                        }
                        nomer++;
                    }
                    System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
                    String hapus = input.nextLine();
                    try {
                        long nimNumber = Long.parseLong(hapus);
                        if (nimNumber < 0) {
                            System.out.println("NIM tidak boleh negatif.");
                            break;
                        }
                        if (hapus.length()!= 15){
                            System.out.println("NIM harus tediri dari 15 digit");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("NIM harus berupa angka.");
                        break;
                    }
                    Iterator<User> iter = LoginSystem.userList.iterator();
                    boolean found = false;
                    while (iter.hasNext()){
                        User user = iter.next();
                        if(user instanceof Mahasiswa && ((Mahasiswa)user).getNim().equalsIgnoreCase(hapus)){
                            iter.remove();
                            found = true;
                            System.out.println("Mahasiswa Berhasil dihapus");
                        }
                    }
                    if (!found){
                        System.out.println("Mahasiswa belum terdaftar");
                    }
                    break;
                case 0:
                    System.out.println("Kembali Ke Menu Sebelumnya....\n");
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid");
            }

        }while (pilihan != 0);
    }

    @Override
    public void displayAppMenu() {
        int pilihan = -1;
        do{
            System.out.println("\nMenu Admin:");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.println("Pilih Menu: ");
            try {
                pilihan = input.nextInt();
                input.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Input Harus Berupa Angka");
                input.nextLine();
                continue;
            }

            switch (pilihan){
                case 1:
                    manageItems();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 0:
                    System.out.println("logout Admin Berhasil\n");
                    break;
                default:
                    System.out.println("Pilihan Tidak valid");
            }
        }while (pilihan !=0);
    }



    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin Berhasil. ("+username+")");
    }
}
