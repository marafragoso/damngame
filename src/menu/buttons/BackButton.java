package com.codeforall.online.damngame.menu.buttons;

import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BackButton extends Button {

    public BackButton(Grid grid, Picture background) {
        super(grid, background);
    }

    public void drawButton() {
        super.drawButton(Grid.PADDING, Grid.PADDING, "resources/resources/menu/back.png");
    }
}
