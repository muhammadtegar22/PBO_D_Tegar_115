package association_1_b;

import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Mahasiswa> mhs = new ArrayList<>();

        // Input nama kelas dari user
        System.out.print("Masukkan nama kelas: ");
        String namaKelas = input.nextLine();

        Kelas kelas = new Kelas(namaKelas, mhs);

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlah = input.nextInt();
        input.nextLine(); // buang newline

        // Input data mahasiswa
        for (int i = 0; i < jumlah; i++) {
            System.out.print("Masukkan NIM Mahasiswa ke-" + (i + 1) + ": ");
            String nim = input.nextLine();
            mhs.add(new Mahasiswa(nim, kelas));
        }

        // Output data
        System.out.println("\nList Mahasiswa di kelas: " + kelas.getNamaKelas());
        System.out.println("============================");

        for (Mahasiswa m : kelas.getMahasiswa()) {
            System.out.println("NIM: " + m.getNim());
        }

        input.close();
    }
}
