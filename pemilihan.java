import java.util.Scanner;
public class pemilihan {
    
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int nilaiUas, nilaiUts, nilaiTugas;
        float nilaiAkhir=0;
        String nilaiHuruf;

        System.out.println("==============================");
        System.out.println("PROGRAM MENGHITUNG NILAI AKHIR");
        System.out.println("==============================");
        
        System.out.print("Masukkan Nilai Tugas: ");
        nilaiTugas = input.nextInt();
        System.out.print("Masukkan Nilai UTS: ");
        nilaiUts = input.nextInt();
        System.out.print("Masukkan Nilai UAS: ");
        nilaiUas = input.nextInt();
        System.out.println("==============================");
        
        

        nilaiAkhir = (float)((0.2*nilaiTugas) + (0.35*nilaiUts) + (0.45*nilaiUas));
        
        if(nilaiAkhir <80 || nilaiAkhir>=100){
            nilaiHuruf = "A";
            System.out.println("Nilai Akhir : "+nilaiAkhir);
            System.out.println("Nilai Huruf : "+nilaiHuruf);
            System.out.println("==============================");
            System.out.println("Selamat Anda LULUS");
        }else if(nilaiAkhir <73 || nilaiAkhir>=80){
            nilaiHuruf = "B+";
            System.out.println("Nilai Akhir : "+nilaiAkhir);
            System.out.println("Nilai Huruf : "+nilaiHuruf);
            System.out.println("==============================");
            System.out.println("Selamat Anda LULUS");
        }else if(nilaiAkhir <65 || nilaiAkhir>=73){
            nilaiHuruf = "B";
            System.out.println("Nilai Akhir : "+nilaiAkhir);
            System.out.println("Nilai Huruf : "+nilaiHuruf);
            System.out.println("==============================");
            System.out.println("Selamat Anda LULUS");
        }else if(nilaiAkhir <60 || nilaiAkhir>=65){
            nilaiHuruf = "C+";
            System.out.println("Nilai Akhir : "+nilaiAkhir);
            System.out.println("Nilai Huruf : "+nilaiHuruf);
            System.out.println("==============================");
            System.out.println("Selamat Anda LULUS");
        }else if(nilaiAkhir <50 || nilaiAkhir>=60){
            nilaiHuruf = "C";
            System.out.println("Nilai Akhir : "+nilaiAkhir);
            System.out.println("Nilai Huruf : "+nilaiHuruf);
            System.out.println("==============================");
            System.out.println("Selamat Anda LULUS");
        }else if(nilaiAkhir <39 || nilaiAkhir>=50){
            nilaiHuruf = "D";
            System.out.println("Nilai Akhir : "+nilaiAkhir);
            System.out.println("Nilai Huruf : "+nilaiHuruf);
            System.out.println("==============================");
            System.out.println("Mohon Maaf Anda TIDAK LULUS");
        }else if(nilaiAkhir <=39){
            nilaiHuruf = "E";
            System.out.println("Nilai Akhir : "+nilaiAkhir);
            System.out.println("Nilai Huruf : "+nilaiHuruf);
            System.out.println("==============================");
            System.out.println("Mohon Maaf Anda TIDAK LULUS");
        }
    }
}

