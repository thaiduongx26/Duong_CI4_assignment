package vn.edu.techkids.models;

/**
 * Created by qhuydtvt on 5/6/2016.
 */
public class EnemyBullet extends GameObject {

    public static final int WIDTH = 32;
    public static final int HEIGHT = 32;

    /* Dan thuong normal*/
    public static final int NORMAL_BULLET_DX = 0;
    public static final int NORMAL_BULLET_DY = 10;

    /*Dan bay cheo tu phai sang trai */
    public static final int BULLET_VECTO_CROSS_TO_LEFT_DX  = -10;
    public static final int BULLET_VECTO_CROSS_TO_LEFT_DY  = 10;

    /* Dan bay cheo tu trai sang phai */

    public static final int BULLET_VECTO_CROSS_TO_RIGHT_DX = 10;
    public static final int BULLET_VECTO_CROSS_TO_RIGHT_DY = 10;


    /*Kiểu bắn :*/

    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_CROSS_RIGHT_TO_LEFT  = 1;
    public static final int TYPE_CROSS_LEFT_TO_RIGHT  = 2;

    /* ----------------------------------------*/

    /* Damage */

    public static final int DAMAGE_BULLET_RIGHT_TO_LEFT = 3;
    /*-----------------*/

    public EnemyBullet(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}
