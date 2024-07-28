package com.codeforall.online.damngame;

import com.codeforall.online.damngame.grid.Position;
import com.codeforall.online.damngame.grid.Grid;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements KeyboardHandler {
    private Position position;
    private int speed;
    private int score;
    private int lives;
    private Picture picture;

    public Player(Grid grid) {

        this.position = new Position(grid, grid.getCols() / 2, grid.getRows() / 2 - 10);
        this.speed = 50;
        this.score = 0;
        this.lives = 3;
        this.picture = new Picture(position.getCol(), position.getRow(), "Raft.png");
        this.picture.draw();

    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        System.out.println("OLA");
        if (e.getKey() == KeyboardEvent.KEY_LEFT) {
            System.out.println("LEFT KEY PRESSED");
        } else if (e.getKey() == KeyboardEvent.KEY_RIGHT) {
            System.out.println("RIGHT KEY PRESSED");
        }

    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }

}
