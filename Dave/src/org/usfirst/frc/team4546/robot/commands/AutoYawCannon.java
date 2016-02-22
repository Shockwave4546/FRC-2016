package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoYawCannon extends Command {

	double speed;
	double angle;
	
	public AutoYawCannon(double speed, double angle)	{
		
		this.speed = speed;
		this.angle = angle;
	}
	
	protected void initialize() {

	}

	protected void execute() {

		Robot.cannon.setYawMotor(speed, 1);
	}
	
	protected boolean isFinished() {
		
		if(speed < 0)	{
			return Robot.cannon.getYaw() >= angle;
		}	else	{
			return Robot.cannon.getYaw() <= angle;
		}
		
	}

	protected void end() {
		
		Robot.cannon.setYawMotor(0, 0);
	}

	protected void interrupted() {

		Robot.cannon.setYawMotor(0, 0);
	}

}
