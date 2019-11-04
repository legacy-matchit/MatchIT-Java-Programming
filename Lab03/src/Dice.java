import java.util.*;

public class Dice {

    /**
     * It is return int value randomly between 1 and 6
     * @return int
     */
    public static int getRandom(){
        Random rand = new Random();
        return rand.nextInt(6) + 1; //
    }

    /**
     * index number will be random dice number
     * values will be count number
     * @param totalPlaycount
     * @return int[]
     */
    public static int[] rollWithTotalPlayCount(int totalPlaycount){
        int [] x = new int[6];
        for(int i = 0; i < totalPlaycount; i++) {
            int result = Dice.getRandom();
            x[result-1]++;
        }
        return x;
    }

    /**
     * It is  probabillty which your expecting number of dice
     * @param expectingNumber
     * @param totalPlaycount
     * @return double
     */
    public static double getExpectingNumberProbabillty(int expectingNumber, int totalPlaycount){
        int probabilltyResult = Dice.rollWithTotalPlayCount(totalPlaycount)[expectingNumber-1];
        return (double) probabilltyResult/totalPlaycount * 100;
    }

    /**
     * this another way by using HashMap
     * key will be dice number and values will be count
     * Idea is using String type. for example: result 1111 is "one is 4 times"
     * @param totalPlaycount
     * @return hashMap
     */
    public static Map<Integer, String> newRollWithTotalPlayCount(int totalPlaycount){


        Map<Integer, String> map = new HashMap<>();

        String value;

        //Make Hashmap Data
        for(int i = 0; i < totalPlaycount; i++){
            int result = getRandom();
            if (map.containsKey(result)){
                value = map.get(result) + Integer.toString(result);
                map.put(result,value);
            }else{
                map.put(result,Integer.toString(result));
            }
        }

        //Change Values
        for(int i =1; i < 7; i++){
            value = map.get(i);
            if (map.containsKey(i))
                map.put(i,Integer.toString(value.length()));
        }
        return map;
    }

}
