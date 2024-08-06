package com.codeforall.online.damngame.menu.buttons;

import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartButton extends Button{

    public StartButton(Grid grid, Picture background) {
        super(grid, background);
    }

    public void drawButton(){
        super.drawButton(Grid.PADDING * 10 + grid.columnToX(background.getX()),
                Grid.PADDING + grid.rowToY(background.getY()),
                "resources/resources/menu/start.png");
    }
}
