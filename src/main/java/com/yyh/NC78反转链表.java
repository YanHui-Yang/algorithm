package com.yyh;

import java.util.Stack;

/**
 * 给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头
 * 如当输入链表{1,2,3}时，
 * 经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}
 */
public class NC78反转链表 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        ListNode node = reverseList2(listNode);
        System.out.println(node);
    }

    // 法一：暴力法
    public static ListNode reverseList1(ListNode head) {
        // 链表反转后的前一个结点
        ListNode pre = null;
        // 当前节点
        ListNode cur = head;
        while (cur != null) {
            // 当前节点的下一个节点
            ListNode curNext = cur.next;
            // 反转链表
            cur.next = pre;
            // 更新pre
            pre = cur;
            // 更新cur
            cur = curNext;
        }
        return pre;
    }

    // 法二：栈
    public static ListNode reverseList2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        // 把链表节点全部摘掉放到栈中
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()) {
            return null;
        }
        ListNode node = stack.pop();
        ListNode dummy = node;
        // 栈中的结点全部出栈，然后重新连成一个新的链表
        while (!stack.isEmpty()) {
            node.next = stack.pop();
            node = node.next;
        }
        // 最后一个结点就是反转前的头结点，一定要让他的next等于空，否则会构成环
        node.next = null;
        return dummy;
    }

    // 法三：递归
    public static ListNode reverseList3(ListNode head) {
        return reverseListInt(head, null);
    }

    private static ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}
