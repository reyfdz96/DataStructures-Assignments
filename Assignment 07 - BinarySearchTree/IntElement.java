// from reference implementation of BST (with some modifications)
public class IntElement extends DataElement
{
    protected int num;

    public IntElement(){num = 0;}
    public IntElement(int x){num = x;}
    public IntElement(IntElement otherElement) {this.num = otherElement.num;}

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public boolean equals(DataElement otherElement) {
        IntElement temp = (IntElement) otherElement;
        return (num == temp.num);
    }

    public int compareTo(DataElement otherElement) {
        IntElement temp = (IntElement) otherElement;
        return (num - temp.num);
    }

    public void copy(DataElement otherElement) {
        IntElement temp = (IntElement) otherElement;
        num = temp.num;
    }

    public DataElement getCopy() {
        IntElement temp = new IntElement(num);
        return temp;
    }

    public String toString() {
        return String.valueOf(num);
    }
}