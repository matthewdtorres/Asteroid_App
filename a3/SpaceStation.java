package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

import java.util.Random;

//the class for all SpaceStation objects
public class SpaceStation extends FixedObject implements IDrawable, ICollider
{

	private Random randNum = new Random();
	private final int blinkRate = 1 + randNum.nextInt(10);
	private int blinkTimer;
	private boolean blinkingLight = false;
	private int width = 100;
	private int height = 100;
	public SpaceStation()
	{
		blinkTimer = blinkRate;
		super.setColor(ColorUtil.BLACK);
		super.setID(0);
		super.setWidth(width/2);
		super.setHeight(height/2);
	}
	
	// changes the status of the Space Station's blinking light 
	// depending on what value the blinking light is currently on
	public void timerUpdate()
	{
		int blinkFlag = blinkTimer % blinkRate;
		
		if(blinkFlag != 0 && blinkingLight == false)
			++blinkTimer;
		
		else if(blinkFlag != 0 && blinkingLight == true)
			--blinkTimer;
		
		else if(blinkFlag == 0 && blinkingLight == false)
			blinkingLight = true;
	
		else
			blinkingLight = false;
	}
	
	public boolean lightStatus()
	{
		return blinkingLight;
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
		if(otherObject instanceof Ships)
			gw.shipReload();
	}
	public void draw(Graphics g, Point pCmpRelPOrigin) 
	{
		// TODO Auto-generated method stub
		g.setColor(super.getColor());
		Point currentLocation = super.getLocation();
		int xLoc = pCmpRelPOrigin.getX()+ currentLocation.getX();// shape location relative
		int yLoc = pCmpRelPOrigin.getY()+ currentLocation.getY();// to parent’s origin
		if(blinkingLight == true) 
			g.fillArc(xLoc, yLoc, super.getWidth(), super.getHeight(), 0, 360);
		else		
			g.drawArc(xLoc, yLoc, super.getWidth(), super.getHeight(), 0, 360);
	}
	public String toString()
	{
		String objectType ="Station: ";
		String parentDesc = super.toString();
		String stationDesc = " blink rate = " + blinkRate;
		
		return objectType + parentDesc + stationDesc;
	}
}