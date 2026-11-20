// Tanggung jawab: mencetak laporan. Rekening tidak lagi tahu cara mencetak dirinya.
public class LaporanBank {
    public static void cetakJudul(String judul) {
        StringBuilder sb = new StringBuilder("========== " + judul + " ");
        while (sb.length() < 35) {
            sb.append('=');
        }
        System.out.println(sb);
    }

    public static void cetakDaftar(String judul, Rekening[] semua) {
        cetakJudul(judul);
        for (Rekening rek : semua) {
            System.out.printf("%s | %-6s | %12s%n",
                    rek.getNomor(), rek.getPemilik(), Rekening.formatRupiah(rek.getSaldo()));
            System.out.println("      " + rek.keterangan());
        }
    }

    public static void cetakTotal(Rekening[] semua) {
        int total = 0;
        for (Rekening rek : semua) {
            total += rek.getSaldo();
        }
        System.out.println("-----------------------------------");
        System.out.println("Total dana bank : " + Rekening.formatRupiah(total));
    }
}