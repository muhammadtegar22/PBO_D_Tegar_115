package com.praktikum.main;

import com.praktikum.data.Items;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;

import java.util.ArrayList;
import java.util.InputMismatchException;
import  java.util.Scanner;
public class LoginSystem {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Items> reportedItems = new ArrayList<>();
    static{
        userList.add(new Admin("Admin115", "Password115", "Tegar", "115"));
        userList.add(new Mahasiswa("Tegar", "202410370110115"));
    }
    public static void main(String[] args) {
        Scanner objinput = new Scanner(System.in);

        while (true) {
            System.out.println("Masukkan pilihan login: ");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan (1/2/0): ");

            int pilihan;
            try {
                pilihan = objinput.nextInt();
                objinput.nextLine();
            }catch (InputMismatchException e){
                System.out.println("input harus berupa angka!");
                objinput.nextLine();
                continue;
            }
            User logged = null;
            switch (pilihan){
                case 1:
                    System.out.print("Masukan username: ");
                    String username = objinput.nextLine();
                    System.out.print("Masukan password: ");
                    String password = objinput.nextLine();
                    for (User user : userList){
                        if(user instanceof Admin && user.login(username,password)){
                            logged = user;
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.print("Masukkan nama: ");
                    String nama = objinput.nextLine();
                    System.out.print("Masukkan NIM: ");
                    String nim = objinput.nextLine();
                    for (User user : userList){
                        if(user instanceof Mahasiswa && user.login(nama,nim)){
                            logged = user;
                            break;
                        }
                    }
                    break;
                case 0:
                    System.out.println("Terimakasih telah mengunakan program kami");
                    objinput.close();
                    return;
                default:
                    System.out.println("Input tidak valid");
            }
            if(logged!=null){
                logged.displayInfo();
                logged.displayAppMenu();
            }else  {
                System.out.println("Login gagal cek kembali kredensial");
            }
        }
    }
}


