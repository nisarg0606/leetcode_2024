class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int result;
        if (n < 2) {
            result = n;
        } else {
            result = fib(n - 1) + fib(n - 2);
        }
        map.put(n, result);
        return result;
    }
}