package A04Mystery;

import csis.Mystery;
import edu.princeton.cs.algs4.*;

import java.util.Arrays;

/**
 * Tests for timing how long each sorting method takes.
 * Specifically,it tests and Prints timing information about the four known and unknown sorting tests.
 * Also, it contains the main method.
 * @author Eric Rytting, starter code by Rianna McIntyre.
 */
public class A04 {
    static final double BILLION = 1_000_000_000;
    private static String[] genMode = {
            "random",
            "mostly sorted",
            "reverse order",
            "sorted"
    };

    private static void getKnownSortTestResults(){
        for (int i = 0; i < 4; i++) {
            System.out.println();
            System.out.println("    Using " + genMode[i] + " arrays");
            System.out.println("           Insertion Sort              Selection Sort                Merge Sort                   Quick Sort        ");
            System.out.println("    ---Elements----Time-taken--- ---Elements----Time-taken--- ---Elements----Time-taken--- ---Elements----Time-taken---");
            int size = 256;
            boolean insertionTimedOut = false;
            boolean selectionTimedOut = false;
            boolean mergeTimedOut = false;
            boolean quickTimedOut = false;
            boolean allTimedOut = false;
            String formatString = " | %-10d    %7.4f s  |";
            String spacerString = " |                          |";

            while (!allTimedOut && size < 68000000) {
                allTimedOut = insertionTimedOut && selectionTimedOut && mergeTimedOut && quickTimedOut;
                Integer[] array = callGenMode(i,size);
                if (!insertionTimedOut) {
                    long startTime = System.nanoTime();
                    Insertion.sort(Arrays.copyOf(array, array.length));
                    long totalTime = System.nanoTime() - startTime;
                    System.out.printf("   " + formatString,
                            size, (totalTime) / BILLION);
                    if (totalTime > 5 * BILLION) {
                        insertionTimedOut = true;
                    }

                } else {
                    System.out.print("   " + spacerString);
                }
                if (!selectionTimedOut) {
                    long startTime = System.nanoTime();
                    Selection.sort(Arrays.copyOf(array, array.length));
                    long totalTime = System.nanoTime() - startTime;
                    System.out.printf(formatString,
                            size, (totalTime) / BILLION);
                    if (totalTime > 5 * BILLION) {
                        selectionTimedOut = true;
                    }
                } else {
                    System.out.print(spacerString);
                }
                if (!mergeTimedOut) {
                    long startTime = System.nanoTime();
                    Merge.sort(Arrays.copyOf(array, array.length));
                    long totalTime = System.nanoTime() - startTime;
                    System.out.printf(formatString,
                            size, (totalTime) / BILLION);
                    if (totalTime > 5 * BILLION) {
                        mergeTimedOut = true;
                    }
                } else {
                    System.out.print(spacerString);
                }
                if (!quickTimedOut) {
                    long startTime = System.nanoTime();
                    Quick.sort(Arrays.copyOf(array, array.length));
                    long totalTime = System.nanoTime() - startTime;
                    System.out.printf(formatString,
                            size, (totalTime) / BILLION);
                    if (totalTime > 5 * BILLION) {
                        quickTimedOut = true;
                    }
                } else {
                    System.out.print(spacerString);
                }
                System.out.println();
                size *= 2;
            }
            System.out.println("    ---------------------------- ---------------------------- ---------------------------- ----------------------------");
        }
    }

    private static Integer[] callGenMode(int genMode, int size){
        switch (genMode) {
            case 0 -> {return ArrayGen.getRandomNumberArray(size);}
            case 1 -> {return ArrayGen.getMostlySortedNumberArray(size);}
            case 2 -> {return ArrayGen.getReverseOrderNumberArray(size);}
            case 3 -> {return ArrayGen.getSortedNumberArray(size);}
            default -> {return new Integer[0];}
        }
    }

    /**
     * Prints results for various tests on the mystery sorts.
     */
    private static void getMysterySortTestResults() {
        for (int i = 0; i < 4; i++) {
            System.out.println();
            System.out.println("    Using " + genMode[i] + " arrays");
            System.out.println("                Sort 1                       Sort 2                       Sort 3                       Sort 4       ");
            System.out.println("    ---Elements----Time-taken--- ---Elements----Time-taken--- ---Elements----Time-taken--- ---Elements----Time-taken---");
            int size = 256;
            boolean sort1TimedOut = false;
            boolean sort2TimedOut = false;
            boolean sort3TimedOut = false;
            boolean sort4TimedOut = false;
            boolean allTimedOut = false;
            String formatString =" | %-10d    %7.4f s  |";
            String spacerString =" |                          |";

            while (!allTimedOut && size < 68000000) {
                allTimedOut = sort1TimedOut && sort2TimedOut && sort3TimedOut && sort4TimedOut;
                Integer[] array = callGenMode(i,size);
                if (!sort1TimedOut) {
                    long startTime = System.nanoTime();
                    Mystery.sort1(Arrays.copyOf(array, array.length));
                    long totalTime = System.nanoTime() - startTime;
                    System.out.printf("   " + formatString,
                            size, (totalTime) / BILLION);
                    if (totalTime > 5*BILLION){
                        sort1TimedOut = true;
                    }

                } else {
                    System.out.print("   "+spacerString);
                }
                if (!sort2TimedOut) {
                    long startTime = System.nanoTime();
                    Mystery.sort2(Arrays.copyOf(array, array.length));
                    long totalTime = System.nanoTime() - startTime;
                    System.out.printf(formatString,
                            size, (totalTime) / BILLION);
                    if (totalTime > 5*BILLION){
                        sort2TimedOut = true;
                    }
                } else {
                    System.out.print(spacerString);
                }
                if (!sort3TimedOut) {
                    long startTime = System.nanoTime();
                    Mystery.sort3(Arrays.copyOf(array, array.length));
                    long totalTime = System.nanoTime() - startTime;
                    System.out.printf(formatString,
                            size, (totalTime) / BILLION);
                    if (totalTime > 5*BILLION){
                        sort3TimedOut = true;
                    }
                } else {
                    System.out.print(spacerString);
                }
                if (!sort4TimedOut) {
                    long startTime = System.nanoTime();
                    Mystery.sort4(Arrays.copyOf(array, array.length));
                    long totalTime = System.nanoTime() - startTime;
                    System.out.printf(formatString,
                            size, (totalTime) / BILLION);
                    if (totalTime > 5*BILLION){
                        sort4TimedOut = true;
                    }
                } else {
                    System.out.print(spacerString);
                }
                size *= 2;
                System.out.println();
            }
            System.out.println("    ---------------------------- ---------------------------- ---------------------------- ----------------------------");
        }
    }

    // = = = = TEST CLIENT = = = = //
    public static void main (String[] args){
        //TIMING TESTS:
        getKnownSortTestResults();
        getMysterySortTestResults();
        //STABILITY TESTS:
        System.out.println();
        System.out.println("KNOWN SORT STABILITY:");
        System.out.println(
                " //expected: InsertionSort (true), SelectionSort (false), Mergesort (true), Quicksort (false)//\n");
        for (String oneName : StabilityTest.SORTNAMES) {
            StabilityTest.getKnownSortTestResults(oneName);
        }

        System.out.println("MYSTERY SORT STABILITY:");
        System.out.println(
                " //expected: InsertionSort (true), SelectionSort (false), Mergesort (true), Quicksort (false)//\n");
        for (int i = 0; i < 4; i++) {
            StabilityTest.getMysterySortTestResults(i+1);
        }
    }
}
