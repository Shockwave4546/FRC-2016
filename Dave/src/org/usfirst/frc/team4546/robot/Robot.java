
package org.usfirst.frc.team4546.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.usfirst.frc.team4546.robot.subsystems.Cannon;
//import org.usfirst.frc.team4546.robot.commands.ExampleCommand;
import org.usfirst.frc.team4546.robot.subsystems.Drivetrain;

//import org.usfirst.frc.team4546.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {

	public static Drivetrain drivetrain;
	public static Cannon cannon;
	public static OI oi;
	
	public static double speed;
	
	CameraServer camera;
	public static NetworkTable table;
	
    Command autonomousCommand;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    
    public void robotInit() {
    	RobotMap.init();	
    	drivetrain = new Drivetrain();
    	cannon = new Cannon();
		oi = new OI();
        chooser = new SendableChooser();
        
        camera = CameraServer.getInstance();
        camera.setQuality(50);
        camera.startAutomaticCapture("cam0");
        
        
        //SmartDashboard.putData("Auto mode", chooser);
        table = NetworkTable.getTable("Camera");
        
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
        
    }

    /**
     * This function is called periodically during autonomous
     */
    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        //Send necessary values to dashboard
    	SmartDashboard.putNumber("Target X Location", table.getNumber("midpointX", 0.0));
    	SmartDashboard.putNumber("Target Y Location", table.getNumber("midpointY", 0.0));
    	SmartDashboard.putNumber("Gyro Angle", drivetrain.getAngle());
    	SmartDashboard.putNumber("Cannon Yaw", cannon.getYaw());
    	SmartDashboard.putNumber("Cannon Pitch", cannon.getPitch());
    	SmartDashboard.putBoolean("Has Ball?", cannon.hasBall());
    	SmartDashboard.putData(cannon);
    	SmartDashboard.putData(drivetrain);
    	
    	SmartDashboard.putNumber("Cannon pitch voltage", cannon.getRawPitch());
    	SmartDashboard.putNumber("Cannon pitch value", cannon.getPitchValue());
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    
}
