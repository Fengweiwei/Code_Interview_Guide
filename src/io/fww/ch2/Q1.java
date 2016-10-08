package io.fww.ch2;

import io.fww.basic.ListNode;

/**
 * Created by fengweiwei on 10/8/16.
 */
public class Q1 {
    /*给定两个有序链表的头指针head1，head2，打印两个链表的公共部分*/
    /*比较简单，关键是注意到链表是有序的，这就可以用类似merge的思路*/
    public void printCommonPart(ListNode head1, ListNode head2){
        if(head1==null||head2==null)
            return;
        while(head1!=null&&head2!=null){
            if(head1.val<head2.val)
                head1 = head1.next;
            else if(head1.val>head2.val)
                head2 = head2.next;
            else{
                System.out.print(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}
