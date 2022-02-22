import java.util.Scanner;

public class tugas1 {
    public static void main (String args[]){
        Scanner tgs = new Scanner(System.in);
        char status = 'y';
        
        double total=0;
        do{
            System.out.print("\nMasukkan berat laundry Anda(Kg): ");
            int berat = tgs.nextInt();
            System.out.print("Silahkan masukkan nama Anda: ");
            String nama = tgs.next();

            double tarif = berat * 4500;

            if(berat > 10){
                double diskon = tarif * 0.05;
                tarif -= diskon;
                total += tarif;
            }else{
                total += tarif;
            }
            System.out.print("Apakah ingin mengulangi? (Y/T): ");
            status = tgs.next().charAt(0);
        
        }while(status == 'y' || status == 'Y');

        System.out.print("\nTotal pendapatan Smile Laundry sebesar Rp" + total);
    }
}
