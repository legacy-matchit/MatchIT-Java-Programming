package memory;

import java.util.Random;

public class Shuffle {


    public static void main(String [] args){

        int[] array = new int[10];

        for(int i = 0; i < array.length; i++){
            array[i] = i;
        }

        Random r = new Random();

//        for(int i = array.length-1; i > 0; i--){
//            System.out.println("i:"+i);
//            int rIndex = r.nextInt(i+1);
//            System.out.println("rIndex:"+ rIndex);
//            int tem = array[i];
//            array[i] = array[rIndex];
//            array[rIndex] = tem;
//        }

        for(int i = 0; i < array.length; i++){
            int rIndex = r.nextInt(array.length-i);
            int range = array.length-i;
            System.out.println("range:" +"[0-" + range + "]");

            int tem = array[i];
            array[i] = array[rIndex];
            array[rIndex] = tem;

            System.out.printf("tem  = array[%d]\n",i);
            System.out.printf("array[%d] = array[%d]\n",i,rIndex);
            System.out.printf("array[%d] = array[%d]\n",rIndex,i);

        }

        for(int i = 0; i < array.length; i++){
            //System.out.print(" "+ array[i]);
            //System.out.println("\n");
            //System.out.print(" "+ array[i]);
        }


    }

}
