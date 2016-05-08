package vn.edu.techkids.controllers;

import com.sun.java.swing.plaf.windows.WindowsTreeUI;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by qhuydtvt on 5/6/2016.
 */
public class CollisionPool {

    private Vector<Colliable> colliableVector;

    private CollisionPool() {
        colliableVector = new Vector<Colliable>();
    }

    public void add(Colliable c){
        this.colliableVector.add(c);
    }

    public void run() {

        Iterator<Colliable> iterator = colliableVector.iterator();
        while(iterator.hasNext()) {
            Colliable c = iterator.next();
            if(!c.getGameObject().isAlive()){
                iterator.remove();
            }
        }

        System.out.println(colliableVector.size());
        for (int i = 0; i < colliableVector.size() - 1; i++) {
            for(int j = i + 1; j < colliableVector.size();j++) {
                Colliable ci = colliableVector.get(i);
                Colliable cj = colliableVector.get(j);
                Rectangle ri = ci.getGameObject().getRect();
                Rectangle rj = cj.getGameObject().getRect();
                if(ri.intersects(rj)){
                    ci.onCollide(cj);
                    cj.onCollide(ci);
                    System.out.println("hit");
                }
            }
        }
    }

    private static CollisionPool inst;
    public static CollisionPool getInst() {
        if(inst == null){
            inst = new CollisionPool();
        }
        return inst;
    }
}
