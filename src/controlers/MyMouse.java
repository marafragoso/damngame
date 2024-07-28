package com.codeforall.online.damngame.controlers;

import com.codeforall.online.damngame.animals.ducks.Duck;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MyMouse implements MouseHandler {
    private Mouse mouse;
    private Duck duck;

    public void init(){
        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    public void setDuck(Duck duck){
        this.duck = duck;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if(mouseEvent.getX() >= duck.getLeftBorder() &&
                mouseEvent.getX() <= duck.getRightBorder() &&
                mouseEvent.getY() <= duck.getLowerBorder() &&
                mouseEvent.getY() >= duck.getUpperBorder()) {

            System.out.println("autch");
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
