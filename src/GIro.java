public class Giro extends Rekening {
    private int batasOverdraft;

    public Giro(String nomor, String pemilik, int saldo, int batasOverdraft) {
        super(nomor, pemilik, saldo);
        this.batasOverdraft = batasOverdraft;
    }

    @Override
    public boolean tarik(int jumlah) {
        if (jumlah > 0 && saldo - jumlah >= -batasOverdraft) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }

    @Override
    public int biayaAdminBulanan() {
        return 15_000;
    }

    @Override
    public String keterangan() {
        return "Giro, batas overdraft " + formatRupiah(batasOverdraft);
    }
}