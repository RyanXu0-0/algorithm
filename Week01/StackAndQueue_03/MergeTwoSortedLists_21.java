package StackAndQueue_03;

import java.util.List;

/**
 * @description:
 * @projectName:IDEAProject
 * @see:StackAndQueue_03
 * @author:徐东
 * @createTime:2020/11/9 21:38
 * @version:1.0
 */
public class MergeTwoSortedLists_21 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    /**
     * description 方法一：递归调用
     * param [l1, l2]
     * return StackAndQueue_03.MergeTwoSortedLists_21.ListNode
     * author Ryan Xu
     * createTime 2020/11/9 21:41
     **/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1) return l2;
        else if (null == l2) return l1;

        if(l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * description 方法二
     * param [l1, l2]
     * return StackAndQueue_03.MergeTwoSortedLists_21.ListNode
     * author Ryan Xu
     * createTime 2020/11/9 21:47
     **/
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode curr = pre;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = null == l1 ? l2 : l1;
        return pre.next;
    }
}
