import java.util.Scanner;
public class Pertanyaan_Mahasiswa{
    
    int nim;
    String nama;
    int umur;
    double ipk;
    
    Pertanyaan_Mahasiswa(int ni, String n, int u, double i){
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

class Pertanyaan_PencarianMhs{
    Pertanyaan_Mahasiswa listMhs[] = new Pertanyaan_Mahasiswa[5];
    int idx;
    
    void tambah(Pertanyaan_Mahasiswa m){
        if(idx < listMhs.length){
            listMhs[idx] = m;
            idx++;
        }else{
            System.out.println("Data sudah penuh !!");
        }
    }
    
    void tampil(){
        for(Pertanyaan_Mahasiswa m : listMhs){
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

    public int FindBinarySearch(int cari, int left, int right){
        int mid;
        if(right >= left){
            mid = (left+right)/2;
            if(cari == listMhs[mid].nim){
                return (mid);
            }else if(listMhs[mid].nim > cari){
                return FindBinarySearch(cari, left, mid-1);
            }else{
                return FindBinarySearch(cari, mid+1, right);
            }
        }
        return -1;
    }

    // Untuk pertanyaan nomor 4 pada pertanyaan 6.3.3
    // public int FindBinarySearch(int cari, int left, int right){
    //     int mid;
    //     if(right >= left){
    //         mid = (left+right)/2;
    //         if(cari == listMhs[mid].nim){
    //             return (mid);
    //         }else if(listMhs[mid].nim > cari){
    //             return FindBinarySearch(cari, mid+1, right);
    //         }else{
    //             return FindBinarySearch(cari, left, mid-1);
    //         }
    //     }
    //     return -1;
    // }
    
    public void TampilPosisi(int x, int pos){
        if(pos != -1){
            System.out.println("data\t : "+ x + " ditemukan pada indeks "+pos);
        }else{
            System.out.println("data\t : "+ x + " tidak ditemukan");
        }
    }
    
    public void TampilData(int x, int pos){
        if(pos != -1){
            System.out.println("Nim\t : "+x);
            System.out.println("Nama\t : "+listMhs[pos].nama);
            System.out.println("Umur\t : "+listMhs[pos].umur);
            System.out.println("IPK\t : "+listMhs[pos].ipk);
        }else{
            System.out.println(" data "+x+"tidak ditemukan");
        }
    }
}

class Pertanyaan_MahasiswaMain_Binary{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        
        Pertanyaan_PencarianMhs data = new Pertanyaan_PencarianMhs();
        System.out.print("Masukkan jumlah Mahasiswa: ");
        int jumMhs = s.nextInt();

        Pertanyaan_Mahasiswa[] x = new Pertanyaan_Mahasiswa[jumMhs];
        data.listMhs = x;
        
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
            Double ipk = s.nextDouble();
            
            Pertanyaan_Mahasiswa m = new Pertanyaan_Mahasiswa(nim, nama, umur, ipk);
            data.tambah(m);
        }    
            System.out.println("-------------------------------------------");
            System.out.println("Data keseluruhan Mahasiswa : ");
            data.tampil();
            
            System.out.println("-------------------------------------------");
            System.out.println("-------------------------------------------");
            System.out.println("Pencarian data : ");
            System.out.println("Masukkan Nim Mahasiswa yang dicari : ");
            System.out.print("NIM : ");
            int cari = s.nextInt();
            System.out.println("menggunakan sequential search : ");
            int posisi = data.FindSeqSearch(cari);
            
            data.TampilPosisi(cari, posisi);
            data.TampilData(cari, posisi);

            // Binary Search
            System.out.println("===========================================");
            System.out.println("menggunakan binary search");
            posisi = data.FindBinarySearch(cari, 0, jumMhs-1);
            data.TampilPosisi(cari, posisi);
            data.TampilData(cari, posisi);
        }
}