import java.util.Scanner;
public class Sum_pertanyaan {
    public int elemen;
    public double keuntungan[];
    public double total;

    Sum_pertanyaan(int elemen){
        this.elemen = elemen;
        this.keuntungan =  new double[elemen];
        this.total = 0;
    }

    double totalBF(double arr[]){
        for(int i=0; i<elemen; i++){
            total = total + arr[i];
        }
        return total;
    }

    double totalDC(double arr[], int l, int r){
        if(l==r){
            return arr[l];
        }else if(l<r){
            int mid = (l+r)/2;
            double lsum = totalDC(arr, l, mid-1);
            double rsum = totalDC(arr, mid+1, r);
            return lsum+rsum+arr[mid];
        }
        return 0;
    }
}

class MainSum_pertanyaan{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=============================================================");
        System.out.println("Program Menghitung Keuntungan Total (Satuan Juta. Misal 5.9) ");
        System.out.println("=============================================================");
        System.out.print("Masukkan jumlah perusahaan : ");
        Sum_pertanyaan[] smArray = new Sum_pertanyaan[sc.nextInt()];
        
        for(int i=0; i<smArray.length; i++){
            System.out.println("=============================================================");
            System.out.println("Data perusahaan ke-"+(i+1));
            System.out.print("Masukkan jumlah bulan : ");
            int elemen = sc.nextInt();
            smArray[i] = new Sum_pertanyaan(elemen);
            
            for(int j=0; j<elemen; j++){
                System.out.print("Masukkan untung bulan ke - "+(j+1)+" = ");
                smArray[i].keuntungan[j] = sc.nextDouble();
            }
        }
        
        for(int i=0; i<smArray.length; i++){
            System.out.println("=============================================================");
            System.out.println("Hasil perhitungan perusahaan ke-"+(i+1));
            System.out.println("Algoritma Brute Force");
            System.out.printf("Total keuntungan perusahaan selama "+smArray[i].elemen+" bulan adalah = %4.2f%n",smArray[i].totalBF(smArray[i].keuntungan));
            System.out.println("Algoritma Divide Conquer");
            System.out.printf("Total keuntungan perusahaan selama "+smArray[i].elemen+" bulan adalah = %4.2f%n",smArray[i].totalDC(smArray[i].keuntungan, 0, smArray[i].elemen-1)); 
        }
        System.out.println("=============================================================");
    }
}