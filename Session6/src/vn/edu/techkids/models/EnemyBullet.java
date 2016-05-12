package vn.edu.techkids.models;

/**
 * Created by qhuydtvt on 5/6/2016.
 */
public class EnemyBullet extends GameObject {

    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;

    public static final int DEFAULT_DAMAGE = 1;

    private int damage = DEFAULT_DAMAGE;

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public EnemyBullet(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public EnemyBullet(int x, int y, int width, int height, int damage) {
        super(x, y, width, height);
        this.damage = damage;
    }
}