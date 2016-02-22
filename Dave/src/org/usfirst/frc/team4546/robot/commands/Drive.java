package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {
		
	//This command handles driving the robot
	
	double driveY;
	double driveZ;
	
	public Drive()	{
		
		requires(Robot.drivetrain);
	}
	
	protected void initialize() {

	}

	protected void execute() {
	
    	
    	//Check X-axis deadzone
    	if (Robot.oi.getDriveStick().getY() <= .04 && Robot.oi.getDriveStick().getY() >= -.04)	{
    		
    		driveY = 0;
    	}	else	{
    	
    		driveY = Robot.oi.getDriveStick().getY();
    	}
    	
    	//Chack Z-axis deadzone
    	if (Robot.oi.getDriveStick().getZ() <= .01 && Robot.oi.getDriveStick().getZ() >= -.01)	{
    		
    		driveZ = 0;
    	}	else	{
    		
    		//Adjust for smaller range of motion on the Z-axis
    		driveZ = (Robot.oi.getDriveStick().getZ()/1.25);
    	}
    	
    	//Drive the robot
    	Robot.drivetrain.drive(Math.pow(driveZ, 2), Math.pow(driveY, 2), Robot.speed);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	
	}

	protected void interrupted() {

	}

}
