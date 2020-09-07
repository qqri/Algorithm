package Sep2;


import StringArray.TrappingRainWater;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode2{
    int val;
    TreeNode2 left, right;

    TreeNode2(int x) {
        this.val = x;
    }
}

public class Q5 {
    public static void main(String[] args) {
        int[] tree = {3,9,20,15,7};
        // 깊이 재는거
        TreeNode2 root = new TreeNode2(3);
        root.left = new TreeNode2(9);
        root.right = new TreeNode2(20);
        root.right.left = new TreeNode2(15);
        root.right.right = new TreeNode2(7);

        System.out.println( solve(root) );
    }

    static int solve(TreeNode2 root) {
        Queue<TreeNode2> que = new LinkedList<>();
        int depth=0;
        que.offer(root);

        //양쪽 꺼낼때 어떻게 재야 하는 지 모르겠음,
        while(!que.isEmpty()) {

            int size = que.size(); // 얼마나 원하는 만큼 for 문을 돌릴지 생각각해보기

            for(int i = 0 ; i < size ; i++ ) {
                TreeNode2 cur = que.poll();
                if(cur.left != null ) que.offer(cur.left);
                if(cur.right != null ) que.offer(cur.right);
            }

            depth++;
        }

        return depth;
    }

}
