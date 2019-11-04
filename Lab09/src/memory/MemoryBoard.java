package memory;


import java.util.Random;

public class MemoryBoard {

	private MemoryCardImage[][] memoryCardImages;
	private boolean isFronted[][];
	private int size;


	/** Skapar ett memorybräde med size * size kort. backFileName är filnamnet
	    för filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen 
	    för frontbilderna.
	 ** Creates a memory board with size * size cards. backFileName is the file name of the
	 file with the back image. The frontFileNames vector contains the file names for the
	 front images. */
	public MemoryBoard(int size,String[] frontFileNames, String backFileName) {
		this.size = size;
		memoryCardImages = new MemoryCardImage[size][size];
		isFronted = new boolean[size][size];
		createCards(frontFileNames,backFileName);
	}


	/** Skapar size * size / 2 st memorykortbilder.
	   Placerar ut varje kort på två slumpmässiga ställen på spelplanen.
	 ** Creates size * size / 2 memory card images.
	 Places each card in two random places on the playing field. */
	private void createCards(String[] frontFileNames, String backFileName) {

		/** [0][1][2][3]
		 *  [4][5][6][7]
		 *  ------------- copy
		 *  [0][1][2][3]
		 *  [4][5][6][7] **/
		for(int i = 0; i < size/2; i++){
			for(int j = 0; j < size; j++){
				MemoryCardImage cardImage = new MemoryCardImage(frontFileNames[i*size+j], backFileName);
				memoryCardImages[i][j] = cardImage;
				memoryCardImages[i+2][j] = cardImage;
				isFronted[i][j] = false;
				isFronted[i+2][j] = false;
			}
		}
		shuffle(memoryCardImages);
	}

	private void shuffle(MemoryCardImage[][] cards){

		/** Fisher–Yates algorithm **/
		Random r = new Random();
		for(int i = cards.length-1; i > 0; i--){
			for(int j = cards[i].length-1; j > 0; j--){

			    /** range will be [0-4], [0-3], [0-2], [0-1] **/
				int rRandom = r.nextInt(i+1);
				int cRandom = r.nextInt(j+1);

				/** swap **/
				MemoryCardImage temp =  cards[i][j];
				cards[i][j] = cards[rRandom][cRandom];
				cards[rRandom][cRandom] = temp;
			}
		}
	}

	/** Tar reda på brädets storlek.
	 ** Finds out the size of the board */
	public int getSize() {
		return size;
	}
	
	/** Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c.
	    Raderna och kolonnerna numreras från 0 och uppåt.
	 **Retrieves the two-sided image of the card on row r, column c.
	 The rows and columns are numbered from 0 upwards */
	public MemoryCardImage getCard(int r, int c) {
		return memoryCardImages[r][c];
	}

	/** Vänder kortet på rad r, kolonn c.
	 ** Turns the card on row r, column c. */
	public void turnCard(int r, int c) {
		isFronted[r][c] = !isFronted[r][c];
	}
	
	/** Returnerar true om kortet r, c har framsidan upp.
	 ** Returns true if card r, c has face up. */
	public boolean frontUp(int r, int c) {
		return isFronted[r][c];
	}
	
	/** Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2, 
	    kolonn c2.
	 ** Returns true if it is the same card on line r1, column c2 as on line r2, column c2. */
	public boolean same(int r1, int c1, int r2, int c2) {
		return getCard(r1,c1).equals(getCard(r2,c2));
	}

	/** Returnerar true om alla kort har framsidan upp.
	 ** Returns true if all cards face up. */
	public boolean hasWon() {
		for(int r = 0; r < size; r++){
			for(int c = 0; c < size; c++){
				if(!isFronted[r][c]){
					return false;
				}
			}
		}
		return true;
	}

}
