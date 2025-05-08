public class Doraemon implements Kucing, Manusia {
    boolean suara;
    boolean balingBaling;
    String warna;
    String ekor;

    // Constructor
    public Doraemon() {
        this.warna = "Biru";
        this.ekor = "Pendek";
    }

    // Method getTerbang
    void getTerbang() {
        balingBaling = true;
        berjalan(false);
    }

    // Method getInfo
    void getInfo() {
        System.out.println("Warna: " + warna);
        System.out.println("Panjang ekor: " + ekor);
        System.out.println("Jumlah kaki: 2");
    }

    // Override method berjalan
    public void berjalan(boolean jalan) {
        balingBaling = false;
        System.out.println("Berjalan: " + jalan);
    }

    // Override method berbicara
    public void berbicara(boolean suara) {
        this.suara = suara;
        System.out.println("Berbicara: " + suara);
    }
}
