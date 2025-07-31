class Solution {
   public int leastInterval(char[] tasks, int n) {
        // freq array of size 26
        int[] freq = new int[26];
        for(char t: tasks){
            freq[t - 'A']++;
        }
        
        int max = 0;
        for(int f: freq){
            if(f >= max){
                max = f;
            }
        }
            
        // count how many tasks have this maximum freq
        int maxCount = 0;
        for(int f: freq){
            if(f == max) 
            maxCount++;
        }
        
        // Calculate minimum required slots
        // (max - 1) * (n + 1)
        int minSlots = (max - 1) * (n + 1) + maxCount;
        
        return Math.max(minSlots, tasks.length);
    }
}