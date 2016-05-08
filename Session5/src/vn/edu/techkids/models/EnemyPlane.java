package vn.edu.techkids.models;

/**
 * Created by qhuydtvt on 5/6/2016.
 */
public class EnemyPlane extends GameObjectWithHP {
    private static final int HP_DEFAULT = 2;

    /* cai nay la cho cai enemy 4s */
    public static final int DEFAULT_VECTO_FLY_DX = 0;
    public static final int DEFAULT_VECTO_FLY_DY = 2;

    /*cai nay cho cai enemy bay cheo*/

    public static final int SPEED_VECTO_CROSS_DX = 2;
    public static final int SPEED_VECTO_CROSS_DY = 2;

    /* FUCK MY ENEMY */

    public EnemyPlane(int x, int y, int width, int height, int hp) {
        super(x, y, width, height, hp);
    }

    public EnemyPlane(int x, int y, int width, int height) {
        this(x, y, width, height, HP_DEFAULT);
    }
}
