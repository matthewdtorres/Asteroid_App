package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class IncreaseSpeedCommand extends Command
{
	private GameWorld gw;	//Reference to a Game World

	public IncreaseSpeedCommand( GameWorld gw )
	{
		super( "Increase Speed" );
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed( ActionEvent e )
	{
		gw.iShipSpeed();
		System.out.println("Increase ship Speed.");
	}
}
