package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveIntake extends Command {
	
	private double speed;
	
	public MoveIntake(double speed) {
	
	this.speed = speed;
		
	}
	
	protected void initialize() {

	}

	protected void execute() {
		Robot.cannon.setFireLeft(speed);
		Robot.cannon.setFireRight(speed);
	}

	protected boolean isFinished() {
		
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {

	}

}
