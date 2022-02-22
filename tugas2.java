import java.util.Scanner;
public class tugas2 {
    static Scanner input = new Scanner(System.in);
    static int kecepatan, jarak, waktu;
    static double hasilV, hasilS, hasilT;
    static void rumusV(){
        System.out.print("Masukkan jarak(s) : ");
        jarak = input.nextInt();
        System.out.print("Masukkan waktu(t) : ");
        waktu = input.nextInt();
        hasilV = jarak / waktu;
        System.out.println("===================================================");
        System.out.println("                 HASIL PERHITUNGAN                 ");
        System.out.println("===================================================");
        System.out.println("Rumus Kecepatan");
        System.out.println("v = s/t");
        System.out.println("v = "+jarak+" / "+waktu+" = "+hasilV);
    }
    static void rumusS(){
        System.out.print("Masukkan kecepatan(v) : ");
        kecepatan = input.nextInt();
        System.out.print("Masukkan waktu(t) : ");
        waktu = input.nextInt();
        hasilS = kecepatan * waktu;
        System.out.println("===================================================");
        System.out.println("                 HASIL PERHITUNGAN                 ");
        System.out.println("===================================================");
        System.out.println("Rumus Jarak");
        System.out.println("s = v.t");
        System.out.println("s = "+kecepatan+" x "+waktu+" = "+hasilS);
    }
    static void rumusT(){
        System.out.print("Masukkan jarak(s) : ");
        jarak = input.nextInt();
        System.out.print("Masukkan kecepatan(v) : ");
        kecepatan = input.nextInt();
        hasilT = jarak / kecepatan;
        System.out.println("===================================================");
        System.out.println("                 HASIL PERHITUNGAN                 ");
        System.out.println("===================================================");
        System.out.println("Rumus Waktu");
        System.out.println("t = s/v");
        System.out.println("t = "+jarak+" / "+kecepatan+" = "+hasilT);
    }
    public static void main(String[] args){
        char ulang = 'y';
        do{
            System.out.println("===================================================");
            System.out.println("PROGRAM MENGHITUNG RUMUS KECEPATAN, JARAK DAN WAKTU");
            System.out.println("===================================================");
            boolean succes = true;
            do{
                System.out.println("Pilihan Menu Perhitungan:");
                System.out.println("1. Kecepatan(v)");
                System.out.println("2. Jarak(s)");
                System.out.println("3. Waktu(t)");
                System.out.print("Silahkan pilih menu yang Anda inginkan: ");
                int pilMenu = input.nextInt();
                switch(pilMenu){
                    case 1:
                    rumusV();
                    break;
                    case 2:
                    rumusS();
                    break;
                    case 3:
                    rumusT();
                    break;
                    
                    default:
                    System.out.print("Maaf inputan yang Anda masukkan salah!");
                }
            }while(!succes);
                System.out.print("\nIngin kembali ke menu utama? (Y/T) ");
                ulang = input.next().charAt(0);
        }while(ulang=='y' || ulang=='Y');
            System.out.println("===================================================");
            System.out.println("                  TERIMA KASIH !!!                 ");
            System.out.println("===================================================");
}
}