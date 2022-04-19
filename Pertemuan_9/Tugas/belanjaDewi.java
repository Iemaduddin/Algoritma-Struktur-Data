package Tugas;

import java.util.Date;
import java.text.SimpleDateFormat;

public class belanjaDewi {
    int top, size, jmlBrg, totalHrg;
    String noTrans, waktu;
    belanjaDewi[] stack;

    public belanjaDewi(String noTrans, int jmlBrg, int totalHrg, String waktu){
        this.noTrans = noTrans;
        this.jmlBrg = jmlBrg;
        this.totalHrg = totalHrg;
        this.waktu = waktu;
    }

    public belanjaDewi(int size){
        this.size = size;
        this.top =-1;
        stack = new belanjaDewi[this.size];
    }

    public boolean IsEmpty(){
        if(top <= -1){
            return true;
        }else{
            return false;
        }
    }

    public boolean IsFull(){
        if(top >= size-1){
            return true;
        }else{
            return false;
        }
    }

    public void push(belanjaDewi stk){
        if(!IsFull()){
            top++;
            stack[top] = stk;
        }else{
            System.out.println("Data sudah full!");
        }
    }

    public void pop(){
        if(!IsEmpty()){
            belanjaDewi st = stack[top];
            top--;
            line(50);
            System.out.printf("Nomor Transaksi: %-10s\n", st.noTrans);
            System.out.printf("Tanggal: %-20s\n", st.waktu);
            line(50);
            System.out.printf("Jumlah Barang: %-6d\n", st.jmlBrg);
            System.out.printf("Total: Rp. %d\n", st.totalHrg);
            line(50);
        }
    }
    
    public void line (int pjg){
        for(int i=0; i<pjg; i++){
            System.out.print("=");
        }
        System.out.println();
    }
    
    public void print(){
        line(50);
        System.out.println("\t\t   ISI STACK                   ");
        line(50);
        for(int i=top; i>=0; i--){
            line(50);
            System.out.printf("Nomor Transaksi: %-10s\n", stack[i].noTrans);
            System.out.printf("Tanggal: %-20s\n", stack[i].waktu);
            line(50);
            System.out.printf("Jumlah Barang: %-6d\n", stack[i].jmlBrg);
            System.out.printf("Total: Rp. %d\n", stack[i].totalHrg);
            line(50);
        }
        System.out.println();
    }
}

class belanjaDewiMain{
    public static void main(String[] args) {
        Date waktu = new Date();
        
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE,dd MMMM YYYY");
        
        belanjaDewi struk = new belanjaDewi(8);
        belanjaDewi[] belanjaDewi = new belanjaDewi[8];
        String date = sdf.format(waktu);
        
        belanjaDewi[0] = new belanjaDewi("ARBDS-010-221", 12, 1200000, date);
        belanjaDewi[1] = new belanjaDewi("ARBDS-020-221", 2, 1100000, date);
        belanjaDewi[2] = new belanjaDewi("ARBDS-013-242", 21, 1500000, date);
        belanjaDewi[3] = new belanjaDewi("ARBDS-524-242", 3, 160000, date);
        belanjaDewi[4] = new belanjaDewi("ARBDS-310-551", 5, 1298000, date);
        belanjaDewi[5] = new belanjaDewi("ARBDS-940-645", 10, 200000, date);
        belanjaDewi[6] = new belanjaDewi("ARBDS-784-215", 9, 3200000, date);
        belanjaDewi[7] = new belanjaDewi("ARBDS-425-254", 8, 1800000, date);
        
        for (int i = 0; i < struk.size; i++) {
            struk.push(belanjaDewi[i]);
        }
        struk.print();
        struk.line(50);
        System.out.println("\tData yang di-pop |struk 5 minggu|");
        struk.line(50);
        for (int i = 0; i < 5; i++) {
            struk.pop();
        }
        struk.print();
    }
}
