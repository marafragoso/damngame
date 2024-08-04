package com.codeforall.online.damngame.animals.ducks;

import com.codeforall.online.damngame.animals.Animal;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Duck extends Animal{
    private DuckReward duckReward;

    public Duck(Picture picture) {
        super(picture);
    }

    public boolean hasReward() {
         return Math.random() < 0.25;
    }

    public void setDuckReward(DuckReward duckReward){
        this.duckReward = duckReward;
    }

    public DuckReward getDuckReward(){
        return this.duckReward;
    }
}
