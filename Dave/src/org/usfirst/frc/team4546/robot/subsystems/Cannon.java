package org.usfirst.frc.team4546.robot.subsystems;

import org.usfirst.frc.team4546.robot.Robot;
import org.usfirst.frc.team4546.robot.RobotMap;

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
	Servo feedBall = RobotMap.cannonFeedBall;
	DigitalInput limitSwitch = RobotMap.cannonLimitSwitch;
	public void setPitchMotor(double speed) {
		pitchMotor.set(speed);
	}
	
	public void setYawMotor(double speed) {
		yawMotor.set(speed);
	}
	
	public void setFireLeft(double speed) {
		fireLeft.set(speed);
	}
	
	public void setFireRight(double speed) {
		fireRight.set(speed);
	}
	
	public void setFeedBall(double servoAngle) {
		feedBall.setAngle(servoAngle);
	}
	
	public boolean hasBall()	{
		
		return limitSwitch.get();
	}
	
	protected void initDefaultCommand() {
		
	}
	
}
