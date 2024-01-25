public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode head = result;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            result.next = l1;
        }
        if (l2 != null) {
            result.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(5))));
        ListNode result = mtsl.mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }
}