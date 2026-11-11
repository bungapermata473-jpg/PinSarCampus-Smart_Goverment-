package pinsarcampus.model;

public class Peminjam extends Pengguna {
    private static final long serialVersionUID = 1L;
    private String organisasi;

    public Peminjam(String nama, String password, String organisasi) {
        super(nama, password);
        this.organisasi = organisasi;
    }

    @Override
    public String getPeran() {
        return "Peminjam (Mahasiswa/Organisasi)";
    }

    public String getOrganisasi() { return organisasi; }
    public void setOrganisasi(String organisasi) { this.organisasi = organisasi; }
}