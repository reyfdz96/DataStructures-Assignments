// from reference implementation of BST (with some modifications)
public class BinaryTree {

    protected BinaryTreeNode root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(BinaryTree otherTree) {
        if(otherTree.root == null)
            this.root = null;
        else
            this.root = makeCopy(otherTree.root);
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public void swapTree(){swapTree(root);}
    public void destroyTree() {root = null;}
    public void levelorderTravesal() {levelorder(root);}
    public void inorderTraversal() {inorder(root);}
    public void preorderTraversal() {preorder(root);}
    public void postorderTraversal() {postorder(root);}
    public int treeHeight() {return height(root);}
    public int treeNodeCount() {return nodeCount(root);}
    public int treeLeavesCount() {return leavesCount(root);}
    public int treeSingleParentCount(){return singleParent(root);}

    //turns this tree into a copy of parameter tree
    public void copy(BinaryTree otherTree) {
        if (this != otherTree) {
            root = null;

            if (otherTree.root != null)
                this.root = makeCopy(otherTree.root);
        }
    }

    //returns a copy of given node and its children
    private BinaryTreeNode makeCopy(BinaryTreeNode otherTreeRoot) {
        BinaryTreeNode temp;

        if(otherTreeRoot == null) {
            temp = null;
        } else {
            temp = new BinaryTreeNode();
            temp.setElement(otherTreeRoot.getElement().getCopy());
            temp.setLeftChild(makeCopy(otherTreeRoot.getLeftChild()));
            temp.setRightChild(makeCopy(otherTreeRoot.getRightChild()));
        }

        return temp;
    }

    private void inorder(BinaryTreeNode n) {
        if (n != null) {
            inorder(n.getLeftChild());
            System.out.print(n.getElement() + " ");
            inorder(n.getRightChild());
        }
    }

    private void preorder(BinaryTreeNode n) {
        if (n != null) {
            System.out.print(n.getElement() + " ");
            preorder(n.getLeftChild());
            preorder(n.getRightChild());
        }
    }

    private void postorder(BinaryTreeNode n) {
        if (n != null) {
            postorder(n.getLeftChild());
            postorder(n.getRightChild());
            System.out.print(n.getElement() + " ");
        }
    }

    private int height(BinaryTreeNode n) {
        if (n == null) return 0;
        return 1 + max(height(n.getLeftChild()), height(n.getRightChild()));
    }

    private int max(int x, int y) {
        return x >= y ? x : y;
    }

    private int nodeCount(BinaryTreeNode n) {
        if (n == null) return 0;
        return 1 + nodeCount(n.getLeftChild()) + nodeCount(n.getRightChild());
    }

    private int leavesCount(BinaryTreeNode n) {
        if (n == null) return 0;

        if (n.getLeftChild() == null && n.getRightChild() == null) {
            System.out.print(n + " ");
            return 1;
        }

        return 0 + (leavesCount(n.getLeftChild()) + leavesCount(n.getRightChild()));

    }

    private int singleParent(BinaryTreeNode n) {
        if (n == null) return 0;
        if (n.getLeftChild() == null ^ n.getRightChild() == null) return 1;

        return 0 + singleParent(n.getLeftChild()) + singleParent(n.getRightChild());
    }

    private void swapTree(BinaryTreeNode n) {
        if (n != null) {
            BinaryTreeNode temp = n.getLeftChild();
            n.setLeftChild(n.getRightChild());
            n.setRightChild(temp);
            swapTree(n.getLeftChild());
            swapTree(n.getRightChild());
        }
    }

    /* * * * * * * *\
     * QUESTION #7 *
    \* * * * * * * */

    // from https://www.geeksforgeeks.org/level-order-tree-traversal/
    private void levelorder(BinaryTreeNode n) {
        int height = height(n);

        for (int i = 1; i <= height; i++) {
            printLevel(n, i);
        }
    }

    private void printLevel(BinaryTreeNode n, int level) {
        if (n == null) return;
        if (level == 1) {
            System.out.print(n + "(" + getLevel(root, n) + ") ");
        } else if (level > 1) {
            printLevel(n.getLeftChild(), level-1);
            printLevel(n.getRightChild(), level-1);
        }
    }

    // from https://www.geeksforgeeks.org/get-level-of-a-node-in-a-binary-tree/
    private int getLevel(BinaryTreeNode rootNode, BinaryTreeNode node) {
        return getLevel(rootNode, node, 1);
    }

    private int getLevel(BinaryTreeNode rootNode, BinaryTreeNode node, int level) {
        if (rootNode == null) return 0;
        if (rootNode == node) return level;

        int downLevel = getLevel(rootNode.getLeftChild(), node, level+1);
        if (downLevel != 0) return downLevel;

        downLevel = getLevel(rootNode.getRightChild(), node, level+1);
        return downLevel;
    }
}