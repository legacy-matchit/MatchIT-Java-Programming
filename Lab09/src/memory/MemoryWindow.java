package memory;

import java.awt.Image;

import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.window.Sprite;

import javax.swing.*;

public class MemoryWindow extends SimpleWindow {
	private int imgSize;
	private MemoryBoard board;

	/** Skapar ett fönster som kan visa memorybrädet board.
	 ** Creates a window that can display the memory board
	 */
	public MemoryWindow(MemoryBoard board) {
		super(604, 604, "Memory");
		this.board = board;
		imgSize = 600 / board.getSize();
	}

	/** Ritar brädet med alla kort. Raderna och kolonnerna numreras från 0 och uppåt.
	 ** Draws the board with all cards. The rows and columns are numbered from 0 upwards */
	public void drawBoard() {
		for (int r = 0; r < board.getSize(); r++) {
			for (int c = 0; c < board.getSize(); c++) {
				drawCard(r, c);
			}
		}
	}

	/** Ritar kortet på rad r, kolonn c.
	 ** Draws the card in row r, column c */
	public void drawCard(int r, int c) {
		int x0 = c * imgSize + 2;
		int y0 = r * imgSize + 2;
		moveTo(x0, y0);
		MemoryCardImage card = board.getCard(r, c);
		if (board.frontUp(r, c)) {
			drawImage(card.getFront().getScaledInstance(imgSize, imgSize, Image.SCALE_SMOOTH));
		} else {
			drawImage(card.getBack().getScaledInstance(imgSize, imgSize, Image.SCALE_SMOOTH));
		}
		moveTo(x0, y0);
		lineTo(x0 + imgSize, y0);
		lineTo(x0 + imgSize, y0 + imgSize);
		lineTo(x0, y0 + imgSize);
		lineTo(x0, y0);
	}

	/** Tar reda på raden för senaste musklick.
	 ** Finds out the line for latest mouse clicks */
	public int getMouseRow() {
		return getMouseY() / imgSize;
	}

	/** Tar reda på kolonnen för senaste musklick.
	 ** Finds the column for the last mouse click */
	public int getMouseCol() {
		return getMouseX() / imgSize;
	}

}
