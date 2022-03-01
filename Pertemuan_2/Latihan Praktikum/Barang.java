public class Barang {
    String namaBarang;
    int hargaSatuan, hargaTotal, diskon;

    int hitungHargaTotal(int jumlah){
        hargaTotal = jumlah*hargaSatuan;
        return hargaTotal; 
    }

    int hitungDiskon(int n){
        if(hargaTotal>100000){
            diskon = hargaTotal * 10/100;
            return diskon;
        }else if(hargaTotal>=50000 && hargaTotal<=100000){
            diskon = hargaTotal * 5/100;
            return diskon;
        }else if(hargaTotal <50000){
            diskon=0;
        }
        return diskon;
    }

    int hitungHargaBayar(int hargaBayar){
        hargaBayar =  hargaTotal - (int) diskon;
        return hargaBayar;
    }
}


class BarangMain {
    public static void main(String[] args) {
        Barang a1 = new Barang(); 
        a1.namaBarang = "Mouse Logitech";
        a1.hargaSatuan = 30000;
        a1.hitungHargaTotal(1);
        a1.hitungDiskon(0);
        int hargaTotal = a1.hitungHargaBayar(0);
        System.out.println("===============================================================");
        System.out.println("                            Rincian                            ");
        System.out.println("===============================================================");
        System.out.println("Nama Barang : "+a1.namaBarang);
        System.out.println("Harga Awal  : "+a1.hitungHargaTotal(1));
        System.out.println("Diskon      : "+a1.diskon);
        System.out.println("Harga Akhir : "+hargaTotal);
        
        Barang a2 = new Barang();
        a2.namaBarang = "Keyboard Mechanical";
        a2.hargaSatuan = 40000;
        a2.hitungHargaTotal(2);
        a2.hitungDiskon(0);
        hargaTotal = a2.hitungHargaBayar(0);
        System.out.println("===============================================================");
        System.out.println("                            Rincian                            ");
        System.out.println("===============================================================");
        System.out.println("Nama Barang : "+a2.namaBarang);
        System.out.println("Harga Awal  : "+a2.hitungHargaTotal(2));
        System.out.println("Diskon      : "+a2.diskon);
        System.out.println("Harga Akhir : "+hargaTotal);
        
        
        Barang a3 = new Barang();
        a3.namaBarang = "Headset Gaming Rexus";
        a3.hargaSatuan = 150000;
        a3.hitungHargaTotal(2);
        a3.hitungDiskon(0);
        hargaTotal = a3.hitungHargaBayar(0);
        System.out.println("===============================================================");
        System.out.println("                            Rincian                            ");
        System.out.println("===============================================================");
        System.out.println("Nama Barang : "+a3.namaBarang);
        System.out.println("Harga Awal  : "+a3.hitungHargaTotal(2));
        System.out.println("Diskon      : "+a3.diskon);
        System.out.println("Harga Akhir : "+hargaTotal);
    }
}