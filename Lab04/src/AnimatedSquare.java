import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class AnimatedSquare {

    public static void main(String[] args) {


        //Fields
        int startX, startY, endX, endY, invervalX, intervalY;

        //create SimpleWindow's instance with size 1500 * 600
        SimpleWindow w = new SimpleWindow(1000, 600, "AnimatedSquare");


        //wait for mouse click event
        w.waitForMouseClick();

        //set start point x and y
        startX = w.getMouseX();
        startY = w.getMouseY();

        Square sq; //= new Square(startX,startY,100);
        //sq.draw(w);

        while (true) {

            //set Square's instance with start point x and y
            sq = new Square(startX,startY,100);

            w.waitForMouseClick();

            w.clear();

            //set end point x and y
            endX = w.getMouseX();
            endY = w.getMouseY();

            //interval
            invervalX = (endX - startX) / 10;
            intervalY = (endY - startY) / 10;



            for(int i = 0; i < 10; i++){
                sq.erase(w); // erase previous square
                sq.move(invervalX,intervalY);//move point
                sq.draw(w);//draw square
                w.delay(100);//stop thread 0.1 second
            }

            //change ended point to start point
            startX = endX;
            startY = endY;

        }
    }

}