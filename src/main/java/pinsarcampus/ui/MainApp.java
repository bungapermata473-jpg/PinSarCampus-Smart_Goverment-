package pinsarcampus.ui;

import pinsarcampus.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Inventaris> daftarInventaris = new ArrayList<>();
        List<Peminjam> daftarPeminjam = new ArrayList<>();

        // Inisialisasi Data Awal Inventaris Kampus
        daftarInventaris.add(new Elektronik("Proyektor Epson EB-X400"));
        daftarInventaris.add(new Elektronik("Kamera DSLR Canon EOS 80D"));
        daftarInventaris.add(new Ruangan("Aula Sekretariat HIMA / UKM", 75));

        boolean berjalan = true;
        System.out.println("==================================================");
        System.out.println("    SELAMAT DATANG DI SISTEM PINSARCAMPUS        ");
        System.out.println("==================================================");

        while (berjalan) {
            System.out.println("\n--- MENU UTAMA PINSARCAMPUS ---");
            System.out.println("1. Lihat Daftar Inventaris & Ruangan");
            System.out.println("2. Registrasi Peminjam Baru (Mahasiswa/HIMA/UKM)");
            System.out.println("3. Lihat Daftar Peminjam Terdaftar");
            System.out.println("4. Keluar Aplikasi");
            System.out.print("Pilih menu (1-4): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                scanner.next();
                continue;
            }

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- DAFTAR INVENTARIS & RUANGAN ---");
                    for (Inventaris inv : daftarInventaris) {
                        System.out.println("[" + inv.getId() + "] " + inv.getNama() 
                            + " | Jenis: " + inv.getJenis() 
                            + " | Maks Durasi: " + inv.getMaksDurasiHari() + " hari"
                            + " | Status: " + (inv.isTersedia() ? "Tersedia" : "Dipinjam"));
                    }
                    break;

                case 2:
                    System.out.println("\n--- REGISTRASI PEMINJAM PINSARCAMPUS ---");
                    System.out.print("Masukkan Nama Lengkap: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Password: ");
                    String pass = scanner.nextLine();
                    System.out.print("Masukkan Asal Organisasi (HIMA/UKM): ");
                    String org = scanner.nextLine();

                    Peminjam peminjamBaru = new Peminjam(nama, pass, org);
                    daftarPeminjam.add(peminjamBaru);

                    System.out.println("\n[SUKSES] Peminjam berhasil terdaftar di PinSarCampus!");
                    System.out.println("ID User     : " + peminjamBaru.getId());
                    System.out.println("Nama        : " + peminjamBaru.getNama());
                    System.out.println("Peran       : " + peminjamBaru.getPeran());
                    System.out.println("Organisasi  : " + peminjamBaru.getOrganisasi());
                    break;

                case 3:
                    System.out.println("\n--- DAFTAR PEMINJAM TERDAFTAR ---");
                    if (daftarPeminjam.isEmpty()) {
                        System.out.println("Belum ada peminjam yang terdaftar.");
                    } else {
                        for (Peminjam p : daftarPeminjam) {
                            System.out.println("- [" + p.getId() + "] " + p.getNama() + " (" + p.getOrganisasi() + ")");
                        }
                    }
                    break;

                case 4:
                    berjalan = false;
                    System.out.println("\nTerima kasih telah menggunakan PinSarCampus!");
                    break;

                default:
                    System.out.println("Pilihan menu tidak valid! Silakan pilih 1 - 4.");
            }
        }
        scanner.close();
    }
}