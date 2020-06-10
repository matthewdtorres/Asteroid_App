package com.mycompany.a3;

import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

//the class for Ship objects. only one of them can be within the gameCollection at a time
public class Ships extends Moveable implements ISteerable, ICollider
{
	private int missileCount = 10;
    private static Ships shipObject = new Ships();
    private static Point location = new Point(512,384);
    private int speed;
    private int direction;
    private int base = 100;
    private int height = 200;
    private int color;
    private Transform rotation;
    //hides the Ship constructor from other class from seeing it
    private Ships(){
    	super.setWidth(base);
    	super.setHeight(height);
    }
    	
    public Point getLocation(){
    	return location;
    }
    	
    public int getColor(){
    	return color;
    }
    
    public int getMissileCount()
    {
    	return missileCount;
    }	
    	
    public void setSpeed(int newSpeed){
    	speed = newSpeed;
    }
    	
    public void setDirection(int newDirection){
    	direction = newDirection;
    }   	
    
    public void setMissileCount(int newMissileCount)
    {
    	missileCount = newMissileCount;
    }
    
    //allows access to the a ship object
    public static Ships getShip()
    {
    	if (shipObject == null)
    	{
    		shipObject = new Ships();
    	}
    	return shipObject;
    }

	public void draw(Graphics g, Point pCmpRelPOrigin, Point pCmpRelSOrigin) 
	{
		g.setColor(super.getColor());
		Point currentLoc = super.getLocation();
	    //rotation = Transform.makeIdentity();
		Point top = new Point(0, height/2);
		Point bottomLeft = new Point(-(base/2),-(height/2));
		Point bottomRight = new Point((base/2), -(height/2));
		// TODO Auto-generated method stub
		
		//Transform gXform = Transform.makeIdentity();
		//g.getTransform(gXform);
		//Transform origin = gXform.copy();
		//gXform.translate(pCmpRelSOrigin.getX() + width/2, pCmpRelSOrigin.getY() + height/2);
		//gXform.concatenate(rotation);
		//gXform.translate(-(pCmpRelSOrigin.getX() + width/2), -(pCmpRelSOrigin.getY() + height/2));
		//g.setTransform(gXform);
		
		g.drawLine(pCmpRelPOrigin.getX() + top.getX() + currentLoc.getX(), pCmpRelPOrigin.getY()+top.getY()+ currentLoc.getY(),
					pCmpRelPOrigin.getX()+ bottomLeft.getX() + currentLoc.getX(),pCmpRelPOrigin.getY()+bottomLeft.getY() + currentLoc.getY());
		
		g.drawLine(pCmpRelPOrigin.getX()+bottomLeft.getX() + currentLoc.getX(), pCmpRelPOrigin.getY()+bottomLeft.getY() + currentLoc.getY(),
					pCmpRelPOrigin.getX()+bottomRight.getX() + currentLoc.getX(), pCmpRelPOrigin.getY()+ bottomRight.getY() + currentLoc.getY());
		
		g.drawLine(pCmpRelPOrigin.getX()+bottomRight.getX() + currentLoc.getX() ,pCmpRelPOrigin.getY()+bottomRight.getY() + currentLoc.getY(),
					pCmpRelPOrigin.getX() + top.getX() + currentLoc.getX(), pCmpRelPOrigin.getY() + top.getY() + currentLoc.getY());
		
		
		
		//g.setTransform(origin);
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
			gw.destoryShip();
		}
	}
    public String toString()
    {
    	String objectType ="Ship: ";
    	String parentDesc = super.toString();
    	String shipDesc = " missiles = " + missileCount;
    	
    	return objectType + parentDesc + shipDesc;
    }
  
}