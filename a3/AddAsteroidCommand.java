package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AddAsteroidCommand extends Command 
{
		
	private GameWorld gw;	//Reference to a Game World

	public AddAsteroidCommand( GameWorld gw )
	{
		super( "Add Asteroid" );
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed( ActionEvent e )
	{
		gw.addAsteroid();
		System.out.println("Add Asteroid.");
	}
		
}


