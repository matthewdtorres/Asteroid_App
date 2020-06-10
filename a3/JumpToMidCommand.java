package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class JumpToMidCommand extends Command
{
	private GameWorld gw;	//Reference to a Game World

	public JumpToMidCommand( GameWorld gw )
	{
		super( "Jump to Middle" );
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed( ActionEvent e )
	{
		gw.shipJump();
		System.out.println("Jump to Middile.	");
	}
}
