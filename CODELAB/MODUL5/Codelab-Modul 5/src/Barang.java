public class Barang {
    private String nama;//menyimpan nama barang
    private int stok;//menyimpan jumlah stok barang

    public Barang(String nama, int stok) {
        this.nama = nama;
        this.stok = stok;
    }

    public String getNama() {//mengakses nilai atribut nama dari luar kelas
        return nama;
    }

    public int getStok() {//mengakses nilai atribut stok dari luar kelas
        return stok;
    }

    public void setStok(int stok) {//mengubah nilai stok suatu barang
        this.stok = stok;
    }
}