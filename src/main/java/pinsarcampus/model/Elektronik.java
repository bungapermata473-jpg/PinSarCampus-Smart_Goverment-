package pinsarcampus.model;

public class Elektronik extends Inventaris {
    private static final long serialVersionUID = 1L;

    public Elektronik(String nama) {
        super(nama);
    }

    @Override
    public String getJenis() {
        return "Elektronik";
    }

    @Override
    public int getMaksDurasiHari() {
        return 3;
    }
}