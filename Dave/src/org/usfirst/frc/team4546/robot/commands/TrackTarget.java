package org.usfirst.frc.team4546.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TrackTarget extends CommandGroup {

	public TrackTarget() {
		addParallel(new TrackTargetX());
		addParallel(new TrackTargetY());
	}
}