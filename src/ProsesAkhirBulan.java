// Tanggung jawab: memproses transaksi akhir bulan (admin, bunga, autodebet).
public class ProsesAkhirBulan {
    public static void potongBiayaAdmin(Rekening[] semua) {
        for (Rekening rek : semua) {
            int biaya = rek.potongBiayaAdmin();
            System.out.println(rek.getNomor() + " biaya admin  : " + Rekening.formatRupiah(biaya));
        }
    }

    public static void tambahBunga(BerBunga[] berbunga) {
        for (BerBunga b : berbunga) {
            int bunga = b.tambahBunga();
            System.out.println(b.getNomor() + " bunga        : " + Rekening.formatRupiah(bunga));
        }
    }

    public static void autodebet(Rekening[] semua, int jumlah) {
        for (Rekening rek : semua) {
            boolean berhasil = rek.tarik(jumlah);
            String hasil = berhasil ? Rekening.formatRupiah(jumlah) : "gagal";
            System.out.println(rek.getNomor() + " autodebet    : " + hasil);
        }
    }
}