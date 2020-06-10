package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AddStationCommand extends Command
{
	private GameWorld gw;	//Reference to a Game World

	public AddStationCommand( GameWorld gw )
	{
		super( "Add Station" );
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed( ActionEvent e )
	{
		gw.addStation();
		System.out.println("Add Station");
	}
}
