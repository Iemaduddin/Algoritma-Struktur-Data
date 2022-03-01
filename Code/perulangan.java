import java.util.Scanner;
public class perulangan {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String hari[] = {"Senin", "Selasa", "Rabu", "Kamis", "Jum'at", "Sabtu", "Minggu"};
        System.out.print("Masukkan NIM : ");
        int nim = sc.nextInt();
        
        int duaDigitNim = nim%100;
        if(duaDigitNim<10){
            duaDigitNim += 10;
        }
        System.out.println("==========================");
        System.out.println("n = " + duaDigitNim);
        System.out.println("==========================");

        for(int i=0; i<duaDigitNim; i++){
            System.out.print(hari[i%hari.length]+" ");
        }

    }
}