public class PacMan {
    int x,y,width,height;

    void moveLeft(){
        x-=1;
    }
    void moveRight(){
        x+=1;
    }
    void moveUp(){
        y-=1;
    }
    void moveDown(){
        y+=1;
    }
    void printPosition(){
        System.out.println("Posisi Pac Man saat ini berada di koordinat "+x+","+y);
    }
}

class PacManMain {
    public static void main(String args[]) {
        
        PacMan pc = new PacMan();
        pc.x = 50;
        pc.y= 3;
        pc.width = 30;
        pc.height = 25;
        if(pc.x <0 || pc.x > pc.width){
            System.exit(0);
        }
        if(pc.y <0 || pc.y > pc.height){
            System.exit(0);
        }
        System.out.println("Posisi Awal Pac Man berada di koordinat "+pc.x+","+pc.y);
        
        pc.moveDown();
        pc.moveLeft();
        pc.moveLeft();
        pc.moveLeft();
        pc.printPosition();
    }
}
