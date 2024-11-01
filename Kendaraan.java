abstract class Kendaraan {
    private String nomorPlat;
    private String merek;
    private String model;
    private RiwayatServis riwayatServis;
    private Pelanggan pelanggan;

    public Kendaraan(String nomorPlat, String merek, String model, Pelanggan pelanggan) {
        this.nomorPlat = nomorPlat;
        this.merek = merek;
        this.model = model;
        this.riwayatServis = new RiwayatServis();
        this.pelanggan = pelanggan;
    }

    public String getNomorPlat() {
        return nomorPlat;
    }

    public String getMerek() {
        return merek;
    }

    public String getModel() {
        return model;
    }

    public RiwayatServis getRiwayatServis() {
        return riwayatServis;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void tambahServis(Servis servis) {
        riwayatServis.tambahServis(servis);
    }
}

