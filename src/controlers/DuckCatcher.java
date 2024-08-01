package com.codeforall.online.damngame.controlers;

import com.codeforall.online.damngame.animals.ducks.Duck;
import com.codeforall.online.damngame.menu.Menu;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class DuckCatcher implements MouseHandler {
    private Mouse mouse;
    private Duck duck;


    public DuckCatcher(Duck duck) {
        this.duck = duck;
        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();

        if (x >= duck.getLeftBorder() &&
                x <= duck.getRightBorder() &&
                y <= duck.getLowerBorder() + 50 &&
                y >= duck.getUpperBorder()) {

            duck.remove();

        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
