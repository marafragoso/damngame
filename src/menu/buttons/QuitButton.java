package com.codeforall.online.damngame.menu.buttons;

import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class QuitButton extends Button{

    public QuitButton(Grid grid, Picture background) {
        super(grid, background);
    }

    public void drawButton() {
        super.drawButton(Grid.PADDING * 10 + grid.columnToX(background.getX()),
                Grid.PADDING * 13 + grid.rowToY(background.getY()),
                "resources/resources/menu/quit.png");
    }
}
