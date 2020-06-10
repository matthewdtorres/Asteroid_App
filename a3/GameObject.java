package com.mycompany.a3;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

//the abstract class that provides all the basic attributes and functions for any Object for the game
public abstract class GameObject 
{
	private Random randomNum = new Random();
    private Point location;
    private int color;
    private int randX = 0 + randomNum.nextInt(1024);	
    private int randY = 0 + randomNum.nextInt(768);
    private int width;
    private int height;
    
    public GameObject()
    {
    	location = new Point(randX, randY);
    	color = ColorUtil.rgb(0, 0, 0);
    }
    	
    public GameObject(Point currentPoint, int currentColor)
    {
    	location = currentPoint;
    	color = currentColor;
    }
    public Point getLocation(){
    	return location;
    }
    	
    public int getColor(){
    	return color;
    }
    
    public int getWidth(){
    	return width;
    }
    
    public int getHeight(){
    	return height;
    }
    
    public void setLocation(Point newLocation){
    	location = newLocation;
    }
    
    public void setHeight(int newHeight){
    	height = newHeight;
    }
    
    public void setWidth(int newWidth){
    	width = newWidth;
    }
    
    public void setColor(int newColor){
    	color = newColor;
    }
	
    public String toString()
    {
    	String colorDesc = " color = " + "[" + ColorUtil.red(color) + ","
    								   + ColorUtil.green(color) + ","
    								   + ColorUtil.blue(color) + "]";
    	
    	String locationDesc = " location = " + location.getX() + "," + location.getY();
    	
    	return locationDesc + colorDesc;
    }

}
