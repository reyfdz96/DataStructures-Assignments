/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author scobo
 */
/** class for nodes used in a binary tree */

public class BinaryTreeNode
{
   // package visible data members
   Object element;
   BinaryTreeNode leftChild;    // left subtree
   BinaryTreeNode rightChild;   // right subtree
   
   // constructors
   public BinaryTreeNode() {}
        
   public BinaryTreeNode(Object theElement)
      {element = theElement;}
        
   public BinaryTreeNode(Object theElement,
                         BinaryTreeNode theleftChild,
                         BinaryTreeNode therightChild)
   {
       element = theElement;
       leftChild = theleftChild;
       rightChild = therightChild;
   }

   // accessor methods
   public BinaryTreeNode getLeftChild() {return leftChild;}
   public BinaryTreeNode getRightChild() {return rightChild;}
   public Object getElement() {return element;}

   // mutator methods
   public void setLeftChild(BinaryTreeNode theLeftChild)
      {leftChild = theLeftChild;}
   public void setRightChild(BinaryTreeNode theRightChild)
      {rightChild = theRightChild;}
   public void setElement(Object theElement)
      {element = theElement;}

   // output method
   public String toString()
      {return element.toString();}
}
