package recursion;

public class SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;
    }

    public static void main(String[] args) {
        SwapNodesInPair swapNodesInPair = new SwapNodesInPair();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result = swapNodesInPair.swapPairs(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        result = swapNodesInPair.swapPairs(head);
        System.out.println("Result");
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
