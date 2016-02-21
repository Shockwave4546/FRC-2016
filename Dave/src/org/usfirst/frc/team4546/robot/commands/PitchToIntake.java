package org.usfirst.frc.team4546.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PitchToIntake extends CommandGroup {
	
	public PitchToIntake()	{
		
		addSequential(new AutoPitchCannon(1, 0));
	}

}
