// class Solution {
//     public int[] maximumBeauty(int[][] items, int[] queries) {
//         int[] result = new int[queries.length];
//         Arrays.fill(result, 0);
//         Map<Integer, Integer> map = new TreeMap<>();
//         for (int i = 0; i < items.length; i++) {
//             map.put(items[i][0], Math.max(map.getOrDefault(items[i][0], 0), items[i][1]));
//         }
//         for (int i = 0; i < queries.length; i++) {
//             Integer key = findKeyLessThanOrEqualTo(map, queries[i]);
//             if (key != null) {
//                 for(Integer keys: map.keySet()){
//                     result[i] = Math.max(map.get(keys), result[i]);
//                 }
//             } else {
//                 result[i] = 0;
//             }
//         }
//         return result;
//     }

//     private static Integer findKeyLessThanOrEqualTo(Map<Integer, Integer> map, int targetKey) {
//         TreeSet<Integer> keys = new TreeSet<>(map.keySet());
//         return keys.floor(targetKey);
//     }
// }

class Solution {
     public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] result = new int[queries.length];
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int max = items[0][1];
        for(int i = 0; i < items.length; i++){
            max = Math.max(max, items[i][1]);
            items[i][1] = max;
        }

        for(int i = 0; i < queries.length; i++){
            result[i] = binarySearch(items, queries[i]);
        }
        return result;
     }

     private int binarySearch(int[][] items, int targetPrice){
        int l = 0;
        int r = items.length - 1;
        int maxBeauty = 0;
        while(l <= r){
            int mid = (l + r) / 2;
            if(items[mid][0] > targetPrice){
                r = mid - 1;
            } else{
                maxBeauty = Math.max(maxBeauty, items[mid][1]);
                l = mid + 1;
            }
        }

        return maxBeauty;
     }

}