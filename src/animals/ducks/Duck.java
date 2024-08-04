package com.codeforall.online.damngame.animals.ducks;

import com.codeforall.online.damngame.Player;
import com.codeforall.online.damngame.animals.Animal;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Duck extends Animal implements MouseHandler {
    private Mouse mouse;
    private boolean wasClicked = false;

    public Duck(Picture picture) {
        super(picture);
        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();

        if (x >= this.getLeftBorder() &&
                x <= this.getRightBorder() &&
                y <= this.getLowerBorder() + 50 &&
                y >= this.getUpperBorder()) {

            this.remove();
            wasClicked = true;
        }


    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    public boolean duckClicked() {
        return this.wasClicked;
    }
}
