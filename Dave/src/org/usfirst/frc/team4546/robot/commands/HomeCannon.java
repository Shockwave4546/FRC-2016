package org.usfirst.frc.team4546.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class HomeCannon extends CommandGroup {
	
	public HomeCannon()	{
		
		addSequential(new AutoPitchCannon(1, 345));
		addSequential(new AutoYawCannon(1, 180));
		
	}

}
