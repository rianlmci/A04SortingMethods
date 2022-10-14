import java.util.Comparator;

public class IntKeyPair implements Comparable<IntKeyPair>{
    private String string;
    private int integer;

    public Comparator<IntKeyPair> stringComparator(IntKeyPair other){
        return new ByStringComparator<>();
    }

    private static class ByStringComparator<I> implements Comparator<IntKeyPair>{

        @Override
        public int compare(IntKeyPair o1, IntKeyPair o2) {
            return o1.string.compareTo(o2.string);
        }
    }

    @Override
    public int compareTo(IntKeyPair other) {
        return Integer.compare(this.integer,other.integer);
    }
}
