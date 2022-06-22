package Pertemuan_16.Tugas.Nomor_1;

import java.util.Scanner;
import java.util.Stack;

public class Tugas1_Stack_Collection {
    String id, judul, director;
    int tahun;

    public Tugas1_Stack_Collection(){

    }

    public Tugas1_Stack_Collection(String id, String judul, int tahun, String director){
        this.id = id;
        this.judul = judul;
        this.tahun = tahun;
        this.director = director;
    }

    @Override
    public String toString() {
        return "Film{" + "ID Film=" + id + ", Judul Film=" + judul + ", Tahun Tayang=" + tahun
                + ", Director=" + director +"}";
    }
}

class Tugas1_Stack_CollectionMain {

    static void menu(){
        System.out.println("====================================");
        System.out.println("Data Film Layar Lebar Sepanjang Masa");
        System.out.println("====================================\n");
        System.out.println("1. Input Judul Film");
        System.out.println("2. Hapus Data Film Teratas");
        System.out.println("3. Cek Judul Film Teratas");
        System.out.println("4. Info semua Judul Film");
        System.out.println("5. Keluar");
        System.out.println("====================================\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        Stack<Tugas1_Stack_Collection> film = new Stack<>();
        int pilih;

        do {
            menu();
            System.out.println("Pilih: ");
            pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    System.out.println("ID Film         :");
                    String id = sc.nextLine();
                    System.out.println("Judul Film      :");
                    String judul = sc.nextLine();
                    System.out.println("Tahun Tayang    :");
                    int tahun = input.nextInt();
                    System.out.println("Director        :");
                    String director = sc.nextLine();
                    
                    Tugas1_Stack_Collection flm = new Tugas1_Stack_Collection();
                    film.push(flm = new Tugas1_Stack_Collection(id, judul, tahun, director));
                    System.out.println("");
                    break;
                case 2:
                    film.pop();
                    System.out.println("Film{" + "ID Film=" + (film.get(film.size()-1).id) + ", Judul Film=" + (film.get(film.size()-1).judul) + 
                    ", Tahun Tayang=" + (film.get(film.size()-1).tahun) + ", Director=" + (film.get(film.size()-1).director) +"}");
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Film{" + "ID Film=" + (film.get(film.size()-1).id) + ", Judul Film=" + (film.get(film.size()-1).judul) + 
                    ", Tahun Tayang=" + (film.get(film.size()-1).tahun) + ", Director=" + (film.get(film.size()-1).director) +"}");
                    break;
                case 4:
                    film.stream().forEach(f -> {
                        System.out.println("Film{" + "ID Film=" + f.id + ", judul=" + f.judul
                        + ", Tahun Tayang=" + f.tahun + ", Director=" + f.director + "}");
                     });
                     System.out.println("");
                     break;
                case 5:
                     System.out.println("Terima kasih");
                     System.exit(0);
                
                default:
                    System.out.println("Inputan yang Anda Masukkan Salah!");
                    break;
            }   
        } while (pilih > 0 && pilih < 6);
    }
}