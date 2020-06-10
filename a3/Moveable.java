package com.mycompany.a3;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Dimension;
import java.lang.Math;

// the class for all Objects that can move within the game space
public class Moveable extends GameObject
{
    private int speed;
    private int direction;   	
    private Random randomNum = new Random();
    private int movingRate = 20;
	
    public Moveable()
    {
    	speed = 0 + randomNum.nextInt(10);
    	direction = 0 + randomNum.nextInt(359);		
    }
    	
    public Moveable(int newSpeed, int newDirection, Point newLocation, int newColor)
    {
    	speed = newSpeed;
    	direction = newDirection;
    	super.setLocation(newLocation);
    	super.setColor(newColor);
    }
    	
    public int getSpeed(){
    	return speed;
    }
    	
    public int getDirection(){
    	return direction;
    }
    
    // updates the location of the movable object based on its heading and speed
    public void move(Dimension dCmpSize, int elapsedTimeRate)
    {
    	Point oldLocation = super.getLocation();
    	int angle = 90 - direction;
    	int distance = speed * movingRate;
    	int deltaX =  (int) ((Math.cos(angle)) * distance);
    	int deltaY =  (int) ((Math.sin(angle)) * distance);
    	int newX = deltaX + oldLocation.getX();
    	int newY = deltaY + oldLocation.getY();
    	newX = (int) (Math.round(newX*10) / 10.0);
    	newY = (int) (Math.round(newY*10) / 10.0);    	
    	Point newLocation = new Point(newX, newY);
    	super.setLocation(newLocation);
    	
    	if ( newX + super.getWidth() >= dCmpSize.getWidth() || newX < 0)
    		speed = -speed;
    	if ( newY + super.getHeight() >= dCmpSize.getHeight() || newY < 0)
    		speed = -speed;
    }
    
    public String toString()
    {
    	String parentDesc = super.toString();
    	String moveableDesc = " direction = " + direction + " speed = " + speed;
    	
    	return moveableDesc + parentDesc;
    }
}