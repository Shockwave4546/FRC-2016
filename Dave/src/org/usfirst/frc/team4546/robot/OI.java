package org.usfirst.frc.team4546.robot;

import org.usfirst.frc.team4546.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	Joystick driveStick;
	Joystick gunnerStick;
	
	public OI()	{		
		driveStick = new Joystick(0);		
		gunnerStick = new Joystick(1);
		
		//Joystick buttons
				//Uncomment any button to open it for binding
			   	//Button trigger = new JoystickButton(driveStick, 1);
			   	//Button thumbButton = new JoystickButton(driveStick, 2);
			   	//Button threeButton = new JoystickButton(driveStick, 3);
			   	//Button fourButton = new JoystickButton(driveStick, 4);
			   	//Button fiveButton= new JoystickButton(driveStick, 5);
			   	//Button sixButton = new JoystickButton(driveStick, 6);
			   	//Button sevenButton = new JoystickButton(driveStick, 7);
			   	//Button eightButton = new JoystickButton(driveStick, 8);
			   	//Button nineButton = new JoystickButton(driveStick, 9);
			   	//Button tenButton = new JoystickButton(driveStick, 10);
			   	//Button elevenButton = new JoystickButton(driveStick, 11);
			   	//Button twelveButton = new JoystickButton(driveStick, 12);
			   	
			   	
			  //Uncomment any button to open it for binding
			   	Button trigger = new JoystickButton(gunnerStick, 1);
			   	//Button thumbButton = new JoystickButton(gunnerStick, 2);
			   	//Button threeButton = new JoystickButton(gunnerStick, 3);
			   	//Button fourButton = new JoystickButton(gunnerStick, 4);
			   	//Button fiveButton= new JoystickButton(gunnerStick, 5);
			   	//Button sixButton = new JoystickButton(gunnerStick, 6);
			   	//Button sevenButton = new JoystickButton(gunnerStick, 7);
			   	//Button eightButton = new JoystickButton(gunnerStick, 8);
			   	//Button nineButton = new JoystickButton(gunnerStick, 9);
			   	//Button tenButton = new JoystickButton(gunnerStick, 10);
			   	//Button elevenButton = new JoystickButton(gunnerStick, 11);
			   	//Button twelveButton = new JoystickButton(gunnerStick, 12);
			   	
			   	trigger.whenPressed(new FireCannon());
	}
	
		
	
	   	//Used to access joystick values
	public Joystick getDriveStick()	{		
		
	   	return driveStick;
	}
	
	public Joystick getGunnerStick()	{
		
		return gunnerStick;
	}
}

