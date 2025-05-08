package perpustakaan;

public class NonFiksi extends Buku { // extends memperluas pewarisan dari class buku
    private final String bidang; // memastikan nilainya tetap atau tidak berubah

    public NonFiksi(String judul, String penulis, String bidang) {
        super(judul, penulis); // memanggil konstruktor milik class induk
        this.bidang = bidang; // constructor
    }

    @Override
    public void displayInfo() {
        System.out.println("Buku Non-Fiksi: " + judul + " Oleh " + penulis + "(Bidang : " + bidang + ")"); // menampilkan informasi
    }
}
