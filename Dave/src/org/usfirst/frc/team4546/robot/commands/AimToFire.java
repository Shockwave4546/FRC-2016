package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;
import org.usfirst.frc.team4546.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class AimToFire extends Command {
	
	//This command pitches the turret to the correct firing angle
	
	double theta = Robot.cannon.getPitch();
	
	double cannonHeight;	//Physically Measured
	double PMHeight;		//Physically Measured
	double dEOCToCamera;	//Physically Measured
	
	double distance = (91 - ((Math.cos(theta) * cannonHeight) + (dEOCToCamera/Math.sin(theta)) + PMHeight))/Math.sin(theta);
	
	public AimToFire() {
		
	}
	protected void end() {
		

	}

	
	protected void execute() {
		

	}

	
	protected void initialize() {
		

	}

	
	protected void interrupted() {
		

	}

	
	protected boolean isFinished() {
		
		return false;
	}

}
