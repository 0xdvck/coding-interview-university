import java.util.*;

class Solution {
    public List<Integer> topKFrequentSolutionOne(int[] nums, int k) {
        //Priority Queue 
        //Time Complexity: O(n + nlogk + klogk)
        //Space Complexity: O(m + k + k)
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){ //O(n)
            map.put(n, map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){ //O(nlog k + (n-k) log k) = O(n log k)
            minHeap.add(entry);
            if (minHeap.size() > k) minHeap.poll();
        }

        List<Integer> res = new ArrayList<>();
        while(res.size()<k){ //O(klogk)
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }

    public int[] topKFrequentSolutionTwo(int[] nums, int k) {
        //Bucket sort 
        //Time Complexity: O(n + n + m + n) -> O(n)
        //Space Complexity: O(n + m + k)
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) { //O(n)
            map.put( nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] freq = new ArrayList[nums.length + 1]; //O(n)
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) { //O(m)
            int frequency = entry.getValue();
            freq[frequency].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;
        for(int j =  freq.length - 1; j >= 0; j--) { //O(n)
            for(int i = freq[j].size() - 1; i >= 0; i--) {
                result[index++] = freq[j].get(i);

                if(index >= k) {
                    return result;
                }

            }
        }
        return  new int[0];
    }
}