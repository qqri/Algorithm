import java.io.*;
import java.util.*;

class node{
    int val;
    node left , right;
    public node(int val) {
        this.val = val;
    }
}

public class Main {
    static List<List<Integer>> lists = new ArrayList<>();
    public static void main(String[] args) {
        node node = new node(3);
        node.left = new node(4);
        node.right = new node(5);
        node.left.left = new node(6);
        node.left.right = new node(7);
        node.right.left = new node(9);
        node.right.right = new node(10);

        solve(node);
        System.out.println(lists);
    }

    static int solve(node root) {
        int level = 1;
        Queue<node> q = new LinkedList<>();
        q.offer(root);
        int size = 0;
        while( !q.isEmpty() ) {
            List<Integer> list= new ArrayList<>();
            size = q.size();
            for(int i=0 ; i < size ; i++ ) {
                node cur = q.poll();
                list.add(cur.val);

                if(cur.left != null ) {
                    q.add(cur.left);
                }
                if(cur.right != null) {
                    q.add(cur.right);
                }
            }
            lists.add(list);
        }
        return level;
    }


}