
/*
    https://leetcode.com/problems/add-two-numbers/
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lr1 = l1;
        ListNode lr2 = l2;
        ListNode l3 = null;
        ListNode tail = l3;

        int addOne = 0;

        while (lr1 != null && lr2 != null) {
            int num = lr1.val + lr2.val + addOne;
            ListNode t;
            if (num > 9) {
                t = new ListNode(num % 10);
                addOne = 1;
            } else {
                t = new ListNode(num);
                addOne = 0;
            }

            if (l3 == null) {
                l3 = t;
                tail = t;
            } else {
                tail.next = t;
                tail = tail.next;
            }

            lr1 = lr1.next;
            lr2 = lr2.next;
        }

        if (lr1 == null) {
            tail.next = lr2;
            while (lr2 != null) {
                int num = lr2.val + addOne;
                if (num == 10) {
                    lr2.val = 0;
                    tail = lr2;
                    lr2 = lr2.next;
                    addOne = 1;
                } else {
                    lr2.val = num;
                    addOne = 0;
                    break;
                }
            }
        } else {
            tail.next = lr1;
            while (lr1 != null) {
                int num = lr1.val + addOne;
                if (num == 10) {
                    lr1.val = 0;
                    tail = lr1;
                    lr1 = lr1.next;
                    addOne = 1;
                } else {
                    lr1.val = num;
                    addOne = 0;
                    break;
                }
            }
        }

        if (addOne == 1) {
            ListNode t = new ListNode(1);
            tail.next = t;
        }

        return l3;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}