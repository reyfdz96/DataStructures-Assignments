import java.util.Random;

public class BinarySearchTreeDemo {
       // test binary search tree class
   public static void main(String [] args)
   {
      BinarySearchTree y = new BinarySearchTree();

      // insert a few elements
      y.put(new Integer(12), new Character('W'));
      y.put(new Integer(8),  new Character('l'));
      y.put(new Integer(14), new Character('o'));
      y.put(new Integer(4),  new Character('e'));
      y.put(new Integer(10), new Character('o'));
      y.put(new Integer(18), new Character('l'));
      y.put(new Integer(16), new Character('r'));
      y.put(new Integer(20), new Character('d'));
      y.put(new Integer(2),  new Character('H'));
      y.put(new Integer(6),  new Character('l'));

      System.out.print(
         "\nTREE DIAGRAM:\n"
         + "                     12:'W'\n"
         + "              +--------+--------+\n"
         + "             8:'l'            14:'o'\n"
         + "         +----+----+            +----+\n"
         + "        4:'e'    10:'o'            18:'l'\n"
         + "    +----+----+                 +----+----+\n"
         + "   2:'H'     6:'l'            16:'r'    20:'d'\n"
      );

      printTree(y);
      System.out.print("\n\n===ASSIGNMENT===\n");
      System.out.print("\ndisplayItemsInRange (0-11):  "); y.displayItemsInRange(0, 11);
      System.out.print("\ndisplayItemsInRange (10-21): "); y.displayItemsInRange(10, 21);
      System.out.print("\ndisplayItemsInRange (6-16):  "); y.displayItemsInRange(6, 16);

      int key = new Random().nextInt(20);
      System.out.println("\n\nSplitting at " + key + "...");

      BinarySearchTree lessThan = new BinarySearchTree();
      BinarySearchTree greaterThan = new BinarySearchTree();
      Object element = y.split(key, lessThan, greaterThan);
      System.out.println("\nSPLIT!");

      if (element != null) {
         System.out.println("\nPopped Character: \'" + element +"\'");
      }

      System.out.println("\nLess than " + key + ":");
      System.out.print("----------------");
      printTree(lessThan);
      System.out.println("\n\nGreater than " + key + ":");
      System.out.print("----------------");
      printTree(greaterThan);

      System.out.println("\n\n[!] Run again for different split results.\n");
   }

   public static void printTree(BinarySearchTree y) {
      System.out.print("\ninOrder:                     "); y.inOrderOutput();
      System.out.print("\npreOrder:                    "); y.preOrderOutput();
      System.out.print("\npostOrder:                   "); y.postOrderOutput();
   }


}
