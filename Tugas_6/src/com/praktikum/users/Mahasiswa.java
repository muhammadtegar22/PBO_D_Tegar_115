package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.data.Items;
import com.praktikum.main.LoginSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {
    Scanner input = new Scanner(System.in);
    public Mahasiswa(String nama,String nim) {
        super(nama,nim);
    }

    @Override
    public void reportItem() {
        System.out.println("---- Laporan Barang ----");
        System.out.print("Nama Barang: ");
        String namaBarang = input.nextLine();
        System.out.print("Deskripsi Barang: ");
        String deskripsiBarang = input.nextLine();
        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String lokasi = input.nextLine();


        Items item = new Items(namaBarang,deskripsiBarang,lokasi);
        LoginSystem.reportedItems.add(item);
        item.setStatus("Reported");
        System.out.println("Laporan telah diterima!");
    }

    @Override
    public void viewReportedItems() {
        System.out.println("---- Daftar Laporan ----");
        if(LoginSystem.reportedItems.isEmpty()){
            System.out.println("Tidak ada laporan barang");
            return;
        }

        int indeks = 0;
        for(Items item : LoginSystem.reportedItems){
            if("Reported".equals(item.getStatus())){
                System.out.println("["+indeks+"] "+item.getItemname()+" -"+item.getDescription()+" -"+item.getLocation());
            }
            indeks++;
        }

    }

    @Override
    public void displayAppMenu() {
        int pilihan=-1;
        do{
            System.out.println("\nMenu Mahasiswa: ");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.println("Pilih Menu: ");


            try {
                pilihan = input.nextInt();
                input.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Input harus berupa angka");
                input.nextLine();
                continue;
            }

            switch (pilihan){
                case 1:
                    reportItem();
                    break;
                case 2:
                    viewReportedItems();
                    break;
                case 0:
                    System.out.println("Logout Mahasiswa Berhasil\n");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }while (pilihan != 0 );
    }


    @Override
    public boolean login(String inputNama, String inputNim) {
        return getNama().equalsIgnoreCase(inputNama)&&getNim().equalsIgnoreCase(inputNim);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Mahasiswa Berhasil: "+getNama());
    }
}
