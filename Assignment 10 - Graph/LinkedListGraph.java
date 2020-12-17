// from reference implementation of Graph
public class LinkedListGraph extends UnorderedLinkedList
{
        //default constructor
   public LinkedListGraph()
   {
       super();
   }

       //copy constructor
   public LinkedListGraph(LinkedListGraph otherGraph)
   {
       super(otherGraph);
   }


        //Method to retrieve the vertices adjacent to a given
        //vertex.
        //Postcondition: The vertices adjacent to a given
        //               vertex from the linked list are retrieved
        //               in the array adjacencyList.
        //               The number of vertices are returned
    public int getAdjacentVertices(DataElement[] adjacencyList)
    {
        LinkedListNode current;
        int length = 0;

        current = first;

        while(current != null)
        {
            adjacencyList[length++] = current.info.getCopy();
            current = current.link;
        }

        return length;
    }
}
