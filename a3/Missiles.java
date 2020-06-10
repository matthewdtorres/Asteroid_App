package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

// the class that contains attributes that describe a Missile object and methods in order to create and modify one
public class Missiles extends Moveable implements IDrawable, ISelectable, ICollider
{
	private boolean isSelected;
    private int fuelLevel = 10;
    private int height = 100;
    private int width = 50;
    
    public Missiles(int shipSpeed, int shipDirection, Point shipLocation, int missileColor)
    {
    	super(shipSpeed + 1, shipDirection, shipLocation, missileColor);
    	Point shipPoint = new Point(shipLocation.getX() + 1, shipLocation.getY() + 1);
    	super.setLocation(shipPoint);
    	super.setWidth(width);
    	super.setHeight(height);
    	width = width/2;
    	
    }
    
    public void fuelTick(){
    	--fuelLevel;			
    }
    
    public int getFuelLevel()
    {
    	return fuelLevel;
    }
    
	public void draw(Graphics g, Point pCmpRelPOrigin) 
	{
		// TODO Auto-generated method stub
		g.setColor(super.getColor());
		Point currentLocation = super.getLocation();
		int xLoc = pCmpRelPOrigin.getX()+ currentLocation.getX();// shape location relative
		int yLoc = pCmpRelPOrigin.getY()+ currentLocation.getY();// to parent’s origin
		if(isSelected) {
			g.fillRect(xLoc, yLoc, width, height);
		}
		else{
			g.drawRect(xLoc, yLoc, width, height);
		}
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
		if(otherObject instanceof Asteroids)
		{
			Asteroids dAsteroid = (Asteroids) otherObject;
			gw.destroyAsteroid(dAsteroid);
			gw.destroyMissile(this);
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
	
	public void setSelected (boolean yesNo){
		isSelected = yesNo;
	}
    public String toString()
    {
    	String objectType ="Missile: ";
    	String parentDesc = super.toString();
    	String missileDesc = " fuel = " + fuelLevel;
    	
    	return objectType + parentDesc + missileDesc;
    }
}