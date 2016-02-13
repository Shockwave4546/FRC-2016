package org.usfirst.frc.team4546.robot;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Servo;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public static AHRS drivetrainAHRS;
	public static Talon drivetrainLeft;
	public static Talon drivetrainRight;
	public static RobotDrive drivetrainChassis;	
	
	public static CANTalon cannonYawMotor;
	public static CANTalon cannonPitchMotor;
	public static CANTalon cannonFireLeft;
	public static CANTalon cannonFireRight;
	public static Servo cannonFeedServo;
	public static DigitalInput cannonLimitSwitch;
	public static AnalogInput cannonPitchEncoder;
	public static AnalogInput cannonYawEncoder;
	
	public static void init()	{
		
		drivetrainLeft = new Talon(0);
		LiveWindow.addActuator("Drivetrain", "Left Motor", (Talon) drivetrainLeft);
		
		drivetrainRight = new Talon(1);
		LiveWindow.addActuator("Drivetrain", "Right Motor", (Talon) drivetrainRight);
		
		drivetrainChassis = new RobotDrive(drivetrainLeft, drivetrainRight);
		
		drivetrainAHRS = new AHRS(SPI.Port.kMXP);
        LiveWindow.addActuator("Drivetrain", "Gyro", (AHRS) drivetrainAHRS);
		
		drivetrainChassis.setSafetyEnabled(true);
		drivetrainChassis.setExpiration(0.1);
        drivetrainChassis.setSensitivity(0.5);
        drivetrainChassis.setMaxOutput(1.0);
        
        drivetrainChassis.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        
        cannonYawMotor = new CANTalon(0);
        LiveWindow.addActuator("Cannon", "Yaw Motor", (CANTalon) cannonYawMotor);
        
        cannonPitchMotor = new CANTalon(1);
        LiveWindow.addActuator("Cannon", "Pitch Motor", (CANTalon) cannonPitchMotor);
        
        cannonFireLeft = new CANTalon(2);
        LiveWindow.addActuator("Cannon", "Left Firing Motor", (CANTalon) cannonFireLeft);
        
        cannonFireRight = new CANTalon(3);
        LiveWindow.addActuator("Cannon", "Right Firing Motor", (CANTalon) cannonFireRight);
        
        cannonFeedServo = new Servo(2);
        LiveWindow.addActuator("Cannon", "Feed Servo", (Servo) cannonFeedServo);
        
        cannonLimitSwitch = new DigitalInput(0);
        LiveWindow.addSensor("Cannon", "Limit Switch", (DigitalInput) cannonLimitSwitch);
        
        cannonPitchEncoder = new AnalogInput(0);
        LiveWindow.addSensor("Cannon", "Pitch Encoder", (AnalogInput) cannonPitchEncoder);
        
        cannonYawEncoder = new AnalogInput(1);
        LiveWindow.addSensor("Cannon", "Yaw Encoder", (AnalogInput) cannonYawEncoder);
        
	}
	
}
