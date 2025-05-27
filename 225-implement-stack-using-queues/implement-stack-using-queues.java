class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        if (size > 1) {
            while (size != 1) {
                Integer temp = queue.remove();
                queue.add(temp);
                size--;
            }
        }
    }

    public int top() {
        return queue.peek();
    }

    public int pop() {
        return queue.remove();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */