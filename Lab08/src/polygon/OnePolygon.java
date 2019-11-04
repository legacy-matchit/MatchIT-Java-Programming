package polygon;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import se.lth.cs.pt.window.SimpleWindow;

public class OnePolygon {

	public static void main(String[] args) {

		System.out.println("Input file name : ");
		Scanner s = new Scanner(System.in);
		String filename = s.nextLine();

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("src/" + filename));
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find "+filename);
			System.exit(0);
		}

//		Scanner scanner = new Scanner(path);

		Polygon pol = new Polygon();

		while (scanner.hasNextInt()) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			pol.addVertex(x, y);
		}

		SimpleWindow w = new SimpleWindow(600, 600, "A polygon");

		pol.draw(w);
	}

}

