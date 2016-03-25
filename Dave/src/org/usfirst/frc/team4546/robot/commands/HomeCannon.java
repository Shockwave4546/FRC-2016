package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class HomeCannon extends CommandGroup {
	
	public HomeCannon()	{
		
		requires(Robot.cannon);
		addSequential(new AutoPitchCannon(-1, Robot.clearPitch));
		addSequential(new AutoYawCannon(1, Robot.homeYaw));
		addSequential(new AutoPitchCannon(1, Robot.homePitch));
	}

}
