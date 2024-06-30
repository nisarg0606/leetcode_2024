class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> current = new ArrayList<>();
        combinationSum2(candidates, target, 0, current, result);
        return result;
    }
    
    private void combinationSum2(int[] candidates, int target, int j, List<Integer> current, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i = j; i < candidates.length; i++) {
            if(i > j && candidates[i] == candidates[i - 1]) {
                continue;
            }
            current.add(candidates[i]);
            combinationSum2(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}