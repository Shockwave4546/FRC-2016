
package org.usfirst.frc.team4546.robot;
/* TKC - 8/23/2017 
import edu.wpi.first.wpilibj.CameraServer;
*/
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team4546.robot.subsystems.*;
import org.usfirst.frc.team4546.robot.commands.*;

/* TKC - 8/23/2017 
import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
*/
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
// TKC - 8/30/2017 - mod to make sure GIT password update work

public class Robot extends IterativeRobot {

	public static Drivetrain drivetrain;
	public static Cannon cannon;
	public static OI oi;
	
	public static double speed;
	public static double cannonSpeed;
	int session;
	public static final double upperLimit = 50;
	public static final double lowerLimit = -40;
	public static final double leftLimit = -130;
	public static final double rightLimit = 180;
	public static final double homeYaw = 175;
	public static final double clearPitch = 16.5;
	public static final double homePitch = 13;
	
	/* TKC - 8/23/2017 
	final NIVision.Point maxVertical = new NIVision.Point(320, 235);
    final NIVision.Point minVertical = new NIVision.Point(320, 0);
	final NIVision.Point maxVertical2 = new NIVision.Point(320, 245);
    final NIVision.Point minVertical2 = new NIVision.Point(320, 480);
    final NIVision.Point maxHorizontal = new NIVision.Point(325, 235);
    final NIVision.Point minHorizontal = new NIVision.Point(325, 245);
    final NIVision.Point maxHorizontal2 = new NIVision.Point(315, 235);
    final NIVision.Point minHorizontal2 = new NIVision.Point(315, 245);
	CameraServer camera;
	*/
	//public static NetworkTable table;
	
    Command autonomousCommand;
    SendableChooser chooser;
    /* TKC - 8/23/2017 
     Image frame;
     */

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    
    public void robotInit() {
    	RobotMap.init();	
    	drivetrain = new Drivetrain();
    	cannon = new Cannon();
		oi = new OI();
        
        //camera = CameraServer.getInstance();
        //camera.setQuality(50);
        //camera.startAutomaticCapture("cam1");
        
        chooser = new SendableChooser();
        chooser.addDefault("No Auto", null);
        chooser.addObject("Just Goose It", new DriveOverObstacle());
        /*chooser.addObject("Spy Auto", new SpyAuto());
        chooser.addObject("Position 2", new StartFromPosition(StartFromPosition.Position.TWO));
        chooser.addObject("Position 3", new StartFromPosition(StartFromPosition.Position.THREE));
        chooser.addObject("Position 4", new StartFromPosition(StartFromPosition.Position.FOUR));
        chooser.addObject("Position 5", new StartFromPosition(StartFromPosition.Position.FIVE));*/
        chooser.addObject("Rampart", new DriveOverObstacle(DriveOverObstacle.Obstacle.RAMPART));
        chooser.addObject("Moat", new DriveOverObstacle(DriveOverObstacle.Obstacle.MOAT));
        chooser.addObject("Wall", new DriveOverObstacle(DriveOverObstacle.Obstacle.WALL));
        chooser.addObject("Terrain", new DriveOverObstacle(DriveOverObstacle.Obstacle.TERRAIN));
        SmartDashboard.putData("Auto mode", chooser);
        
        cannon.setFeedServo(70);
        
        /* TKC - 8/23/2017 
        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        session = NIVision.IMAQdxOpenCamera("cam2",
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        		NIVision.IMAQdxConfigureGrab(session);
        */
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
        SmartDashboard.putNumber("Match Time", Timer.getMatchTime());
        
    }

    /**
     * This function is called periodically during autonomous
     */
    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Match Time", Timer.getMatchTime());
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        SmartDashboard.putNumber("Match Time", Timer.getMatchTime());
        
    }

    /**
     * This function is called periodically during operator control
     */
    
    public void teleopPeriodic() {
        
    	Scheduler.getInstance().run();
    	/* TKC - 8/23/2017 
        		
    	NIVision.IMAQdxGrab(session, frame, 1);
        NIVision.imaqDrawLineOnImage(frame, frame, DrawMode.DRAW_VALUE, maxHorizontal, minHorizontal, 0.0f);
        NIVision.imaqDrawLineOnImage(frame, frame, DrawMode.DRAW_VALUE, maxVertical, minVertical, 0.0f);
        NIVision.imaqDrawLineOnImage(frame, frame, DrawMode.DRAW_VALUE, maxHorizontal2, minHorizontal2, 0.0f);
        NIVision.imaqDrawLineOnImage(frame, frame, DrawMode.DRAW_VALUE, maxVertical2, minVertical2, 0.0f);
        CameraServer.getInstance().setImage(frame);
*/ 
        //Set the speed to the throttle from the driveStick
    	// nbp 8/26/2017 - there may be something janky about this speed calculation - we believe 
    	// that this is what's causing the speed problem
    	// nbp 8/26/2017 - turned out the throttle axis on the new joystick is actually the Z axis
    	// nbp 8/26/2017 - hardcoding for MakerFaire b/c the axis isn't behaving well
    	//speed = ((-oi.getDriveStick().getThrottle() + 1) / 2);
    	speed = (-oi.getDriveStick().getZ() + 1) / 2;
    	//speed = 0.75;
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
        SmartDashboard.putNumber("Match Time", Timer.getMatchTime());
    }
    
    /**
     * This function is called periodically during test mode
     */
    
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    
}
