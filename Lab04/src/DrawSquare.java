import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class DrawSquare {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "DrawSquare");
		Square sq = new Square(250, 250, 100);
		sq.draw(w);

		Square sq1 = new Square(100,100,100);
		Square sq2 = new Square(100,100,100);
		System.out.println(sq1==sq2);
		sq1 = sq2;
		System.out.println(sq1==sq2);

		String x = "Yes";
		String y = "Yes";
		System.out.println(x==y);
		System.out.println("Result:" + (sq1 == sq2));
	}
}
