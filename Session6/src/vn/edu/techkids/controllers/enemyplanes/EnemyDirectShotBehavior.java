package vn.edu.techkids.controllers.enemyplanes;

import vn.edu.techkids.controllers.enemybullet.EnemyBulletController;
import vn.edu.techkids.controllers.enemybullet.EnemyBulletType;
import vn.edu.techkids.models.EnemyBullet;
import vn.edu.techkids.models.GameVector;
import vn.edu.techkids.views.ImageDrawer;

/**
 * Created by Wrong on 5/9/2016.
 */
public class EnemyDirectShotBehavior implements EnemyShotBehavior{

    @Override
    public EnemyBulletController doShot(int x, int y, EnemyBulletType enemyBulletType) {
        EnemyBulletController enemyBulletController = EnemyBulletController.creat(x,y,enemyBulletType);
        return enemyBulletController;
    }
}
