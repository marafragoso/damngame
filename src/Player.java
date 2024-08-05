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
    private Picture picture1;
    private Picture picture2;
    private Picture pictureFull;
    private Picture pictureEmpty;
    private Grid grid;

    public Player(Grid grid) {

        this.grid = grid;
        this.position = new Position(grid, grid.getCols() / 2, grid.getRows() / 2);
        this.speed = 10;
        this.score = 0;
        this.lives = 3;
        this.picture = new Picture(position.getCol(), position.getRow(), Grid.RESOURCE + "resources/Raft_resize.png");
        this.pictureFull = new Picture(Grid.PADDING, Grid.PADDING, Grid.RESOURCE + "resources/full-hearts.png");
        this.pictureEmpty = new Picture(Grid.PADDING,Grid.PADDING, Grid.RESOURCE + "resources/no_lifes.png");
        this.picture1 = new Picture(Grid.PADDING,Grid.PADDING, Grid.RESOURCE + "resources/1 heart.png");
        this.picture2 = new Picture(Grid.PADDING,Grid.PADDING, Grid.RESOURCE + "resources/2hearts.png");

        this.picture.draw();
        picture.grow(0.25, 0.25);

        this.pictureFull.draw();
        pictureFull.grow(0.25, 0.25);


    }

    public int getLives(){
        return this.lives;
    }

    public void decrementLives(){
        this.lives --;
        if(lives==2){
            this.pictureFull.delete();
            this.picture2.draw();
        } else if(lives==1) {
            this.picture2.delete();
            this.picture1.draw();
        } else if(lives==0) {
            this.picture1.delete();
            this.pictureEmpty.draw();
        }
    }

    public void incrementLives(){
        this.lives++;
        if(lives==1){
            this.picture1.delete();
            this.picture2.draw();
        } else if(lives==2){
            this.picture2.delete();
            this.pictureFull.draw();
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

}
