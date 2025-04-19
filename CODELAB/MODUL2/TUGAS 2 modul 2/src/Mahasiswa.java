// Kelas Mahasiswa
class Mahasiswa {
    private String nama = "Muhammad Tegar Budi Wicaksano";
    private String nim = "202410370110115";

    public boolean login(String inputNama, String inputNim) {
        return nama.equals(inputNama) && nim.equals(inputNim);
    }

    public void displayInfo() {
        System.out.println"Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}