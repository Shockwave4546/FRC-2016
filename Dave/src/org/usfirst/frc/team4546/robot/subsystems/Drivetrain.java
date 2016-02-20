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
	Talon left = RobotMap.drivetrainLeft;
	Talon right = RobotMap.drivetrainRight;
	RobotDrive chassis = RobotMap.drivetrainChassis;
	
	//Drivetrain will pretty much always drive
	protected void initDefaultCommand() {
		setDefaultCommand(new Drive());	
	}	
	
	//Pass a forward speed, a rotation value, and an optional speed multiplier
	//Set speed to 1 to disable multiplier
	public void drive(double magnitude, double rotate, double speed)	{		
		chassis.arcadeDrive(magnitude*speed, rotate*speed);
	}
	
	//Get the yaw of the drivetrain itself
	public double getAngle() {
		
		if(drivetrainAHRS.getAngle() <= 90)	{
			return 90 - drivetrainAHRS.getAngle();
		}	else	{
			return drivetrainAHRS.getAngle() - 90;
		}
	}

	//Zero the yaw value of the gyro
	public void zeroYaw() {
		drivetrainAHRS.zeroYaw();
	}
	
	//Reset the gyro
	public void reset() {
		drivetrainAHRS.reset();
	}		

	//Front-back displacement
	public double getDisplacementX()	{
		return drivetrainAHRS.getDisplacementX();
	}
	
	//Left-Right Displacement
	public double getDisplacementY()	{
		return drivetrainAHRS.getDisplacementY();
	}
}        