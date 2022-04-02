public class Tugas_3 {
    public int[] data;
    public int maks = 0;
    public int posisi;
    public int jumlah = 0;

    Tugas_3(int nilai[]){
        data = nilai;
    }

    void tampil(){
        for(int i=0; i<data.length; i++){
            System.out.println(data[i] + " ");
            System.out.println();
        }
    }

    void bubbleSort(){
        for(int i=0; i<data.length-1; i++){
            for(int j=1; j<data.length; j++){
                if(data[j]> data[j-1]){
                    int temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                }
            }
        }
    }

    public int binarySearch(int cari, int left, int right){
        int middle;
        if(right >= left){
            middle = (left+right)/2;
            if(cari == data[middle]){
                return (middle);
            }else if(data[middle] > cari){
                return binarySearch(cari, middle+1, right);
            }else{
                return binarySearch(cari, left, middle-1);
            }
        }
        return -1;
    }

    public int nilaiTerbesar(){
        for(int i=0; i<data.length; i++){
            if(data[i] > maks){
                maks = data[i];
            }
        }
        System.out.print("Nilai yang paling besar adalah : "+maks);
        return maks;
    }

    public void tampilPosisi(int pos){
        for(int i=0; i<data.length; i++){
            if(data[i] == maks){
                jumlah++;
            }
        }
        System.out.print(" dengan jumlah "+ jumlah);
        System.out.println();
        posisi = maks;

        for(int i=0; i<data.length; i++){
            if(posisi == data[i]){
                pos = i;
                System.out.println("Data ditemukan pada indeks ke-"+pos);
            }
        }
    }
}

class Tugas_3_Main{
    public static void main(String[] args) {
        int angka[] = {12, 17, 2, 1, 70, 50, 90, 17, 2, 90};

        Tugas_3 arr = new Tugas_3(angka);

        int sum = 10, maks=0;
        System.out.println("=========================================");
        System.out.println("                TAMPILAN DATA            ");
        System.out.println("=========================================");
        System.out.println("Sebelum di sorting");
        arr.tampil();
        arr.bubbleSort();
        System.out.println("=========================================");
        System.out.println("Setelah di sorting");
        arr.tampil();
        System.out.println("=========================================");
        arr.nilaiTerbesar();
        arr.binarySearch(maks, 0, sum-1);
        arr.tampilPosisi(maks);
    }
}