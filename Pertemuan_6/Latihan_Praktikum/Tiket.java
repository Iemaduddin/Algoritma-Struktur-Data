import java.util.Scanner;
public class Tiket {
    String maskapai, asal, tujuan;
    int harga;
    
    Tiket(String m, int h, String a, String t){
        maskapai = m;
        harga = h;
        asal = a;
        tujuan = t;
    }
    
    void tampilAll(){
        System.out.println("----------------------------------------------------------");
        System.out.println("                     AROBIDSH AIRPORT                     ");
        System.out.println("----------------------------------------------------------");
        System.out.println("NAMA MASKAPAI   : "+maskapai);
        System.out.println("ASAL            : "+asal);
        System.out.println("TUJUAN          : "+tujuan);
        System.out.println("HARGA           : "+harga);
    }
}

class TiketService{
    
    Tiket tikets[] = new Tiket[10];
    int tkt;

    void tambah(Tiket mskp){
       if(tkt < tikets.length){
           tikets[tkt] = mskp;
           tkt++;
       }
    }

    void tampilAll(){
        for(Tiket mskp : tikets){
            mskp.tampilAll();
        }
    }

    void bubbleSort(){
        for(int i=0; i<tikets.length; i++){
            for(int j=1; j<tikets.length; j++){
                if(tikets[j].harga > tikets[j-1].harga){
                    //swap
                    Tiket swp = tikets[j];
                    tikets[j] = tikets[j-1];
                    tikets[j-1] = swp;
                }
            }
        }
    }

    void selectionSort(){
        for(int i=0; i<tikets.length; i++){
            int idxMin = i;
            for(int j=i+1; j<tikets.length; j++){
                if(tikets[j].harga < tikets[idxMin].harga){
                    idxMin = j;
                }

                Tiket swap = tikets[idxMin];
                tikets[idxMin] = tikets[i];
                tikets[i] = swap;
            }
        }
    }
}

class MainTiket{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        TiketService tgsPraktikum = new TiketService();

        Tiket tkt1 = new Tiket("Sriwijaya", 500000, "Surabaya", "Jakarta Barat");
        Tiket tkt2 = new Tiket("Lion Air", 350000, "Surabaya", "Malang");
        Tiket tkt3 = new Tiket("Garuda Indonesia", 450000, "Pekanbaru", "Jakarta Timur");
        Tiket tkt4 = new Tiket("indonesia AirAsia", 360000, "Malang", "Bogor");
        Tiket tkt5 = new Tiket("Nusantara Air", 370000, "Pontianak", "Jakarta Selatan");
        Tiket tkt6 = new Tiket("Pelita Air", 560000, "Malang", "Denpasar");
        Tiket tkt7 = new Tiket("Trigana Air Service", 510000, "Lombok", "Jakarta Utara");
        Tiket tkt8 = new Tiket("Wings Abadi Airlines", 530000, "Semarang", "Malang");
        Tiket tkt9 = new Tiket("Asialink", 550000, "Denpasar", "Solo");
        Tiket tkt10 = new Tiket("Batik Air", 570000, "Pati", "Surakarta");

        tgsPraktikum.tambah(tkt1);
        tgsPraktikum.tambah(tkt2);
        tgsPraktikum.tambah(tkt3);
        tgsPraktikum.tambah(tkt4);
        tgsPraktikum.tambah(tkt5);
        tgsPraktikum.tambah(tkt6);
        tgsPraktikum.tambah(tkt7);
        tgsPraktikum.tambah(tkt8);
        tgsPraktikum.tambah(tkt9);
        tgsPraktikum.tambah(tkt10);
        char ulang = 'Y';
        do{
            System.out.println("==========================================================");
            System.out.println("------------------ DATA SEBELUM SORTING ------------------");
            System.out.println("==========================================================");
            tgsPraktikum.tampilAll();
            System.out.println("---------------------------------------------------------");
            System.out.println("Pilihan Sorting: ");
            System.out.println("1. Ascending ");
            System.out.println("2. Descending ");
            System.out.println("---------------------------------------------------------");
            System.out.print("Masukkan Pilihan: ");
            int pil = sc.nextInt();
            
            switch(pil){
                case 1:
                System.out.println("\n\n==========================================================");
                System.out.println("Pengurutan Besar ke Kecil (Ascending)");
                System.out.println("==========================================================");
                System.out.println("Daftar Data Maskapai setelah sorting berdasarkan harga");
                System.out.println("----------------------------------------------------------");
                tgsPraktikum.bubbleSort();
                tgsPraktikum.tampilAll();
                break;
                case 2:
                System.out.println("\n\n==========================================================");
                System.out.println("Pengurutan Kecil ke Besar (Descending)");
                System.out.println("==========================================================");
                System.out.println("Daftar Data Maskapai setelah sorting berdasarkan harga");
                System.out.println("----------------------------------------------------------");
                tgsPraktikum.selectionSort();
                tgsPraktikum.tampilAll();
                break;
                
                default:
                System.out.println("Pilihan yang Anda masukkan salah!");
            }
            System.out.print("Apakah ingin sorting lagi? (Y/T) :");
            ulang = sc.next().charAt(0);
        }while(ulang == 'Y' || ulang == 'y');
        System.out.println("==========================================================");
        System.out.println("---------------------  TERIMA KASIH  ---------------------");
        System.out.println("==========================================================");
    }
}