package com.codeforall.online.damngame.animals;

import com.codeforall.online.damngame.animals.ducks.Duck;
import com.codeforall.online.damngame.animals.sharks.Shark;
import com.codeforall.online.damngame.grid.Grid;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class AnimalFactory {
    private static final String BIRD_IMAGE_ACCESS = "resources/Bird/";
    private static final String SHARK_IMAGE_ACCESS = "resources/Shark/";

    public static Duck getNewDuck(Grid grid) {
        int initialY = duckInitialY(grid);

        Picture duckPicture = new Picture(grid.columnToX(0), initialY, BIRD_IMAGE_ACCESS + "Bird1.png");

        return new Duck(duckPicture);
    }

    public static Shark getNewShark(Grid grid) {
        int initialX = (int) (Math.random() * ((grid.columnToX(grid.getCols())) - 75) + Grid.PADDING);

        Picture sharkPicture = new Picture(initialX, grid.rowToY(grid.getRows()) - 140, SHARK_IMAGE_ACCESS + "shark1.png");

        return new Shark(sharkPicture);
    }

    private static int duckInitialY(Grid grid) {
        int randomY = (int) (Math.random() * (grid.rowToY(grid.getRows())) / 4) + Grid.PADDING;

        if (randomY < 150) {
            return 150;
        } else if (randomY < 200) {
            return 200;
        } else
            return 250;
    }
}
