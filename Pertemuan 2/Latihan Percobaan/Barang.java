public class Barang {
    String namaBarang, jenisBarang;
    int stok, hargaSatuan;

    Barang(){

    }

    Barang(String nm, String jn, int st, int hs){
        namaBarang = nm;
        jenisBarang = jn;
        stok = st;
        hargaSatuan = hs;
    }

    void tampilBarang(){
        System.out.println("Nama = " + namaBarang);
        System.out.println("Jenis = " + jenisBarang);
        System.out.println("Stok = " + stok);
        System.out.println("Harga Satuan = " + hargaSatuan);
    }
    
    void tambahStok(int n){
        stok=stok+n;
    }
    
    void kurangiStok(int n){
        if(stok >0){
            stok=stok-n;
        }
    }
    
    int hitungHargaTotal (int jumlah){
        return jumlah*hargaSatuan;
    }
}

class BarangMain {
    public static void main(String[] args) {
        Barang b1 = new Barang();
        b1.namaBarang = "Corsair 2 GB";
        b1.jenisBarang = "DDR";
        b1.hargaSatuan = 250000;
        b1.stok = 10;
        b1.tambahStok(1);
        b1.kurangiStok(3);
        b1.tampilBarang();
        int hargaTotal = b1.hitungHargaTotal(4);
        System.out.println("Harga Satuan = " + hargaTotal);
        
        Barang b2 = new Barang("Logitech", "Wireless Mouse", 25, 150000);
        b2.tampilBarang();

        Barang b3 = new Barang("Rexus", "Mechanical Keyboard", 10, 300000);
        b3.tampilBarang();
    }
}
