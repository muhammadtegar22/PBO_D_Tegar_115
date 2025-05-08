package perpustakaan;

public class Fiksi extends Buku { // extends memperluas pewarisan dari class buku
    private final String genre; // memastikan nilainya tetap atau tidak berubah

    public Fiksi(String judul, String penulis, String genre) {
        super(judul, penulis); // memanggil konstruktor milik class induk
        this.genre = genre; // constructor
    }

    @Override
    public void displayInfo() {
        System.out.println("Buku Fiksi: " + judul + " Oleh " + penulis + "(Genre : " + genre + ")"); // menampilkan informasi

    }
}
