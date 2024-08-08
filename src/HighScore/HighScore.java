package com.codeforall.online.damngame.HighScore;

import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.io.*;

/**
 * Reads and writes the highest score to a .txt file
 */
public class HighScore {
    private ScoreFile scoreFile;
    private Picture newHighScoreSymbol;
    private Picture highestScore;
    private Text highScoreText;
    private int highScore;

    public HighScore() {
        this.scoreFile = new ScoreFile("resources/highScore.txt");
        this.highScore = this.scoreFile.readFile();
    }

    // Displays the new high score on the canvas if the player achieves it
    public void drawNewHighScore(Grid grid) {
        newHighScoreSymbol = new Picture(Grid.PADDING + grid.columnToX(grid.getCols()) - 140, Grid.PADDING, "resources/resources/highScore.png");
        newHighScoreSymbol.draw();
    }

    // Displays the highest score recorded upon game is over
    public void drawHighestScore(Grid grid) {
        if(newHighScoreSymbol != null) {
            newHighScoreSymbol.delete();
        }

        this.highestScore = new Picture(Grid.PADDING + grid.columnToX(grid.getCols()) - 140, Grid.PADDING, "resources/resources/highestScore.png");
        this.highestScore.draw();
    }

    public int getHighScore() {
        return this.highScore;
    }

    public Picture getNewHighScoreSymbol() {
        return this.newHighScoreSymbol;
    }

    public Picture getHighestScore() {
        return this.highestScore;
    }

    // Register a new highscore and saves it to a .txt file
    public void setNewHighScore(int newHighScore) {
        this.highScore = newHighScore;
        this.scoreFile.writeFile(String.valueOf(newHighScore));
    }

    // Displays the highest score
    public void displayHighScore(Picture picture) {
        highScoreText = new Text(picture.getX() + 60,picture.getMaxY() + 20, String.valueOf(this.highScore));
        highScoreText.setColor(Color.WHITE);
        highScoreText.grow(20,30);
        highScoreText.draw();
    }

    public void delete() {
        if(this.newHighScoreSymbol != null) {
            this.newHighScoreSymbol.delete();
        }
        if(this.highestScore != null) {
            this.highestScore.delete();
        }

        this.highScoreText.delete();
        this.highScore = 0;
    }
}
