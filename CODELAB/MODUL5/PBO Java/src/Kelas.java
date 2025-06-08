package association_1_b;

import java.util.ArrayList;

public class Kelas {
    private String namaKelas;
    private ArrayList<Mahasiswa> mahasiswa;

    public Kelas(String namaKelas, ArrayList<Mahasiswa> mahasiswa) {
        this.namaKelas = namaKelas;
        this.mahasiswa = mahasiswa;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public ArrayList<Mahasiswa> getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(ArrayList<Mahasiswa> mahasiswa) {
        this.mahasiswa = mahasiswa;
    }
}
