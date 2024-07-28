package com.codeforall.online.damngame.animals;

import com.codeforall.online.damngame.animals.ducks.Duck;
import com.codeforall.online.damngame.animals.sharks.Shark;
import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import com.codeforall.online.damngame.grid.Position;

public class AnimalFactory {
    private static final String BIRD_IMAGE_ACCESS = "Bird/";
    private static final String SHARK_IMAGE_ACCESS = "Shark/";

    public static Duck getNewDuck(Grid grid) {
        int initialY = getInitialPosition(grid);

        Picture duckPicture = new Picture(grid.columnToX(0), initialY, BIRD_IMAGE_ACCESS + "Bird1.png");
        Position duckPosition = new Position(grid, 0, initialY);
        return new Duck(duckPicture, duckPosition);
    }

    public static Shark getNewShark(Grid grid) {
        int randomX = (int) (Math.random() * (grid.columnToX(grid.getCols()) - 75) + Grid.PADDING);

        Picture sharkPicture = new Picture(randomX, grid.rowToY(grid.getRows()) - 140,
                SHARK_IMAGE_ACCESS + "shark.png");

        return new Shark(sharkPicture);
    }

    private static int getInitialPosition(Grid grid) {
        int randomY = (int) (Math.random() * (grid.rowToY(grid.getRows())) / 4) + Grid.PADDING;

        if (randomY < 34) {
            return 34;
        } else if (randomY < 68) {
            return 68;
        } else if (randomY < 102) {
            return 102;
        } else if (randomY < 136) {
            return 136;
        } else
            return 170;
    }
}
