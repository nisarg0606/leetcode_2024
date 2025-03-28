class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int i = 0, j = n-1;
        int count = 0;
        while(j >= i){
            int sum = people[i] + people[j];
            if(sum > limit){
                count++;
                j--;
            }
            else if(sum <= limit){
                count++;
                j--;
                i++;
            }
        }
        return count;
    }
}