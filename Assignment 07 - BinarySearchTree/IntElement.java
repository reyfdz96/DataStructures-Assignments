/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author scobo
 */
public class IntElement extends DataElement
{
	protected int num;

		//default constructor
	public IntElement()
    {
        num = 0;
    }

		//constructor with parameters
    public IntElement(int x)
    {
        num = x;
    }

		//copy constructor
    public IntElement(IntElement otherElement)
    {
        num = otherElement.num;
    }

		//Method to set the value of the instance variable num
 		//Postcondition: num = x;
    public void setNum(int x)
    {
        num = x;
    }

    	//Method to return the value of the instance variable num
		//Postcondition: The value of num is returned
	public int getNum()
	{
	    return num;
	}


    public boolean equals(DataElement otherElement)
    {
        IntElement temp = (IntElement) otherElement;

        return (num == temp.num);
    }

    public int compareTo(DataElement otherElement)
    {
        IntElement temp = (IntElement) otherElement;

        return (num - temp.num);
    }

    public void makeCopy(DataElement otherElement)
    {
          IntElement temp = (IntElement) otherElement;

          num = temp.num;
    }

    public DataElement getCopy()
    {
        IntElement temp = new IntElement(num);
        return temp;
    }

    public String toString()
    {
        return String.valueOf(num);
    }
}
