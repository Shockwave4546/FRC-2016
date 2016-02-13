package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {
		
	//This command handles driving the robot
	
	public Drive()	{
		
		requires(Robot.drivetrain);
	}
	
	protected void initialize() {

	}

	protected void execute() {
		Robot.drivetrain.drive(Robot.oi.getDriveStick().getZ(), Robot.oi.getDriveStick().getY(), 1);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	
	}

	protected void interrupted() {

	}

}
