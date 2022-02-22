public class array {
    public static void main(String args[]){
        String toko[] = {"RoyalGarden1", "RoyalGarden2", "RoyalGarden3", "RoyalGarden4"};
        String bunga[] = {"Aglonema", "Keladi", "Alocasia", "Mawar"};
        int stock[][] = {{10,5,15,7}, {6,11,9,12}, {2,10,10,5}, {5,7,12,9}};
        int harga[] = {75000,50000, 60000, 10000};
        int jmlAg=0, jmlKel=0, jmlAlo=0, jmlMwr=0, jmlRG1=0;

            for(int n=0; n<bunga.length; n++){
                jmlAg += stock[n][0];
                jmlKel += stock[n][1];
                jmlAlo += stock[n][2];
                jmlMwr += stock[n][3];
            }
            System.out.println("Jumlah stock bunga Aglonema sebanyak "+jmlAg);
            System.out.println("Jumlah stock bunga Keladi sebanyak "+jmlKel);
            System.out.println("Jumlah stock bunga Alocasia sebanyak "+jmlAlo);
            System.out.println("Jumlah stock bunga Mawar sebanyak "+jmlMwr);
            System.out.println("\n");
            
            stock[0][0] = (stock[0][0] - 1)*harga[0];
            stock[0][1] = (stock[0][1] - 2)*harga[1];
            stock[0][2] = (stock[0][2] - 0)*harga[2];
            stock[0][3] = (stock[0][3] - 5)*harga[3];
            


            for(int n=0; n<bunga.length; n++){
                jmlRG1 += stock[0][n];
            }
            System.out.println("Jumlah pendapatan dari "+toko[0]+" jika terjual habis sebesar Rp"+jmlRG1);

            

    }
}
