import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        String nama = "Azza Maulidya W";
        String nim = "254311004";

        ArrayList<LayananTransportasi> list = new ArrayList<>();

        list.add(new MadiunMotor("Ifan", 5, 50000));
        list.add(new MadiunMobil("Fian", 10, 1000, nim));

        for (LayananTransportasi laytrans : list) {
            laytrans.prosesTransaksi(nama, nim);
        }
    }
}