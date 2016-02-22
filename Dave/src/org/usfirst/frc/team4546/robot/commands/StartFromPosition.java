package org.usfirst.frc.team4546.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartFromPosition extends CommandGroup {
	
	public enum Position	{
		
		ONE		(0, 0, 0),
		TWO		(1, 1, 1),
		THREE 	(2, 2, 2),
		FOUR	(3, 3, 3),
		FIVE	(4, 4, 4);
		
		private final double distance;
		private final double yaw;
		private final double pitch;
		
		Position(double distance, double yaw, double pitch)	{
			
			this.distance = distance;
			this.yaw = yaw;
			this.pitch = pitch;
		}
		
		double distance()	{
			
			return distance;
		}
		
		double yaw()	{
			
			return yaw;
		}
		
		double pitch()	{
			
			return pitch;
		}
	}
	
	public StartFromPosition(Position position)	{
		
		addSequential(new AutoDrive(1, 0));
		addSequential(new AutoYawCannon(1, 270));
		addSequential(new AutoPitchCannon(1, 0));
		addSequential(new FireCannon());
		
	}

}
