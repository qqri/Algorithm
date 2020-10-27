import java.util.*;

class BiTree {
    int data;
    BiTree left, right;
    public BiTree(int data) {
        this.data = data;
    }
}
public class BinaryTree {
    public static void main(String[] args) {
        int num = 15;
        BiTree nodes[] = new BiTree[num+1];

        for(int i = 1 ; i <= num ; i++ ) {
            BiTree node = new BiTree(i);
            node.left = null;
            node.right = null;
            nodes[i] = node;
        }

        for(int i = 2 ; i <= num ; i++ ) {
            if( i % 2 == 0 ) {
                nodes[i/2].left = nodes[i];
            } else {
                nodes[i/2].right = nodes[i];
            }
        }

        preorder(nodes[1]);
        System.out.println();
        inorder(nodes[1]);
        System.out.println();
        postorder(nodes[1]);


    }

    static void preorder(BiTree ptr) {
        if(ptr != null) {
            System.out.print(ptr.data + " ");
            preorder(ptr.left);
            preorder(ptr.right);
        }
    }

    static void inorder(BiTree ptr) {
        if(ptr != null) {
            inorder(ptr.left);
            System.out.print(ptr.data + " ");
            inorder(ptr.right);
        }
    }

    static void postorder(BiTree ptr) {
        if(ptr != null) {
            postorder(ptr.left);
            postorder(ptr.right);
            System.out.print(ptr.data + " ");
        }
    }

}
