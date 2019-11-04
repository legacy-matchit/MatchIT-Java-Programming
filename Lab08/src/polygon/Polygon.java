package polygon;

import se.lth.cs.pt.window.SimpleWindow;

import java.util.ArrayList;

public class Polygon {

    Point[] point; // array which has Point type object
    int index; // int for tracking the size of the array

    /** constructor **/
    public Polygon(){
        point = new Point[99999];
        int index = 0;
    }

    /** add x,y in array which this class's point[] **/
    public void addVertex(int x, int y){
        Point p = new Point(x,y);
        point[index] = p; //add x,y as p in array at current index
        index++; //Increment index by 1
    }

    /** draw polygon **/
    public void draw(SimpleWindow w){

        /**Draw out points in array**/
        for(int i = 0; i < index; i++){

            Point p = point[i]; // 배열안에있는 포인트 객체를 참조

            if(i > 0){
                w.lineTo(p.getX(),p.getY()); //the point where the line will be drawn
            }else {
                w.moveTo(p.getX(),p.getY()); //first Point
            }


            System.out.println(p);
        }

        // draw last line
        Point p = point[0];
        w.lineTo(p.getX(),p.getY());
    }
}
