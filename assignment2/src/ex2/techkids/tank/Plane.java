package ex2.techkids.tank;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Wrong on 4/26/2016.
 */
public class Plane {
    private Image image ;
    public int x ;
    public int y ;
    public int dx;
    public int dy;

    int xOfbullet;
    int yOfbullet;

    Pullet pullet;

    public Plane(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        if (image != null)
            this.image = image;
    }

    public void paint(Graphics g){
        g.drawImage(image, x, y, null);
        if (pullet != null) {
            pullet.paint(g);

        }
    }

    public void run(){
        if (x == 400 - 70 && dx == 5) dx = 0 ;
        if (y == 600 - 70 && dy == 5) dy = 0;
        if (x == 0 && dx == -5) dx = 0 ;
        if (y == 0 && dy == -5) dy = 0;
        x += dx;
        y += dy;
        if (pullet != null){
            pullet.run();
            xOfbullet = pullet.x;
            yOfbullet = pullet.y;
        }

//        xOfbullet = pullet.x;
//        yOfbullet = pullet.y;
    }

    public void shot(){
        try {
            this.pullet = new Pullet(this.x,this.y,ImageIO.read(new File("resources/bullet.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
