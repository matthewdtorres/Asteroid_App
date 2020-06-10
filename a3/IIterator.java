package com.mycompany.a3;

// the Interface for the Iterator class within the gameCollection class
public interface IIterator
{
	public boolean hasNext();
	public Object getNext();
	public int getCurrentIndex();
}