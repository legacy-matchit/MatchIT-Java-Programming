import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class ClickWithDrawingSquare {

    public static void main(String[] args){

        SimpleWindow w = new SimpleWindow(600, 600, "ClickWithDrawingSquare");

        Square sq;

        int x = 0;
        int y = 0;

        while (true) {

            w.waitForMouseClick();

            x = w.getMouseX();
            y = w.getMouseY();

            w.clear();

            sq = new Square(x,y,100);
            sq.draw(w);
        }
    }
}
