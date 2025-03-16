// RekeningBank.java
public class RekeningBank { // Mendefinisikan kelas RekeningBank

    // Atribut
    String nomorRekening; // Menyimpan nomor rekening
    String namaPemilik;   // Menyimpan nama pemilik rekening
    double saldo;         // Menyimpan saldo rekening

    // Konstruktor
    public RekeningBank(String nomorRekening, String namaPemilik, double saldo) { // Konstruktor untuk menginisialisasi objek RekeningBank
        this.nomorRekening = nomorRekening; // Mengisi atribut nomorRekening dengan nilai dari parameter
        this.namaPemilik = namaPemilik;     // Mengisi atribut namaPemilik dengan nilai dari parameter
        this.saldo = saldo;                 // Mengisi atribut saldo dengan nilai dari parameter
    }

    // Method untuk menampilkan informasi rekening
    public void tampilkanInfo() { // Menampilkan informasi rekening ke layar
        System.out.println("Nomor Rekening : " + nomorRekening); // Menampilkan nomor rekening
        System.out.println("Nama Pemilik   : " + namaPemilik);   // Menampilkan nama pemilik rekening
        System.out.println("Saldo          : Rp " + saldo);      // Menampilkan saldo rekening
        System.out.println(); // Mencetak baris kosong untuk pemisah
    }

    // Method untuk setor uang
    public void setorUang(double jumlah) { // Metode untuk menambahkan saldo rekening
        if (jumlah > 0) { // Memeriksa apakah jumlah yang disetor lebih dari 0
            saldo += jumlah; // Menambah saldo dengan jumlah yang disetor
            System.out.println("Berhasil setor uang sebesar Rp " + jumlah); // Menampilkan pesan sukses
            System.out.println("Saldo saat ini: Rp " + saldo); // Menampilkan saldo terbaru
        } else { // Jika jumlah yang disetor tidak valid
            System.out.println("Jumlah setor harus lebih dari 0!"); // Menampilkan pesan error
        }
        System.out.println(); // Mencetak baris kosong untuk pemisah
    }

    // Method untuk tarik uang
    public void tarikUang(double jumlah) { // Metode untuk menarik saldo dari rekening
        if (jumlah > 0 && jumlah <= saldo) { // Memeriksa apakah jumlah yang ditarik valid dan saldo mencukupi
            saldo -= jumlah; // Mengurangi saldo dengan jumlah yang ditarik
            System.out.println("Berhasil tarik uang sebesar Rp " + jumlah); // Menampilkan pesan sukses
            System.out.println("Saldo saat ini: Rp " + saldo); // Menampilkan saldo terbaru
        } else if (jumlah > saldo) { // Jika saldo tidak mencukupi
            System.out.println("Saldo tidak mencukupi untuk penarikan!"); // Menampilkan pesan error
        } else { // Jika jumlah tarik tidak valid
            System.out.println("Jumlah tarik harus lebih dari 0!"); // Menampilkan pesan error
        }
        System.out.println(); // Mencetak baris kosong untuk pemisah
    }
}
