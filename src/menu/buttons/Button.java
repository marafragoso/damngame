package com.codeforall.online.damngame.menu.buttons;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Button {
    protected Picture button;

    public int getX() {
        return this.button.getX();
    }

    public int getY() {
        return this.button.getY();
    }

    public int getHeight() {
        return this.button.getMaxY();
    }

    public int getWidth() {
        return this.button.getMaxX();
    }

    public void delete() {
        this.button.delete();
    }
}
