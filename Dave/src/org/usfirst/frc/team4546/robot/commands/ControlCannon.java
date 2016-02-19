package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ControlCannon extends CommandGroup {
	
	//This command group handles operator control of the cannon
	
	public ControlCannon() {
		addParallel(new YawCannon());
		addParallel(new PitchCannon());
		requires(Robot.cannon);
		
	}
}