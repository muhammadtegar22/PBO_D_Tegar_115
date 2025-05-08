package perpustakaan;

public class Anggota implements Peminjaman { // (implements) digunakan saat sebuah class ingin menerapkan interface

    String nama, idAnggota;

    public Anggota(String nama, String idAnggota) {
        this.nama = nama; // constructor
        this.idAnggota = idAnggota;
    }

    public void tampilkanInfo() { System.out.println("Anggota: " + nama + "(ID: " + idAnggota + ")");
    }

    @Override
    public void pinjamBuku(String judulBuku) {
        System.out.println(nama + " meminjam buku berjudul: " + judulBuku);
    }

    public void pinjamBuku(String judul, int durasiPeminjaman) {
        System.out.println(nama + " meminjam buku " + judul + " selama " + durasiPeminjaman + " hari");
    }

    @Override
    public void kembalikanBuku(String judul) {
        System.out.println(nama + " mengembalikan buku berjudul: " + judul);
    }
}

