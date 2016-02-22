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
		
		
		Robot.cannon.setPitchMotor(-Math.pow(Robot.oi.getGunnerStick().getY(), 2), Robot.cannonSpeed);
	}

	protected void initialize() {

	}

	protected void interrupted() {

	}

	protected boolean isFinished() {
		return Robot.leftLimit <= Robot.cannon.getPitch() && Robot.rightLimit >= Robot.cannon.getPitch();
	}

}
