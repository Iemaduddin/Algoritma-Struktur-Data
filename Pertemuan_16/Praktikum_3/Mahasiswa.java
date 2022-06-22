package Pertemuan_16.Praktikum_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;



public class Mahasiswa {
        String nim;
        String nama;
        String notelp;

        public Mahasiswa () {
            
        }

        public Mahasiswa(String nim, String nama, String notelp){
                this.nim = nim;
                this.nama = nama;
                this.notelp = notelp;
        }

        @Override
        public String toString(){
                return "Mahasiswa{" + "nim= " + nim + ", nama=" + nama + ", notelp=" + notelp + '}';
        }
}

class ListMahasiswa {
        List<Mahasiswa> mahasiswas = new ArrayList<>();

        public void tambah(Mahasiswa... mahasiswa) {
                mahasiswas.addAll(Arrays.asList(mahasiswa));
        }

        public void hapus(int index) {
                mahasiswas.remove(index);
        }

        public void update(int index, Mahasiswa mhs) {
                mahasiswas.set(index, mhs);
        }

        public void tampil() {
                mahasiswas.stream().forEach(mhs -> {
                        System.out.println("" + mhs.toString());
                });
        }

        int LinearSearch(String nim) {
                for(int i=0; i<mahasiswas.size(); i++) {
                        if(nim.equals(mahasiswas.get(i).nim)) {
                                return i;
                        }
                }
                return -1;
        }

        public static void main(String[] args) {
                ListMahasiswa lm = new ListMahasiswa();
                Mahasiswa m = new Mahasiswa("201234", "Noureen", "021xx1");
                Mahasiswa m1 = new Mahasiswa("201235", "Akhleema", "021xx2");
                Mahasiswa m2 = new Mahasiswa("201236", "Shannum", "021xx3");

                // Menambahkan Objek Mahasiswa
                lm.tambah(m, m1, m2);
                // Menampilkan List Mahasiswa
                lm.tampil();
                // Update Mahasiswa
                lm.update(lm.LinearSearch("201235"), new Mahasiswa("201235", "Akhleema Lela", "021xx2"));
                System.err.println("");
                lm.tampil();
        }
}