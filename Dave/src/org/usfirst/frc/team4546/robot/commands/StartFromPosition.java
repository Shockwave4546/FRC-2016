package org.usfirst.frc.team4546.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartFromPosition extends CommandGroup {
	
	public enum Position	{
		
		ONE		(0, 0, 0),
		TWO		(59.6, 39.65, 26.99),
		THREE 	(59.6, 22.25, 31.47),
		FOUR	(59.6, 0.60, 33.48),
		FIVE	(59.6, 23.27, 31.28);
		
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
		
		addSequential(new AutoDrive(1, position.distance()));
		addSequential(new AutoYawCannon(-1, position.yaw()));
		addSequential(new AutoPitchCannon(-1, position.pitch()));
		addSequential(new FireCannon());
		
	}

}
