package pinsarcampus.model;

public class Admin extends Pengguna {
    private static final long serialVersionUID = 1L;
    private String jabatan;

    public Admin(String nama, String password, String jabatan) {
        super(nama, password);
        this.jabatan = jabatan;
    }

    @Override
    public String getPeran() {
        return "Administrator Sarana";
    }

    public String getJabatan() { return jabatan; }
    public void setJabatan(String jabatan) { this.jabatan = jabatan; }
}
