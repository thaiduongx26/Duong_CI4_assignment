package vn.edu.techkids.controllers;

import vn.edu.techkids.models.Bullet;
import vn.edu.techkids.models.Plane;
import vn.edu.techkids.views.ImageDrawer;

import java.awt.*;

/**
 * Created by Wrong on 5/7/2016.
 */
public class PlaneControllerManager extends ControllerManager {

    @Override
    public void run() {
        super.run();
    }

    private static PlaneControllerManager inst;
    public static PlaneControllerManager getInst() {
        if(inst == null) {
            inst = new PlaneControllerManager();
        }

        return inst;
    }
}
