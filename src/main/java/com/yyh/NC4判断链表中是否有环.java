package com.yyh;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false
 * 输入分为两部分，第一部分为链表，第二部分代表是否有环，然后将组成的head头结点传入到函数里面。
 * -1代表无环，其它的数字代表有环，这些参数解释仅仅是为了方便读者自测调试。实际在编程时读入的是链表的头节点
 * 例如输入{3,2,0,-4},1时，对应的链表结构如下图所示：
 * https://uploadfiles.nowcoder.com/images/20220110/423483716_1641800950920/0710DD5D9C4D4B11A8FA0C06189F9E9C
 * 可以看出环的入口结点为从头结点开始的第1个结点（注：头结点为第0个结点），所以输出true
 * <p>
 * 示例1
 * 输入：{3,2,0,-4},1
 * 返回值：true
 * 说明：第一部分{3,2,0,-4}代表一个链表，第二部分的1表示，-4到位置1（注：头结点为位置0），即-4->2存在一个链接，组成传入的head为一个带环的链表，返回true
 * <p>
 * 示例2
 * 输入：{1},-1
 * 返回值：false
 * 说明：第一部分{1}代表一个链表，-1代表无环，组成传入head为一个无环的单链表，返回false
 * <p>
 * 示例3
 * 输入：{-1,-7,7,-4,19,6,-9,-5,-2,-5},6
 * 返回值：true
 */
public class NC4判断链表中是否有环 {

    // 法一：快慢指针
    public static boolean hasCycle1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // 法二：hash法，记录第一次重复的节点
    public static boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
