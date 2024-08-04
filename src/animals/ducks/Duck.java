package com.codeforall.online.damngame.animals.ducks;

import com.codeforall.online.damngame.animals.Animal;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Duck extends Animal implements MouseHandler {
    private Mouse mouse;
    private DuckReward duckReward;
    private boolean clicked = false;

    public Duck(Picture picture) {
        super(picture);
        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    public boolean hasReward() {
        return Math.random() < 0.25;
    }

    public void setDuckReward(DuckReward duckReward){
        this.duckReward = duckReward;
    }

    public DuckReward getDuckReward(){
        return this.duckReward;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();

        if (x >= this.getLeftBorder() &&
                x <= this.getRightBorder() &&
                y <= this.getLowerBorder() + 50 &&
                y >= this.getUpperBorder()) {

            if (this.hasReward()) {
                DuckReward reward = new DuckReward(this.getPicture().getX(), this.getPicture().getY());
                this.setDuckReward(reward);
            }

            this.remove();
            this.clicked = true;
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }

    public boolean isClicked() {
        return this.clicked;
    }


}
