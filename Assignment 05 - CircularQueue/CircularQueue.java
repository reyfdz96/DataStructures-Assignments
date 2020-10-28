public class CircularQueue {
    private static final int DEFAULT_CAPACITY = 100;
    private int capacity, front, rear;
    private boolean enqueuedLast = false;
    private Object[] queue;

    public CircularQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new Object[capacity];
        front = rear = 0;
    }

    public int getCapacity() {
        return capacity;
    }

    // for demonstration purposes
    public Object[] getQueueArray() {
        return queue;
    }

    public int size() {
        if (isFull()) return capacity;
        return ((capacity - front + rear) % capacity);
    }

    public boolean isEmpty() {
        return (front == rear) && !enqueuedLast;
    }

    public boolean isFull() {
        return (front == rear) && enqueuedLast;
    }

    public Object getFrontElement() {
        return queue[front];
    }

    public Object getRearElement() {
        if (isEmpty()) return queue[front];
        return queue[rear-1];
    }

    public void enqueue(Object element) {
        if (isFull()) throw new QueueFullException("Queue is Full.");
        queue[rear] = element;
        rear = (rear + 1) % queue.length;
        enqueuedLast = true;
    }

    public Object dequeue() {
        if (isEmpty()) throw new QueueEmptyException("Cannot Dequeue: Queue is Empty.");

        Object dequeued = queue[front];
        queue[front] = null;

        front = (front + 1) % capacity;
        enqueuedLast = false;

        return dequeued;
    }

    public Object delete(int k) {
        if (isEmpty()) throw new QueueEmptyException("Cannot Delete: Queue is Empty.");

        if (k < 0) k = 0;
        else if (k >= size()) k = size()-1;

        int i, next;
        next = i = (front + k) % capacity;
        Object deleted = queue[i];

        while (i < capacity) {
            next = (i+1) % capacity;
            if (next == rear) break;
            queue[i] = queue[i = next];
        }

        queue[rear = i] = null;
        enqueuedLast = false;

        return deleted;
    }

    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder result = new StringBuilder("[");
        int next = front;

        for (int i = front; i < capacity; i = next) {
            result.append(queue[i]);
            next = (i + 1) % capacity;
            if (next == rear) break;
            else result.append(", ");
        }

        return result.append("]").toString();
    }

    public class QueueFullException extends RuntimeException {
        public QueueFullException(String msg) {
            super(msg);
        }
    }

    public class QueueEmptyException extends RuntimeException {
        public QueueEmptyException(String msg) {
            super(msg);
        }
    }

}
