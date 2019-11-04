import java.util.ArrayList;

public class TurtleRace{

    /** return true when turtle's X position grater than END POSITION **/
    public static boolean isRaceFinished(RaceTurtle t){
        return t.getX() > RaceWindow.X_END_POS;
    }

    public static void main(String[] args){

        ArrayList<RaceTurtle> turtles = new ArrayList<RaceTurtle>();
        ArrayList<RaceTurtle> arrivedTurtles = new ArrayList<RaceTurtle>();

        RaceWindow w = new RaceWindow();
        TurtleRace race = new TurtleRace();


        /** create 8 Turtles in ArrayList **/
        for(int nbr = 1; nbr <= 8; nbr++ ){
            RaceTurtle t = new RaceTurtle(w, nbr, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
            t.penDown();
            t.left(-90);
            turtles.add(t);
        }


        /** Race start until every turtle arrive end line **/
        while(!(arrivedTurtles.size() == 8)) {

            for(RaceTurtle t : turtles){

                t.raceStep();// race

                if(isRaceFinished(t)){ // check turtle's X position if it is in finish or not

                    /** if turtle has not added, then add  **/
                    if(!arrivedTurtles.contains(t)){
                        arrivedTurtles.add(t);
                        t.penUp();
                    }

                }
                RaceWindow.delay(10);
            }

        }

        int index = 0;

        for (RaceTurtle t: arrivedTurtles) {// print out
            System.out.println("På plats " + ++index + " : " + t);
            if(index == 3){
                break;
            }
        }

    }
}
