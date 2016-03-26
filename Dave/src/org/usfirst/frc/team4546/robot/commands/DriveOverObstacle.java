package org.usfirst.frc.team4546.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveOverObstacle extends CommandGroup {

	public enum Obstacle	{
		
		RAMPART	(.9, 2.5),
		MOAT	(.9, 2.5),
		WALL	(.9, 2.5),
		TERRAIN	(.9, 2.5);
		
		private final double speed;
		private final double timeout;
		
		Obstacle(double speed, double timeout)	{
			this.speed = speed;
			this.timeout = timeout;
		}
		
		double speed()	{
			return speed;
		}
		
		double timeout()	{
			return timeout;
		}
	}
	
	public DriveOverObstacle(Obstacle obstacle)	{
		
		addSequential(new AutoDrive(obstacle.speed()), obstacle.timeout());
	}
	
	public DriveOverObstacle()	{
		
		addSequential(new AutoDrive(1), 2.5);
	}

}
