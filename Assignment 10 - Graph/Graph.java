// from reference implementation of Graph
import java.io.*;

import java.util.*;

public class Graph
{
    protected final int infinity = 10000000;  //This will be used
                                        //in later parts of this chapter,
                              //when we discuss weighted graphs.

    protected int maxSize;            //maximum number of vertices
    protected int gSize;              //current number of vertices
    protected LinkedListGraph[] graph; //array of reference variables
                                       //to create adjacency lists


        //default constructor
        //Postcondition: The graph size is set to 0, that is,
        //               gSize = 0; maxSize = 100
    public Graph()
    {
        maxSize = 100;
        gSize = 0;
        graph = new LinkedListGraph[maxSize];

        for(int i = 0; i < maxSize; i++)
            graph[i] = new LinkedListGraph();
    }


        //Constructor
        //Postcondition: The graph size is set to 0, that is,
        //               gSize = 0; maxSize = size
    public Graph(int size)
    {
        maxSize = size;
        gSize = 0;
        graph = new LinkedListGraph[maxSize];

        for(int i = 0; i < maxSize; i++)
            graph[i] = new LinkedListGraph();
    }

        //Method to determine if the graph is empty.
        //Postcondition: Returns true if the graph is empty;
        //               otherwise, returns false.
    public boolean isEmpty()
    {
        return (gSize == 0);
    }

        //Method to create the graph.
        //Postcondition: The graph is created using the
        //               adjacency list representation.
    public void createGraph() throws IOException, FileNotFoundException
    {
       BufferedReader keyboard = new
             BufferedReader(new InputStreamReader(System.in));

       String fileName;
       StringTokenizer tokenizer;

       int index;
       int vertex;
       int adjacentVertex;

       if(gSize != 0)   //if the graph is not empty, make it empty
          clearGraph();

       System.out.print("Enter input file name: ");
       fileName = keyboard.readLine();

       BufferedReader infile =
                  new BufferedReader(new FileReader(fileName));


       gSize = Integer.parseInt(infile.readLine()); //get the number
                                                    //of vertice
       for(index = 0; index < gSize; index++)
       {
          tokenizer = new StringTokenizer(infile.readLine());
          vertex = Integer.parseInt(tokenizer.nextToken());

          while(tokenizer.hasMoreTokens())
          {
              adjacentVertex = Integer.parseInt(tokenizer.nextToken());
              graph[vertex].insertLast(new IntElement(adjacentVertex));
          } //end while
       } // end for
    }//end createGraph


        //The memory occupied by each vertex is deallocated.
    public void clearGraph()
    {
         int index;

         for(index = 0; index < gSize; index++)
             graph[index] = null;

         gSize = 0;
    }
           //The graph is printed.
    public void printGraph()
    {
        int index;

        for(index = 0; index < gSize; index++)
        {
            System.out.print(index + " ");
            graph[index].print();
            System.out.println();
        }

        System.out.println();
    }

    private void dft(int v, boolean[] visited)
    {
        int w;

        IntElement[] adjacencyList;    //array to retrieve
                                       //the adjacent vertices
        adjacencyList = new IntElement[gSize];

        int alLength; //the number of adjacent vertices

        visited[v] = true;
        System.out.print(" " + v + " ");  //visit the vertex

        alLength  = graph[v].getAdjacentVertices(adjacencyList);
                 //retrieve the adjacent vertices into adjacencyList

        for(int index = 0; index < alLength;
                           index++) //for each vertex
        {                             // adjacent to v
            w = adjacencyList[index].getNum();
            if(!visited[w])
               dft(w, visited);
        } //end while
    } //end dft

    public void depthFirstTraversal()
    {
        boolean[] visited;  //array to keep track of the
                            //visited vertices
        visited = new boolean[gSize];
        int index;

        for(index = 0; index < gSize; index++)
            visited[index] = false;

        for(index = 0; index < gSize; index++) //for each vertex
            if(!visited[index])             //that is not visited
               dft(index, visited);         //do a depth first
                                            //traversal
    } //end depthFirstTraversal

    public void dftAtVertex(int vertex)
    {
        boolean[] visited;
        visited = new boolean[gSize];

        for(int index = 0; index < gSize; index++)
            visited[index] = false;

        dft(vertex,visited);
    } // end dftAtVertex

    public void breadthFirstTraversal()
    {
        LinkedQueueClass queue = new LinkedQueueClass();
        int u;
        IntElement temp = new IntElement();
        boolean[] visited;
        visited = new boolean[gSize];

        for(int ind = 0; ind < gSize; ind++)
            visited[ind] = false;   //initialize the array
                                  //visited to false

        IntElement[] adjacencyList;

        adjacencyList = new IntElement[gSize];

        int alLength;

        for(int index = 0; index < gSize; index++)
            if(!visited[index])
            {
               queue.addQueue(new IntElement(index));
               visited[index] = true;
               System.out.print(" " + index + " ");

               while(!queue.isEmptyQueue())
               {
                   temp = (IntElement) queue.front();
                   u = temp.getNum();
                   queue.deleteQueue();
                   alLength = graph[u].getAdjacentVertices
                                     (adjacencyList);
                    for(int w = 0; w < alLength; w++)
                    {
                        int w1 = adjacencyList[w].getNum();
                        if(!visited[w1])
                        {
                            queue.addQueue(new IntElement(w1));
                            visited[w1] = true;
                            System.out.print(" " + w1 + " ");
                        }
                    }
                } //end while
            } //end if
    } //end breadthFirstTraversal

    // adapted from: https://www.geeksforgeeks.org/shortest-path-unweighted-graph/
    public void printShortestPath(int src, int dest) {
        int pred[] = new int[gSize];
        int dist[] = new int[gSize];

        if (breadthFirstSearch(src, dest, pred, dist) == false) {
            System.out.println("Given source or destination are not connected/found.");
            return;
        }

        LinkedList<IntElement> path = new LinkedList<>();
        int crawl = dest;
        path.add(new IntElement(dest));

        while (pred[crawl] != -1) {
            path.add(new IntElement(pred[crawl]));
            crawl = pred[crawl];
        }

        System.out.println("Shortest path length is: " + dist[dest]);

        System.out.print("The path is: ");

        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }


    }

    // adapted from: https://www.geeksforgeeks.org/shortest-path-unweighted-graph/
    // adapted from: breadthFirstTraversal() method above
    public boolean breadthFirstSearch(int src, int dest, int pred[], int dist[]) {
        LinkedQueueClass queue = new LinkedQueueClass();
        IntElement[] adj = new IntElement[gSize];
        boolean visited[] = new boolean[gSize];
        int u, alLength;

        for (int i = 0; i < gSize; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        visited[src] = true;
        dist[src] = 0;
        queue.addQueue(new IntElement(src));

        while (!queue.isEmptyQueue()) {
            u = ((IntElement) queue.front()).getNum();
            queue.deleteQueue();
            alLength = graph[u].getAdjacentVertices(adj);

            for (int i = 0; i < alLength; i++) {
                int cur = adj[i].getNum();
                if(!visited[cur]) {
                    visited[cur] = true;
                    dist[cur] = dist[u] + 1;
                    pred[cur] = u;
                    queue.addQueue(new IntElement(cur));

                    if (cur == dest) return true;
                }
            }
        }
        return false;
    }

    public void printAdjacencyList() {
        int index;
        String adjacents;

            System.out.println("The number of vertices is " + gSize);
            System.out.println("The adjacency list:");

            for(index = 0; index < gSize; index++)
            {
                adjacents = "Vertex " + index + ":" +
                    graph[index].toString().replaceAll("(\\d*)\\s", " (" + index + ",$1)");

                System.out.println(adjacents);
            }

    }
}