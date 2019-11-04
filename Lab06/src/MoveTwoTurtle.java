import se.lth.cs.pt.window.SimpleWindow;

import javax.swing.plaf.IconUIResource;
import java.util.Random;

public class MoveTwoTurtle {

    public static int getRandom(int range, int side){
        Random rand = new Random();
        return rand.nextInt(range)+side + 1;
    }

    public static int getDistance(int x, int y, int x1, int y1){
        double distance = Math.pow(Math.abs(x-x1),2) + Math.pow(Math.abs(y-y1),2);
        System.out.println((int)Math.sqrt(distance));
        return (int)distance;
    }
    public static void main(String[] args){

        SimpleWindow w = new SimpleWindow(600,600,"MoveTwoTurtle");

        Turtle turtle1 = new Turtle(w,250,250);
        Turtle turtle2 = new Turtle(w,350,350);

        turtle1.penDown();
        turtle2.penDown();

        while(getDistance(turtle1.getX(),turtle1.getY(),turtle2.getX(),turtle2.getY()) >= 2500){

            int stepForTurtle1 = getRandom(10,0);
            int angleForTurtle1 = getRandom(360,-180);
            int stepForTurtle2 = getRandom(10,0);
            int angleForTurtle2 = getRandom(360,-180);

            turtle1.forward(stepForTurtle1);
            turtle1.left(angleForTurtle1);

            turtle2.forward(stepForTurtle2);
            turtle2.left(angleForTurtle2);

            SimpleWindow.delay(1);

        }
    }
}
