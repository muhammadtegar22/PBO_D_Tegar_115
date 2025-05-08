package perpustakaan;

public interface Peminjaman {
    void pinjamBuku(String judulBuku);
    void pinjamBuku(String judul, int durasiPeminjaman);
    void kembalikanBuku(String judul);
    void tampilkanInfo();
}
