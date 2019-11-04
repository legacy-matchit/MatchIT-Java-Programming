import se.lth.cs.pt.window.Sprite;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class RaceTurtle extends Turtle {

    private int nbr;

    public RaceTurtle(RaceWindow w, int nbr,int x, int y){
        super(w,x,y);
        this.nbr = nbr;
    }

    public void raceStep(){
        Random r = new Random();
        int step = r.nextInt(6) + 1;
        forward(step);
    }

    public String toString(){
        return "Number [" + nbr + "] Turtle";
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Turtle)){
            return false;
        }
        RaceTurtle t = (RaceTurtle)obj;
        return this.nbr == t.nbr;
    }

}
