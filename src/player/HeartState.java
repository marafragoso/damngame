package com.codeforall.online.damngame.player;


import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Implementing the State DP, encapsulating the change in the state of the player's lives
 */

public abstract class HeartState {
    protected Player player;
    protected Picture hearts;

    public HeartState(Player player) {
        this.player = player;
        this.hearts = new Picture(Grid.PADDING, Grid.PADDING, Grid.RESOURCE + "resources/full-hearts.png");
    }

    public abstract void drawHearts();

    public abstract void gainLife();

    public abstract void loseLife();

    public void delete() {
        this.hearts.delete();
    }
}
