import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.window.Sprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.IllegalFormatCodePointException;

public class Turtle {

	private SimpleWindow w;
	private double x;
	private double y;
	private int direction;
	private boolean isPenDown;
	private Sprite sprite;
	/** Skapar en sköldpadda som ritar i ritfönstret w. Från början 
	    befinner sig sköldpaddan i punkten x, y med pennan lyft och 
	    huvudet pekande rakt uppåt i fönstret (i negativ y-riktning). */
	public Turtle(SimpleWindow w, int x, int y) {

		sprite = new Sprite(new File("resources/turtle.png").getAbsolutePath(),10,10);
		w.addSprite(sprite);
		this.x = x;
		this.y = y;
		this.w = w;
		turnNorth();
		penUp();
	}

	/** Sänker pennan. */
	public void penDown() {
		isPenDown = true;
	}
	
	/** Lyfter pennan. */
	public void penUp() {
		isPenDown = false;
	}
	
	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		if(isPenDown){
			sprite.moveTo((int)Math.round(x),(int)Math.round(y)-5);
			w.moveTo((int)Math.round(x),(int)Math.round(y));
			x = x + n * Math.cos(Math.toRadians(direction));
			y = y - n * Math.sin(Math.toRadians(direction));
			w.lineTo((int)Math.round(x),(int)Math.round(y));
		}
	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		direction += beta;
		sprite.rotate(direction);
	}

	/** Går till punkten newX, newY utan att rita. Pennans läge (sänkt
	    eller lyft) och huvudets riktning påverkas inte. */
	public void jumpTo(int newX, int newY) {
		x = newX;
		y = newY;
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		direction = 90;
		sprite.rotate(direction);
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int)Math.round(x);
	}

 	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int)Math.round(y);
	}
  
	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
 	public int getDirection() {
 		return direction;
	}

	private Image image(String filePath, int width, int height){
		File imgFile = new File(filePath);
		Image img;
		try {
			img = ImageIO.read(imgFile);
			img = img.getScaledInstance(width, height, 0);
		} catch (IOException e) {
			throw new Error(e);
		}
		return img;
	}
}
