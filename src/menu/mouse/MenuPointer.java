package com.codeforall.online.damngame.menu.mouse;

import com.codeforall.online.damngame.menu.MainMenu;
import com.codeforall.online.damngame.menu.Menu;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MenuPointer implements MouseHandler {
    private Mouse mouse;
    private MainMenu mainMenu;

    public MenuPointer(MainMenu menuButton){
        this.mainMenu = menuButton;

        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();

        if(x >= mainMenu.getStartButton().getX() &&
                x <= mainMenu.getStartButton().getWidth() &&
                y <= mainMenu.getStartButton().getHeight() &&
                y >= mainMenu.getStartButton().getY()) {

            this.mainMenu.setGameStart();
        }

        if(x >= mainMenu.getSettingsButton().getX() &&
                x <= mainMenu.getSettingsButton().getWidth() &&
                y <= mainMenu.getSettingsButton().getHeight() &&
                y >= mainMenu.getSettingsButton().getY()) {

            this.mainMenu.displaySettings();
        }

        if(x >= mainMenu.getQuitButton().getX() &&
                x <= mainMenu.getQuitButton().getWidth() &&
                y <= mainMenu.getQuitButton().getHeight() &&
                y >= mainMenu.getQuitButton().getY()) {

            this.mainMenu.setQuitGame();
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
