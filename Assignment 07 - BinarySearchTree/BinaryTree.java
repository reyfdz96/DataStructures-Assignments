// from reference implementation of BST

public class BinaryTree
{

      //Definition of the node
   protected class BinaryTreeNode
   {
      DataElement info;
      BinaryTreeNode llink;
      BinaryTreeNode rlink;
   }

   protected BinaryTreeNode root;

      //default constructor
      //Postcondition: root = null;
   public BinaryTree()
   {
      root = null;
   }

      //copy constructor
   public BinaryTree(BinaryTree otherTree)
   {
      if(otherTree.root == null) //otherTree is empty
         root = null;
      else
         root = copy(otherTree.root);
   }

      //Method to determine whether the binary tree is empty.
      //Postcondition: Returns true if the binary tree is empty;
      //               otherwise, returns false.
   public boolean isEmpty()
   {
      return (root == null);
   }

   public void swapTree() {
      swapTree(root);
   }

      //Method to do an inorder traversal of the binary tree.
      //Postcondition: The nodes of the binary tree are output
      //               in the inorder sequence.
   public void inorderTraversal()
   {
      inorder(root);
   }

      //Method to do a preorder traversal of the binary tree.
      //Postcondition: The nodes of the binary tree are output
      //               in the preorder sequence.
   public void preorderTraversal()
   {
      preorder(root);
   }

      //Method to do a postorder traversal of the binary tree.
      //Postcondition: The nodes of the binary tree are output
      //               in the postorder sequence.
   public void postorderTraversal()
   {
      postorder(root);
   }

   public void levelorderTravesal() {
      levelorder(root);
   }

      //Method to determine the height of the binary tree.
      //Postcondition: The height of the binary tree is returned.
   public int treeHeight()
   {
      return height(root);
   }

      //Method to determine the number of nodes in the
      //binary tree.
      //Postcondition: The number of nodes in the binary tree
      //               is returned.
   public int treeNodeCount()
   {
      return nodeCount(root);
   }

      //Method to determine the number of leaves in the
      //binary tree.
      //Postcondition: The number of leaves in the binary tree
      //               is returned.
   public int treeLeavesCount()
   {
      return leavesCount(root);
   }

   public int treeSingleParentCount() {
      return singleParent(root);
   }

      //Method to destroy the binary tree.
      //Postcondition: root = null
   public void destroyTree()
   {
      root = null;
   }

      //Method to make a copy of the binary tree
      //specified by otherTree points.
      //Postcondition: A copy of otherTree is assigned to
      //               this binary tree.
   public void copyTree(BinaryTree otherTree)
   {

      if(this != otherTree) //avoid self-copy
      {
         root = null;

         if(otherTree.root != null) //otherTree is nonempty
            root = copy(otherTree.root);
      }

   }

      //Method to make a copy of the binary tree to
      //which otherTreeRoot points.
      //Postcondition: A copy of the binary tree to which
      //               otherTreeRoot is created and the reference of
      //               the root node of the copied binary tree
      //               is returned.
   private BinaryTreeNode copy(BinaryTreeNode otherTreeRoot)
   {
      BinaryTreeNode temp;

      if(otherTreeRoot == null)
         temp = null;
      else
      {
         temp = new BinaryTreeNode();
         temp.info = otherTreeRoot.info.getCopy();
         temp.llink = copy(otherTreeRoot.llink);
         temp.rlink = copy(otherTreeRoot.rlink);
      }

      return temp;
   }//end copy

      //Method to do an inorder traversal of the binary
      //tree to which p points.
      //Postcondition: The nodes of the binary tree to which p
      //               points are output in the inorder sequence.
   private void inorder(BinaryTreeNode p)
   {
      if(p != null)
      {
         inorder(p.llink);
         System.out.print(p.info + " ");
         inorder(p.rlink);
      }
   }

      //Method to do a preorder traversal of the binary
      //tree to which p points.
      //Postcondition: The nodes of the binary tree to which p
      //               points are output in the preorder sequence.
   private void preorder(BinaryTreeNode p)
   {
      if(p != null)
      {
         System.out.print(p.info + " ");
         preorder(p.llink);
         preorder(p.rlink);
      }
   }

      //Method to do a postorder traversal of the binary
      //tree to which p points.
      //Postcondition: The nodes of the binary tree to which p
      //               points are output in the postorder sequence.
   private void postorder(BinaryTreeNode p)
   {
      if(p != null)
      {
         postorder(p.llink);
         postorder(p.rlink);
         System.out.print(p.info + " ");
      }
   }

      //Method to determine the height of the binary tree
      //to which p points.
      //Postcondition: The height of the binary tree to which p
      //               points is returned.
   private int height(BinaryTreeNode p)
   {
      if(p == null)
         return 0;
      else
         return 1 + max(height(p.llink), height(p.rlink));
   }

      //Method to determine the larger of x and y.
      //Postcondition: The larger of x and y is returned.
   private int max(int x, int y)
   {
      if(x >= y)
         return x;
      else
         return y;
   }

      //Method to determine the number of nodes in the binary
      //tree to which p points.
      //Postcondition: The number of nodes in the binary tree
      //               to which p points is returned.
   private int nodeCount(BinaryTreeNode p) {
      if (p == null)
         return 0;
      return 1 + nodeCount(p.llink) + nodeCount(p.rlink);
   }

      //Method to determine the number of leaves in the binary
      //tree to which p points.
      //Postcondition: The number of leaves in the binary tree
      //               to which p points is returned.
   private int leavesCount(BinaryTreeNode n) {
      if (n == null)
         return 0;

      if (n.llink == null && n.rlink == null) {
         System.out.print(n.info + " ");
         return 1;
      }

      return 0 + (leavesCount(n.llink) + leavesCount(n.rlink));

   }

   private int singleParent(BinaryTreeNode n) {
      if (n == null)
         return 0;
      if (n.llink == null ^ n.rlink == null)
         return 1;

      return 0 + singleParent(n.llink) + singleParent(n.rlink);
   }

   private void swapTree(BinaryTreeNode n) {
      if (n != null) {
         BinaryTreeNode temp = n.llink;
         n.llink = n.rlink;
         n.rlink = temp;
         swapTree(n.llink);
         swapTree(n.rlink);
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
            System.out.print(n.info + "(" + getLevel(root, n) + ") ");
        } else if (level > 1) {
            printLevel(n.llink, level-1);
            printLevel(n.rlink, level-1);
        }
    }

    // from https://www.geeksforgeeks.org/get-level-of-a-node-in-a-binary-tree/
    private int getLevel(BinaryTreeNode rootNode, BinaryTreeNode node) {
        return getLevel(rootNode, node, 1);
    }

    private int getLevel(BinaryTreeNode rootNode, BinaryTreeNode node, int level) {
        if (rootNode == null) return 0;
        if (rootNode == node) return level;

        int downLevel = getLevel(rootNode.llink, node, level+1);
        if (downLevel != 0) return downLevel;

        downLevel = getLevel(rootNode.rlink, node, level+1);
        return downLevel;
    }
}