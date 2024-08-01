package com.codeforall.online.damngame;

import com.codeforall.online.damngame.grid.Position;
import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {
    private Position position;
    private int speed;
    private int score;
    private int lives;
    private Picture picture;
    private Grid grid;

    public Player(Grid grid) {

        this.grid = grid;
        this.position = new Position(grid, grid.getCols() / 2, grid.getRows() / 2);
        this.speed = 10;
        this.score = 0;
        this.lives = 3;
        this.picture = new Picture(position.getCol(), position.getRow(), Grid.RESOURCE + "Raft_resize.png");

        this.picture.draw();
        picture.grow(0.25, 0.25);

    }

    public int getLives(){
        return this.lives;
    }

    public void decrementLives(){
        this.lives = this.lives-3;
    }

    public void moveLeft() {
        if (this.position.getCol() - speed <= grid.columnToX(0)) {
            return;
        }
        this.position.updatePosition(-speed, 0);
        this.picture.translate(-speed, 0);
    }

    public void moveRight() {

        if (this.position.getCol() + speed + this.picture.getWidth() >= this.grid.columnToX(grid.getCols())) {
            return;
        }
        this.position.updatePosition(speed, 0);
        this.picture.translate(speed, 0);
    }

    public Picture getPicture() {
        return this.picture;
    }

    public void deletePicture() {
        this.picture.delete();
    }
}
