package Praktikum1.Pertanyaan;
import java.util.Scanner;
public class PakaianPertanyaan{
    String jenis, warna, merk, ukuran;
    double harga;

    PakaianPertanyaan(String jenis, String warna, String merk, String ukuran, double harga){
        this.jenis = jenis;
        this.warna = warna;
        this.merk = merk;
        this.ukuran = ukuran;
        this.harga = harga;
    }
}
class StackPertanyaan {
    int size;
    int top;
    PakaianPertanyaan data[];

    public StackPertanyaan(int size){
        this.size = size;
        data = new PakaianPertanyaan[size];
        top = -1;
    }

    public boolean IsEmpty(){
        if (top == -1){
            return true;
        }else{
            return false;
        }
    }

    public boolean IsFull(){
        if (top == size-1){
            return true;
        }else{
            return false;
        }
    }

    public void push(PakaianPertanyaan pkn){
        if ( !IsFull()){
            top++;
            data[top] = pkn;
        }else{
            System.out.println("Isi stackPertanyaan penuh!");
        }
    }

    public void pop(){
        if (!IsEmpty()){
            PakaianPertanyaan x = data[top];
            top--;
            System.out.println("Data yang keluar: " + x.jenis + " "+ x.warna + " " +
            x.merk + " " + x.ukuran + " " + x.harga);
        }else{
            System.out.println("StackPertanyaan masih kosong");
        }
    }

    public void peek(){
        System.out.println("Elemen teratas: "+ data[top].jenis + " " + data[top].warna + " " +
        data[top].merk + " " + data[top].ukuran + " " + data[top].harga);
    }

    public void print(){
        System.out.println("Isi stackPertanyaan: ");
        for(int i=top; i>=0; i--){
            System.out.println(data[i].jenis + " " + data[i].warna + " " + data[i].merk + " " +
            data[i].ukuran + " " + data[i].harga );
        }
        System.out.println("");
    }

    public void clear(){
        if(!IsEmpty()){
            for (int i=top; i>=0; i++){
                top--;
            }
            System.out.println("StackPertanyaan sudah dikosongkan");
        }else{
            System.out.println("StackPertanyaan masih kosong");
        }
    }
}

class StackPertanyaanMainPertanyaan{
    public static void main(String[] args) {
        StackPertanyaan stk = new StackPertanyaan(5);
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        Scanner sc4 = new Scanner(System.in);

        char pilih, ulang;
        int pil;
        do{
            System.out.println("======================================================");
            System.out.println("                     DATA PAKAIANPertanyaan                     ");
            System.out.println("======================================================");
            System.out.println("Pilihan Pemanggilan Fungsi: ");
            System.out.println("1. Push  ");
            System.out.println("2. Pop  ");
            System.out.println("3. Peek  ");
            System.out.println("4. Print  ");
            System.out.print("\nMasukkan pilihan: ");
            pil = sc.nextInt();
            switch(pil){
                case 1:
                    do{
                        System.out.print("Jenis: ");
                        String jenis = sc1.nextLine();
                        System.out.print("Warna: ");
                        String warna = sc2.nextLine();
                        System.out.print("Merk: ");
                        String merk = sc3.nextLine();
                        System.out.print("Ukuran: ");
                        String ukuran = sc4.nextLine();
                        System.out.print("Harga: ");
                        double harga = sc.nextDouble();
            
                        PakaianPertanyaan p = new PakaianPertanyaan(jenis, warna, merk, ukuran, harga);
                        System.out.print("Apakah Anda akan menambahkan data baru ke stackPertanyaan (y/n)? ");
                        pilih = sc.next().charAt(0);
                        sc.nextLine();
                        stk.push(p);
                    }while(pilih == 'y' || pilih == 'Y');
                case 2:
                stk.pop();
                break;

                case 3:
                stk.peek();
                break;

                case 4:
                stk.print();
                break;

                default:
                System.out.println("Inputan yang Anda masukkan salah!");
            }
            
            System.out.print("Apakah ingin melakukan pemanggilan fungsi lagi? (Y/N)");
            ulang = sc.next().charAt(0);
        }while(ulang == 'y' || ulang == 'Y');
        System.out.println("Terima kasih");
    }
}