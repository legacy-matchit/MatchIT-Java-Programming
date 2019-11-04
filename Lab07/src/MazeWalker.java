import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;


public class MazeWalker implements Result {

    /** attributes for MazeWalker Class **/
    private Turtle turtle;
    private int turnCount; //for total turning count
    private int stepCount; //for total steps count
    private int delay; // for delay

    /** constructor for MazeWalker Class @parameter Turtle only**/
    public MazeWalker(Turtle turtle){
        this(turtle,10);
    }

    /** constructor for MazeWalker Class @parameter Turtle and int **/
    public MazeWalker(Turtle turtle, int delay){
        this.turtle = turtle;
        this.delay = delay;
        turnCount = 0;
        stepCount = 0;
    }



    public void walk(Maze maze){

        //ready for draw line
        turtle.penDown();

        /** Repeat while the turtle will not reach the exit **/
        while (!maze.atExit(turtle.getX(),turtle.getY())){

            turtle.forward(1); // one step forward
            stepCount++; // count step
            SimpleWindow.delay(delay);

            /** If there is no wall on the left side, change direction to the left. **/
            if(!maze.wallAtLeft(turtle.getDirection(),turtle.getX(),turtle.getY())){
                turtle.left(90); //change direction left
                turnCount++;
            }
            /** Turn to the right when there is a wall in front **/
            else if(maze.wallInFront(turtle.getDirection(),turtle.getX(),turtle.getY())){
                turtle.left(-90); //change direction right
                turnCount++;
            }
        }

    }

    /**
     * @return  the number of turns
     */
    private int getTurnCount() {
        return turnCount;
    }

    /**
     * @return the total number of steps moved
     */
    private int getStepCount(){
        return stepCount;
    }


    @Override
    public String getResult() {
        return "Total Steps:" + getStepCount() + " " + "Total Turns:" + getTurnCount();
    }
}
