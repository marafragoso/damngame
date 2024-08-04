package com.codeforall.online.damngame.controlers;

import com.codeforall.online.damngame.GameEngine;
import com.codeforall.online.damngame.GameOver;
import com.codeforall.online.damngame.Player;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

/* KeyHandler.java */
public class KeyHandler implements KeyboardHandler {

    private Player player;
    private Keyboard keyboard;
    private GameEngine gameEngine;

    public KeyHandler(Player player, GameEngine gameEngine) {
        this.player = player;

        this.keyboard = new Keyboard(this);
        createKeyboardEvents();

        this.gameEngine = gameEngine;

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

        KeyboardEvent keyboardEventReplay = new KeyboardEvent();
        keyboardEventReplay.setKey(KeyboardEvent.KEY_R);
        keyboardEventReplay.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventReplay);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        // this is going to happen when keys F or R are pressed
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_A:
                player.moveLeft();
                break;
            case KeyboardEvent.KEY_D:
                player.moveRight();
                break;
            case KeyboardEvent.KEY_R:
                try {
                    gameEngine.start();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        // specify what will happen when the keys are released
    }
}