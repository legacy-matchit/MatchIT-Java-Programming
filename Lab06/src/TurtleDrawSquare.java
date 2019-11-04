import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.maze.*;
public class TurtleDrawSquare {
 	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleDrawSquare");
		Turtle t = new Turtle(w, 300, 300);
		t.penDown();

//		Maze m = new Maze("../Lab06/resources/turtle.png",0,0);
//		m.draw(w);
		for (int i = 0; i < 4; i++) {
			t.forward(100);
			t.left(90);
		}

	}
}
