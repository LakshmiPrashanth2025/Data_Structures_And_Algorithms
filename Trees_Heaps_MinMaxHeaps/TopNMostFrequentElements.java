// Java program to find k most
// frequent element using max heap
import java.util.*;

public class TopNMostFrequentElements {

    // Comparison function to sort the frequency array
    static class Compare implements Comparator<int[]> 
    {
        public int compare(int[] p1, int[] p2) {
            
            // Prioritise element's value in case their frequency was same
            if (p1[0] == p2[0])
                return Integer.compare(p1[1], p2[1]);

            // Sort on the basis of increasing order of frequencies (for min heap behavior)
            return Integer.compare(p1[0], p2[0]);
        }
    }

    // Function to find k numbers with most occurrences
    static ArrayList<Integer> topKFrequent(int[] arr, int k) {

        // HashMap 'map' implemented as frequency hashtable
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr)
            map.put(val, map.getOrDefault(val, 0) + 1);

        // Priority queue (Min-Heap) with custom comparator
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Compare());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) 
        {
            pq.offer(new int[]{entry.getValue(), entry.getKey()});

            if (pq.size() > k){
                pq.poll();
            }
        }

        // store the result
        ArrayList<Integer> res = new ArrayList<>();

        while (!pq.isEmpty()) {
            res.add(pq.poll()[1]);
        }

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 4, 5, 2, 6, 1};
        int k = 2;
        ArrayList<Integer> res = topKFrequent(arr, k);

        for (int i = 0; i < res.size(); i++)
            System.out.print(res.get(i) + " ");
    }
}