package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PitchCannon extends Command {
	
	//This command handles pitching the cannon
	
	double speed;
	
	public PitchCannon(double speed) {
		this.speed = speed;
	}
		
	protected void end() {


	}

	protected void execute() {
		Robot.cannon.setPitchMotor(Robot.oi.getGunnerStick().getY());
	}

	protected void initialize() {

	}

	protected void interrupted() {

	}

	protected boolean isFinished() {
		return false;
	}

}
