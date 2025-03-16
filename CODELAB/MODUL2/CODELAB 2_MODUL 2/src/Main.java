public class Main { // Mendefinisikan kelas utama bernama Main
    public static void main(String[] args) { // Metode utama yang akan dieksekusi pertama kali saat program dijalankan

        // Membuat objek rekening1 dari kelas RekeningBank dengan nomor rekening, nama pemilik, dan saldo awal
        RekeningBank rekening1 = new RekeningBank("12345115", "Tegar", 500000);

        // Membuat objek rekening2 dari kelas RekeningBank dengan nomor rekening, nama pemilik, dan saldo awal
        RekeningBank rekening2 = new RekeningBank("12345222", "Rafly", 300000);

        // Menampilkan informasi rekening pertama
        System.out.println("=== Informasi Rekening 1 ===");
        rekening1.tampilkanInfo();

        // Menampilkan informasi rekening kedua
        System.out.println("=== Informasi Rekening 2 ===");
        rekening2.tampilkanInfo();

        // Melakukan transaksi pada rekening pertama
        System.out.println("=== Transaksi Rekening 1 ===");
        rekening1.setorUang(150000);  // Menyetor uang sebesar Rp 150.000 ke rekening pertama
        rekening1.tarikUang(200000);  // Menarik uang sebesar Rp 200.000 dari rekening pertama

        // Melakukan transaksi pada rekening kedua
        System.out.println("=== Transaksi Rekening 2 ===");
        rekening2.setorUang(50000);   // Menyetor uang sebesar Rp 50.000 ke rekening kedua
        rekening2.tarikUang(400000);  // Mencoba menarik uang Rp 400.000 (saldo tidak mencukupi)
    }
}