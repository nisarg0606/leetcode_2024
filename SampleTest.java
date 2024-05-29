import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SampleTest {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        return map.isEmpty();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = new char[26];
            for (char c : str.toCharArray()) {
                arr[c - 'a']++;
            }
            String key = new String(arr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    // public static void main(String[] args) {
    // SampleTest st = new SampleTest();
    // String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
    // List<List<String>> result = st.groupAnagrams(strs);
    // for (List<String> list : result) {
    // System.out.println(list);
    // }
    // }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>(map.keySet());
        result.sort((n1, n2) -> map.get(n2) - map.get(n1));
        return result.subList(0, k).stream().mapToInt(i -> i).toArray();
    }

    // public static void main(String[] args) {
    // SampleTest st = new SampleTest();
    // int[] nums = { 1, 1, 2, 2, 2, 3 };
    // int k = 2;
    // int[] result = st.topKFrequent(nums, k);
    // for (int num : result) {
    // System.out.println(num);
    // }
    // }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int longestStreak = 1;
        int currentStreak = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    currentStreak++;
                } else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }
        return Math.max(longestStreak, currentStreak);
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] { -1, -1 };
    }

    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n + 1];
        for (int[] t : trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (count[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    public int[][] merge(int[][] intervals) {
        // Custom sorting using lambda expression where a[0] is the start of the
        // interval and b[0] is the start of the next interval
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // List to store the result of type int[] for merged intervals
        List<int[]> result = new ArrayList<>();
        // Add the first interval to the list
        int[] newInterval = intervals[0];
        result.add(newInterval);
        // Iterate through the intervals and merge if necessary
        for (int[] interval : intervals) {
            // If the start of the next interval is less than or equal to the end of the new interval then merge
            if (interval[0] <= newInterval[1]) {
                // Set the end of the new interval to the maximum of the end of the new interval and the end of the current interval
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                // If the start of the next interval is greater than the end of the new interval then add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }
        // Convert the list to an array and return the result
        return result.toArray(new int[result.size()][]);
    }

    // public static void main(String[] args) {
    //     SampleTest st = new SampleTest();
    //     int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
    //     int[][] result = st.merge(intervals);
    //     for (int[] interval : result) {
    //         System.out.println(Arrays.toString(interval));
    //     }
    // }

    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) > nums.length / 3) {
                result.add(key);
            }
        }
        return result;   
    }
}