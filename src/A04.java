import csis.Mystery;

import java.util.Arrays;

public class A04 {
    //original values
    private static Character [] letterNumEight  = { 'c', 'd', 'a', 'b', '3', '2', '1', '4'};
    private static Character [] letterNumSixteen = {
            'c', 'd', 'a', 'b', '3', '2', '1', '4',
            'c', 'd', 'a', 'b', '3', '2', '1', '4'};

    public static void main (String[] args){
        System.out.println("= = = = TESTING SORT 1 = = = =");
        System.out.println("Sort 1 time for length 8:");
        Mystery.sort1(letterNumEight);
        System.out.println(Arrays.toString(letterNumEight));

        resetEight();
        System.out.println(Arrays.toString(letterNumEight));
    }

    private static void resetEight(){
        letterNumEight  = new Character[]{'c', 'd', 'a', 'b', '3', '2', '1', '4'};
    }

    private static void resetSixteen(){
        letterNumSixteen  = new Character[]{
            'c', 'd', 'a', 'b', '3', '2', '1', '4',
            'c', 'd', 'a', 'b', '3', '2', '1', '4'};
    }
}
