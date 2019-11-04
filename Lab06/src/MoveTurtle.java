import se.lth.cs.pt.window.SimpleWindow;
import java.util.Random;
public class MoveTurtle {

    public static int getRandom(int range, int side){
        Random rand = new Random();
        return rand.nextInt(range)+side + 1;
    }
    public static void main(String[] args){

        SimpleWindow w = new SimpleWindow(600,600,"MoveTurtle");
        Turtle turtle = new Turtle(w,w.getWidth()/2,w.getHeight()/2);
        turtle.penDown();
        for(int i = 0; i < 1000; ++i){
            int step = getRandom(10,0);
            int angle = getRandom(360,-180);
            System.out.printf("%d : %d\n",step,angle);
            turtle.forward(step);
            turtle.left(angle);
        }
    }

}
