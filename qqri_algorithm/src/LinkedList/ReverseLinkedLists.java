package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;


public class ReverseLinkedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ReverseLinkedLists rs = new ReverseLinkedLists();
        ListNode result = rs.reverseList(l1);

        while( result != null ) {
            System.out.println(result.val);
            result = result.next;
        }

    }
    public static ListNode reverseList(ListNode current) {
        ListNode prev = null;
        ListNode next = null;
        while(current !=null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public ListNode solve(ListNode l1) {

        PriorityQueue<ListNode> que = new PriorityQueue<ListNode>(Comp);
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;

        que.offer(l1);
        while( !que.isEmpty() ) {
            ListNode node = que.poll();

            p.next = node;
            p = p.next;

            if(node.next != null) que.offer(node.next); //que에 넣으면서 우선순위 큐이기 때문에 정렬된다.
        }

        return newHead.next;

//        que.offer(l1);
//        ListNode newHead = que.poll();
//        return  newHead;
    }

    Comparator<ListNode> Comp = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o2.val-o1.val;
        }
    };
}