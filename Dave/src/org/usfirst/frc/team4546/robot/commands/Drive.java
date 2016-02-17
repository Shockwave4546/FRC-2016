package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {
		
	//This command handles driving the robot
	
	double driveX;
	double driveZ;
	
	public Drive()	{
		
		requires(Robot.drivetrain);
	}
	
	protected void initialize() {

	}

	protected void execute() {
		
		//Set the speed to the throttle from the driveStick
    	Robot.speed = ((-Robot.oi.getDriveStick().getThrottle() + 1) / 2);
    	
    	//Check X-axis deadzone
    	if (Robot.oi.getDriveStick().getX() <= .04 && Robot.oi.getDriveStick().getX() >= -.04)	{
    		
    		driveX = 0;
    	}	else	{
    	
    		driveX = Robot.oi.getDriveStick().getX();
    	}
    	
    	//Chack Z-axis deadzone
    	if (Robot.oi.getDriveStick().getZ() <= .01 && Robot.oi.getDriveStick().getZ() >= -.01)	{
    		
    		driveZ = 0;
    	}	else	{
    		
    		//Adjust for smaller range of motion on the Z-axis
    		driveZ = (Robot.oi.getDriveStick().getZ()/2);
    	}
    	
    	//Drive the robot
    	Robot.drivetrain.drive(driveX, driveZ, Robot.speed);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	
	}

	protected void interrupted() {

	}

}
