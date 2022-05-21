package Pertemuan_12.Tugas;

import java.util.Scanner;

public class Tugas2_Node {
    String id, judul;
    double rating;
    int data;
    Tugas2_Node prev, next;

    public Tugas2_Node(Tugas2_Node prev, String id, String judul, double rating, Tugas2_Node next){
        this.prev = prev;
        this.id = id;
        this.judul = judul;
        this.rating = rating;
        this.next = next;
    }
}

class Tugas2_DoubleLinkedLists{
    Tugas2_Node head;
    int size;

    public Tugas2_DoubleLinkedLists(){
        head = null;
        size = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addFirst(String id, String judul, double rating){
        if(isEmpty()){
            head = new Tugas2_Node(null, id, judul, rating, null);
        }else{
            Tugas2_Node newNode = new Tugas2_Node(null, id, judul, rating, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(String id, String judul, double rating){
        if(isEmpty()){
            addFirst(id, judul, rating);
        }else{
            Tugas2_Node current = head;
            while (current.next != null){
                current = current.next;
            }
            Tugas2_Node newNode = new Tugas2_Node(current, id, judul, rating, null);
            current.next = newNode;
            size++;
        }
    }

    public void add(String id, String judul,  double rating, int index) throws Exception {
        if (isEmpty()) {
            addFirst(id, judul, rating);
        } else if (index < 0 || index > size) {
            throw new Exception("Nilai index di luar batas");
        } else {
            Tugas2_Node current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            if (current.prev == null) {
                Tugas2_Node newNode = new Tugas2_Node(null, id, judul, rating, current);
                current.prev = newNode;
                head = newNode;
            } else {
                Tugas2_Node newNode = new Tugas2_Node(current.prev, id, judul, rating, current);
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        size++;
    }

    public int size(){
        return size;
    }

    public void clear(){
        head = null;
        size = 0;
    }

    public void print(){
        if(!isEmpty()){
            Tugas2_Node tmp = head;
            while (tmp != null){
                System.out.println("ID: " + tmp.id);
                System.out.println("Judul Film: " + tmp.judul);
                System.out.println("Rating Film: " + tmp.rating);
                tmp = tmp.next;
            }
            System.out.println("\nBerhasil Diisi");
        }else{
            System.out.println("Linked List Kosong");
        }
    }


    public void removeFirst() throws Exception {
        if (isEmpty()){
            throw new Exception("Linked List masih kosong, tidak dapat dihapus");
        }else if (size == 1){
            removeLast();
        }else{
            head = head.next;
            head.prev = null;
            size--;
        }
    }
    
    public void removeLast() throws Exception {
        if (isEmpty()){
            throw new Exception("Linked List masih kosong, tidak dapat dihapus");
        }else if (head.next == null){
            head = null;
            size--;
            return;
        }
        Tugas2_Node current = head;
        while (current.next.next != null){
                current = current.next;
        }
        current.next = null;
        size--;
    }

    public void remove(int index) throws Exception {
        if (isEmpty()){
            throw new Exception("Nilai index di luar batas");
        }else if (index == 0){
            removeFirst();
        }else{
            Tugas2_Node current = head;
            int i=0;
            while (i < index){
                current = current.next;
                i++;
            }
            if(current.next == null){
                current.prev.next = null;
            }else if (current.prev == null){
                current = current.next;
                current.prev = null;
                head = current;
            }else{
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
        }
    }

    public String getFirst() throws Exception {
        if (isEmpty()){
            throw new Exception("Linked List Kosong");
        }
        return (head.id + head.judul + head.rating);
    }
    
    public String getLast() throws Exception {
        if (isEmpty()){
            throw new Exception("Linked List Kosong");
        }
        Tugas2_Node tmp = head;
        while (tmp.next != null){
            tmp = tmp.next;
        }
        return (tmp.id + tmp.judul + tmp.rating);
    }
    
    public String get(int index) throws Exception {
        if (isEmpty() || index >= size){
            throw new Exception("Nilai index di luar batas");
        }
        Tugas2_Node tmp = head;
        for(int i = 0; i < index; i++){
            tmp = tmp.next;
        }
        return (tmp.id + tmp.judul + tmp.rating);
    }

    public void search(String id) {
        int i = 0;
        boolean cek = false;
        Tugas2_Node current = head;
        if (head == null){
            System.out.println("List Kosong");
            return;
        }
        while (current != null){
            if(current.id.equalsIgnoreCase(id)){
                cek = true;
                break;
            }
            current = current.next;
            i++;
        }
        if (cek){
            System.out.println("Data ID Film: " + id + " berada di node ke-" + (i+1));
            System.out.println("IDENTITAS:");
            System.out.println(" ID Film: " + current.id);
            System.out.println(" Judul FIlm: " + current.judul);
            System.out.println(" IMDB Rating: " + current.rating);
        }else{
            System.out.println("Data tidak ditemukan");
        }
    }

    public void BubbleSort() {
        Tugas2_Node current = null, index = null;
        String tmp;
        double temp;
        if (head == null) {
            return;
        } else {
            for (current = head; current.next != null; current = current.next) {
                for (index = current.next; index != null; index = index.next) {
                    if (current.rating < index.rating) {
                        temp = current.rating;
                        current.rating = index.rating;
                        index.rating = temp;
                        tmp = current.judul;
                        current.judul = index.judul;
                        index.judul = tmp;
                    }
                }
            }
        }
    }
}

class Tugas2_DLL_FilmMain{
    public static void menu(){
        System.out.println("==============================");
        System.out.println("DATA FILM LAYAR LEBAR");
        System.out.println("==============================");
        System.out.println("1. Tambah Data Awal");
        System.out.println("2. Tambah Data Akhir");
        System.out.println("3. Tambah Data Index Tertentu");
        System.out.println("4. Hapus Data Pertama");
        System.out.println("5. Hapus Data Terakhir");
        System.out.println("6. Hapus Data Tertentu");
        System.out.println("7. Cetak");
        System.out.println("8. Cari ID Film");
        System.out.println("9. Urut Data Rating Film-DESC");
        System.out.println("10. Keluar");
        System.out.println("==============================");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        int menu, index;
        String id, judul, cari;
        double rating;
        Tugas2_DoubleLinkedLists dll = new Tugas2_DoubleLinkedLists();

     
            do{
                menu();
                menu = sc.nextInt();

                try {
                    switch (menu) {
                        case 1:
                            System.out.println("Masukkan Data Film Posisi Awal");
                            System.out.println("ID Film: ");
                            id = input.nextLine();
                            System.out.println("Judul Film: ");
                            judul = input.nextLine();
                            System.out.println("Rating Film: ");
                            rating = sc.nextDouble();
                            dll.addFirst(id, judul, rating);
                            break;
                        case 2:
                            System.out.println("Masukkan Data Film Posisi Akhir");
                            System.out.println("ID Film: ");
                            id = input.nextLine();
                            System.out.println("Judul Film: ");
                            judul = input.nextLine();
                            System.out.println("Rating Film: ");
                            rating = sc.nextDouble();
                            dll.addLast(id, judul, rating);
                            break;
                        case 3:
                            System.out.println("Masukkan Data Film Urutan ke-");
                            System.out.println("ID Film: ");
                            id = input.nextLine();
                            System.out.println("Judul Film: ");
                            judul = input.nextLine();
                            System.out.println("Rating Film: ");
                            rating = sc.nextDouble();
                            System.out.println("Data Film ini akan masuk di urutan ke-");
                            index = sc.nextInt();
                            dll.add(id, judul, rating, index);
                            break;
                        case 4:
                            dll.removeFirst();
                            System.out.println("Penghapusan Data Awal berhasil");
                            break;
                        case 5:
                            dll.removeLast();
                            System.out.println("Penghapusan Data Akhir berhasil");
                            break;
                            case 6:
                            System.out.println("Masukkan posisi index yang ingin dihapus: ");
                            index = sc.nextInt();
                            dll.remove(index);
                            System.out.println("Penghapusan Data Pada Indeks ke-"+ index +" berhasil");
                            break;
                        case 7:
                            System.out.println("Cetak Data");
                            dll.print();
                            System.out.println("Size : " + dll.size());
                            break;
                        case 8:
                            System.out.println("Cari Data");
                            System.out.println("Masukkan Id Film yang dicari");
                            cari = in.nextLine();
                            dll.search(cari);
                            break;
                        case 9:
                            System.out.println("Pengurutan Data Rating FIlm-DESC");
                            dll.BubbleSort();
                            dll.print();
                            break;
                        case 10:
                            System.out.println("TERIMA KASIH.....");
                            System.exit(0);
                            break;

                        default:
                            System.out.println("Inputan yang Anda masukkan salah");
                            break;
                        }
                } catch (Exception e){
                }
            }while (menu > 0 && menu < 11);
        }
        
}