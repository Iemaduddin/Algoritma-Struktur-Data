import java.util.Scanner;
public class Tugas_2 {
    int nim;
    String nama;
    int umur;
    double ipk;
    
    Tugas_2(int ni, String n, int u, double i){
        nim = ni;
        nama = n;
        umur = u;
        ipk = i;
    }

    void tampil(){
        System.out.println("Nim = "+nim);
        System.out.println("Nama = "+nama);
        System.out.println("Umur = "+umur);
        System.out.println("IPK = "+ipk);
    }
}

class Tugas_2_PencarianMhs{
    Tugas_2 listMhs[];
    int idx;
    
    void tambah(Tugas_2 m){
        if(idx < listMhs.length){
            listMhs[idx] = m;
            idx++;
        }else{
            System.out.println("Data sudah penuh !!");
        }
    }
    
    void tampil(){
        for(Tugas_2 m : listMhs){
            m.tampil();
            System.out.println("-------------------------------------------");
        }
    }
    
    public int FindSeqSearch(int cari){
        int posisi = -1;
        for(int j=0; j<listMhs.length; j++){
            if(listMhs[j].nim == cari){
                posisi = j;
                break;
            }
        }
        return posisi;
    }
    
    public int FindSequentialSearch(Tugas_2 listMHS[], String cari){
        int posisi = -1;
        for(int i=0; i<listMHS.length; i++){
            if(cari.equalsIgnoreCase(listMHS[i].nama)){
                posisi = i;
                TampilPosisi(cari, posisi);
                TampilData(cari, posisi);
            }
        }
        return posisi;
    }

    public void TampilPosisi(String x, int pos){
        if(pos != -1){
            System.out.println("data\t : "+ x + " ditemukan pada indeks "+pos+"\n");
        }else{
            System.out.println("data\t : "+ x + "tidak ditemukan");
        }
    }
    
    public void TampilData(String x, int pos){
        if(pos != -1){
            System.out.println("Nim\t : "+listMhs[pos].nim);
            System.out.println("Nama\t : "+x);
            System.out.println("Umur\t : "+listMhs[pos].umur);
            System.out.println("IPK\t : "+listMhs[pos].ipk);
        }else{
            System.out.println("data "+x+"tidak ditemukan");
        }
    }
}

class Tugas2_Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        
        Tugas_2_PencarianMhs data = new Tugas_2_PencarianMhs();
        System.out.print("Masukkan jumlah Mahasiswa: ");
        int jumMhs = s.nextInt();
        Tugas_2[] mhs = new Tugas_2[jumMhs];
        data.listMhs = mhs;

        System.out.println("-------------------------------------------");
        System.out.println("Masukkan data mahasiswa secara urut dari Nim Terkecil");
        for(int i=0; i<jumMhs; i++){
            System.out.println("-------------------------------------------");
            System.out.print("Nim\t : ");
            int nim = s.nextInt();
            System.out.print("Nama\t : ");
            String nama = s1.nextLine();
            System.out.print("Umur\t : ");
            int umur = s.nextInt();
            System.out.print("IPK\t : ");
            double ipk = s.nextDouble();
            
            Tugas_2 m = new Tugas_2(nim, nama, umur, ipk);
            data.tambah(m);
        }    
            System.out.println("-------------------------------------------");
            System.out.println("Data keseluruhan Mahasiswa : ");
            data.tampil();

            System.out.println("-------------------------------------------");
            System.out.println("-------------------------------------------");
            System.out.println("Pencarian data : ");
            System.out.println("Masukkan Nama Mahasiswa yang dicari : ");
            System.out.print("Nama : ");
            String cari = s1.nextLine();
            System.out.println("\n\nMenggunakan sequential search ");
            data.FindSequentialSearch(data.listMhs, cari);
        }
}