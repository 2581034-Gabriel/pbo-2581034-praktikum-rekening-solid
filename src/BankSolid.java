public class BankSolid {
    public static void main(String[] args) {
        Tabungan ani = new Tabungan("101", "Ani", 1_000_000, 2.5);
        Tabungan citra = new Tabungan("102", "Citra", 300_000, 2.0);
        Giro budi = new Giro("201", "Budi", 200_000, 500_000);
        Deposito dewi = new Deposito("301", "Dewi", 5_000_000, 4.0);

        Rekening[] semua = { ani, citra, budi, dewi };
        BerBunga[] berbunga = { ani, citra, dewi };

        LaporanBank.cetakDaftar("REKENING AWAL", semua);

        System.out.println();
        LaporanBank.cetakJudul("AKHIR BULAN");
        ProsesAkhirBulan.potongBiayaAdmin(semua);
        ProsesAkhirBulan.tambahBunga(berbunga);
        ProsesAkhirBulan.autodebet(semua, 50_000);

        System.out.println();
        LaporanBank.cetakDaftar("REKENING AKHIR", semua);
        LaporanBank.cetakTotal(semua);


// Langkah 7 (LSP): saat Deposito.tarik melempar exception, program berhenti dengan:
// Exception in thread "main" java.lang.UnsupportedOperationException: Deposito tidak bisa ditarik
//     at Deposito.tarik(Deposito.java:23)
//     at ProsesAkhirBulan.autodebet(ProsesAkhirBulan.java:19)
// Penyebab: Deposito melanggar kontrak Rekening.tarik (harusnya mengembalikan false).
// Sudah diperbaiki: Deposito.tarik sekarang mengembalikan false.
    }
            }