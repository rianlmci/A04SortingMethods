package A04Mystery;

import csis.Mystery;
import edu.princeton.cs.algs4.*;
import java.util.Arrays;

/**
 * Tests for stability. Tests and Prints information about the four known and unknown sorting tests.
 * @author Rianna McIntyre
 */
public class StabilityTest {
    public static final String [] SORTNAMES = {"Insertion", "Selection", "Merge", "Quick"};

    /**
     * Prints results of sorting a specified array,
     * showing if they are stable or not by comparing their output
     * with a known stable sorting method (Arrays.sort)
     * @param sortName name of the known sort
     */
    static void getKnownSortTestResults(String sortName){
        StringNum [] stableList = StringNum.getListOne();
        Arrays.sort(stableList);
        StringNum [] testList = StringNum.getListOne();
        callKnownSortByName(sortName,testList);
        System.out.printf(" * Stable-Sorted Array: %s \n",
                Arrays.deepToString(stableList));
        System.out.printf(" * %9sSort Array: %s \n",
                sortName, Arrays.deepToString(testList));
        System.out.printf(" * %sSort is stable: %b!\n\n",
                sortName, Arrays.deepToString(stableList).equals(Arrays.deepToString(testList)));
    }

    /**
     * Prints results of sorting a specified array,
     * showing if they are stable or not by comparing their output
     * with a known stable sorting method (Arrays.sort)
     * @param sortNum number of the mystery sort
     */
    static void getMysterySortTestResults(int sortNum){
        StringNum [] stableList = StringNum.getListOne();
        Arrays.sort(stableList);
        StringNum [] testList = StringNum.getListOne();
        callMysterySortByNum(sortNum,testList);
        System.out.printf(" * Stable-Sorted Array: %s \n",
                Arrays.deepToString(stableList));
        System.out.printf(" * MysterySort%d Array:  %s \n",
                sortNum, Arrays.deepToString(testList));
        System.out.printf(" * MysterySort%d is stable: %b! \n\n",
                sortNum, Arrays.deepToString(stableList).equals(Arrays.deepToString(testList)));
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
     * Calls mystery sort by number on the targeted array.
     * @param mysterySortNum number of the mystery sort we call ex: 1 for Mystery.sort1
     * @param arrayToBeSorted array we target with the selected mystery sort
     */

    private static <E> void callMysterySortByNum(int mysterySortNum, Comparable<E>[] arrayToBeSorted) {
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
    // = = = = TEST CLIENT FOR CLASS = = = = //
    public static void main (String args [] ) {
        System.out.println();
        System.out.println("KNOWN SORT STABILITY:");
        System.out.println(
                " //expected: InsertionSort (true), SelectionSort (false), Mergesort (true), Quicksort (false)//\n");
        for (String oneName : SORTNAMES) {
            getKnownSortTestResults(oneName);
        }

        System.out.println("MYSTERY SORT STABILITY:");
        System.out.println(
                " //expected: InsertionSort (true), SelectionSort (false), Mergesort (true), Quicksort (false)//\n");
        for (int i = 0; i < 4; i++) {
            getMysterySortTestResults(i+1);
        }
    }
}

