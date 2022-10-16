/**
 * Class implementation taken from StackOverFlow:
 * <a href= https://stackoverflow.com/questions/60068478/create-a-method-to-check-if-sorting-algorithm-is-stable>source</a>.
 */
class StringNum implements Comparable<StringNum> {
    private final String s;
    private final int n;

    static StringNum a1 = new StringNum("A", 1);
    static StringNum b1 = new StringNum("B", 1);
    static StringNum b2 = new StringNum("B", 2);
    static StringNum c1 = new StringNum("C", 1);
    static StringNum c2 = new StringNum("C", 2);
    static StringNum c3 = new StringNum("C", 3);
    static StringNum d1 = new StringNum("D", 1);
    static StringNum d2 = new StringNum("D", 2);
    static StringNum d3 = new StringNum("D", 3);
    static StringNum d4 = new StringNum("D", 4);
    static StringNum e1 = new StringNum("E", 1);
    static StringNum e2 = new StringNum("E", 2);
    static StringNum e3 = new StringNum("E", 3);
    static StringNum e4 = new StringNum("E", 4);
    static StringNum e5 = new StringNum("E", 5);

    public StringNum(String s, int n) {
        this.s = s;
        this.n = n;
    }

    public static StringNum[] getListOne() {
        StringNum [] list1 = {a1, b1, c1, d1, e1, b2, c2, d2, e2, c3, d3, e3, d4, e4, e5};
        return list1;
    }

    public static StringNum[] getListTwo() {
        StringNum [] list1 = {e5, e4, e3, e2, e1, d4, d3, d2, d1, c3, c2, c1, b2, b1, a1};
        return list1;
    }

    @Override
    public int compareTo(StringNum that) {
        return this.s.compareTo(that.s); // Only order by string, not by number
    }

    @Override
    public String toString() {
        return this.s + ":" + this.n;
    }

}