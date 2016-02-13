package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.*;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TrackTargetX extends PIDCommand {

	//This command handles tracking the target along the X-axis
	
	static double p = 0.01;
	static double i = 0;
	static double d = 0;
	static double tolerance = 2.0f;
	static double minimumInput = 0;
	static double maximumInput = 1920;
	double turnRate;
	double targetDistanceX = 2;
	
	public TrackTargetX() {
		super("Track Target", p, i, d);
		getPIDController().setInputRange(minimumInput, maximumInput);
		getPIDController().setOutputRange(-.1, .1);
		getPIDController().setAbsoluteTolerance(tolerance);
		getPIDController().setContinuous(true);
		
	}
	
	protected double returnPIDInput() {
		return 960 - Robot.table.getNumber("midpointX", 960);
	}

	protected void usePIDOutput(double output) {
		
		turnRate = output;
		
	}

	protected void initialize() {
	
	}

	protected void execute() {
	Robot.cannon.setYawMotor(turnRate);
	
	SmartDashboard.putNumber("turnRate", turnRate);
	SmartDashboard.putNumber("targetDistanceX", targetDistanceX);
		
	}

	protected boolean isFinished() {
		return Robot.table.getNumber("midpointX", 960) > 945 && Robot.table.getNumber("midpointX", 960) < 975;
	}

	protected void end() {
		cancel();
	}

	protected void interrupted() {

	}

}
