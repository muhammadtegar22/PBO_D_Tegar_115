public class Batman {
    protected boolean suara;
    protected double jarak;
    protected int performa;
    protected double suhu;
    protected String posisiSayap;


    public Batman() {
        this.jarak = 0;
        this.performa = 1;
        this.suhu = 30;
        this.posisiSayap = "menutup";
    }


    public void berbicara(boolean suara) {
        this.suara = suara;
    }


    public void setTerbang(double jarakNew) {
        if (jarakNew > this.performa * 10) {
            System.out.println("Performa tidak mendukung");
        } else {
            this.jarak = jarakNew;
        }
    }


    public double getJarak() {
        return this.jarak;
    }


    public void setPerforma(int perform) {
        this.performa = perform;
    }


    public void bergelantungan() {
        if (this.suhu >= 25) {
            this.posisiSayap = "membuka";
        } else {
            this.posisiSayap = "menutup";
        }
    }
}
