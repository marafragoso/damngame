package com.codeforall.online.damngame;

import com.codeforall.online.damngame.HighScore.HighScore;
import com.codeforall.online.damngame.animals.AnimalFactory;
import com.codeforall.online.damngame.animals.ducks.Duck;
import com.codeforall.online.damngame.animals.ducks.DuckReward;
import com.codeforall.online.damngame.animals.sharks.Shark;
import com.codeforall.online.damngame.controlers.KeyHandler;
import com.codeforall.online.damngame.grid.Grid;
import com.codeforall.online.damngame.menu.MainMenu;
import com.codeforall.online.damngame.player.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameEngine {
    private Grid grid;
    private Player player;
    private Soundtrack soundtrack;
    private List<Duck> ducks = new ArrayList<>();
    private List<Shark> sharks = new ArrayList<>();
    private List<DuckReward> rewards = new ArrayList<>();
    private Text scoreText;
    private HighScore highScore;
    private int sharkGenerationInterval = 50;

    public GameEngine() {
        this.grid = new Grid(100, 50);
    }

    /**
     * Displays the main menu
     * @throws InterruptedException
     */
    public void init() throws InterruptedException {
        MainMenu menu = new MainMenu(this.grid);

        while (true) {
            if (menu.getGameStart()) {
                menu.delete();
                start();
                break;
            }

            if (menu.getQuitGame()) {
                System.exit(0);
            }

            Thread.sleep(100);
        }
    }

    public void start() throws InterruptedException {
        try {
            soundtrack = new Soundtrack();
            soundtrack.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }

        //Grid draws the background and
        this.grid.init();
        this.player = new Player(this.grid);

        this.highScore = new HighScore();

        this.scoreText = new Text(Grid.PADDING + 50, Grid.PADDING + 70 , "Score: " + player.getScore());
        this.scoreText.setColor(Color.LIGHT_GRAY);
        this.scoreText.grow(40, 20);
        scoreText.draw();

        new KeyHandler(this.player);

        int duckMovementCounter = 0;
        int sharkMovementCounter = 0;

        while (this.player.getLives() > 0) {

            Thread.sleep(100);

            if(this.player.getScore() > this.highScore.getHighScore()){
                this.highScore.drawNewHighScore(this.grid);
            }

            duckMovementCounter = ducksMove(duckMovementCounter);

            sharkMovementCounter = sharksMove(sharkMovementCounter);

            rewardsMove();

            this.scoreText.setText("Score: " + this.player.getScore()); // to print the score every cicle
        }

        if(this.player.getScore() > this.highScore.getHighScore()) {
            this.highScore.setNewHighScore(this.player.getScore());
            this.highScore.displayHighScore(this.highScore.getNewHighScoreSymbol());
        }

        gameOver();
    }

    public void gameOver() {
        Picture gameOver = new Picture(grid.columnToX(grid.getCols()) / 2, grid.rowToY(grid.getRows()) / 3, "resources/resources/gameover.png");
        gameOver.draw();
        gameOver.translate(-100, 0);
        gameOver.grow(100, 100);

        if(this.highScore.getNewHighScoreSymbol() != null){
            this.highScore.displayHighScore(this.highScore.getNewHighScoreSymbol());
        } else {
            this.highScore.drawHighestScore(this.grid);
            this.highScore.displayHighScore(this.highScore.getHighestScore());
        }

        this.soundtrack.stop();
        deleteElements();
    }

    /**
     * Deletes all the elements in the canvas
     */
    public void deleteElements() {
        if(this.player != null){
            this.player.delete();
            this.player = null;
        }

        for(int i = 0; i < ducks.size(); i++) {
            ducks.get(i).remove();
        }
        ducks.clear();

        for(int i = 0; i < sharks.size(); i++) {
            sharks.get(i).remove();
        }
        sharks.clear();

        for(int i = 0; i < rewards.size(); i++) {
            rewards.get(i).remove();
        }
        rewards.clear();

        if (this.scoreText != null) {
            this.scoreText.delete();
        }
    }

    /**
     * Iterates through the list of available ducks and moves them
     *
     * @param duckMovementCounter The sum of the movements all the ducks have made so far
     * @return updates de duckMovement counter
     */
    public int ducksMove(int duckMovementCounter) {
        if (ducks.isEmpty() || duckMovementCounter % 50 == 0) { //Generates a new duck if the list is empty or at every 50 global duck movement
            ducks.add(AnimalFactory.getNewDuck(grid));
        }

        Iterator<Duck> duckIterator = ducks.iterator();
        while (duckIterator.hasNext()) {
            Duck duck = duckIterator.next();

            duck.moveRight();
            duckMovementCounter++;

            if (duck.hasReward() && duck.getDuckReward() != null) {
                rewards.add(duck.getDuckReward());
                rewardsMove();
            }

            if (duck.getRightBorder() >= grid.columnToX(grid.getCols())) { //Duck gets deleted at the edge of the screen
                duck.remove();
                duckIterator.remove();
            }


            if (duck.isClicked()) { // If a player clicks a duck, it's score gets updated; duck gets deleted
                this.player.increaseScore();
                duckIterator.remove();
            }
        }

        return duckMovementCounter;
    }

    /**
     * Generates a reward that can give player a new life
     */
    public void rewardsMove() {

        Iterator<DuckReward> rewardIterator = rewards.iterator();
        while (rewardIterator.hasNext()) {
            DuckReward reward = rewardIterator.next();

            reward.getRewardPic().draw();
            reward.moveDown();

            if (reward.getRewardPic().getMaxY() > player.getPicture().getMaxY()) { // Reward is wasted if player doesn't catch it before it touches the sea
                reward.getRewardPic().delete();
                rewardIterator.remove();
            }

            CollisionDetector collectReward = new CollisionDetector(this.player.getPicture(), reward.getRewardPic());

            if (collectReward.hasCollided()) { // Player receives +1 life upon reward catch (up to a maximum of 3 lives)
                reward.getRewardPic().delete();
                rewardIterator.remove();

                if (player.getLives() < 3) {
                    player.incrementLives();// Reward gets removed after player catches it
                }
            }
        }
    }

    /**
     * Iterates through the list of available sharks and moves them
     *
     * @param sharkMovementCounter The sum of the movements all the sharks have made so far
     * @return updates de sharkMovement counter
     */
    public int sharksMove(int sharkMovementCounter) {
        // Adjust shark generation interval over time
        if (sharkMovementCounter % 100 == 0 && sharkGenerationInterval > 5) { // Decrease the interval every 200 cycles
            sharkGenerationInterval--;
        }

        // Generate a new shark if the list is empty or based on the current interval
        if (sharks.isEmpty() || sharkMovementCounter % sharkGenerationInterval == 0) {
            sharks.add(AnimalFactory.getNewShark(grid));
        }

        Iterator<Shark> sharkIterator = sharks.iterator();
        while (sharkIterator.hasNext()) {
            Shark shark = sharkIterator.next();

            shark.moveUp();
            sharkMovementCounter++;

            CollisionDetector collision = new CollisionDetector(this.player.getPicture(), shark.getPicture());

            if (collision.hasCollided()) {
                this.player.decrementLives();
                System.out.println(this.player.getLives());

                shark.remove();
                sharkIterator.remove();

            } else if (shark.getUpperBorder() <= grid.rowToY(grid.getRows()) / 1.53) { // Shark gets deleted if it reaches the horizon line
                shark.remove();
                sharkIterator.remove();
            }
        }

        return sharkMovementCounter;
    }
}
