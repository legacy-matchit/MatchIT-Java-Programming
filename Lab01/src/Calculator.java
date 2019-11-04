import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		System.out.println("Write two number");
		Scanner scan = new Scanner(System.in);
		double nbr1 = scan.nextDouble();
		double nbr2 = scan.nextDouble();

		double sum = nbr1 + nbr2;
		double difference = Math.abs(nbr1 - nbr2);
		double product = nbr1 * nbr2;
		double quota = nbr1 / nbr2;

		System.out.println("The sum of the numbers is " + sum);
		System.out.println("The difference of the numbers is " + difference);
		System.out.println("The product of the numbers is " + product);
		System.out.println("The quota of the numbers is " + quota);

	}
}
