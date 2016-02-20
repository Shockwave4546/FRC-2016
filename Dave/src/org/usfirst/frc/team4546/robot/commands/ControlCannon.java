package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ControlCannon extends CommandGroup {
	
	//This command group handles operator control of the cannon
	
	public ControlCannon() {
		addParallel(new YawCannon(1));
		addParallel(new PitchCannon(1));
		requires(Robot.cannon);
		
	}
}