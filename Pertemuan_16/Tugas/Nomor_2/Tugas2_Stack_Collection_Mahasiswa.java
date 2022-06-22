package Pertemuan_16.Tugas.Nomor_2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Tugas2_Stack_Collection_Mahasiswa {
    String nim, nama, noHp;   

    public Tugas2_Stack_Collection_Mahasiswa(){

    }

    public Tugas2_Stack_Collection_Mahasiswa(String nim, String nama, String noHp) {
        this.nim  = nim;
        this.nama =  nama;
        this.noHp = noHp;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" + "nim=" + nim + ", nama=" + nama + ", noTelp=" +noHp + "}";
    }
}

class Tugas2_Stack_Collection_Matakuliah {
    String kode, matkul, sks;
    
    public Tugas2_Stack_Collection_Matakuliah(String kode, String matkul, String sks){
        this.kode = kode;
        this.matkul = matkul;
        this.sks = sks;
    }
}

class Tugas2_Stack_Collection_Nilai {
    String kdNilai, kdMatkul, nimMhs;
    double nilai;

    public Tugas2_Stack_Collection_Nilai(String kdNilai, double nilai, String kdMatkul, String nimMhs) {
        this.kdNilai = kdNilai;
        this.kdMatkul = kdMatkul;
        this.nimMhs = nimMhs;
        this.nilai = nilai;
    }
}

class MainTugas2_Stack_Collection_Pertemuan_16 {
    List<Tugas2_Stack_Collection_Mahasiswa> mhs = new ArrayList<>();
    List<Tugas2_Stack_Collection_Matakuliah> mk = new ArrayList<>();
    List<Tugas2_Stack_Collection_Nilai> nil = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    void setData(){
        //Mahasiswa
        mhs.add(new Tugas2_Stack_Collection_Mahasiswa("20001", "Thalhah", "021xxx"));
        mhs.add(new Tugas2_Stack_Collection_Mahasiswa("20002", "Zubair", "021xxx"));
        mhs.add(new Tugas2_Stack_Collection_Mahasiswa("20003", "Abdur-Rahman", "021xxx"));
        mhs.add(new Tugas2_Stack_Collection_Mahasiswa("20004", "Sa'ad", "021xxx"));
        mhs.add(new Tugas2_Stack_Collection_Mahasiswa("20005", "Sa'id", "021xxx"));
        mhs.add(new Tugas2_Stack_Collection_Mahasiswa("20006", "Ubaidah", "021xxx"));
        
        //Matakuliah
        mk.add(new Tugas2_Stack_Collection_Matakuliah("00001", "Internet of Things", "3"));
        mk.add(new Tugas2_Stack_Collection_Matakuliah("00002", "Algoritma dan Struktur Data", "2"));
        mk.add(new Tugas2_Stack_Collection_Matakuliah("00003", "Algoritma dan Pemrograman", "2"));
        mk.add(new Tugas2_Stack_Collection_Matakuliah("00004", "Praktikum Algoritma dan Struktur Data", "3"));
        mk.add(new Tugas2_Stack_Collection_Matakuliah("00005", "Praktikum Algoritma dan Pemrograman", "3"));
    }
    void inputNilai() {
        System.out.println("Masukkan Data");
        System.out.print("Kode    :");
        String kode = sc.next();
        System.out.print("Nilai   :");
        double nilai = sc.nextDouble();
        System.out.println("");
        System.out.println("DAFTAR MAHASISWA");
        System.out.println("************************************************");
        System.out.printf("%-15s        %-15s   %-14s\n", "NIM", "Nama", "Telf");
        for(Tugas2_Stack_Collection_Mahasiswa mahasiswa : mhs) {
            System.out.printf("%-15s        %-15s   %-14s\n", mahasiswa.nim, mahasiswa.nama, mahasiswa.noHp);
        }
        boolean found = true;
        String pilMhs;
        int confirm = 0;
        do {
            System.out.print("Pilih Mahasiswa by NIM : ");
            pilMhs = sc.next();
            for(Tugas2_Stack_Collection_Mahasiswa mahasiswa : mhs) {
                if(pilMhs.equals(mahasiswa.nim)) {
                    found = false;
                    confirm++;
                }
            }
            if(confirm == 0) {
                System.out.println("Data Kode NIM Tidak Ditemukan");
            }
        } while (found);
        System.out.println("");
        System.out.println("DAFTAR MATA KULIAH");
        System.out.println("************************************************");
        System.out.printf("%-15s        %-40s   %-40s\n", "Kode", "Mata Kuliah", "SKS");
        for(Tugas2_Stack_Collection_Matakuliah matkul : mk) {
            System.out.printf("%-15s        %-40s   %-40s\n", matkul.kode, matkul.matkul, matkul.sks);
        }
        boolean found1 = true;
        String pilMatkul;
        int confirm2 = 0;
        do {
            System.out.print("Pilih Mata Kuliah By Kode: ");
            pilMatkul = sc.next();
            for (Tugas2_Stack_Collection_Matakuliah matkul : mk){
                if(pilMatkul.equals(matkul.kode)) {
                    found1 = false;
                    confirm2++;
                }
            }
            if (confirm2 == 0) {
                System.out.println("Data Kode Mata Kuliah Tidak Ditemukan");
            }
        } while (found1);
        nil.add(new Tugas2_Stack_Collection_Nilai(kode, nilai, pilMatkul, pilMhs));
    }

    void tampilNilai() {
        System.out.println("NIM\tNama Mahasiswa\t\tMata Kuliah\t\t\t\tSKS\tNilai");
        nil.forEach(ns -> {
            System.out.print(ns.nimMhs + "\t");
            for(Tugas2_Stack_Collection_Mahasiswa mahasiswa : mhs) {
                if(mahasiswa.nim.equals(ns.nimMhs)) {
                    System.out.print(mahasiswa.nama + "\t\t");
                }
            }
            for(Tugas2_Stack_Collection_Matakuliah matkul : mk) {
                if(matkul.kode.equals(ns.kdMatkul)) {
                    System.out.print(matkul.matkul + "\t\t" + matkul.sks + "\t");
                }
            }
            System.out.println(ns.nilai);
        });
    }

    void cariNilai() {
        tampilNilai();
        System.out.print("Masukkan Data Mahasiswa[nim] : ");
        String searchNIM = sc.next();
        int confirm3 = 0;
        System.out.println("DAFTAR NILAI MAHASISWA");
        System.out.println("************************************************");
        System.out.println("NIM\t\tNama\t\tMata Kuliah\t\t\t\tSKS\tNilai");
        for(Tugas2_Stack_Collection_Nilai searchNilai : nil) {
            if(searchNilai.nimMhs.equals(searchNIM)) {
                System.out.print(searchNilai.nimMhs + "\t\t");
                for(Tugas2_Stack_Collection_Mahasiswa mahasiswa : mhs) {
                    if(mahasiswa.nim.equals(searchNilai.nimMhs)) {
                        System.out.print(mahasiswa.nama + "\t\t");
                    }
                }
                for(Tugas2_Stack_Collection_Matakuliah matkul : mk) {
                    if(matkul.kode.equals(searchNilai.kdMatkul)) {
                        System.out.print(matkul.matkul + "\t" + matkul.sks + "\t" + searchNilai.nilai);
                        System.out.println("\nTotal SKS " + matkul.sks + " telah diambil");
                    }
                }
                confirm3++;
            }
        }
        if(confirm3 == 0) {
            System.out.println("Data dengan NIM " + searchNIM + " Tidak Ditemukan");
        }
    }
    
    void urutNilai() {
        for(int i=0; i<nil.size()-1; i++) {
            for(int j=0; j<nil.size()-i-1; j++) {
                if(nil.get(j).nilai > nil.get(j+1).nilai) {
                    double swap = nil.get(j).nilai;
                    nil.get(j).nilai = nil.get(j+1).nilai;
                    nil.get(j+1).nilai = swap;
                }
            }
        }
        tampilNilai();
    }


    static void menu(){

    }

    public static void main(String[] args) {
        MainTugas2_Stack_Collection_Pertemuan_16 ddn = new MainTugas2_Stack_Collection_Pertemuan_16();
        int pilih;
        ddn.setData();
        do {
            System.out.println("************************************************");
            System.out.println("SISTEM PENGOLAHAN DATA NILAI MAHASISWA SEMESTER");
            System.out.println("************************************************");
            System.out.println("1. Input Nilai");
            System.out.println("2. Tampil Nilai");
            System.out.println("3. Mencari Nilai Mahasiswa");
            System.out.println("4. Urut Data Nilai");
            System.out.println("5. Keluar");
            System.out.print("Pilih   : ");
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    ddn.inputNilai();
                    break;
                case 2:
                    ddn.tampilNilai();
                    break;
                case 3:
                    ddn.cariNilai();
                    break;
                case 4:
                    ddn.urutNilai();
                    break;
                case 5:
                    System.out.println("Terima Kasih........");
                    System.exit(0);
                default:
                    System.out.println("Plihan Anda Salah!");
                    System.exit(0);
            }
        } while (pilih > 0 && pilih < 6);
    }
}