package com.codeforall.online.damngame.HighScore;

import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.io.*;

public class HighScore {
    private ScoreFile scoreFile;
    private Picture highScoreSymbol;
    private int highScore;

    public HighScore() {
        this.scoreFile = new ScoreFile("resources/highScore.txt");
        this.highScore = this.scoreFile.readFile();
    }

    public void draw(Grid grid) {
        highScoreSymbol = new Picture(Grid.PADDING + grid.columnToX(grid.getCols()) - 140, Grid.PADDING, "resources/resources/highScore.png");
        highScoreSymbol.draw();
    }

    public int getHighScore() {
        return this.highScore;
    }

    public void setNewHighScore(int newHighScore) {
        this.highScore = newHighScore;
        this.scoreFile.writeFile(String.valueOf(newHighScore));
    }

    public void displayHighScore() {
        Text highScoreText = new Text(this.highScoreSymbol.getX() + 60,this.highScoreSymbol.getMaxY() + 20, String.valueOf(this.highScore));
        highScoreText.setColor(Color.WHITE);
        highScoreText.grow(20,30);
        highScoreText.draw();
    }

    public class ScoreFile {
        private final String fileName;

        public ScoreFile(String fileName) {
            this.fileName = fileName;
        }

        public void writeFile(String content) {
            try {
                FileWriter fileWriter = new FileWriter(this.fileName);
                fileWriter.write(content);
                fileWriter.close();
            } catch (IOException e) {
                System.err.println("Error writing to the file: " + e.getMessage());
            }
        }

        public int readFile() {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.fileName))) {
                String line = bufferedReader.readLine();
                int score = Integer.parseInt(line);

                return score;

            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return 0;
        }
    }
}
