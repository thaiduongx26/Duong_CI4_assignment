package vn.edu.techkids.controllers.Gift;

import com.sun.java.swing.plaf.windows.WindowsTreeUI;
import vn.edu.techkids.controllers.Colliable;
import vn.edu.techkids.controllers.CollisionPool;
import vn.edu.techkids.controllers.ControllerManager;
import vn.edu.techkids.models.GameConfig;
import vn.edu.techkids.models.GameObject;
import vn.edu.techkids.models.GiftItem;

import java.awt.*;
import java.util.Random;

/**
 * Created by Wrong on 5/12/2016.
 */
public class GiftItemControllerManager extends ControllerManager {
    int count = 0;
    int time = 0;
    Random random = new Random();
    GiftItemController giftItemController ;
    public GiftItemControllerManager() {
    }

    @Override
    public void run() {
        super.run();
        count++;
        if(GameConfig.getInst().durationInSeconds(count) > 2) {
            for (Colliable colliable : CollisionPool.getInst().getColliableVector()) {
                if (colliable instanceof GiftItemController){
                    time++;
                }
            }
            if (time == 0 && (5 + random.nextInt(10 - 5)) >= 8 ) {
                this.singleControllerVector.add(GiftItemController.creat(GiftItemType.BOMB));
            } else if (time == 0) {
                this.singleControllerVector.add(giftItemController.creat(GiftItemType.BULLET));
            }
            time = 0;
            count = 0;
        }
    }

    private static GiftItemControllerManager inst;
    public static GiftItemControllerManager getInst() {
        if(inst == null) {
            inst = new GiftItemControllerManager();
        }

        return inst;
    }




}
