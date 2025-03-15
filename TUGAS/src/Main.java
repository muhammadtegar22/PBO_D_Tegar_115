import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String lastThreeDigits = "115";
        String usernameValid = "Admin" + lastThreeDigits;
        String passwordValid = "password" + lastThreeDigits;
        String namaMahasiswa = "Muhammad Tegar Budi Wicaksano";
        String nomorMahasiwa = "202410370110115";

        System.out.println("Pilih Jenis Login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        int pilihan = sc.nextInt();
        sc.nextLine();

        if (pilihan == 1)
        {
            System.out.print("Masukkan Username: ");
            String username = sc.nextLine();
            System.out.print("Masukkan Password: ");
            String password = sc.nextLine();

            if (username.equals(usernameValid) && password.equals(passwordValid)) {
                System.out.println("Login Admin berhasil!");
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }
        }
        else if (pilihan == 2)
        {
            System.out.print("Masukkan Nama: ");
            String nama = sc.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = sc.nextLine();

            if (nama.equals(namaMahasiswa) && nim.equals(nomorMahasiwa)) {
                System.out.println("Login Mahasiswa berhasil!");
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }
        }
        else
        {
            System.out.println("Pilihan tidak valid.");
        }

        sc.close();
    }
}