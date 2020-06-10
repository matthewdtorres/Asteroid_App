package com.mycompany.a3;

import java.util.Vector;
// the Collection class that stores all of the objects within its vector
public class GameCollection implements IVectorObjects
{
	private Vector<Object> theVector;
	
	public GameCollection(){
		theVector = new Vector();
	}
	
	public void add(Object newObject){
		theVector.addElement(newObject);
		
	}
	
	public void removeAt(int targetIndex)
	{
		theVector.removeElementAt(targetIndex);
	}
	
	public void copyVector(Vector targetVector)
	{
		theVector.addAll(0, targetVector);
	}
	public int size()
	{
		return theVector.size();
	}
	
	public IIterator getIterator(){
		return new GameIterator();
	}
	
	// the inner class that creates an Iterator for the collection in order to traverse it
	private class GameIterator implements IIterator
	{
		private int currentIndex;
		public GameIterator(){
			currentIndex = -1;
		}
		
		public boolean hasNext()
		{
			if(theVector.size() <= 0)
				return false;
			
			if(currentIndex == theVector.size() - 1)
				return false;
			
			return true;
		}
		
		public Object getNext()
		{
			currentIndex++;
			return(theVector.elementAt(currentIndex));
		}
		
		public int getCurrentIndex()
		{
			return currentIndex;
		}
	}
}