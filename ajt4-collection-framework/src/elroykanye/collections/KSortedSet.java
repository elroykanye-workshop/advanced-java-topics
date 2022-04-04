package elroykanye.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class KSortedSet {
    public static void runner() {
        treeSet();
    }
    public static void treeSet() {
        SortedSet<Integer> ss = new TreeSet<>(Arrays.asList(2, 3, 5));
        System.out.println(ss);
        ss.add(1);
        System.out.println(ss);
    }
}
