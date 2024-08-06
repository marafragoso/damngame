package com.codeforall.online.damngame.menu.buttons;

import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SettingsButton extends Button {

    public SettingsButton(Grid grid, Picture background) {
        super(grid, background);
    }

    public void drawButton(){
        super.drawButton(Grid.PADDING * 10.5 + grid.columnToX(background.getX()),
                Grid.PADDING * 7 + grid.rowToY(background.getY()),
                "resources/resources/menu/settings.png");
    }
}
