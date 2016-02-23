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
	
    	/*
    	//Check X-axis deadzone
    	if (Robot.oi.getDriveStick().getY() <= .04 && Robot.oi.getDriveStick().getY() >= -.04)	{
    		
    		driveY = 0;
    	}	else	{
    	
    		if(Robot.oi.getDriveStick().getY() < 0)	{
    			
    			driveY = -Math.pow(Robot.oi.getDriveStick().getY(), 2);
    		}	else	{
    			
    			driveY = Math.pow(Robot.oi.getDriveStick().getY(), 2);
    		}
    	}
    	
    	//Chack Z-axis deadzone
    	if (Robot.oi.getDriveStick().getZ() <= .01 && Robot.oi.getDriveStick().getZ() >= -.01)	{
    		
    		driveZ = 0;
    	}	else	{
    		
    		//Adjust for smaller range of motion on the Z-axis
    		if(Robot.oi.getDriveStick().getZ() < 0)	{
    			
    			driveZ = -Math.pow(Robot.oi.getDriveStick().getZ(), 2);
    		}	else	{
    			
        		driveZ = Math.pow(Robot.oi.getDriveStick().getZ(), 2);
    		}
    	}
    	
    	//Drive the robot
    	Robot.drivetrain.drive(driveZ, driveY, Robot.speed);
    	*/
		Robot.drivetrain.drive(Robot.oi.getDriveStick().getRawAxis(0), Robot.oi.getDriveStick().getRawAxis(2), Robot.speed);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	
	}

	protected void interrupted() {

	}

}
