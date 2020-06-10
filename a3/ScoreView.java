package com.mycompany.a3;

import java.util.Observer;
import java.util.Observable;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.charts.util.ColorUtil;

public class ScoreView extends Container implements Observer
{
	private Label score;
	private Label shipLives;
	private Label elapsedTime;
	private Label sound;

	public ScoreView()
	{
		//Instantiate all necessary labels
		score = new Label("Score: XXX ");
		shipLives =  new Label( "Lives:  XXX " );
		elapsedTime = new Label("Time: XXX ");
		sound = new Label( "Sound:  XXX " );
		
		//Add some customization to the labels
		score.getAllStyles().setFgColor( ColorUtil.rgb( 0, 0, 255 ) );
		shipLives.getAllStyles().setFgColor( ColorUtil.rgb( 0, 0, 255 ) );
		sound.getAllStyles().setFgColor( ColorUtil.rgb( 0, 0, 255 ) );
		elapsedTime.getAllStyles().setFgColor( ColorUtil.rgb( 0, 0, 255 ) );
		
		//Then add all components to the container
		this.add(score);
		this.add(shipLives);
		this.add(elapsedTime);
		this.add(sound);
	}
	
	
	//This will update labels to the screen when needed
	public void update( Observable o, Object data ){
		//initialize variables from the data gotten from the proxy in the parameters
		int playerScore = ((IGameWorld)data).getTotalScore();
		int shipsLeft = ((IGameWorld)data).getShipLives();
		int timePassed = ((IGameWorld)data).getTotalTime();
		boolean soundFlag = ((IGameWorld)data).getSoundOn();
		
		//display the variables
		score.setText("Current player score: " + playerScore);
		shipLives.setText( "Number of Ships left: " +  shipsLeft);
		elapsedTime.setText("Elapsed Time: " + timePassed);
		if ( soundFlag == true ){
			sound.setText( "Sound:  ON" );
		}
		else{
			sound.setText( "Sound:  OFF" );
		}
	}
}
