package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ControlCannon extends CommandGroup {
	
	//This command group handles operator control of the cannon
	
	public ControlCannon(double x, double y) {
		addParallel(new YawCannon(Robot.oi.getDriveStick().getX()));
		addParallel(new PitchCannon(Robot.oi.getDriveStick().getY()));
		requires(Robot.cannon);
		
	}
}