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

    //Only a few ducks will give a reward to the player
    public boolean hasReward() {
        return Math.random() < 0.5;
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

            //If duck is clicked, the reward (if it has it) gets created
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

    /**
     * Method to help with the duck remove method in the GameEngine class
     *
     * @return  true if the duck was clicked; this makes it so the duck can be removed from the canvas, otherwise it won't
     */
    public boolean isClicked() {
        return this.clicked;
    }


}
