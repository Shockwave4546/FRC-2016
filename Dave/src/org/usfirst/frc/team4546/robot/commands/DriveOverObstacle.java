package org.usfirst.frc.team4546.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveOverObstacle extends CommandGroup {

	public DriveOverObstacle()	{
		
		addSequential(new AutoDrive(1, 59.6));
	}

}
