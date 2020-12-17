// from Sahni implementation of BST
/** binary search tree */

public class BinarySearchTree extends LinkedBinaryTree
                              implements BSTree
{
   // top-level nested class
   static class Data
   {
      // data members
      Object element;   // element in node
      Comparable key;   // its key

      // constructor
      Data(Comparable theKey, Object theElement)
      {
         key = theKey;
         element = theElement;
      }

      public String toString()
         {return element.toString();}
   }

   /** @return element with specified key
     * @return null if no matching element */
   public Object get(Object theKey)
   {
      // pointer p starts at the root and moves through
      // the tree looking for an element with key theKey
      BinaryTreeNode p = root;
      Comparable searchKey = (Comparable) theKey;
      while (p != null)
         // examine p.element.key
         if (searchKey.compareTo(((Data) p.element).key) < 0)
            p = p.leftChild;
         else
            if (searchKey.compareTo(((Data) p.element).key) > 0)
               p = p.rightChild;
            else // found matching element
               return ((Data) p.element).element;

      // no matching element
      return null;
   }

   /** insert an element with the specified key
     * overwrite old element if there is already an
     * element with the given key
     * @return old element (if any) with key theKey */
   public Object put(Object theKey, Object theElement)
   {
      BinaryTreeNode p = root,     // search pointer
                     pp = null;    // parent of p
      Comparable elementKey = (Comparable) theKey;
      // find place to insert theElement
      while (p != null)
      {// examine p.element.key
         pp = p;
         // move p to a child
         if (elementKey.compareTo(((Data) p.element).key) < 0)
            p = p.leftChild;
         else if (elementKey.compareTo(((Data) p.element).key) > 0)
                 p = p.rightChild;
              else
              {// overwrite element with same key
                 Object elementToReturn = ((Data) p.element).element;
                 ((Data) p.element).element = theElement;
                 return elementToReturn;
              }
      }

      // get a node for theElement and attach to pp
      BinaryTreeNode r = new BinaryTreeNode
                             (new Data(elementKey, theElement));
      if (root != null)
         // the tree is not empty
         if (elementKey.compareTo(((Data) pp.element).key) < 0)
            pp.leftChild = r;
         else
            pp.rightChild = r;
      else // insertion into empty tree
         root = r;
      return null;
   }

   /** @return matching element and remove it
     * @return null if no matching element */
   public Object remove(Object theKey)
   {
      Comparable searchKey = (Comparable) theKey;

      // set p to point to node with key searchKey
      BinaryTreeNode p = root,    // search pointer
                     pp = null;   // parent of p
      while (p != null && !((Data) p.element).key.equals(searchKey))
      {// move to a child of p
         pp = p;
         if (searchKey.compareTo(((Data) p.element).key) < 0)
            p = p.leftChild;
         else
            p = p.rightChild;
      }

      if (p == null) // no element with key searchKey
         return null;

      // save element to be removed
      Object theElement = ((Data) p.element).element;

      // restructure tree
      // handle case when p has two children
      if (p.leftChild != null && p.rightChild != null)
      {// two children
         // convert to zero or one child case
         // find element with largest key in left subtree of p
         BinaryTreeNode s = p.leftChild,
                        ps = p;  // parent of s
         while (s.rightChild != null)
         {// move to larger element
            ps = s;
            s = s.rightChild;
         }

         // move largest element from s to p
         p.element = s.element;
         p = s;
         pp = ps;
      }

      // p has at most one child, save this child in c
      BinaryTreeNode c;
      if (p.leftChild == null)
         c = p.rightChild;
      else
         c = p.leftChild;

      // remove node p
      if (p == root) root = c;
      else
      {// is p left or right child of pp?
         if (p == pp.leftChild)
            pp.leftChild = c;
         else
            pp.rightChild = c;
      }

      return theElement;
   }

   /** output elements in ascending order of key */
   public void ascend()
      {inOrderOutput();}

   public void displayItemsInRange(int l, int w)
      {displayItemsInRange(root, new Integer(l), new Integer(w));}

   private void displayItemsInRange(BinaryTreeNode t, Comparable l, Comparable w)
   {
      if (t != null) {
         if (l.compareTo(((Data) t.element).key) >= 0)
            displayItemsInRange(t.rightChild, l, w);
         else if (w.compareTo(((Data) t.element).key) <= 0)
            displayItemsInRange(t.leftChild, l, w);
         else {
            displayItemsInRange(t.leftChild, l, w);
            System.out.print(t.element + " ");
            displayItemsInRange(t.rightChild, l, w);
         }
      }
   }

   public Object split(
      int theKey,
      BinarySearchTree lessThan,
      BinarySearchTree greaterThan)
   {
      BinaryTreeNode foundNode = new BinaryTreeNode();
      split(new Integer (theKey), foundNode, root, lessThan, greaterThan);
      this.root = null;
      return foundNode.getElement();
   }

   private void split(
      Comparable theKey,
      BinaryTreeNode foundNode,
      BinaryTreeNode t,
      BinarySearchTree lessThan,
      BinarySearchTree greaterThan)
   {
      if (t != null) {
         Comparable curKey = ((Data) t.element).key;
         if (theKey.compareTo(curKey) > 0)
            lessThan.put(curKey, t.element);
         else if (theKey.compareTo(curKey) < 0)
            greaterThan.put(curKey, t.element);
         else
            foundNode.setElement(t.getElement());
         split(theKey, foundNode, t.leftChild, lessThan, greaterThan);
         split(theKey, foundNode, t.rightChild, lessThan, greaterThan);
      }
   }

}