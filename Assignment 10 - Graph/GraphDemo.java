// from reference implementation of Graph
import java.io.*;
import java.util.Scanner;

public class GraphDemo
{
    public static void main(String[] args) throws IOException,
                                             FileNotFoundException
    {
        System.out.println("CREATE THE GRAPH");
        Graph myGraph = new Graph(50);

        myGraph.createGraph();
        myGraph.printAdjacencyList();
        System.out.println();

        System.out.println("FIND SHORTEST PATH");
        Scanner scanner = new Scanner(System.in);
        int src, dest;

        System.out.print("Enter two vertices in the range "
            + 0 + " to " + (myGraph.gSize-1) + " to find a path for: ");
        src = scanner.nextInt();
        dest = scanner.nextInt();
        myGraph.printShortestPath(src, dest);
        scanner.close();

    }




}