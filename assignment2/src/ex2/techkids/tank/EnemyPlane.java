package ex2.techkids.tank;

import java.awt.*;

/**
 * Created by Wrong on 4/26/2016.
 */
public class EnemyPlane {
    private int number;
    private Image image;

    public int x = 20;
    public int y = 20;



    public EnemyPlane(Image image) {
//        this.number = number;
        this.image = image;

//        for (int i = 1 ; i <= number ; i++){
//            this.paint(g,x1);
//            x1 += 5;
//        }
        System.out.println("5");
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void paint(Graphics g){
        for (int i = 0 ; i <= number ; i++){
            g.drawImage(image,x + 80*i,y,null);
        }
//        g.drawImage(image,x,y,null);
    }

    public void run(){
        if (y != 599) {
            y += 3;
        }else y = 20;
    }


}
