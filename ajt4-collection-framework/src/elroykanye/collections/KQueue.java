package elroykanye.collections;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KQueue {
    public static void priorityQueue() {
        Queue<Integer> q = new PriorityQueue<>(Arrays.asList(7, 4 ,5));
        q.add(2); q.add(6);
        q.offer(0);
    }
}
