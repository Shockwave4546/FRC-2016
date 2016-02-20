package org.usfirst.frc.team4546.robot.subsystems;

import org.usfirst.frc.team4546.robot.Robot;
import org.usfirst.frc.team4546.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4546.robot.commands.*;

public class Cannon extends Subsystem {

	CANTalon fireRight = RobotMap.cannonFireRight;
	CANTalon fireLeft = RobotMap.cannonFireLeft;
	CANTalon yawMotor = RobotMap.cannonYawMotor;
	CANTalon pitchMotor = RobotMap.cannonPitchMotor;
	Servo feedServo = RobotMap.cannonFeedServo;
	DigitalInput ballLimit = RobotMap.cannonLimitSwitch;
	AnalogInput pitchEncoder = RobotMap.cannonPitchEncoder;
	AnalogInput yawEncoder = RobotMap.cannonYawEncoder;
	
	//Set speed of pitch motor
	public void setPitchMotor(double speed) {
		
		if(!(Robot.lowerLimit <= Robot.cannon.getPitch() && Robot.upperLimit >= Robot.cannon.getPitch()))	{

			pitchMotor.set(speed);
		}
	}
	
	//Set speed of yaw motor
	public void setYawMotor(double speed) {

		if(!(Robot.leftLimit <= Robot.cannon.getPitch() && Robot.rightLimit >= Robot.cannon.getPitch()))	{

			yawMotor.set(speed);
		}
	}
	
	//Set speed of left firing motor
	public void setFireLeft(double speed) {
		fireLeft.set(speed);
	}
	
	//Set speed of right firing motor
	public void setFireRight(double speed) {
		
		fireRight.set(speed);
	}
	
	//Set angle of feed servo
	public void setFeedServo(double servoAngle) {
		feedServo.setAngle(servoAngle);
	}
	
	//Returns true when ball is loaded
	public boolean hasBall()	{
		
		return ballLimit.get();
	}
	
	//Raw encoder voltage for debug
	public double getRawPitch()	{
		
		return pitchEncoder.getVoltage();
	}
	
	//Pitch of cannon
	public double getPitch()	{
		
		return 72*pitchEncoder.getVoltage();
	}
	
	//Raw encoder voltage for debug
	public double getRawYaw()	{
		
		return yawEncoder.getVoltage();
	}
	
	//Yaw of cannon
	public double getYaw()	{
		
		return 72*yawEncoder.getVoltage();
	}
	
	protected void initDefaultCommand() {
		
		setDefaultCommand(new ControlCannon());
	}
	
}
