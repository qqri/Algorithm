package LinkedList;

import StringArray.MergeInterval;

import java.util.*;


public class MergekSortedLists {
    public static void main(String[] args) {
        //1->4->5,   1->3->4,   2->6
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        MergekSortedLists ms = new MergekSortedLists();
        ListNode list =  ms.solve(lists);

        while (list!=null) {
            System.out.println(list.val);
            list = list.next;
        }
    }
    public ListNode solve(ListNode[] lists ) {
        //1
        PriorityQueue<ListNode> que = new PriorityQueue<ListNode>(Comp);
        ListNode newHead = new ListNode(0);
        ListNode p = newHead; // 이렇게만 해도 p랑 newHead랑 같은 값 공유
        for(ListNode node : lists) {
            if (node != null) que.offer(node);
        }

        //2
        while( !que.isEmpty() ) {
            ListNode node = que.poll();

            System.out.print("" + node.val +  "\t");
            p.next = node;
            p = p.next;

            if(node.next != null) que.offer(node.next); //que에 넣으면서 우선순위 큐이기 때문에 정렬된다.
        }


        return newHead.next;
    }
    Comparator<ListNode> Comp = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    };
/*
* 모르겠는 부분
* 1. 어떻게 중간에 값을 삽입할 수 있는지? -> 우선순위 큐로 이용
* 2. 아아 ? 중간에 링크드 리스트 처럼 한다 ?
* 3. result 초반으로 돌리기 어떻게 ?? -> 노드끼리 같은값 공유 가능
* */
    public static ListNode solve1(ListNode[] lists) {
        ListNode result = new ListNode(0);
        for(int i = 0 ; i < lists.length ; i++ ) {
            ListNode current = lists[i];
            while( current != null ){
                while( result != null) {
                    if (current.val < result.val) {
                        int temp = result.val;
                        result.val = current.val;
                        result.next = new ListNode(temp);
                    }
                    //크거나 같은 경우 그냥 뒤에 붙이면 됨.
                    else {
                        result.next = new ListNode(current.val);
                    }
                    result = result.next;
                }

                current  = current.next;
            }

        }

        return result.next;
    }


}
//    public ListNode mergeKLists(ListNode[] lists) {
//
//    }