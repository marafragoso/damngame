package com.codeforall.online.damngame.menu.mouse;

import com.codeforall.online.damngame.menu.MainMenu;
import com.codeforall.online.damngame.menu.SettingsMenu;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class SettingsPointer implements MouseHandler {

    private Mouse mouse;
    private SettingsMenu settingsMenu;

    public SettingsPointer(SettingsMenu settingsMenu) {
        this.settingsMenu = settingsMenu;

        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);

    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();

        if(x >= settingsMenu.getBackButton().getX() &&
                x <= settingsMenu.getBackButton().getWidth() + 20 &&
                y <= settingsMenu.getBackButton().getHeight() + 20 &&
                y >= settingsMenu.getBackButton().getY()) {

            this.settingsMenu.returnToMainMenu();
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
