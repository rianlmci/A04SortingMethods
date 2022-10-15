import csis.Mystery;
import edu.princeton.cs.algs4.*;

import java.util.Arrays;


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
    private static void getMysterySortTestResults() {//todo array from outside method?
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
        getKnownSortTestResults();
        getMysterySortTestResults();
    }
}
