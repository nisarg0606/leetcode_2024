// class Solution {
//     public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
//         // int count = 0;
//         // for(int i = 0; i < fruits.length; i++){
//         //     for(int j = 0; j < baskets.length; j++){
//         //         if(fruits[i] <= baskets[j] && baskets[j] != -1){
//         //             count++;
//         //             baskets[j] = -1;
//         //             break;
//         //         }
//         //     }
//         // }
//         // return baskets.length - count;
//     }
// }

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] used = new boolean[n];
        int placed = 0;

        for (int i = 0; i < n && placed < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!used[j] && baskets[j] >= fruits[i]) {
                    used[j] = true;
                    placed++;
                    break;
                }
            }
        }

        return n - placed;
    }
}
