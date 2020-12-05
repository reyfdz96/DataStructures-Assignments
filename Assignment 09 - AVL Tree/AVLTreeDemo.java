import java.util.Iterator;
import java.util.Scanner;

public class AVLTreeDemo {
    public static void main(String[] args) {
        AVLTree<Integer> t = new AVLTree<>();
        Scanner scan = new Scanner(System.in);
        int n = 0;

        while (n < 10) {
            System.out.print("How many numbers do you wish to enter (n >= 10)? n = ");
            try {
                n = Integer.valueOf(scan.nextLine());
            } catch (Exception e) {
                n = 0;
            }
        }

        String format = "%" + String.valueOf(n).length() + "d";

        for (int i = 0; i < n; i++) {
            String current = String.format(format, i+1);
            int num = 0;

            while (true) {
                System.out.print("Element " + current + ": ");
                try {
                    num = Integer.valueOf(scan.nextLine());
                } catch (Exception e) {
                    continue;
                }
                break;
            }

            t.insert(num);
        }

        printTree(t);
        System.out.println();

        while (true) {
            System.out.print("What kth smallest number do you wish to find ('q' to quit)? k = ");
            String k = scan.nextLine();
            if (k.toLowerCase().equals("q")) break;

            try {
                System.out.println(smallestInTree(t, Integer.valueOf(k)));
            } catch (NumberFormatException e) {
                continue;
            }
        }

        scan.close();
        System.out.println("Bye!");

    }

    public static void printTree(BST t) {
        System.out.print("\nTREE TRAVERSAL:");
        System.out.print("\nInorder:   "); t.inorder();
        System.out.print("\nPreorder:  "); t.preorder();
        System.out.print("\nPostorder: "); t.postorder();
        System.out.println();
    }

    public static Object smallestInTree(BST t, int k) {
        Iterator iterator = t.iterator();
        Object smallest = null;
        for (int i = 0; i < k; i++) {
            if (iterator.hasNext())
                smallest = iterator.next();
        }
        return smallest;
    }
}
