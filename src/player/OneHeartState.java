package com.codeforall.online.damngame.player;

import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class OneHeartState extends HeartState {

    public OneHeartState(Player player) {
        super(player);
    }

    @Override
    public void drawHearts() {
        this.hearts.delete();
        this.hearts = new Picture(Grid.PADDING, Grid.PADDING, Grid.RESOURCE + "resources/1 heart.png");
        this.hearts.draw();
    }

    @Override
    public void gainLife() {
        this.hearts.delete();
        player.setHeartState(new TwoHeartState(player));
        player.getHeartState().drawHearts();
    }

    @Override
    public void loseLife() {
        this.hearts.delete();
        player.setHeartState(new NoHeartState(player));
        player.getHeartState().drawHearts();
    }
}

