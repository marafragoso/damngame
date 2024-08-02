package com.codeforall.online.damngame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CollisionDetector {
    private Picture p1;
    private Picture p2;

    public CollisionDetector(Picture p1, Picture p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public boolean hasCollided(){
        if (p1.getX() + p1.getWidth() >= p2.getX() && p1.getY() + p1.getHeight() >= p2.getY()
                && p2.getX() + p2.getWidth() >= p1.getX()
                && p2.getY() + p2.getHeight() >= p1.getY()) {

            return true;
        }
        return false;
    }
}
