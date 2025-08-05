class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        // int i = 0, j = 0;
        // while(j < baskets.length && i < fruits.length){
        //     if(fruits[i] <= baskets[j]){
        //         count++;
        //         i++;
        //         j++;
        //     }else{
        //         j++;
        //     }
        // }
        for(int i = 0; i < fruits.length; i++){
            for(int j = 0; j < baskets.length; j++){
                if(fruits[i] <= baskets[j] && baskets[j] != -1){
                    count++;
                    baskets[j] = -1;
                    break;
                }
            }
        }
        return baskets.length - count;
    }
}