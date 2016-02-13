package org.usfirst.frc.team4546.robot.subsystems;

import org.usfirst.frc.team4546.robot.RobotMap;
import org.usfirst.frc.team4546.robot.commands.Drive;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {
	
	AHRS drivetrainAHRS = RobotMap.drivetrainAHRS;
	CANTalon left = RobotMap.drivetrainLeft;
	CANTalon right = RobotMap.drivetrainRight;
	RobotDrive chassis = RobotMap.drivetrainChassis;
	
	protected void initDefaultCommand() {
		setDefaultCommand(new Drive());	
	}	
	
	public void drive(double magnitude, double rotate, double speed)	{		
		chassis.arcadeDrive(magnitude*speed, rotate*speed);
	}
	
	public double getAngle() {
		return drivetrainAHRS.getAngle();
	}

	public void zeroYaw() {
		drivetrainAHRS.zeroYaw();
	}
	
	public void reset() {
		drivetrainAHRS.reset();
	}		

}        