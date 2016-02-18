package org.usfirst.frc.team4546.robot.triggers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class POVButton extends Trigger {

	private Joystick joystick;
	private int POV;
	private int degrees;
	
	public POVButton(Joystick joystick, int pov, int degrees)	{
		
		this.joystick = joystick;
		this.POV = pov;
		this.degrees = degrees;
	}
	
	public boolean get() {

		return joystick.getPOV(POV) == degrees;
		
	}

}
