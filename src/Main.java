package com.codeforall.online.damngame;

import com.codeforall.online.damngame.GameEngine;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        /* pre-game */
        GameEngine gameEngine = new GameEngine();

        gameEngine.init();
        gameEngine.start();
    }
}
