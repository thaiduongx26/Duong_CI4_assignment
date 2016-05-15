package com.company.Models;

/**
 * Created by Wrong on 5/15/2016.
 */
public class Score {
    public static int score = 0;

    public int getScore() {
        return score;
    }

    public static void setScore() {
        score ++;
    }

    public static void setScore(int delta){
        score += delta;
    }
    public Score() {
//        this.score = score;
    }
}
