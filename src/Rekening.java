import java.util.Locale;

public abstract class Rekening {
    private String nomor;
    private String pemilik;
    protected int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getNomor() {
        return nomor;
    }

    public String getPemilik() {
        return pemilik;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setor(int jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
        }
    }

    // Kontrak tarik: true kalau berhasil, false kalau gagal, tidak pernah melempar exception.
    public boolean tarik(int jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }

    // Setiap jenis rekening wajib menentukan biaya admin bulanannya sendiri.
    public abstract int biayaAdminBulanan();

    // Baris kedua laporan, misalnya "Tabungan, bunga 2.5% per bulan".
    public abstract String keterangan();

    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }

    public static String formatRupiah(int angka) {
        return "Rp" + String.format(Locale.GERMANY, "%,d", angka);
    }
}