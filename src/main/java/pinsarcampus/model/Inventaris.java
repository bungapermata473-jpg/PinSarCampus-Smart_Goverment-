package pinsarcampus.model;

import java.io.Serializable;

public abstract class Inventaris implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int counter = 0;
    private final String id;
    private String nama;
    private boolean tersedia = true;

    public Inventaris(String nama) {
        this.id = "INV-" + (++counter);
        this.nama = nama;
    }

    public abstract String getJenis();
    public abstract int getMaksDurasiHari();

    public String getId() { return id; }
    public String getNama() { return nama; }
    public boolean isTersedia() { return tersedia; }
    public void setTersedia(boolean tersedia) { this.tersedia = tersedia; }
}