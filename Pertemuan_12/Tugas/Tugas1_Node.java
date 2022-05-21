package Pertemuan_12.Tugas;

import java.util.Scanner;
public class Tugas1_Node {
    String nik, nama;
    int nomor;
    Tugas1_Node prev, next;

    Tugas1_Node(Tugas1_Node prev, int nomor, String nama, Tugas1_Node next){
        this.prev = prev;
        this.nomor = nomor;
        this.nama = nama;
        this.next = next;
    }
}

class Tugas1_DoubleLinkedLists{
    Tugas1_Node front, rear;
    int size;

    public Tugas1_DoubleLinkedLists(){
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public void Enqueue(int nomor, String nama){
        Tugas1_Node newNode = new Tugas1_Node(null, nomor, nama, null);
        if(isEmpty()){
            front = newNode;
            rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public void Dequeue() throws Exception {
        if(isEmpty()){
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        }else if(size == 1){
            removeLast();
        }else{
            System.out.println(front.nama + " telah selesai divaksinasi.");
            front = front.next;
            front.prev = null;
            size--;
        }
    }

    public void removeLast() throws Exception {
        if(isEmpty()){
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        }else if(front.next == null){
            front = null;
            size--;
            return;
        }
        Tugas1_Node current = front;
        while (current.next.next != null){
            current = current.next;
        }
        current.next = null;
        size--;
    }

    public void print(){
        if(!isEmpty()){
            Tugas1_Node tmp = front;
            System.out.println();
            System.out.println("++++++++++++++++++++++++");
            System.out.println("Daftar Pengantri Vaksin");
            System.out.println("++++++++++++++++++++++++");
            System.out.println("|No.\t | Nama |");
            while(tmp != null){
                System.out.println("|"+tmp.nomor + "\t | " + tmp.nama + " |");
                tmp = tmp.next;
            }
            System.out.println("Size Antrian = " + size);
        }else{
            System.out.println("Linked List Kosong");
        }
    }
}

class Tugas1_DLL_VaksinMain{
    public static void menu(){
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("PENGANTRI VAKSIN EXTRAVAGANZA");
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("1. Tambah Data Penerima Vaksin");
        System.out.println("2. Hapus Data Pengantri Vaksin");
        System.out.println("3. Daftar Penerima Vaksin");
        System.out.println("4. Keluar");
        System.out.println("++++++++++++++++++++++++++++++");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        int menu = 0;
        Tugas1_DoubleLinkedLists dll = new Tugas1_DoubleLinkedLists();

        do{
            System.out.println();
            menu();
            menu = sc.nextInt();
            switch (menu){
                case 1:
                    System.out.println("-----------------------------");
                    System.out.println("Masukkan Data Penerima Vaksin");
                    System.out.println("-----------------------------");
                    System.out.println("Nomor Antrian: ");
                    int noAntrian = sc.nextInt();
                    System.out.println("Nama Penerima: ");
                    String namaPenerima = input.nextLine();
                    dll.Enqueue(noAntrian, namaPenerima);
                    break;
                case 2:
                    dll.Dequeue();
                    dll.print();
                    break;
                case 3:
                    dll.print();
                    break;
                case 4:
                    System.out.println("TERIMA KASIH...");
                    System.exit(0);
            }
        }while(menu > 0 && menu < 5);
    }
}