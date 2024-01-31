import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostVisitedSectorinaCircularTrack {
    public List<Integer> mostVisited(int n, int[] rounds) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rounds.length - 1; i++) {
            int start = rounds[i];
            int end = rounds[i + 1];
            if (start <= end) {
                for (int j = start; j <= end; j++) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
            } else {
                for (int j = 1; j <= end; j++) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
                for (int j = start; j <= n; j++) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
            }
        }
        // map.put(rounds[rounds.length - 1], map.getOrDefault(rounds[rounds.length - 1], 0) + 1);
        int max = 0;
        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        List<Integer> result = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                result.add(key);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MostVisitedSectorinaCircularTrack mostVisitedSectorinaCircularTrack = new MostVisitedSectorinaCircularTrack();
        System.out.println(mostVisitedSectorinaCircularTrack.mostVisited(7, new int[] { 1, 3, 5, 7 }));
        System.out.println(mostVisitedSectorinaCircularTrack.mostVisited(4, new int[] { 1, 3, 1, 2 }));
        System.out.println(mostVisitedSectorinaCircularTrack.mostVisited(2, new int[] { 2, 1, 2, 1, 2, 1, 2, 1, 2 }));
    }
}




    // List<Integer> result = new ArrayList<>();
        // int start = rounds[0];
        // int end = rounds[rounds.length - 1];
        // if (start <= end) {
        //     for (int i = start; i <= end; i++) {
        //         result.add(i);
        //     }
        // } else {
        //     for (int i = 1; i <= end; i++) {
        //         result.add(i);
        //     }
        //     for (int i = start; i <= n; i++) {
        //         result.add(i);
        //     }
        // }
        // return result;