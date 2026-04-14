abstract class LayananTransportasi {
    protected String namaDriver;
    protected double jarak;
    protected double saldoUser;
    public LayananTransportasi(String namaDriver, double jarak, double saldoUser) {
        this.namaDriver = namaDriver;
        this.jarak = (jarak <= 0) ? 1 : jarak;
        this.saldoUser = saldoUser;
    }

    public abstract double hitungTarif();

    public void prosesTransaksi(String nama, String nim) {
        double total = hitungTarif();

        System.out.println("=== Transaksi oleh " + nama + " - " + nim + " ===");

        if (saldoUser >= total) {
            saldoUser -= total;
            System.out.println("Driver: " + namaDriver);
            System.out.println("Jarak: " + jarak + " km");
            System.out.println("Total Bayar: Rp " + total);
            System.out.println("Sisa Saldo: Rp " + saldoUser);
        } else {
            System.out.println("Gagal: Saldo tidak mencukupi untuk perjalanan ini!");
        }

        System.out.println();
    }
}

class MadiunMotor extends LayananTransportasi {

    public MadiunMotor(String namaDriver, double jarak, double saldoUser) {
        super(namaDriver, jarak, saldoUser);
    }

    @Override
    public double hitungTarif() {
        return jarak * 2500;
    }
}

class MadiunMobil extends LayananTransportasi {

    private String nim;

    public MadiunMobil(String namaDriver, double jarak, double saldoUser, String nim) {
        super(namaDriver, jarak, saldoUser);
        this.nim = nim;
    }
    
    private int ambil2DigitTerakhir() {
        return Integer.parseInt(nim.substring(nim.length() - 2));
    }

    private double hitungBiayaAdmin() {
        return 3000 + (ambil2DigitTerakhir() * 100);
    }

    @Override
    public double hitungTarif() {
        return (jarak * 5000) + hitungBiayaAdmin();
    }
}