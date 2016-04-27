package ex2.techkids.tank;

import java.awt.*;

/**
 * Created by Wrong on 4/26/2016.
 */
public class Pullet {
    public int x;
    public int y;
    private Image image;

    public Pullet(int x,int y,Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public void run(){
        y  -= 5 ;
    }

    public void paint(Graphics g){
        g.drawImage(image,x,y,null);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }
}
