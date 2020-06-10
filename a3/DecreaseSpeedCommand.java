package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class DecreaseSpeedCommand extends Command
{
	private GameWorld gw;	//Reference to a Game World

	public DecreaseSpeedCommand( GameWorld gw )
	{
		super( "Decrease Speed" );
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed( ActionEvent e )
	{
		gw.dShipSpeed();
		System.out.println("Decrease ship speed.");
	}
}
