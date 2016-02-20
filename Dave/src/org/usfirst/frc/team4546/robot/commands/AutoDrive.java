package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command {

	double speed;
	double distance;
	
	public AutoDrive(double speed, double distance)	{
		
		this.speed = speed;
		this.distance = distance;
		requires(Robot.drivetrain);
	}
	
	protected void initialize() {

	}

	protected void execute() {
		
		Robot.drivetrain.drive(speed, 0, 1);
	}

	protected boolean isFinished() {

		return Robot.drivetrain.getDisplacementX() == distance;
	}

	protected void end() {

		Robot.drivetrain.drive(0, 0, 0);
	}

	protected void interrupted() {

		Robot.drivetrain.drive(0, 0, 0);
	}

}
