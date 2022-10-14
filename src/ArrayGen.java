import java.util.Random;

public class ArrayGen {
    private static final Random random = new Random();
    /**
     * Creates an array of the specified size
     * that is filled with random numbers.
     *
     * @param size size to generate
     * @return the array of numbers.
     */
    public static Integer[] getRandomNumberArray(int size){
        Integer[] out = new Integer[size];

        for (int i = 0; i < out.length; i++) {
            out[i] = random.nextInt(101);
        }

        return out;
    }
    public static Integer[] getMostlySortedNumberArray(int size){
        Integer[] out = new Integer[size];

        for (int i = 0; i < size; i++) {
            out[i] = random.nextInt(i>2?i-2:0,i+2);
        }
        return out;
    }
    public static Integer[] getSortedNumberArray(int size){
        Integer[] out = new Integer[size];

        for (int i = 0; i < size; i++) {
            out[i] = i;
        }
        return out;
    }
    public static Integer[] getReverseOrderNumberArray(int size){
        Integer[] out = new Integer[size];
        int j = size;
        for (int i = 0; i < size; i++) {
            out[i] = j;
            j--;
        }
        return out;
    }
}
