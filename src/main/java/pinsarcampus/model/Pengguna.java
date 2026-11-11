package pinsarcampus.model;

import java.io.Serializable;

public abstract class Pengguna implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int counter = 0;
    private final String id;
    private String nama;
    private String password;

    public Pengguna(String nama, String password) {
        this.id = "USR-" + (++counter);
        setNama(nama);
        this.password = password;
    }

    public abstract String getPeran();

    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama wajib diisi!");
        }
        this.nama = nama;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public boolean cekPassword(String input) { return password.equals(input); }
}