package com.codeforall.online.damngame.animals.ducks;

import com.codeforall.online.damngame.animals.Animal;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Duck extends Animal{
    private DuckReward duckReward;
    private boolean reward;

    public Duck(Picture picture) {
        super(picture);
    }

    public boolean hasReward() {
         if(Math.random() < 0.2) {
             this.reward = true;
             return true;
         };
         return false;
    }

    public void setDuckReward(DuckReward duckReward){
        this.duckReward = duckReward;
    }

    public DuckReward getDuckReward(){
        return this.duckReward;
    }
}
