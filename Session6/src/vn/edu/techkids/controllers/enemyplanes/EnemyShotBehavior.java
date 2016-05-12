package vn.edu.techkids.controllers.enemyplanes;

import vn.edu.techkids.controllers.enemybullet.EnemyBulletController;
import vn.edu.techkids.controllers.enemybullet.EnemyBulletType;

/**
 * Created by Wrong on 5/9/2016.
 */
public interface EnemyShotBehavior {
    EnemyBulletController doShot(int x, int y, EnemyBulletType enemyBulletType);
}
