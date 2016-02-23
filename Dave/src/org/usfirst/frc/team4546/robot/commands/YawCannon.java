package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class YawCannon extends Command {
	
	//This command controls the yaw of the cannon
	
	double speed;
	public YawCannon() {
		
	}

	protected void end() {

		Robot.cannon.setYawMotor(0, 0);
	}

	protected void execute() {
		
		if(Robot.oi.getGunnerStick().getZ() < 0)	{
			
			speed = -Math.pow(Robot.oi.getGunnerStick().getZ()/1.25, 2);
		}	else	{
			speed = Math.pow(Robot.oi.getGunnerStick().getZ()/1.25, 2);
		}
		Robot.cannon.setYawMotor(speed, Robot.cannonSpeed);
	}

	protected void initialize() {

	}

	protected void interrupted() {
		
		Robot.cannon.setYawMotor(0, 0);
	}

	protected boolean isFinished() {
		return !(Robot.leftLimit <= Robot.cannon.getYaw() && Robot.rightLimit >= Robot.cannon.getYaw());
	}

}
