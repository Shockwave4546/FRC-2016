package org.usfirst.frc.team4546.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveOverObstacle extends CommandGroup {

	public enum Obstacle	{
		
		RAMPART	(1),
		MOAT	(1),
		WALL	(1),
		TERRAIN	(1);
		
		private final double speed;
		Obstacle(double speed)	{
			this.speed = speed;
		}
		
		double speed()	{
			 return speed;
		}
	}
	
	public DriveOverObstacle(Obstacle obstacle)	{
		
		addSequential(new AutoDrive(obstacle.speed(), 59.6));
	}
	
	public DriveOverObstacle()	{
		
		addSequential(new AutoDrive(1, 59.6));
	}

}
