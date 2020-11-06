package LinkedList_02;

public class reverseNodesInKGroup_25 {
    /**
     * description
     * param [args]
     * return void
     * author Ryan Xu
     * createTime 2020/11/5
     **/
//    public static void main(String[] args) {
//        ListNode head = new ListNode(0);
//        head.next = new ListNode(1);
//        reverseKGroup(head, 2);
//    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if(null == end) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;

            pre = start;
            end =start;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode start) {
        ListNode cur = start;
        ListNode pre = null;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
