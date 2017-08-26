package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {
		
	//This command handles driving the robot
	
	double driveY;
	double driveX;
	
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
    	
    		if(Robot.oi.getDriveStick().getY() < 0)	{
    			
    			driveY = -Math.pow(Robot.oi.getDriveStick().getY(), 2);
    		}	else	{
    			
    			driveY = Math.pow(Robot.oi.getDriveStick().getY(), 2);
    		}
    	}
    	
    	//Chack X-axis deadzone
    	if (Robot.oi.getDriveStick().getX() <= .01 && Robot.oi.getDriveStick().getX() >= -.01)	{
    		
    		driveX = 0;
    	}	else	{
    		
    		//Adjust for smaller range of motion on the X-axis
    		if(Robot.oi.getDriveStick().getX() < 0)	{
    			
    			driveX = -Math.pow(Robot.oi.getDriveStick().getX(), 2);
    		}	else	{
    			
        		driveX = Math.pow(Robot.oi.getDriveStick().getX(), 2);
    		}
    	}
    	
    	//Drive the robot
    	Robot.drivetrain.drive(driveX, driveY, Robot.speed);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	
	}

	protected void interrupted() {

	}

}
