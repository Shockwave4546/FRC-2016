package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PitchCannon extends Command {
	
	//This command handles pitching the cannon
	
	double speed;
	
	public PitchCannon() {
		
	}
		
	protected void end() {


	}

	protected void execute() {
		
		if(Robot.oi.getGunnerStick().getZ() < 0)	{
			
			speed = -Math.pow(Robot.oi.getGunnerStick().getY(), 2);
		}	else	{
			speed = Math.pow(Robot.oi.getGunnerStick().getY(), 2);
		}
		Robot.cannon.setPitchMotor(speed, Robot.cannonSpeed);
	}

	protected void initialize() {

	}

	protected void interrupted() {

	}

	protected boolean isFinished() {
		return Robot.leftLimit <= Robot.cannon.getPitch() && Robot.rightLimit >= Robot.cannon.getPitch();
	}

}
