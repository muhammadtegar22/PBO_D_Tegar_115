public final class BatmanJR extends Batman {
    private int peluru;


    public BatmanJR() {
        this.peluru = 5;
    }


    public void tembak() {
        if (getPeluru() == 0) {
            System.out.println("Peluru dalam keadaan kosong");
        } else {
            this.peluru--;System.out.println("Menembak! Sisa peluru: " + this.peluru);
        }
    }


    public void setPeluru(int tambahPeluru) {
        this.peluru = tambahPeluru;
    }


    public int getPeluru() {
        return this.peluru;
    }
}
