package com.codeforall.online.damngame.player;

import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class FullHeartState extends HeartState {

    public FullHeartState(Player player) {
        super(player);
    }

    @Override
    public void drawHearts() {
        this.hearts.delete();
        this.hearts = new Picture(Grid.PADDING, Grid.PADDING, Grid.RESOURCE + "resources/full-hearts.png");
        this.hearts.draw();
    }

    @Override
    public void gainLife() { // No transition, already in the full hearts state
    }

    @Override
    public void loseLife() {
        this.hearts.delete();
        player.setHeartState(new TwoHeartState(player));
        player.getHeartState().drawHearts();
    }
}