import java.util.*;

public class TopKFrequency {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        // sort the map by value so that we can get the top k frequent elements
        // we are using a priority queue to sort the map by value
        // here the lambda function compares the values of the keys in the map and sorts
        // them in ascending order
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));

        // add keys where the frequency is greater than or equal to k
        for (int key : freq.keySet()) {
            pq.add(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequency tkf = new TopKFrequency();
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        int[] res = tkf.topKFrequent(nums, k);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
