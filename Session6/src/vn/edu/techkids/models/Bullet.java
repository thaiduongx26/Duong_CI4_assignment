package vn.edu.techkids.models;

public class Bullet extends GameObject {


    public static final int DEFAULT_WIDTH = 13;
    public static final int DEFAULT_HEIGHT = 33;
    public static final int DAMAGE_DEFAULT = 1;

    private int damage = DAMAGE_DEFAULT;

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Bullet(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}
