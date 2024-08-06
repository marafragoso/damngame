package com.codeforall.online.damngame.animals.ducks;

import com.codeforall.online.damngame.animals.Animation;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DuckReward implements Animation {
    private Picture reward;

    public DuckReward(int x, int y) {
        this.reward = new Picture(x,y,"resources/resources/Bird/reward.png");
    }

    @Override
    public void moveRight() {
    }

    @Override
    public void moveLeft() {
    }

    @Override
    public void moveUp() {
    }

    @Override
    public void moveDown() {
        this.reward.translate(0,10);
    }

    public Picture getRewardPic() {
        return this.reward;
    }

    public void remove() {
        this.getRewardPic().delete();
    }
}
