package com.mycompany.a3;

import java.util.Observer;
import java.util.Observable;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class MapView extends Container implements Observer
{
	// Assignemnt 3 fields and constructors
	private GameCollection theObjects;
	public MapView(GameCollection theObjects){
		this.theObjects = theObjects;
	}
	
	public void DisplayPanel(GameCollection drawObjects){
		theObjects = drawObjects;
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		Point pCmpRelPOrigin = new Point(getX(), getY());
		Point pCmpRelSOrigin = new Point(getAbsoluteX(), getAbsoluteY());
		IIterator gameIterator = theObjects.getIterator();
		while (gameIterator.hasNext())
		{
			Object currentElement = gameIterator.getNext();
			if(currentElement instanceof Ships)
			{
				Ships currentObject = (Ships) currentElement;
				currentObject.draw(g, pCmpRelPOrigin, pCmpRelSOrigin);
			}
			else
			{
				IDrawable currentObject = (IDrawable) currentElement;
				currentObject.draw(g, pCmpRelPOrigin);
			}
		}
	}
	
	public void pointerPressed(int x, int y) 
	{
		x = x - getParent().getAbsoluteX();
		y = y - getParent().getAbsoluteY();
		Point pPtrRelPOrigin = new Point(x, y);
		Point pCmpRelPOrigin = new Point(getX(), getY());
		
		IIterator gameIterator = theObjects.getIterator();
		while(gameIterator.hasNext())
		{
			Object currentElement = gameIterator.getNext();
			if(currentElement instanceof Asteroids)
			{
				Asteroids currentObj = (Asteroids) currentElement;
				if (currentObj.contains(pPtrRelPOrigin, pCmpRelPOrigin))
					currentObj.setSelected(true);
				else
					currentObj.setSelected(false);
				repaint();
			}
			else if(currentElement instanceof Missiles)
			{
				Missiles currentObj = (Missiles) currentElement;
				if (currentObj.contains(pPtrRelPOrigin, pCmpRelPOrigin))
					currentObj.setSelected(true);
				else
					currentObj.setSelected(false);
				repaint();
			}
		}
	}
	public void update(Observable o, Object data)
	{
		//Initialize variables for the MapView to use from the Game Proxy sent in the arguments
		GameCollection go = ((IGameWorld)data).getGameObjects();
		IIterator gameIterator = go.getIterator();
		
		while ( gameIterator.hasNext() ){
			System.out.println( gameIterator.getNext() );
			
		repaint();
		}
	}
}
	