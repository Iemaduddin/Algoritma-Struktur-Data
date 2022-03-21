import java.util.Scanner;
public class Pacman {
    int pil;
    
    Pacman(int a){
        pil = a;
        System.out.println("Energi default sebesar: " + pil*10 + " diberikan kepada ");
    }
    
    
    void makanPil(int n){
        pil += n;
        System.out.println("Energi yang diperoleh Pacman: " + pil);
    }
}

class Kuman {
    int powerKuman;
    
    Kuman (int power){
        powerKuman = power;
    }
    
    void makanPacman(int p){
        powerKuman +=p;
        System.out.println("\nKekuatan kuman bertambah sebesar: "+powerKuman);
        
    }
}
class GameMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=========PACMAN=========");
        System.out.println("\nTentukan jumlah Pacman: ");
        int pm = sc.nextInt();
        Pacman[] p = new Pacman[pm];
        
        System.out.println("\nTentukan jumlah pil untuk setiap Pacman: ");
        int pil = sc.nextInt();
        int totalPil = 10*pil;

        for (int i=0;i<pm;i++){
            p[i] = new Pacman(totalPil);
            System.out.println("===> pacman ke-"+(i+1)+" <==== sesuai jumlah pil sebanyak -"+pil+" buah");

        }
        
        
        System.out.println("\n\n=========KUMAN=========");
        System.out.println("\nTentukan jumlah Kuman: ");
        int km = sc.nextInt();
        Kuman[] k = new Kuman[km];

        for(int j=0;j<km;j++){
            int pk=0;
            k[j] = new Kuman(pk);

            System.out.println("Kuman ke-"+(j+1) + " memiliki power -"+pk);




        }
        
        System.out.println("\n\n======GAME PACMAN VS KUMAN=====");
        System.out.println("\nPilih Pacman yang kamu mainkan!");
        System.out.println("Pilih Pacman ke: ");
        int opsi = sc.nextInt();
        System.out.println("Kamu memilih pacman ke-"+(opsi));
        
        System.out.println("\nTentukan jumlah pil yang dimakan oleh Pacman ke-"+(opsi)+"!");
        int pil2 = sc.nextInt();
        int ePil =0;
        ePil = pil2*10;
        p[opsi-1].makanPil(ePil);


       
        System.out.println("\nTentukan kuman yang kamu mainkan!");
        System.out.println("Pilih kuman ke:");
        int km2 = sc.nextInt();
        System.out.println("kuman ke -"+km2+" menyerang pacman -"+(opsi)+" !");
        int pKuman = 10;
        k[km2-1].makanPacman(pKuman);

        System.out.println("Kekuatan Pacman ke-"+(opsi)+" berkurang menjadi : "+ (p[opsi-1].pil-5) );

        
        
        
        
    }
}

