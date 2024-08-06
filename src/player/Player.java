package com.codeforall.online.damngame.player;

import com.codeforall.online.damngame.grid.Position;
import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {
    private Position position;
    private int speed = 10;
    private int score;
    private int lives = 3;
    private Picture picture;
    private Grid grid;
    private boolean easyMode = false;
    private HeartState heartState;

    public Player(Grid grid) {
        this.grid = grid;

        this.position = new Position(grid, grid.getCols() / 2, grid.getRows() / 2);

        this.picture = new Picture(position.getCol(), position.getRow(), Grid.RESOURCE + "resources/Raft_resize.png");
        this.picture.draw();
        picture.grow(0.25, 0.25);

        this.heartState = new FullHeartState(this); //Initializing heart state to the state of full hearts
        this.heartState.drawHearts();
    }

    public int getLives() {
        return this.lives;
    }

    public void decrementLives() {
        if(!easyMode){
            this.lives --;

            heartState.loseLife(); // Changes the heart state to the previous state, until we reach the empty heart state
        }
    }

    public void incrementLives() {
        this.lives ++;

        heartState.gainLife(); // Changes the heart state to the next state, until we reach the full heart state
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

    public void setEasyMode() {
        this.easyMode = true;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public HeartState getHeartState() {
        return this.heartState;
    }

    public void setHeartState(HeartState heartState) {
        this.heartState = heartState;
    }
}

