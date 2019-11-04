import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class TestMoveSquare {
    public static void main(String[] args){

        int startPositionX=0,endPositionX=0,startPositionY=0,endPositionY=0,x=0,y=0;

        SimpleWindow w = new SimpleWindow(1000,600,"TEST");

        w.waitForMouseClick();
        startPositionX = w.getMouseX();
        startPositionY = w.getMouseY();




        while (true){

            w.waitForMouseClick();
            endPositionX = w.getMouseX();
            endPositionY = w.getMouseY();

            Square sq = new Square(startPositionX,startPositionY,100);

            x = (endPositionX - startPositionX) / 10;
            y = (endPositionY - startPositionY) / 10;


            for(int i = 0; i < 10; i++){
                sq.erase(w);
                sq.move(x,y);
                sq.draw(w);
                w.delay(100);

            }

            startPositionX = endPositionX;
            startPositionY = endPositionY;
        }
    }
}
