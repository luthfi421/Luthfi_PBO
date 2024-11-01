import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Bengkel {
    private List<Kendaraan> kendaraans;
    private List<Pelanggan> pelanggans;

    public Bengkel() {
        this.kendaraans = new ArrayList<>();
        this.pelanggans = new ArrayList<>();
    }

    public void tambahKendaraan(Kendaraan kendaraan) {
        kendaraans.add(kendaraan);
    }

    public void tambahPelanggan(Pelanggan pelanggan) {
        pelanggans.add(pelanggan);
    }

    public void catatServis(Kendaraan kendaraan, Servis servis) {
        kendaraan.tambahServis(servis);
    }

    public void tampilkanRiwayatServis(Kendaraan kendaraan) {
        System.out.println("Riwayat Servis untuk " + kendaraan.getMerek() + " " + kendaraan.getModel() +
                " (plat: " + kendaraan.getNomorPlat() + ") (Pemilik: " +
                kendaraan.getPelanggan().getNama() + "):");
        for (Servis servis : kendaraan.getRiwayatServis().getServisList()) {
            System.out.println(servis.getDeskripsi() + " pada " + servis.getTanggal());
        }
        System.out.println();
    }

    public void tampilkanKendaraan() {
        System.out.println("Daftar Kendaraan:");
        for (int i = 0; i < kendaraans.size(); i++) {
            Kendaraan k = kendaraans.get(i);
            System.out.println((i + 1) + ". " + k.getMerek() + " " + k.getModel() + " (Plat: " + k.getNomorPlat() + ")");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bengkel bengkel = new Bengkel();

        System.out.print("Masukkan nama pelanggan: ");
        String namaPelanggan = scanner.nextLine();
        System.out.print("Masukkan no telepon pelanggan: ");
        String noTeleponPelanggan = scanner.nextLine();
        Pelanggan pelanggan = new Pelanggan(namaPelanggan, noTeleponPelanggan);
        bengkel.tambahPelanggan(pelanggan);


        System.out.print("Masukkan nomor plat kendaraan: ");
        String nomorPlat = scanner.nextLine();
        System.out.print("Masukkan merek kendaraan: ");
        String merek = scanner.nextLine();
        System.out.print("Masukkan model kendaraan: ");
        String model = scanner.nextLine();

        Kendaraan kendaraan1 = new Mobil(nomorPlat, merek, model, pelanggan);
        bengkel.tambahKendaraan(kendaraan1);

        System.out.print("Apakah Anda ingin menambahkan kendaraan motor? (y/n): ");
        String tambahMotor = scanner.nextLine();
        if (tambahMotor.equalsIgnoreCase("y")) {
            System.out.print("Masukkan nomor plat kendaraan motor: ");
            nomorPlat = scanner.nextLine();
            System.out.print("Masukkan merek kendaraan motor: ");
            merek = scanner.nextLine();
            System.out.print("Masukkan model kendaraan motor: ");
            model = scanner.nextLine();
            Kendaraan kendaraan2 = new Motor(nomorPlat, merek, model, pelanggan);
            bengkel.tambahKendaraan(kendaraan2);
        }

        bengkel.tampilkanKendaraan();


        System.out.print("Pilih kendaraan untuk diservis (masukkan nomor): ");
        int pilihanKendaraan = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan deskripsi servis: ");
        String deskripsiServis = scanner.nextLine();
        System.out.print("Masukkan tanggal servis (YYYY-MM-DD): ");
        String tanggalServis = scanner.nextLine();

        Kendaraan kendaraanDipilih = bengkel.kendaraans.get(pilihanKendaraan - 1);
        bengkel.catatServis(kendaraanDipilih, new Servis(deskripsiServis, tanggalServis));

        bengkel.tampilkanRiwayatServis(kendaraanDipilih);

        scanner.close();
    }
}