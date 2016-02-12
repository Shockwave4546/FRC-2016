package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class YawCannon extends Command {
	
	double speed;

	public YawCannon(double speed) {
		this.speed = speed;
	}

	protected void end() {

	}

	protected void execute() {
		Robot.cannon.setYawMotor(speed);
	}

	protected void initialize() {

	}

	protected void interrupted() {

	}

	protected boolean isFinished() {
		return false;
	}

}
