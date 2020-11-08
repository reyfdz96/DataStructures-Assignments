// from reference implementation of BST
import java.util.Random;

public class BinarySearchTreeProgram {
    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree();
        Random random = new Random();
        int size = random.nextInt(10);

        System.out.println("\nBinarySearchTree created.");

        for (int i = 0; i < size; i++) {
            int num = random.nextInt(100);
            System.out.println("Inserting " + num + "...");
            t.insert(new IntElement(num));
        }
        System.out.println("");
        printTree(t);
        t.swapTree();
        System.out.println("\nSWAP!\n");
        printTree(t);

        System.out.println("\n[!] Run again for different results.\n");
    }

    public static void printTree(BinaryTree t) {
        System.out.print("BINARY TREE DESCRIPTION:");
        System.out.print("\nisEmpty:      " + t.isEmpty());
        System.out.print("\nTree height:  " + t.treeHeight());
        System.out.print("\nInorder:      "); t.inorderTraversal();
        System.out.print("\nPreorder:     "); t.preorderTraversal();
        System.out.print("\nPostorder:    "); t.postorderTraversal();

        System.out.print("\n===ASSIGNMENT===");
        System.out.print("\nnodeCount:    " + t.treeNodeCount());
        System.out.print("\nleavesCount:  ");
        int leaves = t.treeLeavesCount();
        System.out.print("(" + leaves + ")");
        System.out.print("\nsingleParent: " + t.treeSingleParentCount());
        System.out.print("\nlevelOrder:   "); t.levelorderTravesal();
        System.out.println("");
    }

}
