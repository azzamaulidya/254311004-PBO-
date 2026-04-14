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