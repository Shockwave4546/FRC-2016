package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;
import org.usfirst.frc.team4546.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoFire extends CommandGroup {
	
	//This command group handles the automatic targeting and firing process
	/*
	double midpointX = Robot.table.getNumber("midpointX", 0.0);
	double midpointY = Robot.table.getNumber("midpointY", 0.0);
	
	public boolean seesTarget() {
		if((midpointX == 0.0) && (midpointY == 0.0)) {
			return false;
		} else {
			return true;
		}
	}
	
	public	AutoFire()	{
		if(seesTarget() && Robot.cannon.hasBall()) {
			addParallel(new TrackTargetX());
			addSequential(new TrackTargetY());			
			if(Robot.oi.getDriveStick().getRawButton(1)) {				
				addSequential(new AimToFire());
				addSequential(new FireCannon(), 1);				
			}
		} else {
			//addParallel(new ControlCannon(Robot.oi.getDriveStick().getX(), Robot.oi.getDriveStick().getY()));
		}
		
	}*/

}
