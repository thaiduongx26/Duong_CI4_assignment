package vn.edu.techkids.models;

/**
 * Created by Wrong on 5/12/2016.
 */
public class GiftItem extends GameObject{
    public static final int DEFAULT_WIDTH = 30;
    public static final int DEFAULT_HEIGHT = 30;

    public GiftItem(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public GiftItem(int x, int y) {
        super(x, y, DEFAULT_WIDTH,  DEFAULT_HEIGHT);
    }
}
