package com.mycompany.a3;


public interface IGameWorld 
{
	public GameCollection getGameObjects();
    public int getTotalScore();
    public int getShipLives();
    public int getTotalTime();
    public boolean getSoundOn();
    public void setSoundOn(boolean sound);
    public void addAsteroid();
    public void addStation();
    public void addShip();
    public void iShipSpeed();
    public void dShipSpeed();
    public void turnLeft();
    public void turnRight();
    public void fireMissile();
    public void shipJump();
    public void shipReload();
    public void destroyAsteroid();
    public void destroyMissile();
    public void destoryShip();
    public void tickClock();
}
