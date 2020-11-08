
public class BinarySearchTree extends BinaryTree
{
       //default constructor
       //Postcondition: root = null;
    public BinarySearchTree()
    {
        super();
    }

       //copy constructor
    public BinarySearchTree(BinarySearchTree otherTree)
    {
        super(otherTree);
    }

       //Method to determine whether searchItem is in the binary
       //search tree.
       //Postcondition: Returns true if searchItem is found in the
       //               binary search tree; otherwise, returns false.
    public boolean search(DataElement searchItem)
    {
        BinaryTreeNode current;
        boolean found = false;

        if(root == null)
           System.out.println("Cannot search an empty tree.");
        else
        {
           current = root;

           while(current != null && !found)
           {
               if(current.info.equals(searchItem))
                  found = true;
               else
                  if(current.info.compareTo(searchItem) > 0)
                     current = current.llink;
                  else
                     current = current.rlink;
           }//end while
        }//end else

        return found;
    }//end search

       //Method to insert insertItem in the binary search tree.
       //Postcondition: If no node in the binary search tree has
       //               the same info as insertItem, a node with
       //               the info insertItem is created and inserted
       //               in the binary search tree.
    public void insert(DataElement insertItem)
    {
        BinaryTreeNode current;      //reference variable to
                                     //traverse the tree
        BinaryTreeNode trailCurrent = null; //reference variable
                                     //behind current
        BinaryTreeNode newNode;      //reference variable to
                                     //create the node

        newNode = new BinaryTreeNode();

        newNode.info = insertItem.getCopy();
        newNode.llink = null;
        newNode.rlink = null;

        if(root == null)
           root = newNode;
        else
        {
           current = root;

           while(current != null)
           {
               trailCurrent = current;

               if(current.info.equals(insertItem))
               {
                  System.err.print("The insert item is already in "
                                 + "the list -- duplicates are "
                                 + "not allowed.");
                  return;
               }
               else
                  if(current.info.compareTo(insertItem) > 0)
                     current = current.llink;
                  else
                     current = current.rlink;
           }//end while

           if(trailCurrent.info.compareTo(insertItem) > 0)
              trailCurrent.llink = newNode;
           else
              trailCurrent.rlink = newNode;
       }
    }//end insert

       //Method to delete deleteItem from the binary search tree
       //Postcondition: If a node with the same info as deleteItem
       //               is found, it is deleted from the binary
       //               search tree.
    public void deleteNode(DataElement deleteItem)
    {
        BinaryTreeNode current;  //reference variable to
                                  //traverse the tree
        BinaryTreeNode trailCurrent; //reference variable
                                      //behind current
        boolean found = false;

        if(root == null)
            System.err.println("Cannot delete from the empty tree.");
        else
        {
            current = root;
            trailCurrent = root;

            while(current != null && !found)
            {
                if(current.info.equals(deleteItem))
                   found = true;
                else
                {
                   trailCurrent = current;

                   if(current.info.compareTo(deleteItem) > 0)
                      current = current.llink;
                   else
                      current = current.rlink;
                }
            }//end while

            if(current == null)
               System.out.println("The delete item is not in "
                                + "the list.");
            else
               if(found)
               {
                  if(current == root)
                     root = deleteFromTree(root);
                  else
                     if(trailCurrent.info.compareTo(deleteItem) > 0)
                        trailCurrent.llink = deleteFromTree(trailCurrent.llink);
                     else
                        trailCurrent.rlink = deleteFromTree(trailCurrent.rlink);
                }//end if
        }
    }//end deleteNode

       //Method to delete the node, to which p points, from the
       //binary search tree.
       //Postcondition: The node to which p points is deleted
       //               from the binary search tree. The reference
       //               of the root node of the binary search tree
       //               after deletion is returned.
    private BinaryTreeNode deleteFromTree(BinaryTreeNode p)
    {
         BinaryTreeNode current;        //reference variable to
                                        //traverse the tree
         BinaryTreeNode trailCurrent;   //reference variable
                                        //behind current
         if(p == null)
            System.err.println("Error: The node to be deleted "
                             + "is null.");
         else if(p.llink == null && p.rlink == null)
                 p = null;
         else if(p.llink == null)
                 p = p.rlink;
         else if(p.rlink == null)
                 p = p.llink;
         else
         {
            current = p.llink;
            trailCurrent = null;

            while(current.rlink != null)
            {
                trailCurrent = current;
                current = current.rlink;
            }//end while

            p.info = current.info;

            if(trailCurrent == null) //current did not move;
                                     //current == p.llink; adjust p
               p.llink = current.llink;
            else
               trailCurrent.rlink = current.llink;
          }//end else

        return p;
    }//end deleteFromTree
}