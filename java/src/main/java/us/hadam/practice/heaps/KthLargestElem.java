package us.hadam.practice.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElem {
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (int n: nums) {
            pq.add(n);
        }
        int result = -1;
        for (int i=0; i<k; i++) result = pq.remove();
        return result;
    }
}
