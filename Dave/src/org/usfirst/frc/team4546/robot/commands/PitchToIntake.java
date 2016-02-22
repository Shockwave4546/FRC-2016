package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PitchToIntake extends CommandGroup {
	
	public PitchToIntake()	{
		
		addSequential(new AutoPitchCannon(-1, Robot.lowerLimit));
	}

}
