import java.util.EmptyStackException;

public class LinkedStack<E> {
    private Node<E> stackTop;
    private int size = 0;

    public LinkedStack() {
        stackTop = null;
    }

    public int size() {
        return size;
    }

    boolean empty() {
        return (stackTop == null);
    }

    public E peek() {
        if(empty()) throw new EmptyStackException();

        return stackTop.element;
    }

    public E pop() {
        if (empty()) throw new EmptyStackException();

        E temp = stackTop.element;
        stackTop = stackTop.next;
        size--;

        return temp;
    }

    public E push(E e) {
        stackTop = new Node<>(e, stackTop);
        size++;
        return stackTop.element;
    }

    public boolean contains(E e) {
        Node<E> current = stackTop;
        while (current.next != null) {
            if (current.element.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = stackTop;

        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;

            if (current != null) result.append(", ");
        }

        return result.append("]").toString();
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

    }

}
