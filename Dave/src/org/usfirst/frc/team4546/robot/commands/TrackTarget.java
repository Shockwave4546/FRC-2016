package org.usfirst.frc.team4546.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TrackTarget extends CommandGroup {

	//This command group allows X and Y tracking to run parallel while being scheduled sequentially
	//Not used with current configuration
	
	public TrackTarget() {
		addParallel(new TrackTargetX());
		addParallel(new TrackTargetY());
	}
}