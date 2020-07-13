package LinkedList;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }
}
public class AddTwoNumbers {
    public static void main(String[] args) {
        //1 Node 직접 구현
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(2);

        ListNode node = solve(l1, l2);
        while( node != null) {
            System.out.println(node.val);
            node = node.next;
        }

        System.out.println();
        //2 ArrayList 방식
        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        num1.add(2); num1.add(4); num1.add(3);
        num2.add(5); num2.add(6); num2.add(4);

        if(num1.size() >= num2.size()) {
            result = solve1(num1, num2);
        }else{
            result = solve1(num2, num1);
        }

        for(int i : result){
            System.out.println(i);
        }

    }

    public static ListNode solve(ListNode l1, ListNode l2){
        ListNode NewHead = new ListNode(0);
        ListNode p1,p2,p3;
        p1 = l1; p2 = l2; p3 = NewHead;
        int carry = 0;

        while (p1 != null || p2!= null) {
            if(p1 != null ) {
                carry += p1.val;
                p1 = p1.next;
            }
            if(p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }
            p3.next = new ListNode(carry%10);
            p3 = p3.next;
            carry /= 10; // 몫만 남겨두고 넘긴다.
        }

        return NewHead.next;
    }

    public static List<Integer> solve1(List<Integer> num1,List<Integer> num2 ){
        //1
        List<Integer> result = new ArrayList<>();

        //2 -> num1 이 num2 보다 사이즈 더 큼.
        for(int i = 0 ;i < num2.size() ; i ++ ){
            int cur = num1.get(i) + num2.get(i);
            if(cur >= 10) {
                result.add(cur-10);
                num1.set(i+1, num1.get(i+1)+1 );
            } else {
                result.add(cur);
            }
        }

        if(num1.size() != num2.size()) {
            for(int i = num2.size(); i < num1.size()-1 ; i++ ){
                int cur = num1.get(i) + num2.get(i);
                if(num1.get(i) >=10 ) {
                    result.add(cur-10);
                    num1.set(i+1, num1.get(i+1)+1 );
                } else {
                    result.add(cur);
                }
            }

            if( num1.get(num1.size()-1) >= 10 )  {
                result.add( num1.get(num1.size()-1)-10 );
                result.add(1);
            }
        }

        return result;
    }
}
