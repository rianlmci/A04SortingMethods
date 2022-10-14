import csis.Mystery;
import edu.princeton.cs.algs4.*;

import java.util.Arrays;


public class A04 {
    static final double BILLION = 1_000_000_000;

    private static void getKnownSortTestResults(){
        //TIME TESTS:
        //System.out.println("= = = = TESTING " +  + " SORT = = = =");
        //System.out.println("\nTIME:");//TODO need different header
        int size = 1;
        boolean insertionTimedOut = false;
        boolean selectionTimedOut = false;
        boolean mergeTimedOut = false;
        boolean quickTimedOut = false;
        boolean allTimedOut = false;

        for (int i = 0; !allTimedOut ; i++) {
            allTimedOut = insertionTimedOut && selectionTimedOut && mergeTimedOut && quickTimedOut;
            Integer[] array = ArrayGen.getRandomNumberArray(size);
            if (!insertionTimedOut) {
                long startTime = System.nanoTime();
                Insertion.sort(Arrays.copyOf(array, array.length));
                long totalTime = System.nanoTime() - startTime;
                System.out.printf(" * Insertion Sort time for length  %d: %.8f seconds.\n",
                        size, (totalTime) / BILLION);
                if (totalTime > 5*BILLION){
                    insertionTimedOut = true;
                }

            } else {
                //TODO print spacer
            }
            if (!selectionTimedOut) {
                long startTime = System.nanoTime();
                Selection.sort(Arrays.copyOf(array, array.length));
                long totalTime = System.nanoTime() - startTime;
                System.out.printf(" * Selection Sort time for length  %d: %.8f seconds.\n",
                        size, (totalTime) / BILLION);
                if (totalTime > 5*BILLION){
                    selectionTimedOut = true;
                }
            } else {
                //TODO print spacer
            }
            if (!mergeTimedOut) {
                long startTime = System.nanoTime();
                Merge.sort(Arrays.copyOf(array, array.length));
                long totalTime = System.nanoTime() - startTime;
                System.out.printf(" * Merge Sort time for length  %d: %.8f seconds.\n",
                        size, (totalTime) / BILLION);
                if (totalTime > 5*BILLION){
                    mergeTimedOut = true;
                }
            } else {
                //TODO print spacer
            }
            if (!quickTimedOut) {
                long startTime = System.nanoTime();
                Quick.sort(Arrays.copyOf(array, array.length));
                long totalTime = System.nanoTime() - startTime;
                System.out.printf(" * Quick Sort time for length  %d: %.8f seconds.\n",
                        size, (totalTime) / BILLION);
                if (totalTime > 5*BILLION){
                    quickTimedOut = true;
                }
            } else {
                //TODO print spacer
            }
            size *= 2;
        }
        //Testing length vs. time (8)



//        //TODO
//        //STABILITY TEST:
//        String stable [] = stabilityTestData;
//        Arrays.sort(stabilityTestData);
//        String test [] = stabilityTestData;
//        callKnownSortByName(sortName,test);
//        System.out.println("\nSTABILITY:");
//        System.out.printf(" * %sSort is Stable: ",
//                sortName);
//        boolean isUnstable = false;
//
//        for (String oneStable : stable) {
//            for(String oneTest : test){
//                if(oneStable != oneTest){
//                    isUnstable = true;
//                }
//            }
//        }
//        System.out.print(isUnstable + "\n\n");
    }

    /**
     * Prints results for various tests on the mystery sorts.
     */
    private static void getMysterySortTestResults() {//todo array from outside method
        //System.out.println("= = = = TESTING " + i.toUpperCase() + " SORT = = = =");
        //System.out.println("\nTIME:"); TODO: need different header
        int size = 1;
        boolean sort1TimedOut = false;
        boolean sort2TimedOut = false;
        boolean sort3TimedOut = false;
        boolean sort4TimedOut = false;
        boolean allTimedOut = false;

        while (!allTimedOut) {
            allTimedOut = sort1TimedOut && sort2TimedOut && sort3TimedOut && sort4TimedOut;
            Integer[] array = ArrayGen.getRandomNumberArray(size);
            if (!sort1TimedOut) {
                long startTime = System.nanoTime();
                Mystery.sort1(Arrays.copyOf(array, array.length));
                long totalTime = System.nanoTime() - startTime;
                System.out.printf(" * Sort1 Sort time for length  %d: %.8f seconds.\n",
                        size, (totalTime) / BILLION);
                if (totalTime > 5*BILLION){
                    sort1TimedOut = true;
                }

            } else {
                //TODO print spacer
            }
            if (!sort2TimedOut) {
                long startTime = System.nanoTime();
                Mystery.sort2(Arrays.copyOf(array, array.length));
                long totalTime = System.nanoTime() - startTime;
                System.out.printf(" * Sort2 Sort time for length  %d: %.8f seconds.\n",
                        size, (totalTime) / BILLION);
                if (totalTime > 5*BILLION){
                    sort2TimedOut = true;
                }
            } else {
                //TODO print spacer
            }
            if (!sort3TimedOut) {
                long startTime = System.nanoTime();
                Mystery.sort3(Arrays.copyOf(array, array.length));
                long totalTime = System.nanoTime() - startTime;
                System.out.printf(" * Sort3 Sort time for length  %d: %.8f seconds.\n",
                        size, (totalTime) / BILLION);
                if (totalTime > 5*BILLION){
                    sort3TimedOut = true;
                }
            } else {
                //TODO print spacer
            }
            if (!sort4TimedOut) {
                long startTime = System.nanoTime();
                Mystery.sort4(Arrays.copyOf(array, array.length));
                long totalTime = System.nanoTime() - startTime;
                System.out.printf(" * Sort4 Sort time for length  %d: %.8f seconds.\n",
                        size, (totalTime) / BILLION);
                if (totalTime > 5*BILLION){
                    sort4TimedOut = true;
                }
            } else {
                //TODO print spacer
            }
            size *= 2;
        }
    }

    // = = = = TEST CLIENT = = = = //
    public static void main (String[] args){
        getKnownSortTestResults();
        getMysterySortTestResults();
    }
}
