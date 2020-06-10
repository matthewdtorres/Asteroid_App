package com.mycompany.a3;

import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.Label;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;



// the class that sets up the game to be playable for the user.
public class Game extends Form implements Runnable
{ 	
        private GameWorld gw;
        private MapView mv;
        private ScoreView sv;
        private static int mapHeight;
        private static int mapWidth;
        
        public Game()
        {
        	this.setLayout(new BorderLayout());
        	gw = new GameWorld();
        	GameWorldProxy gwp = new GameWorldProxy(gw);
        	GameCollection gameObjects = gwp.getGameObjects();
        	mv = new MapView(gameObjects);
        	sv = new ScoreView();

          //------------- North Container --------------//
        	Container northContainer = new Container();
        	northContainer.setLayout( new FlowLayout() );
        	northContainer = FlowLayout.encloseCenter( sv );	//Places everything in center
        	//Then attach to the NORTH border
        	this.add( BorderLayout.NORTH, northContainer );
		
		//----------------- West Container --------------//
    		Container westContainer = new Container();
    		westContainer.setLayout( new FlowLayout() );
    		
        	//adding buttons
        	Button addAsteroid = new Button ( "Add Asteroid" );
        	Button addStation = new Button ( "Add Station" );
        	Button addShip = new Button ("Add Ship");
        	Button increaseSpeed = new Button ( "Increase Speed" );
        	Button decreaseSpeed = new Button ( "Decrease Speed" );
        	Button turnLeft = new Button ( "Turn Left" );
        	Button turnRight = new Button ( "Turn Right" );
        	Button fireMissile = new Button ( "Fire Missile" );
        	Button jumpToMid = new Button ( "Jump to Middle" );
        	Button loadMissiles = new Button ( "Load Missiles" );
    		Button quit = new Button ("Quit");
    		
    		//styling buttons	
    		addAsteroid.getAllStyles().setBgTransparency( 255 );
    		addAsteroid.getUnselectedStyle().setBgColor( ColorUtil.CYAN );
    		addAsteroid.getAllStyles().setFgColor( ColorUtil.rgb( 255, 255, 255 ) );
    		
    		addStation.getAllStyles().setBgTransparency( 255 );
    		addStation.getUnselectedStyle().setBgColor( ColorUtil.GREEN );
    		addAsteroid.getAllStyles().setFgColor( ColorUtil.rgb( 255, 255, 255 ) );
    		
    		addShip.getAllStyles().setBgTransparency( 255 );
    		addShip.getUnselectedStyle().setBgColor( ColorUtil.rgb(150, 0, 0) );
    		addShip.getAllStyles().setFgColor( ColorUtil.rgb( 255, 255, 255 ) );
    		
    		increaseSpeed.getAllStyles().setBgTransparency( 255 );
    		increaseSpeed.getUnselectedStyle().setBgColor( ColorUtil.YELLOW);
    		increaseSpeed.getAllStyles().setFgColor( ColorUtil.rgb( 255, 255, 255 ) );
    		
    		decreaseSpeed.getAllStyles().setBgTransparency( 255 );
    		decreaseSpeed.getUnselectedStyle().setBgColor( ColorUtil.GRAY);
    		decreaseSpeed.getAllStyles().setFgColor( ColorUtil.rgb( 255, 255, 255 ) );
    		
    		turnLeft.getAllStyles().setBgTransparency( 255 );
    		turnLeft.getUnselectedStyle().setBgColor( ColorUtil.rgb( 0, 0, 150 ) );
    		turnLeft.getAllStyles().setFgColor( ColorUtil.rgb( 255, 255, 255 ) );
    		
    		turnRight.getAllStyles().setBgTransparency( 255 );
    		turnRight.getUnselectedStyle().setBgColor( ColorUtil.rgb( 255,192,203 ) );
    		turnRight.getAllStyles().setFgColor( ColorUtil.rgb( 255, 255, 255 ) );
    		
    		turnRight.getAllStyles().setBgTransparency( 255 );
    		turnRight.getUnselectedStyle().setBgColor( ColorUtil.rgb( 255,192,203 ) );
    		turnRight.getAllStyles().setFgColor( ColorUtil.rgb( 255, 255, 255 ) );
    		
    		fireMissile.getAllStyles().setBgTransparency( 255 );
    		fireMissile.getUnselectedStyle().setBgColor( ColorUtil.rgb( 255,165,0 ) );
    		fireMissile.getAllStyles().setFgColor( ColorUtil.rgb( 255, 255, 255 ) );
    		
    		jumpToMid.getAllStyles().setBgTransparency( 255 );
    		jumpToMid.getUnselectedStyle().setBgColor( ColorUtil.rgb( 0,191,255 ) );
    		jumpToMid.getAllStyles().setFgColor( ColorUtil.rgb( 255, 255, 255 ) );
    		
    		loadMissiles.getAllStyles().setBgTransparency( 255 );
    		loadMissiles.getUnselectedStyle().setBgColor( ColorUtil.rgb( 210,105,30 ) );
    		loadMissiles.getAllStyles().setFgColor( ColorUtil.rgb( 255, 255, 255 ) );
    		
    		quit.getAllStyles().setBgTransparency( 255 );
    		quit.getUnselectedStyle().setBgColor( ColorUtil.rgb( 0,0,0 ) );
    		quit.getAllStyles().setFgColor( ColorUtil.rgb( 255, 255, 255 ) );
    		
    		//button padding
    		addAsteroid.getAllStyles().setPadding( TOP, 5 );
    		addAsteroid.getAllStyles().setPadding( BOTTOM, 5 );
    		addStation.getAllStyles().setPadding( TOP, 5 );
    		addStation.getAllStyles().setPadding( BOTTOM, 5 );
    		addShip.getAllStyles().setPadding( TOP, 5 );
    		addShip.getAllStyles().setPadding( BOTTOM, 5 );
    		increaseSpeed.getAllStyles().setPadding( TOP, 5 );
    		increaseSpeed.getAllStyles().setPadding( BOTTOM, 5 );
    		decreaseSpeed.getAllStyles().setPadding( TOP, 5 );
    		decreaseSpeed.getAllStyles().setPadding( BOTTOM, 5 );
    		turnLeft.getAllStyles().setPadding( TOP, 5 );
    		turnLeft.getAllStyles().setPadding( BOTTOM, 5 );
    		turnRight.getAllStyles().setPadding( TOP, 5 );
    		turnRight.getAllStyles().setPadding( BOTTOM, 5 );
    		fireMissile.getAllStyles().setPadding( TOP, 5 );
    		fireMissile.getAllStyles().setPadding( BOTTOM, 5 );
    		jumpToMid.getAllStyles().setPadding( TOP, 5 );
    		jumpToMid.getAllStyles().setPadding( BOTTOM, 5 );
    		loadMissiles.getAllStyles().setPadding( TOP, 5 );
    		loadMissiles.getAllStyles().setPadding( BOTTOM, 5 );
    		quit.getAllStyles().setPadding( TOP, 5 );
    		quit.getAllStyles().setPadding( BOTTOM, 5 );
    		
    		//create tempContainer
    		
    		Container tempCWest = new Container();
    		tempCWest.setLayout( new BoxLayout( BoxLayout.Y_AXIS) );
    		tempCWest.add(addAsteroid);
    		tempCWest.add(addStation);
    		tempCWest.add(addShip);
    		tempCWest.add(increaseSpeed);
    		tempCWest.add(decreaseSpeed);
    		tempCWest.add(turnLeft);
    		tempCWest.add(turnRight);
    		tempCWest.add(fireMissile);
    		tempCWest.add(jumpToMid);
    		tempCWest.add(loadMissiles);
    		tempCWest.add(quit);
    		
    		//adding the Container to the West border
    		westContainer = FlowLayout.encloseCenterMiddle( tempCWest );
    		westContainer.getAllStyles().setBorder( Border.createLineBorder( 4, ColorUtil.rgb( 0, 0, 0 ) ) );
    		this.add( BorderLayout.WEST, westContainer );
    		
    		
    		//--------------South Container-------------------//
//    		Container southContainer = new Container();
//    		southContainer.setLayout( new FlowLayout() );
    		
//    		Button tickClock = new Button( "Tick Clock" );
    		
    		//Purple 'Tick Clock'
//    		tickClock.getAllStyles().setBgTransparency( 255 );
//    		tickClock.getUnselectedStyle().setBgColor( ColorUtil.rgb( 150, 0, 150 ) );
//    		tickClock.getAllStyles().setFgColor( ColorUtil.rgb( 255, 255, 255 ) );
    		
    		//Set some button padding
//    		tickClock.getAllStyles().setPadding( TOP, 5 );
//    		tickClock.getAllStyles().setPadding( BOTTOM, 5 );
    		
    		//Then attach all the buttons to a temporary container.
//    		Container tempCSouth = new Container();
//    		tempCSouth.setLayout( new FlowLayout() );
//    		tempCSouth.add( tickClock );
    		
    		//Then attach to the SOUTH border
//    		southContainer = FlowLayout.encloseCenterMiddle( tempCSouth );
//    		southContainer.getAllStyles().setBorder( Border.createLineBorder( 4, ColorUtil.rgb( 0, 0, 0 ) ) );
//    		this.add( BorderLayout.SOUTH, southContainer );
    	
    		//------------- Center Container -----------------//
    		
    		//Attach the map to what's left in the CENTER border
    		mv.getAllStyles().setBorder( Border.createLineBorder( 4, ColorUtil.rgb(0, 0, 0) ) );
    		this.add( BorderLayout.CENTER, mv );
    		
    		//creates a timer for animation
    		UITimer timer = new UITimer (this);
    		timer.schedule(20, true, this);
    		
    		gw.setTimer(timer);
    		
    		gw.setGameForm(this);
    		
    		//Then show it all at the end
    		this.show();
    		
    		//Then initialize a game world at the end and attach the observers
    		gw.addObserver(mv);
    		gw.addObserver(sv);
    		
    		//~~~~~~~~~~~~~~~~~~~~~~ ALL COMMANDS BELOW ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    		
    		//Declare all the needed commands for the buttons, keys, and side bar
    		AddAsteroidCommand myAddAsteroid = new AddAsteroidCommand(gw);
    		AddStationCommand myAddStation = new AddStationCommand(gw);
    		AddShipCommand myAddShip = new AddShipCommand(gw);
    		IncreaseSpeedCommand myIncreaseSpeed = new IncreaseSpeedCommand(gw);
    		DecreaseSpeedCommand myDecreaseSpeed = new DecreaseSpeedCommand(gw);
    		TurnLeftCommand myTurnLeft = new TurnLeftCommand(gw);
    		TurnRightCommand myTurnRight = new TurnRightCommand(gw);
    		FireMissileCommand myFireMissile = new FireMissileCommand(gw);
    		JumpToMidCommand myJumpToMid = new JumpToMidCommand(gw);
    		LoadMissilesCommand myLoadMissiles = new LoadMissilesCommand(gw);
    		QuitCommand myQuit = new QuitCommand();
    		SoundCheckCommand mySoundCheck = new SoundCheckCommand(gw);
    		PauseGameCommand myPausedGame = new	PauseGameCommand(gw);
    		
    		addAsteroid.setCommand( myAddAsteroid );
    		addStation.setCommand(myAddStation);
    		addShip.setCommand(myAddShip);
    		increaseSpeed.setCommand(myIncreaseSpeed);
    		decreaseSpeed.setCommand(myDecreaseSpeed);
    		turnLeft.setCommand(myTurnLeft);
    		turnRight.setCommand(myTurnRight);
    		fireMissile.setCommand(myFireMissile);
    		jumpToMid.setCommand(myJumpToMid);
    		loadMissiles.setCommand(myLoadMissiles);
    		quit.setCommand(myQuit);
  
    		//Then the commands to the keys
    		addKeyListener( 'a', myAddAsteroid );
    		addKeyListener( 'b', myAddStation );
    		addKeyListener( 's', myAddShip );
    		addKeyListener( 'i', myIncreaseSpeed);
    		addKeyListener( 'd', myDecreaseSpeed);
    		addKeyListener( 'l', myTurnLeft);
    		addKeyListener( 'r', myTurnRight);
    		addKeyListener( 'f', myFireMissile);
    		addKeyListener( 'j', myJumpToMid);
    		addKeyListener( 'n', myLoadMissiles);
    		addKeyListener( 'q', myQuit);
    		
    		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Natural Title Bar ~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    		//Create a new toolbar to act as the title bar
    		Toolbar tb = new Toolbar();
    		setToolbar(tb); 	//Set the toolbar to this form
    		//First create the title
    		tb.setTitle( "Asteroid Game" );
    		tb.setTitleCentered( true ); //Center it
    			
    		
    		//Then add a check box for sound
    		CheckBox soundCheck = new CheckBox( "Turn Sound ON / OFF" );
    		CheckBox pauseGame = new CheckBox("Pause game");
    		//Make it look prettier
    		soundCheck.getAllStyles().setBgTransparency( 255 );
    		soundCheck.getAllStyles().setBgColor( ColorUtil.rgb( 150, 150, 150 ) );
    		pauseGame.getAllStyles().setBgTransparency( 255 );
    		pauseGame.getAllStyles().setBgColor( ColorUtil.rgb( 150, 150, 150 ) );//Mild Gray
    		//Add the command to it
    		soundCheck.setCommand( mySoundCheck );
    		pauseGame.setCommand( myPausedGame );
    		
    		//Then add it to the side menu
    		//mySoundCheck.putClientProperty("SideComponent", soundCheck);
    		soundCheck.setText( "Turn Sound ON / OFF" );
    		pauseGame.setText("Pause Game");
    		tb.addComponentToSideMenu( soundCheck );
    		tb.addComponentToSideMenu( pauseGame );
    		
    		this.show();
    		
    		//At the very end update the world
    		gw.updateWorld();
        }
        
        public void run()
        {
        	Dimension dCmpSize = new Dimension(mv.getWidth(), mv.getHeight());
        	gw.tickClock(dCmpSize);
        	
        	GameCollection gameObjects = gw.getGameObjects();
        	IIterator gameIterator = gameObjects.getIterator();
        	
        	while(gameIterator.hasNext())
        	{
        		ICollider currentObj = (ICollider) gameIterator.getNext();
        		
        		IIterator gameIterator2 = gameObjects.getIterator();
        		while(gameIterator2.hasNext())
        		{
        			ICollider otherObj = (ICollider) gameIterator2.getNext();
        			
        			if(currentObj != otherObj)
        			{
        				if(currentObj.collidesWith((GameObject)otherObj))
        				{
        					currentObj.handleCollision(otherObj, gw);
        					break;
        				}
        				
        			}
        		}
        	}
        	mv.repaint();
        }
}
