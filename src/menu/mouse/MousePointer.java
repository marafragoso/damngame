package com.codeforall.online.damngame.menu.mouse;

import com.codeforall.online.damngame.menu.Menu;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MousePointer implements MouseHandler {
    private Mouse mouse;
    private Menu menu;

    public MousePointer(Menu menuButton){
        this.menu = menuButton;

        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();

        if(x >= menu.getStartButton().getX() &&
                x <= menu.getStartButton().getWidth() &&
                y <= menu.getStartButton().getHeight() &&
                y >= menu.getStartButton().getY()) {

            this.menu.setGameStart();
        }

        if(x >= menu.getQuitButton().getX() &&
                x <= menu.getQuitButton().getWidth() &&
                y <= menu.getQuitButton().getHeight() &&
                y >= menu.getQuitButton().getY()) {

            this.menu.setQuitGame();
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
