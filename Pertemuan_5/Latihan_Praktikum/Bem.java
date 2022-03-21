import java.util.Scanner;
public class Bem {
    public int vote, jmlVote=0, jmlKandidat=4;
    public String kandidat;
    public int nilai=1, acc=0, acc2=0,control=0;
    public int[] array = new int[10000];

    public int hitungHasil(int js, int k1, int k2, int k3, int k4){
        if(nilai==5){
            nilai = 1;
        }
        if(nilai == 1 && k1>0){
            array[control] = nilai;
            control++;
            nilai++;
            return hitungHasil(js, k1-1, k2, k3, k4);
        }else if(nilai == 2 && k2>0){
            array[control] = nilai;
            control++;
            nilai++;
            return hitungHasil(js, k1, k2-1, k3, k4);
        }else if(nilai == 3 && k3>0){
            array[control] = nilai;
            control++;
            nilai++;
            return hitungHasil(js, k1, k2, k3-1, k4);
        }else if(nilai == 4 && k4>0){
            array[control] = nilai;
            control++;
            nilai++;
            return hitungHasil(js, k1, k2, k3, k4-1);
        }else if(k1==0 && k2==0 && k3==0 && k4==0){
            if(array[acc] == array[acc+1] && acc + 1<js){
                return array[acc];
            }else if(acc+2<js){
                acc +=2;
                return hitungHasil(js, k1, k2, k3, k4);
            }else{
                return 0;
            }
        }else{
            nilai++;
            return hitungHasil(js, k1, k2, k3, k4);
        }
    }
}

class MainBem{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("      Pemilihan Ketua BEM Tahun 2022     ");
        System.out.println("==========================================");
        
        Bem bem = new Bem();
        Bem[] bem2 = new Bem[bem.jmlKandidat];
        for(int i=0; i<bem.jmlKandidat; i++){
            bem2[i] = new Bem();
            System.out.print("Nama Kandidat ke-"+(i+1)+" : ");
            bem2[i].kandidat = sc.nextLine();
        }
        
        System.out.println("==========================================");
        for(int i=0; i<bem.jmlKandidat; i++){
            System.out.print("Masukkan Jumlah Suara Kandidat ke-"+(i+1)+" : ");
            bem2[i].vote = sc.nextInt();
            bem.jmlVote += bem2[i].vote;
        }
        
        System.out.println("==========================================");
        int hasil = bem.hitungHasil(bem.jmlVote, bem2[0].vote, bem2[1].vote, bem2[2].vote, bem2[3].vote); 
        if(hasil==0){
            System.out.println("Masing-masing kandidat memiliki mayoritas yang hampir sama");
        }else{
            System.out.println("Ketua BEM yang terpilih adalah "+bem2[hasil-1].kandidat);
        }
    }
}