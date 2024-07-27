package com.codeforall.online.damngame.animals;

import com.codeforall.online.damngame.animals.ducks.Duck;
import com.codeforall.online.damngame.animals.sharks.Shark;
import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class AnimalFactory {

    public static Duck getNewDuck(Grid grid){
        int randomY = (int)(Math.random() * (grid.rowToY(grid.getRows())) / 4) + Grid.PADDING;

        Picture duckPicture = new Picture(grid.columnToX(0), randomY, Grid.RESOURCE + "Bird/Bird2.png");

        return new Duck(duckPicture);
    }

    public static Shark getNewShark(Grid grid){
        int randomX = (int)(Math.random() * (grid.columnToX(grid.getCols()) - 75) + Grid.PADDING);

        Picture sharkPicture = new Picture(randomX, grid.rowToY(grid.getRows()) - 140, Grid.RESOURCE + "/Shark/shark1.png");

        return new Shark(sharkPicture);
    }
}
