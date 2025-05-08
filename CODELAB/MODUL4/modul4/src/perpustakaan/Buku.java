package perpustakaan;

public abstract class Buku {
    protected String judul; // class buku merupakan class induk yang mempunyai atribut
    protected String penulis;

    public Buku(String judul, String penulis){
        this.judul = judul; // constructor
        this.penulis = penulis; // constructor
    }

    public abstract void displayInfo();
}
