package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;

public class QuitCommand extends Command
{
	public QuitCommand( ){
		super( "Quit" );
	}
	
	@Override
	public void actionPerformed( ActionEvent e )
	{
		TextField myText = new TextField();	//Text field to hold the value
		//Display a dialog box to allow the user to enter a number
		Dialog.show("Are You Sure You Wish to Exit?", myText, new Command( "Enter" ) );
		//Check to make sure it is in fact a number
		String value = myText.getText();
		value = value.toUpperCase();
		
		if ( value.equals("Y") || value.equals("YES") ){
			System.exit(1);	//Then Leave
		}
		else if ( value.equals("N") || value.equals("NO") ){
			//Do nothing, move on
		}
		else{
			System.out.println( "Invalid response. Ignoring input." );
		}
		//Otherwise do nothing and move on
	}
}
