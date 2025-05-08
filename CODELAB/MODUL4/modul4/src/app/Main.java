package app;

import perpustakaan.*; //memakai * agar mempermudah akses class dalam package langsung menggunakan class tersebut tanpa harus menuliskan nama package berulang kali

public class Main {
    public static void main(String[] args) {
        System.out.println("\n === PERPUSTAKAAN ===");
        NonFiksi nonfiksi1 = new NonFiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan"); //constructor
        Fiksi fiksi2 = new Fiksi("Hainuwele: Sang Putri Kelapa", "Lilis Hu", "Dongeng"); //constructor

        nonfiksi1.displayInfo();
        fiksi2.displayInfo();

        System.out.println("\n === DAFTAR ANGGOTA ===");

        Peminjaman anggota1 = new Anggota ("Muhammad Tegar Budi Wicaksano", "ID : 115"); //contructor
        Peminjaman anggota2 = new Anggota ("Faul Cahyaditya", "ID : 138"); // constructor

        anggota1.tampilkanInfo();
        anggota2.tampilkanInfo();

        System.out.println("\n === DAFTAR PEMINJAM ===");

        anggota1.pinjamBuku("Madilog");
        anggota2.pinjamBuku("Hainuwele: Sang Putri Kelapa",7);

        System.out.println("\n === DAFTAR PENGEMBALIAN ===");

        anggota1.kembalikanBuku("Madilog");
        anggota2.kembalikanBuku("Hainuwele: Sang Putri Kelapa");

    }

}

