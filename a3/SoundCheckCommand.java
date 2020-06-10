package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SoundCheckCommand extends Command
{
	private GameWorld gw;
	
	public SoundCheckCommand( GameWorld gw ){
		super( "Sound Check" );
		this.gw = gw;
	}

	@Override
	public void actionPerformed( ActionEvent e ){
		if ( gw.getSoundOn() == false ){
			gw.setSoundOn( true );
		}
		else{
			gw.setSoundOn( false );
		}
	}
}
