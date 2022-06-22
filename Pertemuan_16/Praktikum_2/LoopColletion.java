package Pertemuan_16.Praktikum_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LoopColletion{
    public static void main(String[] args) {

        Stack<String> fruits = new Stack<>();
        fruits.push("Banana");
        fruits.add("Orange");
        fruits.add("Watermelon");
        fruits.add("Leci");
        fruits.add("Salak");

        for(String fruit : fruits){
            System.out.printf("%s ", fruit);
        }

        System.out.println("\n" + fruits.toString());

        while(!fruits.empty()){
            System.out.printf("%s ", fruits.pop());
        }

        fruits.push("Melon");
        fruits.push("Strawberry");
        System.out.println("");
        for(Iterator<String> it = fruits.iterator(); it.hasNext();){
            String fruit = it.next();
            System.out.printf("%s ", fruit);
        }
        System.out.println("");
        fruits.stream().forEach(e ->{
            System.out.printf("%s ", e);
        });
        System.out.println("");
        for(int i=0; i<fruits.size(); i++){
            System.out.printf("%s ", fruits.get(i));
        }

        // // Pertanyaan Nomor 6
        // fruits.push("Mango");
        // fruits.push("Guava");
        // fruits.push("Avocado");

        // fruits.sort((String i, String j) -> i.compareTo(j));
        // System.out.println("");
        // System.out.println("\nSetelah Data telah di Sorting");

        for(int i=0; i<fruits.size(); i++) {
            System.out.printf("%s ", fruits.get(i));
        }
    }
}