package Pertemuan_14.Tugas.No_2;

import java.util.Scanner;;
public class BinaryTreeArray {
    int[] data;
    int idxLast;

    public BinaryTreeArray(){
        data = new int[10];
    }

    void populateData(int data[], int idxLast){
        this.data = data;
        this.idxLast = idxLast;
    }

    void add(int dt, int idx){
        data[idx] = dt;
    }

    void updateData(int data[]){
        this.data = data;
    }

    void traverseInOrder(int idxStart){
        if(idxStart <= idxLast){
            traverseInOrder(2 * idxStart + 1);
            System.out.print(data[idxStart] + " ");
            traverseInOrder(2 * idxStart + 2);
        }
    }

    void traversePreOrder(int idxStart){
        if(idxStart <= idxLast){
            if(data[idxStart] == 0){
                System.out.print(idxLast + " ");
            }else{
                System.out.print(data[idxStart] + " ");
            }
            traversePreOrder(2 * idxStart + 1);
            traversePreOrder(2 * idxStart + 2);
        }
    }
    void traversePostOrder(int idxStart){
        if(idxStart <= idxLast){
            traversePostOrder(2 * idxStart + 1);
            traversePostOrder(2 * idxStart + 2);
            if(data[idxStart] == 0){
                System.out.print(idxLast + " ");
            }else{
                System.out.print(data[idxStart] + " ");
            }
        }
    }
}

class BinaryTreeArrayMain{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BinaryTreeArray bta = new BinaryTreeArray();
        // int[] data = {6,4,8,3,5,7,9,0,0,0};
        // int idxLast = 6;
        // bta.populateData(data, idxLast);
        // bta.traverseInOrder(0);

        System.out.print("Masukkan Jumlah Data : ");
        int jmlDt = input.nextInt();
        int data[] = new int[jmlDt];

        for(int i=0; i<data.length; i++){
            System.out.print("Masukkan Angka : ");
            int angka = input.nextInt();
            bta.add(angka, i);
            bta.updateData(data);
        }
        System.out.println("==========================");
        System.out.print("Pilih Angka: ");
        int idxLast = input.nextInt();
        bta.populateData(data, idxLast);   
        System.out.println("InOrder     : ");
        bta.traverseInOrder(0);
        System.out.println("");
        System.out.println("PreOrder     : ");
        bta.traversePreOrder(0);
        System.out.println("");
        System.out.println("PostOrder     : ");
        bta.traversePostOrder(0);
        System.out.println("");
    }
}
