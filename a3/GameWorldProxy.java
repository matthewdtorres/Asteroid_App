package com.mycompany.a3;

import java.util.Observable;

public class GameWorldProxy extends Observable implements IGameWorld
{
	private GameWorld realGameWorld;
	
	public GameWorldProxy(GameWorld gw){
		realGameWorld = gw;
	}
	
	public GameCollection getGameObjects(){
		return realGameWorld.getGameObjects();
	}
    
    public int getTotalScore(){
    	return realGameWorld.getTotalScore();
    }
    
    public int getShipLives(){
    	return realGameWorld.getShipLives();
    }
    
    public int getTotalTime(){
    	return realGameWorld.getTotalTime();
    }
    
    public boolean getSoundOn(){
    	return realGameWorld.getSoundOn();
    }
    
    //All the methods unavaliable for the view to modify
    public void setSoundOn(boolean s){
    	System.out.println("Error: view cannot change model.");
    }
    
    public void addAsteroid(){
    	System.out.println("Error: view cannot change model.");
    }
    
    public void addStation(){
    	System.out.println("Error: view cannot change model.");
    }
    
    public void addShip(){
    	System.out.println("Error: view cannot change model.");
    }
    
    public void iShipSpeed(){
    	System.out.println("Error: view cannot change model.");
    }
    
    public void dShipSpeed(){
    	System.out.println("Error: view cannot change model.");
    }
    
    public void turnLeft(){
    	System.out.println("Error: view cannot change model.");
    }
    public void turnRight(){
    	System.out.println("Error: view cannot change model.");
    }
    
    public void fireMissile(){
    	System.out.println("Error: view cannot change model.");
    }
    
    public void shipJump(){
    	System.out.println("Error: view cannot change model.");
    }
    
    public void shipReload(){
    	System.out.println("Error: view cannot change model.");
    }
    
    public void destroyAsteroid(){
    	System.out.println("Error: view cannot change model.");
    }
    
    public void destroyMissile(){
    	System.out.println("Error: view cannot change model.");
    }
    
	public void destoryShip() {
		System.out.println("Error: view cannot change model.");
	}
	
    public void tickClock(){
    	System.out.println("Error: view cannot change model.");
    }

}
