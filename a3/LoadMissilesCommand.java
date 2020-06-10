package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class LoadMissilesCommand extends Command
{
	private GameWorld gw;	//Reference to a Game World

	public LoadMissilesCommand( GameWorld gw )
	{
		super( "Load Missiles" );
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed( ActionEvent e )
	{
		gw.shipReload();
		System.out.println("Load Missiles.");
	}
}
