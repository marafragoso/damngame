package com.codeforall.online.damngame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Checks for the collision between two pictures on the canvas
 */
public class CollisionDetector {
    private Picture p1;
    private Picture p2;

    public CollisionDetector(Picture p1, Picture p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Checks for the collision between two pictures
     * @return  true if the collision has happened
     */
    public boolean hasCollided(){
        return (p1.getX() + p1.getWidth() >= p2.getX() &&
                p1.getY() + p1.getHeight() >= p2.getY() &&
                p2.getX() + p2.getWidth() >= p1.getX() &&
                p2.getY() + p2.getHeight() >= p1.getY());
    }
}
