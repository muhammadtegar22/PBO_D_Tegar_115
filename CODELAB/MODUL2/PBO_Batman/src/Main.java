public class Main {
    public static void main(String[] args) {
        // Polimorfisme: variabel bertipe Batman mengacu ke objek BatmanJR
        Batman batman1 = new Batman();
        Batman batman2 = new BatmanJR();


        batman1.setPerforma(3);
        batman1.setTerbang(20);
        System.out.println("Jarak Batman1: " + batman1.getJarak());


        batman2.setPerforma(5);
        batman2.setTerbang(40); // Harusnya berhasil karena performa * 10 = 50
        System.out.println("Jarak Batman2: " + batman2.getJarak());


        // Untuk akses method yang spesifik milik BatmanJR
        if (batman2 instanceof BatmanJR) {
            BatmanJR jr = (BatmanJR) batman2;
            jr.tembak();
            jr.tembak();
            jr.tembak();
            jr.tembak();
            jr.tembak();
            jr.tembak(); // Akan menampilkan pesan "peluru dalam keadaan kosong"
        }
    }
}
