package com.codeforall.online.damngame.menu.buttons;

import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Button {
    protected Picture button;
    protected Grid grid;
    protected Picture background;

    public Button(Grid grid, Picture background) {
        this.grid = grid;
        this.background = background;
    }

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

    public void drawButton(double buttonX, double buttonY, String filePath) {
        this.button = new Picture(buttonX, buttonY, filePath);
        this.button.draw();
    }

    public void delete() {
        this.button.delete();
    }
}
