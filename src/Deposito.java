public class Deposito extends Rekening implements BerBunga {
    private double bungaPersen;

    public Deposito(String nomor, String pemilik, int saldo, double bungaPersen) {
        super(nomor, pemilik, saldo);
        this.bungaPersen = bungaPersen;
    }

    @Override
    public int tambahBunga() {
        int bunga = (int) Math.round(saldo * bungaPersen / 100);
        saldo += bunga;
        return bunga;
    }

    @Override
    public int biayaAdminBulanan() {
        return 0;
    }

    @Override
    public boolean tarik(int jumlah) {
        return false;
    }
    @Override
    public String keterangan() {
        return "Deposito, bunga " + bungaPersen + "% per bulan";
    }
}