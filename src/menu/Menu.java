package com.codeforall.online.damngame.menu;

import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Menu {
    protected Grid grid;
    protected Picture background;

    public Menu(Grid grid) {
        this.grid = grid;

        drawBackground();
    }

    private void drawBackground() {
        this.background = new Picture(Grid.PADDING, Grid.PADDING, "resources/resources/menu/menuBackground.png");
        this.background.draw();
    }

    public void delete() {
        this.background.delete();
    }
}
