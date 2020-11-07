// Taken from reference implementation of BST (with some modifications)
public abstract class DataElement {
    public abstract boolean equals(DataElement otherElement);
    public abstract int compareTo(DataElement otherElement);
    public abstract void copy(DataElement otherElement);
    public abstract DataElement getCopy();
}