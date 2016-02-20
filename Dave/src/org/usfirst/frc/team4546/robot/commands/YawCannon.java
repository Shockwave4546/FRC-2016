package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class YawCannon extends Command {
	
	//This command controls the yaw of the cannon
	
	double speed;
	public YawCannon(double speed) {
		this.speed = speed;
	}

	protected void end() {

	}

	protected void execute() {
		Robot.cannon.setYawMotor(Robot.oi.getGunnerStick().getZ()/1.5, Robot.cannonSpeed);
	}

	protected void initialize() {

	}

	protected void interrupted() {

	}

	protected boolean isFinished() {
		return Robot.lowerLimit <= Robot.cannon.getYaw() && Robot.upperLimit >= Robot.cannon.getYaw();
	}

}
