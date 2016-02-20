package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoPitchCannon extends Command {

	double speed;
	double angle;
	
	public AutoPitchCannon(double speed, double angle)	{
		
		this.speed = speed;
		this.angle = angle;
	}
	
	protected void initialize() {

	}

	protected void execute() {

		Robot.cannon.setPitchMotor(speed, 1);
	}

	protected boolean isFinished() {
		return Robot.cannon.getPitch() == angle;
	}

	protected void end() {

	}

	protected void interrupted() {

	}

}
