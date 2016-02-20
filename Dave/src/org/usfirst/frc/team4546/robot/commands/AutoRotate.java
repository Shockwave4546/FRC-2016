package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoRotate extends Command {

	double speed;
	double angle;
	
	public AutoRotate(double speed, double angle)	{
		
		this.speed = speed;
		this.angle = angle;
	}
	
	protected void initialize() {

	}

	protected void execute() {

		Robot.drivetrain.drive(0, speed, 1);
	}

	protected boolean isFinished() {
		return Robot.drivetrain.getAngle() == angle;
	}

	protected void end() {

		Robot.drivetrain.drive(0, 0, 0);
	}

	protected void interrupted() {

		Robot.drivetrain.drive(0, 0, 0);
	}

}
