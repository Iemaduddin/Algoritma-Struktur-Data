# **Algoritma dan Struktur Data 2021-2022** #

**Nama: Iemaduddin**

**No/Kelas   : 16/TI-1F**

**NIM   : 2141720055**

---
**JOBSHEET II OBJEK**

**2.2 Deklarasi Class, Atribut dan Method**

```
public class Barang {
    String namaBarang, jenisBarang;
    int stok, hargaSatuan;


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
        stok=stok-n;
    }

    int hitungHargaTotal (int jumlah){
        return jumlah*hargaSatuan;
    }
}
```

**2.2.3 Pertanyaan**

1. Sebutkan 2 karakteristik class/objek!

   **Jawab:** Atribut dan Method

2. Kata kunci apakah yang digunakan untuk mendeklarasikan class?

   **Jawab:** _class namaClass_

3. Perhatikan class **Barang** yang ada di Praktikum di atas, ada berapa atribut yang dimiliki oleh class tersebut? Sebutkan! Dan pada baris berapa saja deklarasi atribut dilakukan?

   **Jawab:** Ada 4 atribut, yaitu:

   - namaBarang dan jenisBarang bertipe data String dideklarasikan pada baris ke-13 (di Jobsheet)

   - stok dan hargaSatuan bertipe data int dideklarasikan pada baris ke-14 (di Jobsheet).

4. Ada berapa method yang dimiliki oleh class tersebut? Sebutkan! Dan pada baris berapa saja deklarasi method dilakukan?

   **Jawab:** Ada 4 method, yakni:

   - tampilBarang() bertipe data void pada baris ke-16

   - tambahStok(int n) bertipe data void pada baris ke-23

   - kurangiStok(int n) bertipe data void pada baris ke-27

   - hitungHargaTotal(int jumlah) bertipe data int pada baris ke-31

5. Perhatikan method **kurangiStok()** yang ada di class Barang, modifikasi isi method tersebut sehingga proses pengurangan hanya dilakukan jika stok masih ada (masih lebih besar dari 0)

   **Jawab:**

   ```
   void kurangiStok(int n){
        if(stok >0){
            stok=stok-n;
        }
    }
   ```

6. Menurut Anda, mengapa method **tambahStok()** dibuat dengan memiliki 1 parameter berupa bilangan int?

   **Jawab:** Karena pada method **tambahStok()** digunakan untuk menambahkan stok dengan satu variabel saja yaitu n, yang mana n tersebut digunakan untuk inputan jumlah stok yang ingin ditambahkan

7. Menurut Anda, mengapa method **hitungHargaTotal()** memiliki tipe data int?

   **Jawab:** Karena pada method **hitungHargaTotal()** digunakan untuk menghitung harga total dengan menginputkan jumlah barang yang dibeli lalu dikalikan dengan harga satuan yang telah ditentukan sehingga hasilnya akan digunakan pada method yang lain dengan kata lain method pada **hitungHargaTotal()** membutuhkan tipe data kembalian

8. Menurut Anda, mengapa method **tambahStok()** memiliki tipe data void?

   **Jawab:** Karena pada method **tambahStok()** tidak membutuhkan tipe data kembalian

**2.3 Instansiasi Objek dan Mengakses Atribut & Method**

```
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
    }
}
```

**2.3.2 Verifikasi Hasil Percobaan**

![Output 2.3.2](Screenshot/2.3.2.jpg)

**2.3.3 Pertanyaan**

1. Pada class **BarangMain**, pada baris berapakah proses instansiasi dilakukan? Dan apa nama objek yang dihasilkan?

   **Jawab:** Proses instansiasi berada pada baris ke-13 (di jobsheet) dan menghasilkan nama objek, yaitu **b1**.

2. Bagaimana cara mengakses atribut dan method dari suatu objek?

   **Jawab:**

   - Cara mengakses atribut dari suatu objek:

   ```
       namaObjek.namaAtribut = nilai;
   ```

   - Cara mengakses method dari suatu objek:

   ```
       namaObjek.namaMethod();
   ```

**2.4 Membuat Konstruktor**

```
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
    }
}
```

**2.4.2 Verifikasi Hasil Percobaan**

![Output 2.4.2](Screenshot/2.4.2.jpg)

**2.4.3 Pertanyaan**

1. Perhatikan class **Barang** yang ada di Praktikum 2.4.1, pada baris berapakah deklarasi konstruktor berparameter dilakukan?

   **Jawab:** deklarasi konstruktor berparameter dilakukan pada baris ke-18, yakni:

```
    Barang(String nm, String jn, int st, int hs){
        namaBarang = nm;
        jenisBarang = jn;
        stok = st;
        hargaSatuan = hs;
    }
```

2.  Perhatikan class **BarangMain** di Praktikum 2.4.1, apa sebenarnya yang dilakukan pada baris program dibawah ini?
    `Barang b2 = new Barang("Logitech", "Wireless Mouse", 150000, 25);`

    **Jawab:** Penggunaan konstruktor berparameter pada saat instansiasi objek

3.  Coba buat objek dengan nama **b3** dengan menggunakan konstruktor berparameter dari class **Barang**.

```
Barang b3 = new Barang("Rexus", "Mechanical Keyboard", 10, 300000);
b3.tampilBarang();
```

**2.5 Latihan Praktikum**

Waktu : 60 Menit

1. Buat program berdasarkan diagram class berikut ini!

| Barang |
| ----------------------------------------------------------------------- |
| nama: String
hargaSatuan: int
jumlah: int  
| ----------------------------------------------------------------------- |
| hitungHargaTotal(): int
hitungDiskon(): int
hitungHargaBayar(): int |

- Method hitungHargaTotal() digunakan untuk menghitung harga total yang merupakan perkalian antara hargaSatuan dengan jumlah barang yang dibeli
- Method hitungDiskon() digunakan untuk menghitung diskon dengan aturan sbb:
    - Jika harga total > 100000, akan mendapat diskon 10%
    - Jika harga total mulai dari 50000 sampai 100000 akan mendapat diskon sebesar 5%
    - Jika dibawah 50000 tidak mendapat diskon
- Method hitungHargaBayar() digunakan untuk menghitung harga total setelah dikurangi diskon

**Jawab:**
- Code:
```
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
```
- Output:
![Output Latihan Praktikum Nomor 1](Screenshot/2.5.1.jpg)

2. Buat program berdasarkan diagram class berikut ini!

| PacMan                                                                                   |
| ---------------------------------------------------------------------------------------- |
|x: int 
y: int 
width: int 
height: int|                                      |
| ---------------------------------------------------------------------------------------- |
| moveLeft(): void 
moveRight(): void 
moveUp(): void 
moveDown(): void 
printPosition(): void |

- Atribut x digunakan untuk menyimpan posisi koordinat x (mendatar) dari pacman, sedangkan atribut y untuk posisi koordinat y (vertikal)
- Atribut width digunakan untuk menyimpan lebar dari area permainan, sedangkan height untuk menyimpan panjang area
- Method moveLeft() digunakan untuk mengubah posisi pacman ke kiri (koordinat x akan berkurang 1), sedangkan moveRight() untuk bergerak ke kanan (koordinat x akan bertambah. Perlu diperhatikan bahwa koordinat x tidak boleh lebih kecil dari 0 atau lebih besar dari nilai width
- Method moveUp() digunakan untuk mengubah posisi pacman ke atas (koordinat y akan berkurang 1), sedangkan moveDown() untuk bergerak ke bawah (koordinat y akan bertambah. Perlu diperhatikan bahwa koordinat y tidak boleh lebih kecil dari 0 atau lebih besar dari nilai height.


**Jawab:**
- Code:
```
public class PacMan {
    int x,y,width,height;

    void moveLeft(){
        x-=1;
    }
    void moveRight(){
        x+=1;
    }
    void moveUp(){
        y-=1;
    }
    void moveDown(){
        y+=1;
    }
    void printPosition(){
        System.out.println("Posisi Pac Man saat ini berada di koordinat "+x+","+y);
    }
}

class PacManMain {
    public static void main(String args[]) {
        
        PacMan pc = new PacMan();
        pc.x = 5;
        pc.y= 3;
        pc.width = 30;
        pc.height = 25;
        if(pc.x <0 || pc.x > pc.width){
            System.exit(0);
        }
        if(pc.y <0 || pc.y > pc.height){
            System.exit(0);
        }
        System.out.println("Posisi Awal Pac Man berada di koordinat "+pc.x+","+pc.y);
        
        pc.moveDown();
        pc.moveLeft();
        pc.moveLeft();
        pc.moveLeft();
        pc.printPosition();
    }
}
```
- Output:
![Output Latihan Praktikum Nomor 2](Screenshot/2.5.2.jpg)


## **Terima Kasih** ##