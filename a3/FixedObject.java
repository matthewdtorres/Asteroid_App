package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

import java.util.Random;

//a class that contains attributes and methods for game objects that are unmovable in the game space
public class FixedObject extends GameObject
{
	private Random randomNum = new Random();
	private static int id;
	private final Point location;
	private int color;
    private int randX = 0 + randomNum.nextInt(1024);	
    private int randY = 0 + randomNum.nextInt(768);
    
	public FixedObject()
	{
    	location = new Point(randX, randY);
    	color = ColorUtil.rgb(0, 0, 0);
	}
	
	public FixedObject(int newColor)
	{
    	location = new Point(randX, randY);
    	color = newColor;
	}
	public FixedObject(Point currentLocation, int currentColor, int currentID)
	{
		location = currentLocation;
		color = currentColor;
		id = currentID;
	}
	
	public int getID()
	{
		return id;
	}
	
	public void setColor(int newColor)
	{
		color = newColor;
	}
	
	public void setID(int newID)
	{
		id = newID;
	}
	public String toString()
	{
		String parentDesc = super.toString();
		String idDesc = " ID = " + id;
		
		return parentDesc + idDesc;
	}
}