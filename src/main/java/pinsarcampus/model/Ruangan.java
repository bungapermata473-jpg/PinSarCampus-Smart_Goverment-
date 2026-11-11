package pinsarcampus.model;

public class Ruangan extends Inventaris {
    private static final long serialVersionUID = 1L;
    private int kapasitas;

    public Ruangan(String nama, int kapasitas) {
        super(nama);
        this.kapasitas = kapasitas;
    }

    @Override
    public String getJenis() {
        return "Ruangan";
    }

    @Override
    public int getMaksDurasiHari() {
        return 1;
    }

    public int getKapasitas() { return kapasitas; }
    public void setKapasitas(int kapasitas) { this.kapasitas = kapasitas; }
}