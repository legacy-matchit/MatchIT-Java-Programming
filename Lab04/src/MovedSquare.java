import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

import java.awt.*;

public class MovedSquare {

    public static void main(String[] args) {

        //Fields
        int startX, startY, endX, endY, intervalX, intervalY;

        //create SimpleWindow's instance with size 1500 * 600
        SimpleWindow w = new SimpleWindow(1500, 600, "MovedSquare");

        w.setLineColor(Color.RED);

        //wait for mouse click event
        w.waitForMouseClick();

        //set start point x and y
        startX = w.getMouseX();
        startY = w.getMouseY();

        Square sq; //= new Square(startX,startY,100);


        while (true) {

            //set Square's instance with start point x and y
            sq = new Square(startX,startY,100);

            w.waitForMouseClick();

            //set end point x and y
            endX = w.getMouseX();
            endY = w.getMouseY();

            //interval
            intervalX = (endX - startX) / 10;
            intervalY = (endY - startY) / 10;


            for(int i = 0; i < 10; i++){
                sq.move(intervalX,intervalY);//move point
                sq.draw(w);//draw square
            }

            //change ended point to start point
            startX = endX;
            startY = endY;

        }

    }


//    public static void main(String[] args) {
//
//        //Fields
//        int startX =0, startY=0, endX=0, endY=0, intervaX=0, intervalY=0;
//        boolean firstClicked = true;
//
//        //create SimpleWindow's instance with size 1500 * 600
//        SimpleWindow w = new SimpleWindow(1500, 600, "MovedSquare");
//
//        w.setLineColor(Color.RED);
//
//        Square sq;
//
//
//        while (true) {
//
//            w.waitForMouseClick();
//
//            if(firstClicked){
//                firstClicked = false;
//
//                //set start point x and y
//                startX = w.getMouseX();
//                startY = w.getMouseY();
//
//            }else{
//
//                //set end point x and y
//                endX = w.getMouseX();
//                endY = w.getMouseY();
//
//                //set Square's instance with start point x and y
//                sq = new Square(startX,startY,100);
//
//
//                //interval
//                intervaX = (endX - startX) / 10;
//                intervalY = (endY - startY) / 10;
//
//
//                for(int i = 0; i < 10; i++){
//                    sq.move(intervaX,intervalY);//move point
//                    sq.draw(w);//draw square
//                }
//
//                //change ended point to start point
//                startX = endX;
//                startY = endY;
//            }
//
//        }
//
//    }

}


