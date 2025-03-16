public class Main { // Mendefinisikan kelas utama bernama Main
    public static void main(String[] args) { // Metode utama yang akan dieksekusi pertama kali saat program dijalankan

        // Membuat objek hewan1 dari kelas Hewan dengan nama "Kucing", jenis "Mamalia", dan suara "Nyann~~"
        Hewan hewan1 = new Hewan("Kucing", "Mamalia", "Nyann~~");

        // Membuat objek hewan2 dari kelas Hewan dengan nama "Anjing", jenis "Mamalia", dan suara "Woof-Woof!!"
        Hewan hewan2 = new Hewan("Anjing", "Mamalia", "Woof-Woof!!");

        // Memanggil metode tampilkanInfo() untuk menampilkan informasi dari hewan1
        hewan1.tampilkanInfo();

        // Memanggil metode tampilkanInfo() untuk menampilkan informasi dari hewan2
        hewan2.tampilkanInfo();
    }
}