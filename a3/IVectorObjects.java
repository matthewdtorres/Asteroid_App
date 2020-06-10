package com.mycompany.a3;

import java.util.Vector;

//the Vector Interface for the gameCollection class
public interface IVectorObjects
{
	public void add(Object newItem);
	public void removeAt(int currentIndex);
	public void copyVector(Vector<Object> targetVector);
	public IIterator getIterator();
	
}