package org.usfirst.frc.team4546.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class HomeCannon extends CommandGroup {
	
	double homePitch;
	
	public HomeCannon()	{
		
		addSequential(new AutoPitchCannon(1, homePitch));
		addSequential(new AutoYawCannon(1, 180));
		
	}

}
