package io.fww.ch2;

import io.fww.basic.ListNode;

/**
 * Created by fengweiwei on 10/8/16.
 */
public class Q2 {
    /*单链表删除倒数第k个元素*/
    public ListNode removeLatKthNode(ListNode head, int lastKth){
        if(head == null||lastKth<1)
            return null;
        /*首先拿到链表长度*/
        int len = 0;
        ListNode p = head;
        while(p!=null){
            len++;
            p = p.next;
        }

        if(len<lastKth)
            return null;
        /*head移len-k，就是要删除的node（无非正着数，倒着数而已）*/
        ListNode pre = null;
        p = head;
        for(int i=0; i<len-lastKth; i++){
            pre = p;
            p = p.next;
        }
        pre.next = p.next;
        return p;
    }
}
