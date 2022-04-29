# **JOBSHEET IX LINKED LIST** 

### **Nama : Iemaduddin**
### **No. Absen/Kelas : 16/TI-1F**
### **NIM : 2141720055**
#

## **1. Tujuan Praktikum**  

Setelah melakukan materi praktikum ini, mahasiswa mampu: 

1. Membuat struktur data linked list 
2. Membuat linked list pada program 
3. Membedakan permasalahan apa yang dapat diselesaikan menggunakan linked list 

## **2. Praktikum** 

### **2.1 Pembuatan Single Linked List** 

**Waktu percobaan : 30 menit** 

Didalam praktikum ini, kita akan mempraktekkan bagaimana membuat Single Linked List dengan representasi data berupa Node, pengaksesan linked list dan metode penambahan data.** 

1. Pada Project **StrukturData** yang sudah dibuat pada Minggu sebelumnya, buat package dengan nama **minggu11** 
2. Tambahkan class-class berikut: 
    - Node.java
    - SingleLinkedList.java
    - SLLMain.java
3. Implementasi class Node 

    ```
    public class Node{
        int data;
        Node next;

        public Node (int data, Node berikutnya){
            this.data = data;
            this.next = berikutnya;
        }
    }
    ```

4. Tambahkan atribut pada class SingleLinkedList 

    ```
    class SingleLinkedList{
        Node head;
        Node tail;
    }
    ```

5. Sebagai langkah berikutnya, akan diimplementasikan method-method yang terdapat pada SingleLinkedList. 
6. Tambahkan method **isEmpty()**. 

    ```
        public boolean IsEmpty(){
            return head == null;
        }
    ```

7. Implementasi method untuk mencetak dengan menggunakan proses traverse. 

    ```
        public void print(){
            if(!IsEmpty()){
                Node tmp =head;
                System.out.print("Isi Linked List:\t");
                while (tmp != null){
                    System.out.print(tmp.data + "\t");
                    tmp = tmp.next;
                }
                System.out.println("");
            }else{
                System.out.println("Linked list kosong");
            }
        }
    ```


8. Implementasikan method **addFirst()**. 

    ```
        public void addFirst(int input){
            Node ndInput = new Node(input, null);
            if(IsEmpty()){
                head = ndInput;
                tail = ndInput;
            }else{
                ndInput.next = head;
                head = ndInput;
            }
        }
    ```

9. Implementasikan method **addLast()**. 

    ```
        public void addLast(int input){
            Node ndInput = new Node(input, null);
            if(IsEmpty()){
                head = ndInput;
                tail = ndInput;
            }else{
                tail.next = ndInput;
                tail = ndInput;
            }
        }
    ```

10. Implementasikan method **insertAfter**, untuk memasukkan node yang memiliki data input setelah node yang memiliki data key. 

    ```
        public void insertAfter(int key, int input){
            Node ndInput = new Node(input, null);
            Node temp = head;
            do{
                if(temp.data == key){
                    ndInput.next = temp.next;
                    temp.next = ndInput;
                    if(ndInput.next == null) tail = ndInput;
                    break;
                }
                temp = temp.next;
            }while (temp != null);
        }
    ```

11. Tambahkan method penambahan node pada indeks tertentu. 

    ```
        public void insertAt(int index, int input){
            if(index < 0){
                System.out.println("indeks salah");
            }else if(index == 0){
                addFirst(input);
            }else{
                Node temp = head;
                for(int i=0; i<index-1; i++){
                    temp = temp.next;
                }
                temp.next = new Node(input, temp.next);
                if(temp.next.next == null) tail = temp.next;
            }
        }
    ```

12. Pada class SLLMain, buatlah  fungsi **main**, kemudian buat object dari class SingleLinkedList. 

    ```
    class SLLMain{
        public static void main(String[] args) {
            SingleLinkedList singLL = new SingleLinkedList();
        }
    }
    ```

13. Tambahkan Method penambahan data dan pencetakan data di setiap penambahannya agar terlihat perubahannya. 

    ```
            singLL.print();
            singLL.addFirst(890);
            singLL.print();
            singLL.addLast(760);
            singLL.print();
            singLL.addFirst(700);
            singLL.print();
            singLL.insertAfter(700, 999);
            singLL.print();
            singLL.insertAt(3, 833);
            singLL.print();
    ```

### **2.1.1 Verifikasi Hasil Percobaan** 

Cocokkan hasil compile kode program anda dengan gambar berikut ini. 


![Verifikasi_Praktikum_2](Screenshots/Verifikasi_Praktikum_1.jpg)

### **2.1.2 Pertanyaan**

1. Mengapa hasil compile kode program di baris pertama menghasilkan “Linked List Kosong”? 


    **Jawab:** Karena eksekusi awal langsung mencetak isi dari linked list yang mana linked listnya berada di dalam kondisi antrian atau listnya sedang kosong atau tidak memiliki data.


2. Pada step 10, jelaskan kegunaan kode berikut 

    ```
     ndInput.next = temp.next;
     temp.next = ndInput;
    ```

    **Jawab:**
    - Baris pertama merupakan Node baru yang mana merujuk pada alamat memori dari node setelah key
    - Baris kedua ialah pointer temp menyimpan alamat memori ndInput


3. Perhatikan class **SingleLinkedList**, pada method **insertAt** Jelaskan kegunaan kode berikut  

    ```
    if(temp.next.next == null) tail = temp.next;
    ```

    **Jawab:** Digunakan untuk kondisi jika temp.next.next (temp dari setelah temp) sama dengan null, maka tail sama dengan temp.next



## **2.2 Modifikasi Elemen pada Single Linked List** 

**Waktu percobaan : 30 menit** 

Didalam praktikum ini, kita akan mempraktekkan bagaimana mengakses elemen, mendapatkan indeks dan melakukan penghapusan data pada Single Linked List.:  

### **2.2.1 Langkah-langkah Percobaan** 
1. Implementasikan method untuk mengakses data dan indeks pada linked list 
2. Tambahkan method untuk mendapatkan data pada indeks tertentu pada class Single Linked List 

    ```
        public int gedData(int index){
            Node tmp = head;
            for(int i=0; i<index; i++){
                tmp = tmp.next; 
            }
            return tmp.data;
        }
    ```

3. Implementasikan method **indexOf**. 

    ```
        public int indexOf(int key){
            Node tmp = head;
            int index = 0;
            while (tmp != null && tmp.data != key){
                tmp = tmp.next;
                index++;
            }

            if(tmp == null){
                return -1;
            }else{
                return index;
            }
        }
    ```

4. Tambahkan method removeFirst pada class SingleLinkedList 

    ```
        public void removeFirst(){
            if(isEmpty()){
                System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
            }else if(head == tail){
                head = tail = null;
            }else{
                head = head.next;
            }
        }
    ```

5. Tambahkan  method  untuk  menghapus  data  pada  bagian  belakang  pada  class SingleLinkedList 

    ```
        public void removeLast(){
            if(isEmpty()){
                System.out.println("Linked List masih Kosong, tidak dapat dihapus");
            }else if(head == tail){
                head = tail = null;
            }else{
                Node temp = head;
                while(temp.next != tail){
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
            }
        }
    ```

6. Sebagai langkah berikutnya, akan diimplementasikan method remove 

    ```
        public void remove(int key){
            if(isEmpty()){
                System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
            }else{
                Node temp = head;
                while(temp != null){
                    if((temp.data == key) && (temp == head)){
                        this.removeFirst();
                        break;
                    }else if(temp.next.data == key){
                        temp.next = temp.next.next;
                        if(temp.next == null){
                            tail = temp;
                        }
                        break;
                    }
                    temp = temp.next;
                }
            }
        }
    ```

7. Implementasi method untuk menghapus node dengan menggunakan index. 

    ```
        public void removeAt(int index){
            if (index == 0){
                removeFirst();
            }else{
                Node temp = head;
                for(int i=0; i<index-1; i++){
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                if(temp.next == null){
                    tail = temp;
                }
            }
        }
    ```

8. Kemudian, coba lakukan pengaksesan dan penghapusan data di method main pada class SLLMain dengan menambahkan kode berikut 

    ```
        System.out.println("Data pada indekx ke-1 = " + singLL.gedData(1));
        System.out.println("Data 3 berada pada indeks ke-" + singLL.indexOf(760));

        singLL.remove(999);
        singLL.print();
        singLL.removeAt(0);
        singLL.print();
        singLL.removeFirst();
        singLL.print();
        singLL.removeLast();
        singLL.print();
    ```

9. Method SLLMain menjadi: 

    ```
    class SLLMain{
        public static void main(String[] args) {
            SingleLinkedList singLL = new SingleLinkedList();
            singLL.print();
            singLL.addFirst(890);
            singLL.print();
            singLL.addLast(760);
            singLL.print();
            singLL.addFirst(700);
            singLL.print();
            singLL.insertAfter(700, 999);
            singLL.print();
            singLL.insertAt(3, 833);
            singLL.print();

            System.out.println("Data pada indekx ke-1 = " + singLL.gedData(1));
            System.out.println("Data 3 berada pada indeks ke-" + singLL.indexOf(760));

            singLL.remove(999);
            singLL.print();
            singLL.removeAt(0);
            singLL.print();
            singLL.removeFirst();
            singLL.print();
            singLL.removeLast();
            singLL.print();
        }
    }
    ```

10. Jalankan class SLLMain  
### **2.2.2 Verifikasi Hasil Percobaan** 

Cocokkan hasil compile kode program anda dengan gambar berikut ini. 


![Verifikasi_Praktikum_2](Screenshots/Verifikasi_Praktikum_2.jpg)


### **2.2.3 Pertanyaan**

1. Mengapa digunakan keyword break pada fungsi remove? Jelaskan! 


    **Jawab:** Karena pada code tersebut merupakan sebuah perulangan yang mana pada kondisi tersebut jika salah salah satu dari dua kondisi yang telah ditentukan tersebut terpenuhi, maka sudah tidak perlu dilakukan perulangan lagi, maka dari itu diberikan keyword break agar tidak berulang.


2. Jelaskan kegunaan kode dibawah pada method remove 

    ```
    }else if(temp.next.data == key){
        temp.next = temp.next.next;
    ```


    **Jawab:** Kondisi tersebut dieksekusi jika kondisi yang pertama tidak cocok. Jika data temp setelahnya (temp.next.data) sama dengan key (data yang dirujuk), maka temp.next berubah menjadi temp.next.next atau terjadi perubahan posisi pada node sebelumnya ke node setelahnya.


3. Apa saja nilai kembalian yang dapat dikembalikan pada method indexOf? Jelaskan maksud masing-masing kembalian tersebut!

    **Jawab:**

    - Jika tmp == null, maka akan mengembalikan nilai -1 atau tidak terdapat dalam index (data kosong).
    - jika tidak, maka akan mengembalikan nilai dari index yang diinputkan


## **3. Tugas** 

**Waktu pengerjaan : 50 menit**


1  Buat method insertBefore untuk menambahkan node sebelum keyword yang diinginkan

**Jawab:**

- Code:

    - Class SingleLinkedList()


        ![Code_Tugas_1](Screenshots/Code_Tugas_1.png)


    - Class SLLMain()


        ![Code_Tugas_1_Main](Screenshots/Code_Tugas_1_Main.png)

- Output:


    ![Output_Tugas_1](Screenshots/Output_Tugas1.jpg)


2  Implementasikan ilustrasi Linked List Berikut. Gunakan 4 macam penambahan data yang telah dipelajari sebelumnya untuk menginputkan data. 


![Soal_Tugas_2](Screenshots/Soal_Tugas_2.jpg)


**Jawab:**

- Code:


    ```
    package Pertemuan_11.Tugas;

    public class ilustrasiLinkedList {
        char data;
        ilustrasiLinkedList next;

        public ilustrasiLinkedList(char data, ilustrasiLinkedList next){
            this.data = data;
            this.next = next;
        }
    }

    class SingleLinkedList_Tugas{
        ilustrasiLinkedList head;
        ilustrasiLinkedList tail;

        public boolean isEmpty(){
            return head == null;
        }

        public void print(){
            if(!isEmpty()){
                ilustrasiLinkedList tmp = head;
                System.out.print("Isi Linked List:\t");
                while (tmp != null){
                    System.out.print(tmp.data + "\t");
                    tmp = tmp.next;
                }
                System.out.println("");
            }else{
                System.out.println("Linked list kosong");
            }
        }

        public void addFirst(char input){
            ilustrasiLinkedList ndInput = new ilustrasiLinkedList(input, null);
            if(isEmpty()){
                head = ndInput;
                tail = ndInput;
            }else{
                ndInput.next = head;
                head = ndInput;
            }
        }

        public void addLast(char input){
            ilustrasiLinkedList ndInput = new ilustrasiLinkedList(input, null);
            if(isEmpty()){
                head = ndInput;
                tail = ndInput;
            }else{
                tail.next = ndInput;
                tail = ndInput;
            }
        }

        public void insertAfter(char key, char input){
            ilustrasiLinkedList ndInput = new ilustrasiLinkedList(input, null);
            ilustrasiLinkedList temp = head;
            do{
                if(temp.data == key){
                    ndInput.next = temp.next;
                    temp.next = ndInput;
                    if(ndInput.next == null) tail = ndInput;
                    break;
                }
                temp = temp.next;
            }while (temp != null);
        }
        
        public void insertBefore(char key, char input){
            ilustrasiLinkedList ndInput = new ilustrasiLinkedList(input, null);
            ilustrasiLinkedList temp = head;
            do{
                if((temp.data == key) && (temp == head)){
                    this.addFirst(input);
                    break;
                }else if (temp.next.data == key){
                    ndInput.next = temp.next;
                    temp.next = ndInput;
                    break;
                }
                temp = temp.next;
            }while (temp != null);
        }
        public void insertAt(int index, char input){
            if(index < 0){
                System.out.println("indeks salah");
            }else if(index == 0){
                addFirst(input);
            }else{
                ilustrasiLinkedList temp = head;
                for(int i=0; i<index-1; i++){
                    temp = temp.next;
                }
                temp.next = new ilustrasiLinkedList(input, temp.next);
                if(temp.next.next == null) tail = temp.next;
            }
        }
    }

    class Tugas2_SLLMain{
        public static void main(String[] args) {
            SingleLinkedList_Tugas ilusSLL = new SingleLinkedList_Tugas();
            ilusSLL.print();
            ilusSLL.addFirst('b');
            ilusSLL.print();
            ilusSLL.addLast('d');
            ilusSLL.print();
            ilusSLL.insertAfter('d', 'e');
            ilusSLL.print();
            ilusSLL.insertBefore('d', 'c');
            ilusSLL.print();
            ilusSLL.insertAt(0, 'a');
            ilusSLL.print();
        }
    }
    ```


- Output:


    ![Output_Tugas_2](Screenshots/Output_Tugas2.jpg)


3  Buatlah Implementasi Stack berikut menggunakan Single Linked List 


![Soal_Tugas_3](Screenshots/Soal_Tugas_3.jpg)


**Jawab:**

- Code:


    ```
    package Pertemuan_11.Tugas;

    public class implementasiStack {
        String data;
        implementasiStack next;

        public implementasiStack(String data, implementasiStack next){
            this.data = data;
            this.next = next;
        }
    }

    class implementasiStackSSL{
        implementasiStack head;
        implementasiStack tail;
        
        public boolean isEmpty(){
            return head == null;
        }
        
        public void print(){
            if (!isEmpty()){
                implementasiStack tmp = head;
                System.out.println("");
                while (tmp != null){
                    System.out.println(tmp.data);
                    tmp = tmp.next;
                }
                System.out.println();
            }else{
                System.out.println("Stack Masih Kosong!");
            }
        }

        public void peek(){
            if(!isEmpty()){
                implementasiStack tmp = head;
                System.out.println("Isi Stack Teratas : " + tmp.data);
            }else{
                System.out.println("Stack Masing Kosong!");
            }
        }

        public void pushAwal(String input){
            implementasiStack ndInput = new implementasiStack(input, null);
            if(isEmpty()){
                head = ndInput;
                tail = ndInput;
            }else{
                ndInput.next = head;
                head = ndInput;
            }
        }
    }

    class Tugas3_implementasiStack_Main{
        public static void main(String[] args) {
            implementasiStackSSL sllStack = new implementasiStackSSL();
            sllStack.pushAwal("Bahasa");
            sllStack.print();
            sllStack.pushAwal("Android");
            sllStack.print();
            sllStack.pushAwal("Komputer");
            sllStack.print();
            sllStack.pushAwal("Basis Data");
            sllStack.print();
            sllStack.pushAwal("Matematika");
            sllStack.print();
            sllStack.pushAwal("Algoritma");
            sllStack.print();
            sllStack.pushAwal("Statistika");
            sllStack.print();
            sllStack.pushAwal("Multimedia");
            sllStack.print();

            System.out.println("Isi Stack: ");
            sllStack.print();
            sllStack.peek();
        }
    }
    ```


- Output:


    ![Output_Tugas_3](Screenshots/Output_Tugas3.jpg)


4.  (1) Buatlah implementasi program antrian untuk mengilustasikan mahasiswa yang sedang meminta tanda tangan KRS pada dosen DPA di kampus pada tugas jobsheet 8 menggunakan LinkedList. (2) Implementasikan Queue pada antrian mahasiswa dengan menggunakan konsep LinkedList! 


**Jawab:**

(1) Implementasi program antrian untuk mengilustasikan mahasiswa yang sedang meminta tanda tangan KRS pada dosen DPA di kampus pada tugas jobsheet 8 menggunakan LinkedList

- Code:

    ```
    package Pertemuan_11.Tugas;

    import java.util.Scanner;
    public class Mahasiswa {
        String nim, nama;
        int absen;
        double ipk;
        Mahasiswa next;

        Mahasiswa(String nim, String nama, int absen, double ipk, Mahasiswa next){
            this.nim = nim;
            this.nama = nama;
            this.absen = absen;
            this.ipk = ipk;
            this.next = next;
        }
    }

    class SLLMahasiswa{
        Mahasiswa head;
        Mahasiswa tail;

        public boolean IsEmpty(){
            return head == null;
        }

        public void print(){
            if(!IsEmpty()){
                Mahasiswa tmp = head;
                int sort = 0;
                while(tmp != null){
                    System.out.println("Mahasiswa ke-" + sort + " : " + tmp.nim + " " + 
                    tmp.nama + " " + tmp.absen + " " + tmp.ipk);
                    tmp = tmp.next;
                    sort++;
                }
            }else{
                System.out.println("Antrian Masih Kosong!");
            }
        }

        public void antrianTerdepan(){
            if(!IsEmpty()){
                Mahasiswa tmp = head;
                System.out.println("Antrian paling depan: " + tmp.nim + " " + 
                tmp.nama + " " + tmp.absen + " " + tmp.ipk);
            }else{
                System.out.println("Antrian masing kosong!");
            }
        }

        public void antrianTerbelakang(){
            if(!IsEmpty()){
                Mahasiswa tmp = head;
                while(tmp != null){
                    if(tmp == tail){
                        System.out.println("Antrian paling belakang: " + tmp.nim + " " + 
                        tmp.nama + " " + tmp.absen + " " + tmp.ipk);
                    }
                    tmp = tmp.next;
                }
            }else{
                System.out.println("Antrian masih kosong!");
            }
        }

        public void addData(String nim, String nama, int absen, double ipk){
            Mahasiswa ndInput = new Mahasiswa(nim, nama, absen, ipk, null);
            if(IsEmpty()){
                head = ndInput;
                tail = ndInput;
            }else{
                tail.next = ndInput;
                tail = ndInput;
            }
        }

        public void searchDataOfIndex(int index){
            if(IsEmpty()){
                System.out.println("Antrian masih kosong!");
            }else{
                Mahasiswa tmp = head;
                for(int i=1; i<index; i++){
                    tmp = tmp.next;
                }
                System.out.println("Data Mahasiswa dengan Nomor Antrian " + index + " : " + tmp.nim + " " + 
                tmp.nama + " " + tmp.absen + " " + tmp.ipk);
            }
        }

        public void searchDataOfNim(String key){
            Mahasiswa tmp = head;
            int index = 0;
            while (tmp != null && (!(tmp.nim.equals(key)))){
                tmp = tmp.next;
                index++;
            }
            if(tmp == null){
                System.out.println("Antrian Kosong!");
            }else{
                System.out.println("Mahasiswa dengan NIM: " + key + " berada pada index ke - " + index);
            }
            System.out.println("Data Mahasiswa: " + tmp.nim + " " + 
            tmp.nama + " " + tmp.absen + " " + tmp.ipk);
        }

        public void remove(){
            if(IsEmpty()){
                System.out.println("Antrian Masih Kosong, tidak dapat dihapus!");
            }else if (head == tail){
                head = tail = null;
            }else{
                Mahasiswa temp = head;
                while(temp.next != tail){
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
            }
        }
    }

    class MahasiswaMain{
        public static void menu(){
            System.out.println("\nPilihan menu: ");
            System.out.println("1. Antrian baru");
            System.out.println("2. Antrian keluar");
            System.out.println("3. Cek Antrian paling depan");
            System.out.println("4. Cek Antrian Paling Belakang");
            System.out.println("5. Cek Semua Antrian");
            System.out.println("6. Cek Antrian Mahasiswa");
            System.out.println("7. Cetak Data Mahasiswa");
            System.out.println("8. Exit");
            System.out.println("---------------------------------------------------------------------");
        }   
        public static void main(String[] args) {
            SLLMahasiswa sllM = new SLLMahasiswa();
            Scanner sc = new Scanner(System.in);
            Scanner input = new Scanner(System.in);

            int pilih;
            do{
                menu();
                System.out.print("Masukkan pilihan: ");
                pilih = sc.nextInt();
                sc.nextLine();
                switch(pilih){
                    case 1:
                        System.out.print("\nNIM: ");
                        String nim = sc.nextLine();
                        System.out.print("Nama: ");
                        String nama = sc.nextLine();
                        System.out.print("Absen: ");
                        int absen = sc.nextInt();
                        System.out.print("IPK: ");
                        double ipk = sc.nextDouble();
                        sllM.addData(nim, nama, absen, ipk);
                        System.out.println("");
                        break;
                    case 2:
                        sllM.remove();
                        System.out.println("");
                        break;
                    case 3:
                        sllM.antrianTerdepan();
                        System.out.println("");
                        break;
                    case 4:
                        sllM.antrianTerbelakang();
                        System.out.println("");
                        break;
                    case 5:
                        sllM.print();
                        System.out.println("");
                        break;
                    case 6:
                        System.out.print("Masukkan NIM : ");
                        String cari = input.nextLine();
                        sllM.searchDataOfNim(cari);
                        System.out.println("");
                        break;
                    case 7:
                        System.out.print("Masukkan Nomor Antrian: ");
                        int index = sc.nextInt();
                        sllM.searchDataOfIndex(index);
                        break;
                    case 8:
                        System.out.println("TERIMA KASIH....");
                        System.exit(0);
                        break;
                }
            } while (pilih > 0 && pilih < 9);
            System.out.println("TERIMA KASIH...");
        }
    }

    ```

- Output:


    ![Output_Tugas_4-1_1](Screenshots/Output_Tugas_4-1_1.jpg)


    ![Output_Tugas_4-1_2](Screenshots/Output_Tugas_4-1_2.jpg)


    ![Output_Tugas_4-1_3](Screenshots/Output_Tugas_4-1_3.jpg)


(2) Implementasikan Queue pada antrian mahasiswa dengan menggunakan konsep LinkedList!

- Code:

    ```
    package Pertemuan_11.Tugas;

    import java.util.Scanner;
    public class implementasiLinkedListQueue {
        String nim, nama;
        int absen;
        double ipk;
        implementasiLinkedListQueue next;
        
        implementasiLinkedListQueue(String nim, String nama, int absen, double ipk, implementasiLinkedListQueue next){
            this.nim = nim;
            this.nama = nama;
            this.absen = absen;
            this.ipk = ipk;
            this.next = next;
        }
    }


    class SLLQueue{
        implementasiLinkedListQueue head;
        implementasiLinkedListQueue tail;

        public boolean IsEmpty(){
            return head == null;
        }

        public void print(){
            if(!IsEmpty()){
                implementasiLinkedListQueue tmp = head;
                int sort = 0;
                while(tmp != null){
                    System.out.println("Mahasiswa ke-" + sort + " : " + tmp.nim + " " + 
                    tmp.nama + " " + tmp.absen + " " + tmp.ipk);
                    tmp = tmp.next;
                    sort++;
                }
            }else{
                System.out.println("Antrian Masih Kosong!");
            }
        }

        public void peek(){
            if(!IsEmpty()){
                implementasiLinkedListQueue tmp = head;
                System.out.println("Antrian paling depan: " + tmp.nim + " " + 
                tmp.nama + " " + tmp.absen + " " + tmp.ipk);
            }else{
                System.out.println("Antrian masing kosong!");
            }
        }

        public void peekRear(){
            if(!IsEmpty()){
                implementasiLinkedListQueue tmp = head;
                while(tmp != null){
                    if(tmp == tail){
                        System.out.println("Antrian paling belakang: " + tmp.nim + " " + 
                        tmp.nama + " " + tmp.absen + " " + tmp.ipk);
                    }
                    tmp = tmp.next;
                }
            }else{
                System.out.println("Antrian masih kosong!");
            }
        }

        public void Enqueue(String nim, String nama, int absen, double ipk){
            implementasiLinkedListQueue ndInput = new implementasiLinkedListQueue(nim, nama, absen, ipk, null);
            if(IsEmpty()){
                head = ndInput;
                tail = ndInput;
            }else{
                tail.next = ndInput;
                tail = ndInput;
            }
        }

        public void Dequeue(){
            if(IsEmpty()){
                System.out.println("Antrian Masih Kosong, tidak dapat dihapus!");
            }else if (head == tail){
                head = tail = null;
            }else{
                implementasiLinkedListQueue temp = head;
                while(temp.next != tail){
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
            }
        }


        public void peekPosition(String key){
            implementasiLinkedListQueue tmp = head;
            int index = 0;
            while (tmp != null && (!(tmp.nim.equals(key)))){
                tmp = tmp.next;
                index++;
            }
            if(tmp == null){
                System.out.println("Antrian Kosong!");
            }else{
                System.out.println("Mahasiswa dengan NIM: " + key + " berada pada index ke - " + index);
            }
            System.out.println("Data Mahasiswa: " + tmp.nim + " " + 
            tmp.nama + " " + tmp.absen + " " + tmp.ipk);
        }

        public void peekAt(int index){
            if(IsEmpty()){
                System.out.println("Antrian masih kosong!");
            }else{
                implementasiLinkedListQueue tmp = head;
                for(int i=1; i<index; i++){
                    tmp = tmp.next;
                }
                System.out.println("Data Mahasiswa dengan Nomor Antrian " + index + " : " + tmp.nim + " " + 
                tmp.nama + " " + tmp.absen + " " + tmp.ipk);
            }
        }

        public void clear(int jml){
            if(!IsEmpty()){
                head = tail = null;
                jml = 0;
                System.out.println("Antrian Mahasiswa berhasil dikosongkan");
            }else{
                System.out.println("Antrian Mahasiswa Masih kosong");
            }
        }
    }

    class implementasiLinkedListQueueMain{
        public static void menu(){
            System.out.println("\nPilihan menu: ");
            System.out.println("1. Antrian baru (Enqueue)");
            System.out.println("2. Antrian keluar (Dequeue)");
            System.out.println("3. Cek Antrian paling depan (Peek)");
            System.out.println("4. Cek Antrian Paling Belakang (Peek Rear)");
            System.out.println("5. Cek Semua Antrian");
            System.out.println("6. Cek Antrian Mahasiswa (Peek Position)");
            System.out.println("7. Cetak Data Mahasiswa (Peek At)");
            System.out.println("8. Kosongkan Antrian (Clear)");
            System.out.println("9. Exit");
            System.out.println("---------------------------------------------------------------------");
        }
        
        public static void main(String[] args) {
            SLLQueue sllM = new SLLQueue();
            Scanner sc = new Scanner(System.in);
            Scanner input = new Scanner(System.in);

            int pilih, jml;

            System.out.println("Masukkan Jumlah Mahasiswa: ");
            jml = sc.nextInt();
            do{
                menu();
                System.out.print("Masukkan pilihan: ");
                pilih = sc.nextInt();
                sc.nextLine();
                switch(pilih){
                    case 1:
                        System.out.print("\nNIM: ");
                        String nim = sc.nextLine();
                        System.out.print("Nama: ");
                        String nama = sc.nextLine();
                        System.out.print("Absen: ");
                        int absen = sc.nextInt();
                        System.out.print("IPK: ");
                        double ipk = sc.nextDouble();
                        sllM.Enqueue(nim, nama, absen, ipk);
                        System.out.println("");
                        break;
                    case 2:
                        sllM.Dequeue();
                        System.out.println("");
                        break;
                    case 3:
                        sllM.peek();
                        System.out.println("");
                        break;
                    case 4:
                        sllM.peekRear();
                        System.out.println("");
                        break;
                    case 5:
                        sllM.print();
                        System.out.println("");
                        break;
                    case 6:
                        System.out.print("Masukkan NIM : ");
                        String cari = input.nextLine();
                        sllM.peekPosition(cari);
                        System.out.println("");
                        break;
                    case 7:
                        System.out.print("Masukkan Nomor Antrian: ");
                        int index = sc.nextInt();
                        sllM.peekAt(index);
                        break;
                    case 8:
                        sllM.clear(jml);
                        System.out.println("");
                        break;
                    case 9:
                        System.out.println("TERIMA KASIH....");
                        System.exit(0);
                        break;
                }
            } while (pilih > 0 && pilih < 10);
            System.out.println("TERIMA KASIH...");
        }
    }
    ```


- Output:


    ![Output_Tugas_4-2_1](Screenshots/Output_Tugas_4-2_1.jpg)



    ![Output_Tugas_4-2_2](Screenshots/Output_Tugas_4-2_2.jpg)



    ![Output_Tugas_4-2_3](Screenshots/Output_Tugas_4-2_3.jpg)



    ![Output_Tugas_4-2_4](Screenshots/Output_Tugas_4-2_4.jpg)


    ![Output_Tugas_4-2_5](Screenshots/Output_Tugas_4-2_5.jpg)
