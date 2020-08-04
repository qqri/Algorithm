package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 문제 이해를 못했었음.
// 이진트리의 depth 를 구하는 문제이다! 재귀, bfs, dfs 세가지 방법으로 풀이 가능.
class Node {
    int val;
    Node left, right;
    Node(int val) {
        this.val = val;
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        Node node = new Node(3);
        node.left = new Node(1);
        node.right = new Node(4);

        node.right.left = new Node(6);
        node.right.left = new Node(9);
        node.left.left = new Node(5);
        node.left.right = new Node(8);

        node.left.left.left = new Node(7);

        System.out.println(bfs(node));
    }

    public static int solve(Node node) {
        if(node == null) return 0;

        System.out.println(node.val);
        int leftMax = solve(node.left);
        int righthMax = solve(node.right);
        //끝에서 부터 다시 나온다고 생각
        return Math.max(leftMax, righthMax) + 1;
    }

    public static int dfs ( Node root ) {

        if(root == null) return 0;
        Stack<Node> stack = new Stack<>();
        Stack<Integer> val = new Stack<>();
        int max  = 0 ;
        stack.push(root);
        val.push(1);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            int cnt = val.pop();

            max = Math.max(cnt, max);

            if( node.left != null ) {
                stack.push(node.left);
                val.push(cnt+1);
            }
            if( node.right != null ) {
                stack.push(node.right);
                val.push(cnt+1);
            }

        }

        return max;
    }

    public static int bfs (Node root) { //FIFO 먼저 들어간 것 부터 뺀다.
        if(root == null) return 0;
        int cnt = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i =0 ; i < size ; i++ ) {
                Node node = q.poll();
                //일단 빼고
                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
                // 다시 넣음.
            }
            cnt++;
        }

        return cnt;
    }
}
