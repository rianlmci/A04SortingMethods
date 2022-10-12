import csis.Mystery;
import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class A04 {
    //original values
    private static Character [] letterNumEight  = { 'c', 'd', 'a', 'b', '3', '2', '1', '4'};
    private static Character [] letterNumSixteen = {
            'c', 'd', 'a', 'b', '3', '2', '1', '4',
            'c', 'd', 'a', 'b', '3', '2', '1', '4'};
    private static Character [] letterNumTwentyFour = {
            'c', 'd', 'a', 'b', '3', '2', '1', '4',
            'c', 'd', 'a', 'b', '3', '2', '1', '4',
            'c', 'd', 'a', 'b', '3', '2', '1', '4'};
    //TODO https://stackoverflow.com/questions/60068478/create-a-method-to-check-if-sorting-algorithm-is-stable
    static String[] stabilityTestData = {"5","9","3","9","8","4"}; //TODO: Remove me!
    static final double BILLION = 1_000_000_000;
    static final String [] SORTNAMES = {"Insertion", "Selection", "Merge", "Quick"};

    private static void getKnownSortTestResults(String sortName){
        //TIME TESTS:
        System.out.println("= = = = TESTING " + sortName.toUpperCase() + " SORT = = = =");
        System.out.println("\nTIME:");

        //Testing length vs. time (8)
        long startTime = System.nanoTime();
        callKnownSortByName(sortName, letterNumEight);
        System.out.printf(" * %sSort time for length  8: %.8f seconds.\n",
                sortName, (System.nanoTime()-startTime)/BILLION);
        resetEight();

        //Testing length vs. time (16)
        startTime = System.nanoTime();
        callKnownSortByName(sortName, letterNumSixteen);
        System.out.printf(" * %sSort time for length 16: %.8f seconds.\n",
                sortName,(System.nanoTime()-startTime)/BILLION);
        resetSixteen();

        //Testing length vs. time (24)
        startTime = System.nanoTime();
        callKnownSortByName(sortName, letterNumTwentyFour);
        System.out.printf(" * %sSort time for length 24: %.8f seconds.\n",
                sortName,(System.nanoTime()-startTime)/BILLION);
        resetTwentyFour();

        //STABILITY TEST:
        String stable [] = stabilityTestData;
        Arrays.sort(stabilityTestData);
        String test [] = stabilityTestData;
        callKnownSortByName(sortName,test);
        System.out.println("\nSTABILITY:");

        //TODO
        System.out.printf(" * %sSort is Stable: ",
                sortName);
        boolean isUnstable = false;

        for (String oneStable : stable) {
            for(String oneTest : test){
                if(oneStable != oneTest){
                    isUnstable = true;
                }
            }
        }
        System.out.print(isUnstable + "\n\n");
    }

    /**
     * Calls a known sort by name on the targeted array.
     * @param sortName name of the sort we call ex: "Quick" for Quicksort
     * @param arrayToBeSorted array we target with the selected sort
     */
    private static <E> void callKnownSortByName(String sortName, Comparable<E>[] arrayToBeSorted) {
        switch(sortName){
            case "Insertion":
                Insertion.sort(arrayToBeSorted);
                break;
            case "Selection":
                Selection.sort(arrayToBeSorted);
                break;
            case "Merge":
                Merge.sort(arrayToBeSorted);
                break;
            case "Quick":
                Quick.sort(arrayToBeSorted);
                break;
        }
    }

    /**
     * Prints results for various tests on the mystery sorts.
     * @param mysterySortNum number of the mystery sort we are testing ex: 1 for Mystery.sort1
     */
    private static void getMysterySortTestResults(int mysterySortNum) {
        //ERROR CATCHING:
        if(mysterySortNum <= 0 || mysterySortNum > 4){
            throw new IllegalArgumentException("This is not a valid sort methods number!");
        }

        //TIME TESTS:
        System.out.println("= = = = TESTING SORT " + mysterySortNum + " = = = =");
        System.out.println("\nTIME:");

        //Testing length vs. time (8)
        long startTime = System.nanoTime();
        callMysterySortByNum(mysterySortNum, letterNumEight);
        System.out.printf(" * MysterySort%d time for length  8: %.8f seconds.\n",
                mysterySortNum, (System.nanoTime()-startTime)/BILLION);
        resetEight();

        //Testing length vs. time (16)
        startTime = System.nanoTime();
        callMysterySortByNum(mysterySortNum, letterNumSixteen);
        System.out.printf(" * MysterySort%d time for length 16: %.8f seconds.\n",
                mysterySortNum,(System.nanoTime()-startTime)/BILLION);
        resetSixteen();

        //Testing length vs. time (24)
        startTime = System.nanoTime();
        callMysterySortByNum(mysterySortNum, letterNumTwentyFour);
        System.out.printf(" * MysterySort%d time for length 24: %.8f seconds.\n\n",
                mysterySortNum,(System.nanoTime()-startTime)/BILLION);
        resetTwentyFour();
    }

    /**
     * Calls mystery sort by number on the targeted array.
     * @param mysterySortNum number of the mystery sort we call ex: 1 for Mystery.sort1
     * @param arrayToBeSorted array we target with the selected mystery sort
     */
    private static void callMysterySortByNum(int mysterySortNum, Character[] arrayToBeSorted) {
        switch(mysterySortNum){
            case 1:
                Mystery.sort1(arrayToBeSorted);
                break;
            case 2:
                Mystery.sort2(arrayToBeSorted);
                break;
            case 3:
                Mystery.sort3(arrayToBeSorted);
                break;
            case 4:
                Mystery.sort4(arrayToBeSorted);
                break;
        }
    }


    /**
     * Resets the alpha-numeric Character array of size 8
     * to the original scrambled values.
     */
    private static void resetEight(){
        letterNumEight  = new Character[]{'c', 'd', 'a', 'b', '3', '2', '1', '4'};
    }

    /**
     * Resets the alpha-numeric Character array of size 16
     * to the original scrambled values.
     */
    private static void resetSixteen(){
        letterNumSixteen  = new Character[]{
            'c', 'd', 'a', 'b', '3', '2', '1', '4',
            'c', 'd', 'a', 'b', '3', '2', '1', '4'};
    }

    /**
     * Resets the alpha-numeric Character array of size 24
     * to the original scrambled values.
     */
    private static void resetTwentyFour(){
        letterNumTwentyFour  = new Character[]{
                'c', 'd', 'a', 'b', '3', '2', '1', '4',
                'c', 'd', 'a', 'b', '3', '2', '1', '4',
                'c', 'd', 'a', 'b', '3', '2', '1', '4'};
    }

    // = = = = TEST CLIENT = = = = //
    public static void main (String[] args){
        for (String sortName:
                SORTNAMES) {
            getKnownSortTestResults(sortName);
        }

        for (int i = 1; i < 5; i++) {
            getMysterySortTestResults(i);
        }


    }
}
