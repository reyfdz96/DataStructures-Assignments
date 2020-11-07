// from reference implementation of BST (with some modifications)
public class BinarySearchTree extends BinaryTree{
    public BinarySearchTree() {
        super();
    }

    public BinarySearchTree(BinarySearchTree otherTree) {
        super(otherTree);
    }

    public boolean search(DataElement searchItem) {
        BinaryTreeNode current;
        boolean found = false;

        if (root == null)
            System.err.println("Cannot search an empty tree.");
        else {
            current = root;

            while (current != null && !found) {
                if (current.getElement().equals(searchItem)) {
                    found = true;
                } else if (current.getElement().compareTo(searchItem) > 0) {
                    current = current.getLeftChild();
                } else {
                    current = current.getRightChild();
                }
            }
        }

        return found;
    }

    public void insert(DataElement insertItem) {
        BinaryTreeNode current;
        BinaryTreeNode previous = null;
        BinaryTreeNode newNode = new BinaryTreeNode(insertItem.getCopy());

        if (root == null) {
            root = newNode;
        } else {
            current = root;

            while (current != null) {
                previous = current;

                if (current.getElement().equals(insertItem)) {
                    System.err.println("The insert item is already in the list "
                                        + "-- duplicates are not allowed.");
                    return;
                } else if (current.getElement().compareTo(insertItem) > 0) {
                    current = current.getLeftChild();
                } else {
                    current = current.getRightChild();
                }
            }

            if (previous.getElement().compareTo(insertItem) > 0)
                previous.setLeftChild(newNode);
            else
                previous.setRightChild(newNode);
        }
    }

    public void deleteNode(DataElement deleteItem) {
        BinaryTreeNode current;
        BinaryTreeNode previous;
        boolean found = false;

        if (root == null) {
            System.err.println("Cannot delete from the empty tree.");
        } else {
            current = root;
            previous = root;

            while (current != null && !found) {
                if (current.getElement().equals(deleteItem)) {
                    found = true;
                } else {
                    previous = current;

                    if (current.getElement().compareTo(deleteItem) > 0)
                        current = current.getLeftChild();
                    else
                        current = current.getRightChild();
                }
            }

            if (current == null) {
                System.err.println("The delete item is not in the list.");
            } else if (found) {
                if (current == root) {
                    root = deleteFromTree(root);
                } else if (previous.getElement().compareTo(deleteItem) > 0) {
                    previous.setLeftChild(deleteFromTree(previous.getLeftChild()));
                } else {
                    previous.setRightChild(deleteFromTree(previous.getRightChild()));
                }
            }
        }
    }

    private BinaryTreeNode deleteFromTree(BinaryTreeNode n) {
        if (n == null) {
            System.err.println("Error: The Node to be deleted is null.");
        } else if (n.getLeftChild() == null && n.getRightChild() == null) {
            n = null;
        } else if (n.getLeftChild() == null) {
            n = n.getRightChild();
        } else if (n.getRightChild() == null) {
            n = n.getLeftChild();
        } else {
            BinaryTreeNode current = n.getLeftChild();
            BinaryTreeNode previous = null;

            while (current.getRightChild() != null) {
                previous = current;
                current = current.getRightChild();
            }

            n.setElement(current.getElement());

            if (previous == null)
                n.setLeftChild(current.getLeftChild());
            else
                previous.setRightChild(current.getLeftChild());
        }
        return n;
    }
}
