public class Main {
    public static void main(String[] args) {
        // Object Doraemon
        Doraemon doraemon = new Doraemon();
        doraemon.getInfo();
        doraemon.getTerbang();
        doraemon.berjalan(true);
        doraemon.berbicara(true);

        System.out.println(); // pemisah

        // Object Doramona
        Doramona doramona = new Doramona();
        doramona.getInfo();
        doramona.getTerbang();
        doramona.berjalan(true);
        doramona.berbicara(false);
    }
}
