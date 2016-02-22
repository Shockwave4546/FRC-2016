package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PitchCannon extends Command {
	
	//This command handles pitching the cannon
	
	double speed;
	
	public PitchCannon() {
		
	}
		
	protected void end() {

		Robot.cannon.setPitchMotor(0, 0);
	}

	protected void execute() {
		
		if(Robot.oi.getGunnerStick().getY() < 0)	{
			
			speed = Math.pow(Robot.oi.getGunnerStick().getY(), 2);
		}	else	{
			speed = -Math.pow(Robot.oi.getGunnerStick().getY(), 2);
		}
		Robot.cannon.setPitchMotor(speed, Robot.cannonSpeed);
	}

	protected void initialize() {

	}

	protected void interrupted() {

		Robot.cannon.setPitchMotor(0, 0);
	}

	protected boolean isFinished() {
		//TODO cahnge to &&
		return !(Robot.upperLimit >= Robot.cannon.getPitch() || Robot.lowerLimit <= Robot.cannon.getPitch());
	}

}
