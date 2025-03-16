public class Hewan { // Mendefinisikan kelas bernama Hewan
    // Atribut
    String nama;  // Menyimpan nama hewan
    String jenis; // Menyimpan jenis hewan
    String suara; // Menyimpan suara yang dihasilkan hewan

    // Konstruktor
    public Hewan(String nama, String jenis, String suara) { // Konstruktor untuk menginisialisasi atribut saat objek dibuat
        this.nama = nama;   // Mengisi atribut nama dengan nilai dari parameter
        this.jenis = jenis; // Mengisi atribut jenis dengan nilai dari parameter
        this.suara = suara; // Mengisi atribut suara dengan nilai dari parameter
    }

    // Metode untuk menampilkan informasi hewan
    public void tampilkanInfo() { // Metode untuk mencetak informasi hewan ke layar
        System.out.println("Nama  : " + nama);  // Menampilkan nama hewan
        System.out.println("Jenis : " + jenis); // Menampilkan jenis hewan
        System.out.println("Suara : " + suara); // Menampilkan suara hewan
        System.out.println(); // Mencetak baris kosong untuk pemisah
    }
}
