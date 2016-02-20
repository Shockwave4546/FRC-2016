package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class FireCannon extends Command {
	
	//This command handles firing the cannon
	
	boolean finished = false;
	
	protected void end() {
		Robot.cannon.setFeedServo(70);
		Robot.cannon.setFireLeft(0);
		Robot.cannon.setFireRight(0);

	}

	
	protected void execute() {
		
	
	}

	
	protected void initialize() {
		Robot.cannon.setFireLeft(-1);
		Robot.cannon.setFireRight(-1);
		Timer.delay(.25);
		Robot.cannon.setFeedServo(150);
		Timer.delay(1);
		finished = true;

	}

	
	protected void interrupted() {
		
		Robot.cannon.setFireLeft(0);
		Robot.cannon.setFireRight(0);
	}

	
	protected boolean isFinished() {
		
		return finished;
	}

}
