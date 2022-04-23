package Tugas.No_1;
import java.util.Scanner;
public class Queue {
    int[] data;
    int front;
    int rear;
    int size;
    int max;

    public Queue(int n){
        max = n;
        data = new int[max];
        size = 0;
        front = rear = -1;
    }

    public boolean IsEmpty(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean IsFull(){
        if(size == max){
            return true;
        }else{
            return false;
        }
    }

    public void peek(){
        if(!IsEmpty()){
            System.out.println("Elemen terdepan: " +data[front]);
        }else{
            System.out.println("Queue masih kosong");
        }
    }

    public void print(){
        if(IsEmpty()){
            System.out.println("Queue masih kosong");
        }else{
            int i = front;
            while (i != rear){
                System.out.print(data[i] + " ");
                i = (i+1) % max;
            }
            System.out.println(data[i] + " ");
            System.out.println("Jumlah elemen = " + size);
        }
    }

    public void clear(){
        if(!IsEmpty()){
            front = rear = -1;
            size = 0;
            System.out.println("Queue berhasil dikosongkan");
        }else{
            System.out.println("Queue masih kosong");
        }
    }

    public void Enqueue(int dt){
        if(IsFull()){
            System.out.println("Queue sudah penuh");
        }else{
            if(IsEmpty()){
                front = rear = 0;
            }else{
                if(rear == max - 1){
                    rear = 0;
                }else{
                    rear++;
                }
            }
            data[rear] = dt;
            size++;
        }
    }

    // Untuk pertanyaan praktikum 1
    // public void Enqueue(int dt){ 
    //     if(IsFull()){
    //         System.exit(0); // dilakukan modifikasi pada baris ini
    //     }else{
    //         if(IsEmpty()){
    //             front = rear = 0;
    //         }else{
    //             if(rear == max - 1){
    //                 rear = 0;
    //             }else{
    //                 rear++;
    //             }
    //         }
    //         data[rear] = dt;
    //         size++;
    //     }
    // }

    public int Dequeue(){
        int dt = 0;
        if(IsEmpty()){
            System.out.println("Queue masih kosong");
        }else{
            dt = data[front];
            size--;
            if(IsEmpty()){
                front = rear = -1;
            }else{
                if(front == max - 1){
                    front =0;
                }else{
                    front++;
                }
            }
        }
        return dt;
    }

    // Untuk pertanyaan praktikum 1
    // public int Dequeue(){ 
    //     int dt = 0;
    //     if(IsEmpty()){
    //         System.exit(0); // dilakukan modifikasi pada baris ini
    //     }else{
    //         dt = data[front];
    //         size--;
    //         if(IsEmpty()){
    //             front = rear = -1;
    //         }else{
    //             if(front == max - 1){
    //                 front =0;
    //             }else{
    //                 front++;
    //             }
    //         }
    //     }
    //     return dt;
    // }

    public int peekPosition(int data){
        int posisi = -1;
        if(!IsEmpty()){
            for(int j=0; j<this.data.length; j++){
                if(this.data[j] == data){
                    posisi = j;
                    break;
                }
            }
        }else{
            System.out.println("Queue masih kosong");
        }
        return posisi;
    }

    public void peekAt(int posisi){
        if(!IsEmpty()){
            if(posisi !=0){
                System.out.println("Data pada urutan ke-"+ (posisi) + " ialah "+data[posisi-1]);
            }
        }
    }

}

class Tugas_1_QueueMain{
    public static void menu(){
        System.out.println("Masukkan operasi yang diinginkan:");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Print");
        System.out.println("4. Peek");
        System.out.println("5. Peek Position");
        System.out.println("6. Peek At");
        System.out.println("7. Clear");
        System.out.println("8. Exit");
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan kapasitas queue: ");
        int n = sc.nextInt();

        Queue Q = new Queue(n);
        int pilih;
        do{
            menu();
            pilih = sc.nextInt();
            switch(pilih){
                case 1:
                    System.out.print("Masukkan data baru: ");
                    int dataMasuk = sc.nextInt();
                    Q.Enqueue(dataMasuk);
                    break;
                case 2:
                    int dataKeluar = Q.Dequeue();
                    if(dataKeluar != 0){
                        System.out.println("Data yang dikeluarkan: "+ dataKeluar);
                        break;
                    }
                case 3:
                    Q.print();
                    break;
                case 4:
                    Q.peek();
                    break;
                case 5:
                    System.out.print("Masukkan data: ");
                    int cari = sc.nextInt();
                    int posisi = Q.peekPosition(cari);
                    if(posisi != -1){
                        System.out.println("Data " +cari + " berada di posisi urutan ke-"+(posisi+1));
                    }else{
                        System.out.println("Data tidak ditemukan!");
                    }
                    break;
                case 6:
                    System.out.print("Masukkan urutan data: ");
                    int dataCari = sc.nextInt();
                    Q.peekAt(dataCari);
                    break;
                case 7:
                    Q.clear();
                    break;
                case 8:
                System.out.println("TERIMA KASIH......");
                    System.exit(0);
                    break;
            }
        }while(pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5 ||
               pilih == 6 || pilih == 7 || pilih == 8);
    }
}
