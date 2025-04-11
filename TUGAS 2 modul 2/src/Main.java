import java.util.Scanner;

// Kelas Admin
class Admin {
    private String username = "Admin115";
    private String password = "password115";

    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }
}

// Kelas Mahasiswa
class Mahasiswa {
    private String nama = "Muhammad Tegar Budi Wicaksano";
    private String nim = "202410370110115";

    public boolean login(String inputNama, String inputNim) {
        return nama.equals(inputNama) && nim.equals(inputNim);
    }

    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}

// Kelas Utama (LoginSystem)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin();
        Mahasiswa mahasiswa = new Mahasiswa();

        System.out.println("Pilih Jenis Login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        int pilihan = sc.nextInt();
        sc.nextLine(); // membersihkan newline

        if (pilihan == 1) {
            // Login sebagai Admin
            System.out.print("Masukkan Username: ");
            String username = sc.nextLine();
            System.out.print("Masukkan Password: ");
            String password = sc.nextLine();

            if (admin.login(username, password)) {
                System.out.println("Login Admin berhasil!");
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }

        } else if (pilihan == 2) {
            // Login sebagai Mahasiswa
            System.out.print("Masukkan Nama: ");
            String nama = sc.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = sc.nextLine();

            if (mahasiswa.login(nama, nim)) {
                System.out.println("Login Mahasiswa berhasil!");
                mahasiswa.displayInfo();
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }

        } else {
            System.out.println("Pilihan tidak valid.");
        }

        sc.close();
    }
}