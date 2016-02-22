
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

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;

//import org.usfirst.frc.team4546.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	public static double cannonSpeed;
	int session;
	public static final double upperLimit = 39;
	public static final double lowerLimit = -57;
	public static final double leftLimit = -130;
	public static final double rightLimit = 180;
	
	final NIVision.Point maxVertical = new NIVision.Point(320, 235);
    final NIVision.Point minVertical = new NIVision.Point(320, 0);
	final NIVision.Point maxVertical2 = new NIVision.Point(320, 245);
    final NIVision.Point minVertical2 = new NIVision.Point(320, 480);
    final NIVision.Point maxHorizontal = new NIVision.Point(325, 235);
    final NIVision.Point minHorizontal = new NIVision.Point(325, 245);
    final NIVision.Point maxHorizontal2 = new NIVision.Point(315, 235);
    final NIVision.Point minHorizontal2 = new NIVision.Point(315, 245);
	CameraServer camera;
	//public static NetworkTable table;
	
    Command autonomousCommand;
    SendableChooser chooser;
    Image frame;

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
        
        //camera = CameraServer.getInstance();
        //camera.setQuality(50);
        //camera.startAutomaticCapture("cam1");
        
        
        //SmartDashboard.putData("Auto mode", chooser);
        //table = NetworkTable.getTable("Camera");
        cannon.setFeedServo(70);
        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

        // the camera name (ex "cam0") can be found through the roborio web interface
        session = NIVision.IMAQdxOpenCamera("cam0",
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        		NIVision.IMAQdxConfigureGrab(session);
        
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
        
        //Draw crosshairs on camera image
        NIVision.IMAQdxGrab(session, frame, 1);
        NIVision.imaqDrawLineOnImage(frame, frame, DrawMode.DRAW_VALUE, maxHorizontal, minHorizontal, 0.0f);
        NIVision.imaqDrawLineOnImage(frame, frame, DrawMode.DRAW_VALUE, maxVertical, minVertical, 0.0f);
        NIVision.imaqDrawLineOnImage(frame, frame, DrawMode.DRAW_VALUE, maxHorizontal2, minHorizontal2, 0.0f);
        NIVision.imaqDrawLineOnImage(frame, frame, DrawMode.DRAW_VALUE, maxVertical2, minVertical2, 0.0f);
        CameraServer.getInstance().setImage(frame);
        
        //Set the speed to the throttle from the driveStick
    	speed = ((-oi.getDriveStick().getThrottle() + 1) / 2);
    	cannonSpeed = ((-oi.getGunnerStick().getThrottle() + 1) / 2);
        
        //Send necessary values to dashboard
        SmartDashboard.putNumber("Robot Speed", speed*100);
        SmartDashboard.putNumber("Cannon Speed", cannonSpeed*100);
    	SmartDashboard.putNumber("Gyro Angle", drivetrain.getAngle());
    	SmartDashboard.putNumber("Cannon Yaw", cannon.getYaw());
    	SmartDashboard.putNumber("Cannon Pitch", cannon.getPitch());
    	SmartDashboard.putBoolean("Has Ball?", cannon.hasBall());
    	SmartDashboard.putData(cannon);
    	SmartDashboard.putData(drivetrain);
    	
    	SmartDashboard.putNumber("Gunner Z", oi.getGunnerStick().getZ());
    	SmartDashboard.putNumber("Gunner Y", oi.getGunnerStick().getY());
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    
}
