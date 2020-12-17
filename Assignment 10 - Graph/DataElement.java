// from reference implementation of Graph
public abstract class DataElement
{
	public abstract boolean equals(DataElement otherElement);
      	//Method to determine if two objects contains the same data
 		//Postcondition: Returns true if this object contains the
 		//		data is the object otherElement; otherwise it
      	//          returns false otherwise

    public abstract int compareTo(DataElement otherElement);
      	//Method to compare two objects.
 		//Postcondition:  Returns a value < 0 if this element is
 		//                  less than otherElement;
 		//                Returns 0 if this element is same as
 		//                   otherElement;
      	//			      Returns a value > 0 if this element is
 		//                   greater than otherElement;

 	public abstract void makeCopy(DataElement otherElement);
 		//Method to copy otherElement into this element
		//Postcondition: data of otherElement is copied into
		//               this object
	public abstract DataElement getCopy();
    	//Method to return a copy of this object.
 		//Postcondition: A copy of this object is created and
      	//               a reference of the copy is returned
}
