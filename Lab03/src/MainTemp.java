import java.util.*;

public class MainTemp {

	public static void main(String[] args) {

		double [] temp = {0.8, 0.3, 0.9, 2.4, 2.0, 0.8, -2.1, -2.6, -3.5, -0.6,
				-0.4, -0.9, -2.9, -2.4, -0.6, 2.0, 3.6, 2.9, 4.5, 5.7,
				6.2, 5.7, 3.3, 0.4, -0.7, 5.3, 7.4, 5.5};

		System.out.println("Number of days: " + temp.length);
		System.out.println("Daily temperature of the first day of the month: " + temp[0]);
		System.out.println("Daily temperature of the last day of the month: " + temp[temp.length - 1]);
		System.out.println("Mean: " +  ArrayStatistics.avg(temp));
		System.out.println("Lowest daily temperature: " + ArrayStatistics.min(temp));
		System.out.println("Maximum daily temperature:" + ArrayStatistics.max(temp));
		System.out.println("Date of first day temperature below 0 degrees: " +
				(ArrayStatistics.indexfirstNegative(temp) + 1));



		Scanner scan = new Scanner(System.in);

		System.out.println("How many times do you roll the dice:");
		int totalPlayCount = scan.nextInt();//input data from user how many time user want to play

		System.out.println("Enter your expecting number[1-6]:");
		int expectingNumber = scan.nextInt();//input data from user what number use expect

		//call newRollWithTotalPlayCount
		Map resultMap = Dice.newRollWithTotalPlayCount(totalPlayCount);
		System.out.println("The number " + expectingNumber + " you expected came " + resultMap.get(expectingNumber) + " times." +
				"and probability : " + Dice.getExpectingNumberProbabillty(expectingNumber,totalPlayCount) + "%\n");
		System.out.println("One is " + resultMap.get(1) + " times.\n");
		System.out.println("Two is " + resultMap.get(2) + " times.\n");
		System.out.println("Three is " + resultMap.get(3) + " times.\n");
		System.out.println("Four is " + resultMap.get(4) + " times.\n");
		System.out.println("Five is " +resultMap.get(5) + " times.\n");
		System.out.println("Six is " +resultMap.get(6) + " times.\n" );
		//look inside result
		System.out.println(resultMap);


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
//		//look inside result
//		for(int i=0; i<result.length; i++){
//			System.out.println(result[i]);
//		}

	}
	
}
