package ex2.techkids.tank;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static java.lang.System.*;

/**
 * Created by Wrong on 4/26/2016.
 */
public class gameWindow extends Frame implements Runnable{

    Image backgroundWindow;
    Plane plane1;
    Plane plane2;
    Random random = new Random();

    int ran;


    EnemyPlane enemy;


    Thread thread;

    Image backbufferImage;
    Random rd = new Random();

    public gameWindow() {
        this.setVisible(true);
        this.setSize(400,600);
        try {
            backgroundWindow = ImageIO.read(new File("resources/background.png"));
            plane1 = new Plane(230,500,ImageIO.read(new File("resources/plane4.png")));
            enemy = new EnemyPlane(ImageIO.read(new File("resources/plane1.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }


        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        plane1.dy = -5;
                        System.out.println("up");
                        //repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        plane1.dy = 5 ;
                        //repaint();
                        break;
                    case KeyEvent.VK_LEFT:
                        plane1.dx = -5 ;
                        //repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                        plane1.dx = 5 ;
                        //repaint();
                        break;
                    case KeyEvent.VK_SPACE:
                        plane1.shot();
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        plane1.dy = 0 ;
                        //repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        plane1.dy = 0 ;
                        //repaint();
                        break;
                    case KeyEvent.VK_LEFT:
                        plane1.dx = 0 ;
                        //repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                        plane1.dx = 0 ;
                        //repaint();
                        break;
                }
            }
        });
        thread = new Thread(this);
        thread.start();
        repaint();
    }

    public void update (Graphics g){
        if(backbufferImage == null){
            backbufferImage = new BufferedImage(400,600,1);
        }
        Graphics backbufferGraphics = backbufferImage.getGraphics();
        backbufferGraphics.drawImage(backgroundWindow,0,0,null);


        enemy.setNumber(rd.nextInt(4));

        enemy.paint(backbufferGraphics);


        plane1.paint(backbufferGraphics);

        g.drawImage(backbufferImage,0,0,null);


//        try {
//            enemyPlane = new EnemyPlane(random.nextInt(8),ImageIO.read(new File("resources/plane1.png")),backbufferGraphics);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void run() {
        while (true){
            plane1.run();

            if (plane1.xOfbullet >= enemy.x && plane1.xOfbullet <= enemy.x + 60 && plane1.yOfbullet == enemy.y){
                enemy.y = 20;
            }

            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            enemy.run();
            repaint();

        }
    }
}
