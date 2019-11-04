import se.lth.cs.pt.window.SimpleWindow;

public class LineDrawing {
	public static void main(String[] args) {

		SimpleWindow w = new SimpleWindow(500, 500, "LineDrawing");
		w.moveTo(0, 0);



		while (true) {
			// vänta tills användaren klickar på en musknapp
			w.waitForMouseClick();
			// rita en linje till den punkt där användaren klickade
			int mouseX = w.getMouseX();
			int mouseY = w.getMouseY();

			//draw line
			w.lineTo(mouseX,mouseY);
		}

	}
}
