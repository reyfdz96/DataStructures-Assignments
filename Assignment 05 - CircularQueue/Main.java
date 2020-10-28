import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(6);
        Random random = new Random();

        System.out.println("\n\nCREATING QUEUE");
        System.out.println("\nCreating queue of capacity " + q.getCapacity() + "...");
        printQueue(q);

        System.out.println("\n\nADDING TO QUEUE");

        for (int i = 0; i < q.getCapacity(); i++) {
            char hex = (char) (65 + i);
            System.out.println("\nAdding \'" + hex + "\' to rear of queue...");
            q.enqueue(hex);
            printQueue(q);
        }

        System.out.println("\n\nREMOVING FROM QUEUE");

        for (int i = 0; i < q.getCapacity() / 2; i++) {
            System.out.println("\nRemoving from front of queue...");
            q.dequeue();
            printQueue(q);
        }

        System.out.println("\n\nADDING TO QUEUE (AGAIN)");

        for (int i = 0; i < q.getCapacity() / 2; i++) {
            char hex = (char) (90 - i);
            System.out.println("\nAdding \'" + hex + "\' to rear of queue...");
            q.enqueue(hex);
            printQueue(q);
        }

        System.out.println("\n\nDELETING ELEMENT FROM QUEUE");

        for (int i = 0; i < q.getCapacity() / 2; i++) {
            int k = random.nextInt(q.size());
            System.out.println("\nDeleting \'" + q.delete(k) + "\' from queue...");
            printQueue(q);
        }

    }

    public static void printQueue(CircularQueue q) {
        System.out.println("Array(" + q.getCapacity() +"): " + Arrays.toString(q.getQueueArray()).replaceAll("null", "_"));
        System.out.println("Queue(" + q.size() + "): " + q);
    }
}
