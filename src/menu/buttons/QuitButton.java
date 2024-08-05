package com.codeforall.online.damngame.menu.buttons;

import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class QuitButton extends Button{

    public void drawButton(Grid grid, Picture background){
        this.button =  new Picture(Grid.PADDING * 10 + grid.columnToX(background.getX()),
                Grid.PADDING * 13 + grid.rowToY(background.getY()),
                "resources/resources/menu/quit.png");

        this.button.draw();
    }
}
