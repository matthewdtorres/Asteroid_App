package com.mycompany.a3;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

//the class that contains all of the attributes and methods for Asteroid Objects
public class Asteroids extends Moveable implements ISelectable, IDrawable, ICollider
{
	private Random randNum = new Random();
	private int size;
	private int height = 5;
	private int width = 5;
	private boolean isSelected;
	public Asteroids()
	{
		size = 1 + randNum.nextInt(50);
    	super.setColor(ColorUtil.GRAY);
    	width = (width*size);
    	height = (height*size);
    	super.setWidth(width);
    	super.setHeight(height);
	}
	
	public void draw(Graphics g, Point pCmpRelPOrigin) 
	{
		// TODO Auto-generated method stub
		g.setColor(super.getColor());
		Point currentLocation = super.getLocation();
		int xLoc = pCmpRelPOrigin.getX()+ currentLocation.getX();// shape location relative
		int yLoc = pCmpRelPOrigin.getY()+ currentLocation.getY();// to parent’s origin
		if(isSelected) {
			g.fillRect(xLoc, yLoc, width/2, height);
		}
		else{
			g.drawRect(xLoc, yLoc, width/2, height);
		}
	}
	
	public boolean contains(Point pPtrRelPOrigin, Point pCmpRelPOrigin) 
	{
		int px = pPtrRelPOrigin.getX(); // pointer location relative to
		int py = pPtrRelPOrigin.getY(); // parent’s origin
		int xLoc = pCmpRelPOrigin.getX()+ super.getLocation().getX();// shape location relative
		int yLoc = pCmpRelPOrigin.getY()+ super.getLocation().getY();// to parent’s origin
		if ( (px >= xLoc) && (px <= xLoc+width) 
			&& (py >= yLoc) && (py <= yLoc+height) )
			return true; 
		else 
			return false;
	}
	
	public boolean collidesWith(GameObject obj)
	{	
		//finding the centers of both objects
		boolean result = false;
		Point currentLocation = super.getLocation();
		Point otherObjLocation = obj.getLocation();
		
		int thisCenterX = currentLocation.getX() + (super.getWidth()/2);
		int thisCenterY = currentLocation.getY() + (super.getHeight()/2);
		int otherCenterX = otherObjLocation.getX() + (obj.getWidth()/2);
		int otherCenterY = otherObjLocation.getY() + (obj.getHeight()/2);
		
		//finding the distance between the centers
		int dx = thisCenterX - otherCenterX;
		int dy = thisCenterY - otherCenterY;
		int distBetweenCentersSqr = ((dx*dx) + (dy*dy));
		
		//find square of the sum of the radii
		int thisRadius = super.getHeight()/2;
		int otherRadius = obj.getHeight()/2;
		int radiiSqr = ((thisRadius*thisRadius) + (2*thisRadius*otherRadius)
												+ (otherRadius*otherRadius));
		if(distBetweenCentersSqr <= radiiSqr)
			result = true;
		
		return result;
	}
	
	public void handleCollision(ICollider otherObject, GameWorld gw)
	{
		if(otherObject instanceof Missiles)
		{
			Missiles dMissile = (Missiles) otherObject;
			gw.destroyMissile(dMissile);
			gw.destroyAsteroid(this);
		}
		else if(otherObject instanceof Ships)
		{
			gw.destoryShip();
			gw.destroyAsteroid(this);
		}
	}
	public void setSelected (boolean yesNo){
		isSelected = yesNo;
	}
	
	public String toString()
	{
		String objectType ="Asteroid: ";
		String parentDesc = super.toString();
		String asteroidDesc = " size = " + size;
		
		return objectType + parentDesc + asteroidDesc;
	}
}