
public class ArrayStatistics {


	/**
	 *  when i is 6; a[6] is -2.1 it returns 6
	 *  temp[6] is -2.1 this is when was the temperature minus
	 *  we don't need to check else statement because it returns -1
	 */
	public static int indexfirstNegative(double[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 *The point is to initialize the Min variable to the highest value to find the minimum value,
	 *compare the Min value with the listed value, and save the value smaller than the Min value back in Min.
	 *
	 * minVal = 1.7976931348623157E308
	 * 	1st is 0.8 < minVal. it is true so minVal changes 0.8
	 * 	2nd is 0.3 < minVal. it is true so minVal changes 0.3
	 * 	3rd is 0.9 < minVal. it is false so minVal won’t changes 0.3
	 * 	4th is 2.4 < minVal. itis false so minVal won’t changes 0.3
	 * 	...
	 * 	when i is 8; a[8] is -3.5 minVal changes -3.5
	 * 	so until finish the loop minVal is -3.5 and return minVal
	 *
	 */
	public static double min(double[] a) {
		double minVal = Double.MAX_VALUE; // deleted - mark  or //double minVal = a[0]
		for (int i = 0; i < a.length; i++) {
			if (a[i] < minVal) {
				minVal = a[i];
			}
		}
		return minVal;
	}
	
	/**
	 * The point is to initialize the Max variable to the lowest value to find the maximum value,
	 * compare the Max value with the listed value, and save the value larger than the Max value back in Max.
	 *
	 *  maxVal = -1.7976931348623157E308
	 * 	1st is 0.8 > maxVal(-1.7976931348623157E308) it is true so maxVal changes 0.8
	 * 	2nd is 0.3 > maxVal(0.8) it is false so maxVal doesen’t change 0.8
	 * 	3rd is 0.9 > maxVal(0.8) it is true so maxVal changes 0.9
	 * 	4th is 2.4 > maxVal(0.9) it is true so maxVal changes 2.4
	 * 	....
	 * 	when i is 26 which means a[26] is 7.4 maxVal changes 7.4
	 * 	so until finish the loop maxVal is 7.4 and return maxVal
	 */
	public static double max(double[] a) {
		double maxVal = Double.MIN_VALUE; // or double maxVal = a[0]
		for (int i = 0; i < a.length; i++) { // chagend operator == to <
			if (a[i] > maxVal) {
				maxVal = a[i];
			}
		}
		return maxVal;
	}
	
	/**
	 *
	 *	changed int i = 1 >> int i = 0
	 *  changed sum += i >> sum += a[i]
	 *
	 *  When it start i = 1 the result skip first value 0.8
	 *  and sum += i is 1+2+3+4+5+....27
	 */
	public static double avg(double[] a) {
		double sum = 0;
		for (int i = 0; i < a.length; i++) { // changed i value 1 to 0
			sum += a[i]; // changed i to a[i]
		}
		return sum / a.length;
	}

}
