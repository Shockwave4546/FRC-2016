package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command {

	double speed;
	double distance;
	
	public AutoDrive(double speed)	{
		
		this.speed = speed;
		requires(Robot.drivetrain);
	}
	
	protected void initialize() {

	}

	protected void execute() {
		
		Robot.drivetrain.drive(0, speed, 1);
	}

	protected boolean isFinished() {

		return false;
	}

	protected void end() {

		Robot.drivetrain.drive(0, 0, 0);
	}

	protected void interrupted() {

		Robot.drivetrain.drive(0, 0, 0);
	}

}
