package com.March.list;

/**
 * Create by sunyang on 2019/3/19 21:50
 * For me:One handred lines of code every day,make myself stronger.
 */
public class MyList {

    /**
     * 头节点的插入
     */

    public static void headInsert(ListNode head,ListNode newHead){
        ListNode old = head;
        head = newHead;
        head.next = old;
    }

    /**
     * 尾节点的插入
     */
    public static void tailInsert(ListNode tail, ListNode newTail){
        ListNode old = tail;
        tail = newTail;
        tail.next = null;
        old.next = tail;

    }

    /**
     * 单链表遍历
     */
    public static void traverse(ListNode node){
        while (node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 查找，时间复杂度（0n）
     */
    public static int find(ListNode head, int value){
        int index = -1;
        int count = 0;
        while (head != null){
            if (head.value == value){
                index = count;
                return index;
            }
            count++;
            head = head.next;
        }
        System.out.println(index);
        return index;
    }

    /**
     * 插入操作
     */
    public static void insert(ListNode p, ListNode s){
        ListNode next = p.next;
        p.next = s;
        s.next = next;
    }

    /**
     * 删除操作
     * q:要删除的节点
     */
    public static void del(ListNode head, ListNode q){
        if (q != null && q.next != null){
            ListNode p = q.next; //要删除节点下一个节点p
            q.value = p.value; //把下一个节点值赋值给q
            //删除掉下一个节点
            q.next = p.next;
            p = null;
        }
        //删除最后一个元素的情况
        if (q.next == null){
            while (head != null){
                //遍历查找要删节点前一个节点
                if (head.next != null && head.next == q){
                    head.next = null;
                    break;
                }
                head = head.next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        traverse(node1);
        ListNode newHead = new ListNode(0);
        headInsert(node1, newHead);
        traverse(newHead);
        ListNode newTail = new ListNode(5);
        tailInsert(node3, newTail);
        traverse(node1);
        System.out.println(find(node1, 5));
        insert(node2, node4);
        traverse(node1);
        del(node1,node4);
        traverse(node1);


    }
}
