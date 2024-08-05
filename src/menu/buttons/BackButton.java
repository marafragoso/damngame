package com.codeforall.online.damngame.menu.buttons;

import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BackButton extends Button {

    public void drawButton(Grid grid, Picture background){
        this.button = new Picture(Grid.PADDING, Grid.PADDING, "resources/resources/menu/back.png");
        this.button.draw();
    }
}
