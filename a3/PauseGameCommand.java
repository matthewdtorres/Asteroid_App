package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.util.UITimer;

public class PauseGameCommand extends Command
{
	private GameWorld gw;
	
	public PauseGameCommand( GameWorld gw ){
		super( "Pause Game" );
		this.gw = gw;
	}
	
	public void actionPerformed( ActionEvent e )
	{
		UITimer timer = gw.getTimer();
		
		if ( gw.getTimerStatus() == false ){
			timer.schedule(20, true, gw.getGameForm());
			gw.setTimerStatus(true);
		}
		else{
			timer.schedule(20, false, gw.getGameForm());
			gw.setTimerStatus(false);
		}
	}
}
