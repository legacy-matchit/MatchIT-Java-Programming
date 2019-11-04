package memory;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MemoryCardImage {

	private Image back;
	private Image front;

	/** Skapar en tvåsidig bild av ett memorykort. Bilden på framsidan finns i
	    filen med namnet frontFileName och bilden på baksidan i filen med namnet 
	    backFileName.
	 ** Creates a two-sided image of a memory card. The image
	 on the front page is in the file named frontFileName and
	 the image on the back of the file named backFileName. */
	public MemoryCardImage(String frontFileName, String backFileName) {
		front = readImage(frontFileName);
		back = readImage(backFileName);
	}

	/** Returnerar bilden på framsidan.
	 ** Returns the image on the front. */
	public Image getFront() {
		return front;
	}
	
	/** Returnerar bilden på baksidan.
	 ** Returns the image on the back */
	public Image getBack() {
		return back;
	}

	private Image readImage(String fileName) {
		fileName = "src/"+fileName;
		Image img = null;
		try {
			File pathToFile = new File(fileName);
			img = ImageIO.read(pathToFile);
		} catch (IOException ex) {
			System.err.println("Failed to create image of MemoryCardImage (" + fileName + ")");
			ex.printStackTrace();
		}
		return img;
	}
	
}
