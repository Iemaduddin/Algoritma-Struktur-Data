import java.util.Scanner;
public class fungsi {
    static Scanner input = new Scanner(System.in);
    static String toko[] = {"RoyalGarden1", "RoyalGarden2", "RoyalGarden3", "RoyalGarden4"};
    static String bunga[] = {"Aglonema", "Keladi", "Alocasia", "Mawar"};
    static int stock[][] = {{10,5,15,7}, {6,11,9,12}, {2,10,10,5}, {5,7,12,9}};
    static int harga[] = {75000,50000, 60000, 10000};
    static int jmlAg=0, jmlKel=0, jmlAlo=0, jmlMwr=0, jmlRG1=0;


    
    static void tampilArray(){
        System.out.println("\t\t     Aglonema  Keladi  Alocasia  Mawar");
        for(int i=0; i<toko.length; i++){
            System.out.println(toko[i]+"    \t"+stock[i][0]+"\t  "+stock[i][1]+"   \t  "+stock[i][2]+"   \t  "+stock[i][3]);

        }
    }
    
    
    
    static void jmlStock(){
        for(int n=0; n<bunga.length; n++){
            jmlAg += stock[n][0];
            jmlKel += stock[n][1];
            jmlAlo += stock[n][2];
            jmlMwr += stock[n][3];
        }
        System.out.println("\nJumlah stock bunga Aglonema sebanyak "+jmlAg);
        System.out.println("Jumlah stock bunga Keladi sebanyak "+jmlKel);
        System.out.println("Jumlah stock bunga Alocasia sebanyak "+jmlAlo);
        System.out.println("Jumlah stock bunga Mawar sebanyak "+jmlMwr);
        System.out.println("\n");
    }

    public static void main(String[] args){
        char ulang = 'y';
        do{
            boolean succes = true;
            do{
                System.out.println("Pilihan Menu Pertanyaan");
                System.out.println("1. Fungsi untuk menampilkan array stock sesuai tabel");
                System.out.println("2. Fungsi untuk mengetahui jumlah stock berdasarkan jenis bunganya di seluruh cabang");
                System.out.print("Silahkan pilih menu yang Anda inginkan: ");
                int pilMenu = input.nextInt();
                switch(pilMenu){
                    case 1:
                    tampilArray();
                    break;
                    case 2:
                    jmlStock();
                    break;
                    default:
                    System.out.print("Maaf inputan yang Anda masukkan salah!");
                }
            }while(!succes);
                System.out.print("\nIngin kembali ke menu utama? (Y/T) ");
                ulang = input.next().charAt(0);
        }while(ulang=='y' || ulang=='Y');
    }
}
