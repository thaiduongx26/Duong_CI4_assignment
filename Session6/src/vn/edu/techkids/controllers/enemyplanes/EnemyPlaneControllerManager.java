package vn.edu.techkids.controllers.enemyplanes;

import vn.edu.techkids.controllers.ControllerManager;
import vn.edu.techkids.models.GameConfig;

/**
 * Created by qhuydtvt on 5/6/2016.
 */
public class EnemyPlaneControllerManager extends ControllerManager {

    private int count = 0;

    private int planeType = 0;

    private EnemyPlaneControllerManager() {
        super();
    }

    @Override
    public void run() {
        super.run();
        count++;
        planeType++;
        if(GameConfig.getInst().durationInSeconds(count) > 2) {
            count = 0;

            for (int x = 40; x < GameConfig.getInst().getScreenWidth() - 40; x += 100) {
//                    EnemyPlane enemyPlane = new EnemyPlane(x, 0, 32, 32);
//                    ImageDrawer imageDrawer =
//                            new ImageDrawer("resources/plane1.png");
//                    EnemyPlaneController enemyPlaneController = new EnemyPlaneController(
//                            enemyPlane,
//                            imageDrawer
//                    );
                if (planeType % 2 == 0) {
                    this.singleControllerVector.add(EnemyPlaneController.creat(EnemyPlaneType.BLACK, x, 0));
                } else {
                    this.singleControllerVector.add(EnemyPlaneController.creat(EnemyPlaneType.WHILE, x, 0));
                }
            }

        }
    }

    private static EnemyPlaneControllerManager inst;
    public static EnemyPlaneControllerManager getInst() {
        if(inst == null) {
            inst = new EnemyPlaneControllerManager();
        }

        return inst;
    }
}
