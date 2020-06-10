package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AddShipCommand extends Command 
{
	private GameWorld gw;	//Reference to a Game World

	public AddShipCommand( GameWorld gw )
	{
		super( "Add Ship" );
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed( ActionEvent e )
	{
		gw.addShip();
		System.out.println("Adding Ship.");
	}
}
