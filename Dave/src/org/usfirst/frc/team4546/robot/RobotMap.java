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
	public static CANTalon drivetrainLeft;
	public static CANTalon drivetrainRight;
	public static RobotDrive drivetrainChassis;	
	
	public static Talon cannonYawMotor;
	public static Talon cannonPitchMotor;
	public static CANTalon cannonFireLeft;
	public static CANTalon cannonFireRight;
	public static Servo cannonFeedBall;
	public static DigitalInput cannonLimitSwitch;
	public static Potentiometer cannonPotentiometer;
	
	public static void init()	{
		
		drivetrainLeft = new CANTalon(0);
		drivetrainRight = new CANTalon(1);
		
		drivetrainChassis = new RobotDrive(drivetrainLeft, drivetrainRight);
		
		drivetrainChassis.setSafetyEnabled(true);
		drivetrainChassis.setExpiration(0.1);
        drivetrainChassis.setSensitivity(0.5);
        drivetrainChassis.setMaxOutput(1.0);
        
        drivetrainChassis.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        
        cannonYawMotor = new Talon(0);
        cannonPitchMotor = new Talon(1);
        cannonFireLeft = new CANTalon(2);
        cannonFireRight = new CANTalon(3);
        
        cannonFeedBall = new Servo(2);
        cannonLimitSwitch = new DigitalInput(0);
        cannonPotentiometer = new AnalogPotentiometer(1, 360, 30); //http://wpilib.screenstepslive.com/s/4485/m/13809/l/241877-potentiometers-measuring-joint-angle-or-linear-motion
        
        drivetrainAHRS = new AHRS(SPI.Port.kMXP);
                                
	}
	
}
