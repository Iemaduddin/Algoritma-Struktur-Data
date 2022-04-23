package Tugas.No_2;
import java.util.Scanner;
public class Mahasiswa {
    String nim, nama;
    int absen;
    double ipk;

    Mahasiswa(String nim, String nama, int absen, double ipk){
        this.nim = nim;
        this.nama = nama;
        this.absen = absen;
        this.ipk = ipk;
    }

    Mahasiswa(){

    }
}

class Queue {
    Mahasiswa[] data;
    int front;
    int rear;
    int size;
    int max;

    public Queue(int n){
        max = n;
        data = new Mahasiswa[max];
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
            System.out.println("Mahasiswa Antrian terdepan: " + data[front].nim + " " + data[front].nama + " " + 
            data[front].absen + " " + data[front].ipk);
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
                System.out.println(data[i].nim + " " + data[i].nama + " " + data[i].absen + " " +
                data[i].ipk);
                i = (i+1) % max;
            }
            System.out.println(data[i].nim + " " + data[i].nama + " " + data[i].absen + " " +
            data[i].ipk);
            System.out.println("Jumlah Antrian = " + size);
        }
    }

    public void Enqueue(Mahasiswa antri){
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
            data[rear] = antri;
            size++;
        }
    }

    public Mahasiswa Dequeue(){
        Mahasiswa dt = new Mahasiswa();
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

    public void peekRear(){
        if(!IsEmpty()){
            System.out.println("Antrian paling belakang: " + data[rear].nim + " " + data[rear].nama + " " + 
            data[rear].absen + " " + data[rear].ipk);
        }else{
            System.out.println("Queue masih kosong");
        }
    }
    
    public int peekPosition(String nim){
        int posisi = -1;
        if(!IsEmpty()){
            for(int j=0; j<data.length; j++){
                if(nim.equalsIgnoreCase(data[j].nim)){
                    posisi = j;
                    break;
                }
            }
        }else{
            System.out.println("Queue masih kosong");
        }
        return posisi;
    }
    
    public void printMahasiswa(int posisi){
        if(!IsEmpty()){
            System.out.println("=====================================================================");
            System.out.println("                             DATA MAHASISWA                          ");
            System.out.println("=====================================================================");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("NIM\t: " + data[posisi-1].nim);
            System.out.println("Nama\t: " + data[posisi-1].nama);
            System.out.println("Absen\t: " + data[posisi-1].absen);
            System.out.println("IPK\t: " + data[posisi-1].ipk);
        }else{
            System.out.println("Queue masih kosong");
        }
    }
}

class Tugas_2_QueueMain{
    public static void menu(){
        System.out.println("\nPilihan menu: ");
        System.out.println("1. Antrian baru");
        System.out.println("2. Antrian keluar");
        System.out.println("3. Cek Antrian terdepan");
        System.out.println("4. Cek Semua Antrian");
        System.out.println("5. Cek Antrian Paling Belakang");
        System.out.println("6. Cek Antrian Mahasiswa");
        System.out.println("7. Cetak Data Mahasiswa");
        System.out.println("8. Exit");
        System.out.println("---------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan kapasitas queue: ");
        int jumlah = sc.nextInt();
        Queue antri = new Queue(jumlah);

        int pilih;
        do{
            menu();
            pilih = sc.nextInt();
            sc.nextLine();
            switch(pilih){
                case 1:
                    System.out.print("NIM: ");
                    String nim = sc.nextLine();
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Absen: ");
                    int absen = sc.nextInt();
                    System.out.print("IPK: ");
                    double ipk = sc.nextDouble();
                    Mahasiswa nb = new Mahasiswa(nim, nama, absen, ipk);
                    sc.nextLine();
                    antri.Enqueue(nb);
                    break;
                case 2:
                    Mahasiswa data = antri.Dequeue();
                    if(!"".equals(data.nim) && !"".equals(data.nama)
                    && data.absen !=0 && data.ipk !=0){
                        System.out.println("Antrian yang keluar: " + data.nim + " " + data.nama + " " 
                        + data.absen + " " + data.ipk);
                        break;
                    }
                case 3:
                    antri.peek();
                    break;
                case 4:
                    antri.print();
                    break;
                case 5:
                    antri.peekRear();
                    break;
                case 6:
                    System.out.print("NIM : ");
                    String cari = sc.nextLine();
                    int posisi = antri.peekPosition(cari);
                    if(posisi != -1){
                        System.out.println("Mahasiswa dengan NIM " +cari + " mendapatkan posisi antrian ke-"+(posisi+1));
                    }else{
                        System.out.println("NIM tidak ditemukan!");
                    }
                    break;
                case 7:
                    System.out.print("Masukkan Nomor Antrian: ");
                    int noAntrian = sc.nextInt();
                    antri.printMahasiswa(noAntrian);
                    break;
                case 8:
                    System.out.println("TERIMA KASIH....");
                    System.exit(0);
                    break;
            }
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5 || 
                 pilih == 6 || pilih == 7 || pilih == 8);
    }
}