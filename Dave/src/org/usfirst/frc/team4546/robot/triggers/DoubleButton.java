package org.usfirst.frc.team4546.robot.triggers;

import edu.wpi.first.wpilibj.buttons.*;

public class DoubleButton extends Trigger {	
	
	private Button firstButton;
	private Button secondButton;
	
	public DoubleButton(Button firstButton, Button secondButton)	{
		
		this.firstButton = firstButton;
		this.secondButton = secondButton;
		
	}
	public boolean get() {
		
		return firstButton.get() && secondButton.get();

	}

}
