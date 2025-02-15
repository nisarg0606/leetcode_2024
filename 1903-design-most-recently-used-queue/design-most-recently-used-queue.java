class MRUQueue {

    private List<Integer> queue;

    public MRUQueue(int n) {
        queue = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
    }

    public int fetch(int k) {
        int val = queue.get(k - 1); // Get the k-th element (1-based index)
        queue.remove(k - 1); // Remove it (O(n) due to shifting)
        queue.add(val); // Append it to the end (O(1))
        return val;
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */