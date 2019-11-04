package memory;

import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.window.Sprite;

import javax.sql.rowset.spi.SyncProvider;
import javax.swing.*;

public class MemoryGame {

	private int point;
	private MemoryBoard board;
	private MemoryWindow window;

	/** constructor**/
	public MemoryGame(){
		point = 100;
	}

	/** getter for count **/
	public int getCount(){
		return point;
	}

	/** **/
	public void flipCard(int r, int c){
		board.turnCard(r,c);
		window.drawCard(r,c);
	}

	public void showDialog(){
		//when finish game
		String[] options = {"Try Again", "Close"};
		int x = JOptionPane.showOptionDialog(null, "Your result is " + getCount(),
				"Game Over",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		window.close();
		if(x == 0){
			start();
		}
	}

	public void start(){

		String backFilename = "back.jpg";
		String[] frontFileNames = {"can.jpg", "flopsy_mopsy_cottontail.jpg",
				"friends.jpg", "mother_ladybird.jpg", "mr_mcgregor.jpg",
				"mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };

		//MemoryBoard's instance
		board = new MemoryBoard(4,frontFileNames, backFilename);
		//MemoryWindow's instance
		window = new MemoryWindow(board);
		window.drawBoard(); // draw board  and cards

		/** repeat until memoryBoard.hasWon() returns true **/
		while (!board.hasWon()) {

			/** first click **/
			window.waitForMouseClick();
			int r1 = window.getMouseRow();
			int c1 = window.getMouseCol();
			point--;

			/** if card is not front flip
			 *  첫번째로 클릭한 카드가 뒤집혀 있는 것만 가능 */
			if(!board.frontUp(r1,c1)){
				flipCard(r1,c1);

				/** second click and compare if it is same or not
				 *  첫번째 카드가 앞인 상황에서 반복 (체크했을때 다르면 둘다 뒤집기때문에 while문을 빠져서 첫번째 클릭으로 다시시작함) **/
				while (board.frontUp(r1,c1)){

					/** 두번째 카드를 체크한다. **/
					window.waitForMouseClick();
					int r2 = window.getMouseRow();
					int c2 = window.getMouseCol();
					point--;

					/** if it is not same place
					 *  똑같은 열과행이 아니면 **/
					if(r1 != r2 || c1 != c2){


						/** 두번째 클릭한 카드도 뒤집혀 있은 것만 체크 **/
						if(!board.frontUp(r2,c2)){

							flipCard(r2,c2);

							/** 카드 체크 **/
							if(!board.same(r1,c1,r2,c2)){

								/** 둘다 뒤집히면서 루프를 빠져나간다 **/
								SimpleWindow.delay(500);
								flipCard(r1,c1);//
								flipCard(r2,c2);//
							/** same */
							}else{
								break;
							}
						}
					}
				}
			}




		}

		showDialog();
	}

	public static void main(String[] args) {
		//MemoryGame's instance
		MemoryGame game = new MemoryGame();
		game.start();
	}
}
