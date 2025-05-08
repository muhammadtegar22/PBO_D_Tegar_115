public class Doramona extends Doraemon {

    // Constructor Doramona
    public Doramona() {
        super();
        this.warna = "Pink";
        this.ekor = "Panjang";
    }

    // Override method berbicara
    @Override
    public void berbicara(boolean suara) {
        super.suara = suara;
        System.out.println("Doramona berbicara: " + suara);
    }
}
