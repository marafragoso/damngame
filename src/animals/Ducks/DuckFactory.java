package com.codeforall.online.damngame.animals.Ducks;

import com.codeforall.online.damngame.grid.Grid;
import com.codeforall.online.damngame.grid.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DuckFactory {
    private Grid grid;

    public static Duck getNewDuck(Grid grid){
        int randomY = (int)(Math.random() * (grid.rowToY(grid.getRows())) / 4) + Grid.PADDING;

        Picture duckPicture = new Picture(grid.columnToX(0), randomY, Grid.RESOURCE + "Bird/Bird1.png");
        Position duckPosition = new Position(grid, grid.columnToX(0), randomY);

        Duck duck = new Duck(duckPicture, duckPosition);

        return duck;
    }
}
