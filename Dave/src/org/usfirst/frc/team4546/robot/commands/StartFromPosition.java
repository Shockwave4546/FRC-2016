package org.usfirst.frc.team4546.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartFromPosition extends CommandGroup {
	
	public enum Position	{
		
		ONE		(0),
		TWO		(1),
		THREE 	(2),
		FOUR	(3),
		FIVE	(4);
		
		private final double distance;
		
		Position(double distance)	{
			
			this.distance = distance;
		}
		
		double distance()	{
			
			return distance;
		}
	}
	
	public StartFromPosition(Position position)	{
		
		addSequential(new AutoDrive(1, 0));
		addSequential(new AutoRotate(1, 90));
		addSequential(new AutoDrive(1, position.distance()));
		addSequential(new AutoYawCannon(1, 270));
		addSequential(new AutoPitchCannon(1, 0));
		addSequential(new FireCannon());
		
	}

}
