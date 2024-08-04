package com.codeforall.online.damngame.animals;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Animal implements Animation {
    private Picture picture;
    private boolean toRemove = false;

    public Animal(Picture picture) {
        this.picture = picture;
        picture.draw();
    }

    public int getUpperBorder() {
        return this.picture.getY();
    }

    public int getRightBorder() {
        return this.picture.getMaxX();
    }

    public int getLowerBorder() {
        return this.picture.getMaxY();
    }

    public int getLeftBorder() {
        return this.picture.getX();
    }

    @Override
    public void moveRight() {
        this.picture.translate(5, 0);
    }

    @Override
    public void moveLeft() {
        this.picture.translate(-20, 0);
    }

    @Override
    public void moveUp() {
        this.picture.translate(0, -10);
    }

    @Override
    public void moveDown() {
        this.picture.translate(0, 10);
    }

    public void remove() {
        this.picture.delete();
        this.toRemove = true;
    }

    public boolean getToRemove() {
        return toRemove;
    }

    public Picture getPicture() {
        return this.picture;
    }

}
