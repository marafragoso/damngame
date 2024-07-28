package com.codeforall.online.damngame.animals.Ducks;

import com.codeforall.online.damngame.grid.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Duck {
    protected Picture picture;
    private Position position;

    public Duck(Picture picture, Position position) {
        this.picture = picture;
        this.position = position;
        picture.draw();
    }

    public int getRightBorder(){
        return this.picture.getMaxX();
    }

    public void moveRight(){
        this.picture.translate(10,0);
        this.position.updatePosition(10,0);
    }
}
