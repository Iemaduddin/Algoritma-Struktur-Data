import java.util.Scanner;
public class Faktorial{
    public int nilai;

    public int faktoialBF(int n){
        int fakto = 1;
        for(int i=1; i<=n; i++){
            fakto *= i;
        }
        return fakto;
    }

    public int faktoialDC(int n){
        if(n == 1){ // divide
            return 1; //conquer
        }else{ //divide
            int fakto = n* faktoialDC(n-1); //conquer
            return fakto;
        }
    }
}

class MainFaktoial{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long awal = System.currentTimeMillis();
        System.out.println("============================================");
        System.out.print("Masukkan jumlah elemen yang ingin dihitung: ");
        int elemen = sc.nextInt();
        
        Faktorial[] fk = new Faktorial[elemen];
        for(int i=0; i<elemen; i++){
            fk[i] = new Faktorial();
            System.out.print("Masukkan nilai data ke-"+(i+1)+" : ");
            fk[i].nilai = sc.nextInt();
        }
        
        System.out.println("============================================");
        System.out.println("Hasil Faktoial dengan Brute Force");
        for(int i=0; i<elemen; i++){
            System.out.println("Faktoial dari nilai "+fk[i].nilai+" adalah : "+fk[i].faktoialBF(fk[i].nilai));
        }
        System.out.println("============================================");
        System.out.println("Hasil Faktoial dengan Divide and Conquer");
        for(int i=0; i<elemen; i++){
            System.out.println("Faktoial dari nilai "+fk[i].nilai+" adalah : "+fk[i].faktoialDC(fk[i].nilai));
        }
        System.out.println("============================================");
        long selesai = System.currentTimeMillis();
        long time = selesai - awal;
        System.out.println("Waktu Eksekusi : "+String.valueOf(time)+" milidetik");
    }
}