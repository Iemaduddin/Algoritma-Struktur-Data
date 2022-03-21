import java.util.Scanner;
public class Pangkat_pertanyaan {
    public int nilai, pangkat;

    public void Pangkat_pertanyaan (int a, int n) {
        nilai = a;
        pangkat = n;
    }

    public int pangkatBF(int a, int n){
        int hasil = 1;
        for(int i=0; i<n; i++){
            hasil = hasil * a;
        }
        return hasil;
    }

    public int pangkatDC(int a, int n){
        if(n==0){
            return 1;
        }else{
            if(n%2==1){
                return (pangkatDC(a, n/2)*pangkatDC(a, n/2)*a);
            }else{
                return (pangkatDC(a, n/2)*pangkatDC(a, n/2));
            }
        }
    }
}

class MainPangkat_pertanyaan{
    public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       char ulang;
       do{
       System.out.println("=================================================");
       System.out.print("Masukkan jumlah elemen yang ingin dihitung: ");
       int elemen = sc.nextInt();
       
       Pangkat_pertanyaan[] png = new Pangkat_pertanyaan[elemen];
       
       for(int i=0; i<elemen; i++){
           png[i] = new Pangkat_pertanyaan();
           System.out.print("Masukkan nilai yang akan dipangkatkan ke-"+(i+1)+" : ");
           png[i].nilai = sc.nextInt();
           System.out.print("Masukkan nilai pemangkat ke-"+(i+1)+" : ");
           png[i].pangkat = sc.nextInt();
        }
            System.out.println("=================================================");
            System.out.println("Pilihan Perhitungan");
            System.out.println("1. Brute Force");
            System.out.println("2. Divide and Conquer");
            System.out.println("=================================================");
            System.out.print("Masukkan pilihan Anda: ");
            int pil = sc.nextInt();
    
            switch(pil){
                case 1:
                System.out.println("=================================================");
                System.out.println("Hasil Pangkat dengan Bruce Force");
                for(int i=0; i<elemen; i++){
                    System.out.println("Nilai "+png[i].nilai+" pangkat "+png[i].pangkat+" adalah : "+png[i].pangkatBF(png[i].nilai, png[i].pangkat));
                }
                break;
                case 2:
                System.out.println("=================================================");
                System.out.println("Hasil Pangkat dengan Divide and Conquer");
                for(int i=0; i<elemen; i++){
                    System.out.println("Nilai "+png[i].nilai+" pangkat "+png[i].pangkat+" adalah : "+png[i].pangkatDC(png[i].nilai, png[i].pangkat));
                }
                break;
                default:
                System.out.println("Maaf input yang Anda masukkan salah");
            }
            System.out.println("=================================================");
            System.out.print("Apakah ingin kembali ke menu? (Y/T) : ");
            ulang = sc.next().charAt(0); 
        }while(ulang == 'Y' || ulang == 'y');
        System.out.println("=================================================");
        System.out.println("                  TERIMA KASIH                   ");
        System.out.println("=================================================");
    }
}