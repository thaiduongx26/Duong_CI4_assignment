package vn.edu.techkids.controllers.Gift;

import vn.edu.techkids.controllers.Colliable;
import vn.edu.techkids.controllers.CollisionPool;
import vn.edu.techkids.controllers.PlaneController;
import vn.edu.techkids.controllers.SingleController;
import vn.edu.techkids.models.GameObject;
import vn.edu.techkids.models.GameVector;
import vn.edu.techkids.models.GiftItem;
import vn.edu.techkids.views.GameDrawer;
import vn.edu.techkids.views.ImageDrawer;

import java.awt.*;
import java.util.Random;

/**
 * Created by Wrong on 5/12/2016.
 */
public class GiftItemController extends SingleController implements Colliable{
//    GiftItemType giftItemType;
    public GiftItemController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer,new GameVector(0,0));
        CollisionPool.getInst().add(this);
    }

    public static GiftItemType giftType;
    public static GiftItemController creat(GiftItemType giftItemType){
        int x;
        int y;
//        GiftItemType giftItemtype ;
        GiftItemController giftItemController = null;
        giftType = giftItemType;
        Random random = new Random();
        switch (giftItemType){
            case BOMB:
                x = 50 + random.nextInt(400 - GiftItem.DEFAULT_WIDTH - 50);
                y = 50 + random.nextInt(600 - GiftItem.DEFAULT_HEIGHT - 50);
                GiftItem giftItem1 = new GiftItem(x,y);
                ImageDrawer imageDrawer1 = new ImageDrawer("resources/bomb.png");
                giftItemController = new GiftItemController(giftItem1,imageDrawer1);

                break;
            case BULLET:
                x = 50 + random.nextInt(400 - GiftItem.DEFAULT_WIDTH - 50);
                y = 50 + random.nextInt(600 - GiftItem.DEFAULT_HEIGHT - 50);
                GiftItem giftItem2 = new GiftItem(x,y);
                ImageDrawer imageDrawer2 = new ImageDrawer("resources/bullet.png");
                giftItemController = new GiftItemController(giftItem2,imageDrawer2);
                break;
        }
//        System.out.println(giftType);
        return giftItemController;
    }



    @Override
    public void run() {
        super.run();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void onCollide(Colliable c) {

    }
}
