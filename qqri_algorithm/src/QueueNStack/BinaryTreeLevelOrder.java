package QueueNStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int x){
        this.val = x;
    }
}
public class BinaryTreeLevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(7);

        System.out.println(solve(root));
    }

    public static List<List<Integer>> solve(TreeNode root) {
        //1
        List<List<Integer>> result = new ArrayList<>();
        if(root == null ) return result;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        //2
        while(!que.isEmpty()) {
            int size = que.size();
            List<Integer> list = new ArrayList<>();

            for(int i = 0 ; i < size ; i++ ){
                TreeNode node = que.poll(); // FIFO 니까 첫번째꺼 나옴 -> 여기서 한번 뺀다. -> 이따 왼쪽부터 넣으니까 bfs
                list.add(node.val);

                if(node.left != null) {
                    que.offer( node.left ); //왼쪽 넣음
                }
                if(node.right != null) {
                    que.offer( node.right ); // 오른쪽 넣음
                }
            }
            result.add(list);
        }

        return result;
    }
}
