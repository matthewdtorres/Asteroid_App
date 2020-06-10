package com.mycompany.a3;

import java.util.Vector;
import java.util.Observable;
import java.util.Random;
import java.lang.String;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import com.codename1.ui.util.UITimer;

// a class that creates the initial objects when the game begins
public class GameWorld extends Observable
{
    private GameCollection gameVector;
	private int shipLives = 3;
	private int totalTime = 0;
	private int totalScore = 0;
	private boolean soundOn;
	private Object currentElement = new Object();
    private boolean timerStatus = true;
    private UITimer timer;
    private Game gameForm;
    
    public GameWorld()
    {
    	gameVector = new GameCollection();
    	this.init();
    }
    
    public void init()
    {
 //   	Point starterPoint = new Point(512,384);
 //   	SpaceStation starterStation = new SpaceStation();
 //   	Asteroids newAsteroid = new Asteroids();
 //   	Ships starterShip = Ships.getShip();
//    	starterShip.setLocation(starterPoint);
//    	starterShip.setColor(ColorUtil.BLUE);
    	
//    	gameVector.add(starterShip);
//    	gameVector.add(starterStation);
//    	gameVector.add(newAsteroid);
    	updateWorld();
    	
    }
    
    public void updateWorld()
    {
    	this.setChanged();
    	GameWorldProxy gwp = new GameWorldProxy(this);
    	notifyObservers(gwp);
    }
    
    public GameCollection getGameObjects(){
    	return gameVector;
    }
    
    
    public int getTotalScore(){
    	return totalScore;
    }
    
    public int getShipLives(){
    	return shipLives;
    }
    
    public int getTotalTime(){
    	return totalTime;
    }
    
    public boolean getSoundOn(){
    	return soundOn;
    }
    
    public UITimer getTimer(){
    	return timer;
    }
    
    public boolean getTimerStatus(){
    	return timerStatus;
    }
    public Game getGameForm(){
    	return gameForm;
    }
    
    public void setSoundOn(boolean s)
    {
    	this.soundOn = s;
    	updateWorld();
    }
    
    public void setTimer(UITimer t){
    	timer = t;
    	updateWorld();
    }
    
    public void setTimerStatus(boolean b){
    	timerStatus = b;
    	updateWorld();
    }
    public void setGameForm(Game gameForm)
    {
    	this.gameForm = gameForm;
    	updateWorld();
    }
    
    public void addAsteroid(){
    	gameVector.add(new Asteroids());
    	updateWorld();
    }
    
    public void addStation(){
    	gameVector.add(new SpaceStation());
    	updateWorld();
    }
    
    public void addShip()
    {
    	IIterator vectorIterator = gameVector.getIterator();
		//check if vector is empty, if so, add a ship to the Vector
		if(gameVector.size() == 0)
		{
			Ships newShip = Ships.getShip();
			gameVector.add(newShip);
			updateWorld();
		}
		else
		{
			//if not, iterate through the vector to find if there's another ship before adding one
			while(vectorIterator.hasNext())
			{
				currentElement = vectorIterator.getNext();
				if(currentElement instanceof Ships)
				{
					System.out.println("ERROR: cannot create more than one ship during a game.");
					break;
				}
				else if((gameVector.size() - 1) == vectorIterator.getCurrentIndex())
				{
					Ships newShip = Ships.getShip();
					gameVector.add(newShip);
					updateWorld();
					break;
				}	
			}
		}
    }
    
    public void iShipSpeed()
    {
    	IIterator vectorIterator = gameVector.getIterator();
		while(vectorIterator.hasNext())
		{
			//If a ship is found while iterating through the vector, 
			//put it into the variable currentElement for modification
			//same case for case 'l', 'r', and 'd'
			currentElement = vectorIterator.getNext();
			if(currentElement instanceof Ships)
			{
				Ships theShip = (Ships) currentElement;
				if(theShip.getSpeed() == 10)
				{
					System.out.println("Ship is already at max speeds.");
					break;
				}
				else
				{
					theShip.setSpeed(theShip.getSpeed() + 1);
					updateWorld();
					break;
				}
			}	
				else if(vectorIterator.hasNext() == false)
			{
				System.out.println("ERROR: no ship in game");
				break;
			}
				
		}
    }
    
    public void dShipSpeed()
    {
    	IIterator vectorIterator = gameVector.getIterator();
		while(vectorIterator.hasNext())
		{
			currentElement = vectorIterator.getNext();
			if(currentElement instanceof Ships)
			{
				Ships theShip = (Ships) currentElement;
				if (theShip.getSpeed() == 0)
				{
					System.out.println("ERROR: ship speed is already at the lowest speed.");
					break;
				}
				else
				{
					theShip.setSpeed(theShip.getSpeed() - 1);
					updateWorld();
					break;
				}
			}
			
			else if(vectorIterator.hasNext() == false)
			{
				System.out.println("ERROR: no ship in game");
				break;
			}
		}
    }
    
    public void turnLeft()
    {
    	IIterator vectorIterator = gameVector.getIterator();
		while(vectorIterator.hasNext())
		{
			currentElement = vectorIterator.getNext();
			if(currentElement instanceof Ships)
			{
				Ships theShip = (Ships) currentElement;
				if (theShip.getDirection() == 0)
				{
					theShip.setDirection(359);
					updateWorld();
					break;
				}
				else
				{
					theShip.setDirection(theShip.getDirection() - 10);
					updateWorld();
					break;
				}
			}
			
			else if(vectorIterator.hasNext() == false)
			{
				System.out.println("ERROR: no ship in game");
				break;
			}
		}
    }
    
    public void turnRight()
    {
    	IIterator vectorIterator = gameVector.getIterator();
		while(vectorIterator.hasNext())
		{
			currentElement = vectorIterator.getNext();
			if(currentElement instanceof Ships)
			{
				Ships theShip = (Ships) currentElement;
				if (theShip.getDirection() == 359)
				{
					theShip.setDirection(0);
					updateWorld();
					break;
				}
				else
				{
					theShip.setDirection(theShip.getDirection() + 10);
					updateWorld();
					break;
				}
			}
			
			else if(vectorIterator.hasNext() == false)
			{
				System.out.println("ERROR: no ship in game");
				break;
			}
				
		}
    }
    
    public void fireMissile()
    {
    	IIterator vectorIterator = gameVector.getIterator();
		while(vectorIterator.hasNext())
		{
			//If a ship is found while iterating through the vector, 
			//put it into the variable currentElement to fire missiles
			// If there are no missiles left, notify the player.
			//If there are, create a Missile Object and add it to the vector
			currentElement = vectorIterator.getNext();
			if(currentElement instanceof Ships)
			{
				Ships theShip = (Ships) currentElement;
				if(theShip.getMissileCount() == 0)
				{
					System.out.println("ERROR: no missiles left to fire");
					break;
				}
				else
				{
					theShip.setMissileCount(theShip.getMissileCount() - 1);
					Missiles newMissile = new Missiles(theShip.getSpeed(), theShip.getDirection(), theShip.getLocation(), ColorUtil.YELLOW);
					gameVector.add(newMissile);
					break;
						
				}
			}
			
			else if(vectorIterator.hasNext() == false)
			{
				System.out.println("ERROR: no ship in game");
				break;
			}
			
		}
		updateWorld();
    }
    
    public void shipJump()
    {
    	IIterator vectorIterator = gameVector.getIterator();
		// create a variable of type Point2D in order to reset the location of the ship
		Point startPoint = new Point(512,384);
		while(vectorIterator.hasNext())
		{
			currentElement = vectorIterator.getNext();
			if(currentElement instanceof Ships)
			{
				Ships theShip = (Ships) currentElement;
				theShip.setLocation(startPoint);
				updateWorld();
				break;
			}
			else if(vectorIterator.hasNext() == false)
			{
				System.out.println("ERROR: no ship in game");
				break;
			}
		}
    }
    
    public void destroyAsteroid(GameObject dAsteroid)
    {
    	IIterator vectorIterator = gameVector.getIterator();
		while(vectorIterator.hasNext())
		{
				currentElement = vectorIterator.getNext();
				if(currentElement == dAsteroid)
				{
					gameVector.removeAt(vectorIterator.getCurrentIndex());
					++totalScore;
					updateWorld();
					break;
				}
		}
    }
    
    public void destroyMissile(GameObject dMissile)
    {
    	IIterator vectorIterator = gameVector.getIterator();
		while(vectorIterator.hasNext())
		{
			currentElement = vectorIterator.getNext();
			if(currentElement == dMissile)
			{
				gameVector.removeAt(vectorIterator.getCurrentIndex());
				updateWorld();
				break;
			}
		}
    }
    
    public void destoryShip()
    {
    	IIterator vectorIterator = gameVector.getIterator();
		//remove a Ship and Asteroid object from the vector.
		//if 3 ships have been removed, the game ends
		while(vectorIterator.hasNext())
		{
			currentElement = vectorIterator.getNext();
			if(currentElement instanceof Ships)
			{
				gameVector.removeAt(vectorIterator.getCurrentIndex());
				--shipLives;
				if(shipLives == 0)
				{
					System.out.println("All ships destroyed: GAME OVER");
					System.exit(1);
					break;
				}
			}					
		}
    }
    public void shipReload()
    {
    	IIterator vectorIterator = gameVector.getIterator();
		//Find the ship object in the Vector and access the method that returns the Missile count
		while(vectorIterator.hasNext())
		{
			currentElement = vectorIterator.getNext();
			if(currentElement instanceof Ships)
			{
				Ships theShip = (Ships) currentElement;
				theShip.setMissileCount(10);
				updateWorld();
				break;
			}
			
			else if(vectorIterator.hasNext() == false)
			{
				System.out.println("ERROR: no ship in game");
				break;
			}
				
		}
    }
     
    public void tickClock(Dimension dCmpSize)
    {
    	IIterator vectorIterator = gameVector.getIterator();
    	//If an object is of Moveable type, implement its move function in order to update its location values
		while(vectorIterator.hasNext())
		{
			currentElement = vectorIterator.getNext();
			
			if(currentElement instanceof Moveable)
			{
				Moveable currentObject = (Moveable) currentElement;
				//Must move the "move" function to the animation form
				currentObject.move(dCmpSize, 20);
			}
			
			if(currentElement instanceof SpaceStation)
			{
				SpaceStation currentObject = (SpaceStation) currentElement;
				currentObject.timerUpdate();
			}
			
			if(currentElement instanceof Missiles)
			{
				Missiles currentObject = (Missiles) currentElement;
				currentObject.fuelTick();
				if(currentObject.getFuelLevel() == 0)
					gameVector.removeAt(vectorIterator.getCurrentIndex());
			}
		}
		
		//checks if any of the objects have collided with each other
		++totalTime;
		updateWorld();
    }
    
}
    