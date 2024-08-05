package com.codeforall.online.damngame;

import com.codeforall.online.damngame.grid.Position;
import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {
    private Position position;
    private int speed;
    private int score;
    private int lives;
    private Picture hearts;
    private Picture picture;
    private Grid grid;

    public Player(Grid grid) {

        this.grid = grid;
        this.position = new Position(grid, grid.getCols() / 2, grid.getRows() / 2);
        this.speed = 10;
        this.score = 0;
        this.lives = 3;
        this.hearts = new Picture(Grid.PADDING, Grid.PADDING, Grid.RESOURCE + "resources/full-hearts.png");
        this.picture = new Picture(position.getCol(), position.getRow(), Grid.RESOURCE + "resources/Raft_resize.png");

        this.picture.draw();
        picture.grow(0.25, 0.25);

        this.hearts.draw();
    }

    public int getLives() {
        return this.lives;
    }

    public void decrementLives(){
        this.lives --;

        drawLives();
    }

    public void incrementLives(){
        this.lives ++;

        drawLives();
    }

    public void drawLives() {
        switch(this.lives){
            case 0:
                this.hearts.delete();
                this.hearts = new Picture(Grid.PADDING,Grid.PADDING, Grid.RESOURCE + "resources/no_lifes.png");
                this.hearts.draw();
                break;
            case 1:
                this.hearts.delete();
                this.hearts = new Picture(Grid.PADDING,Grid.PADDING, Grid.RESOURCE + "resources/1 heart.png");
                this.hearts.draw();
                break;
            case 2:
                this.hearts.delete();
                this.hearts = new Picture(Grid.PADDING,Grid.PADDING, Grid.RESOURCE + "resources/2hearts.png");
                this.hearts.draw();
                break;
            case 3:
                this.hearts.delete();
                this.hearts = new Picture(Grid.PADDING, Grid.PADDING, Grid.RESOURCE + "resources/full-hearts.png");
                this.hearts.draw();
                break;
        }
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

    public int getScore() {
        return this.score;
    }

    public void increaseScore() {
        this.score ++;
    }
}

