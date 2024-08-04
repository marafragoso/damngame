package com.codeforall.online.damngame.controlers;

import com.codeforall.online.damngame.player.Player;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

/* KeyHandler.java */
public class KeyHandler implements KeyboardHandler {

    private Player player;
    private Keyboard keyboard;

    public KeyHandler(Player player) {
        this.player = player;

        this.keyboard = new Keyboard(this);
        createKeyboardEvents();
    }

    public void createKeyboardEvents() {

        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKey(KeyboardEvent.KEY_A);
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventLeft);

        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKey(KeyboardEvent.KEY_D);
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventRight);

        KeyboardEvent keyboardEventEasy = new KeyboardEvent();
        keyboardEventEasy.setKey(KeyboardEvent.KEY_E);
        keyboardEventEasy.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventEasy);

        KeyboardEvent keyboardEventIncreaseSpeed = new KeyboardEvent();
        keyboardEventIncreaseSpeed.setKey(KeyboardEvent.KEY_S);
        keyboardEventIncreaseSpeed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventIncreaseSpeed);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_A:
                player.moveLeft();
                break;
            case KeyboardEvent.KEY_D:
                player.moveRight();
                break;
            case KeyboardEvent.KEY_S:
                player.setSpeed(30);
                break;
            case KeyboardEvent.KEY_E:
                player.setEasyMode(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}