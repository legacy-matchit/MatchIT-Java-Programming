import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){


        /** input from user **/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which map do you want to choose?? input [1-6] : ");
        int nbr = scanner.nextInt();
        int delay = 10;

        /** if out of range 1-6 ask again **/
        while (nbr < 1 || nbr > 6){
            System.out.println("You have to input range [1-6] : ");
            nbr = scanner.nextInt();// input
        }

        /** when it chosen 5 or 6 it can change delay time **/
        if(nbr >= 5){
            System.out.println("You can see the turtle find its way faster if change delay time. Do you want to change?? [1...Y/...Other Default 10]");
            if(scanner.nextInt() == 1){ // if yes
                System.out.println("input [ 1 ]");
                delay = scanner.nextInt(); // input
            }
        }

        /** Create Instance as SimpleWindow, Maze, Turtle MazeWalker Classes **/
        SimpleWindow w = new SimpleWindow(600,600,"MazeWalker");

        Maze maze = new Maze(nbr);

        Turtle turtle = new Turtle(w,maze.getXEntry(),maze.getYEntry());

        MazeWalker mazeWalker = new MazeWalker(turtle,delay);

        /** Draw maze **/
        maze.draw(w);

        /** Walk in maze **/
        mazeWalker.walk(maze);

        /** Report Result **/
        w.moveTo(30,500);
        w.writeText("Finish" + mazeWalker.getResult());
    }
}
