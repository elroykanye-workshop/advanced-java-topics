package elroykanye.collections;

import java.util.*;

public class KSet {
    public void iterator() {
        java.util.Set<Integer> even = new HashSet<>(List.of(0, 2, 4));
        even.add(6); even.add(8);
        for (Integer e : even) System.out.println(e);
    }
    public void hashSet () {
        HashSet<Integer> empty = new HashSet<>(0);

        HashSet<Integer> even = new HashSet<>(Arrays.asList(0,2,4));

        HashSet<Integer> copy = new HashSet<>(even);

        HashSet<Integer> blank = new HashSet<>(8);

        HashSet<Integer> nullSet = new HashSet<>(8,1);

        List<HashSet<Integer>> hashSetList = List.of(empty, even, copy, blank, nullSet);
        hashSetList.forEach(System.out::println);
    }

    public void linkedHashSet() {
        java.util.Set<Object> orderedSet = new LinkedHashSet<>();
    }
}
