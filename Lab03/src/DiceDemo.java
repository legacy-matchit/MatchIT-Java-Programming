import java.util.Arrays;
import java.util.Scanner;

public class DiceDemo {

    public static void main(String[] args){

        /**
         *
         */

        Scanner scan = new Scanner(System.in);

        System.out.println("How many times do you roll the dice:");
        int totalPlayCount = scan.nextInt();//input data from user how many time user want to play

        System.out.println("Enter your expecting number[1-6]:");
        int expectingNumber = scan.nextInt();//input data from user what number use expect

        //call rollWithTotalPlayCount
        int [] result = Dice.rollWithTotalPlayCount(totalPlayCount);

        System.out.println("\n\nThe number " + expectingNumber +
                " you expected came " + result[expectingNumber-1] + " times" +
                "and probability : " + Dice.getExpectingNumberProbabillty(expectingNumber,totalPlayCount) + "%\n");

        System.out.println("One is " + result[0] + " times.\n");
        System.out.println("Two is " + result[1] + " times.\n");
        System.out.println("Three is " + result[2]  + " times.\n");
        System.out.println("Four is " + result[3]  + " times.\n");
        System.out.println("Five is " + result[4]  + " times.\n");
        System.out.println("Six is " +result[5]  + " times.\n" );

        System.out.println(Arrays.toString(result));
    }

}
