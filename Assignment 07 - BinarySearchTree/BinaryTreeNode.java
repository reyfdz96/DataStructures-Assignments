// from Sahni's implementation of BST
public class BinaryTreeNode {
    private DataElement element;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    public BinaryTreeNode() {}

    public BinaryTreeNode(DataElement element) {
        this.element = element;
    }

    public BinaryTreeNode(DataElement element,
                          BinaryTreeNode leftChild,
                          BinaryTreeNode rightChild)
    {
        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public DataElement getElement() {return element;}
    public BinaryTreeNode getLeftChild() {return leftChild;}
    public BinaryTreeNode getRightChild() {return rightChild;}

    public void setElement(DataElement element) {this.element = element;}
    public void setLeftChild(BinaryTreeNode leftChild) {this.leftChild = leftChild;}
    public void setRightChild(BinaryTreeNode rightChild) {this.rightChild = rightChild;}

    public String toString() {return element.toString();}
}
