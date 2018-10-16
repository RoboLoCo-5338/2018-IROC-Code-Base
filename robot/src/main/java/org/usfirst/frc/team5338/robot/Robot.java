//Package for all of our code.
package org.usfirst.frc.team5338.robot;

//Import of necessary subsystem.
import org.usfirst.frc.team5338.robot.commands.Autonomous;
import org.usfirst.frc.team5338.robot.subsystems.Claw;
import org.usfirst.frc.team5338.robot.subsystems.Climber;
import org.usfirst.frc.team5338.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5338.robot.subsystems.Sensors;
import org.usfirst.frc.team5338.robot.subsystems.VisionSystem;

//Import of all essential WPILib classes.
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//Main class that is called by the FMS.
public class Robot extends IterativeRobot
{
	// Creates static DriveTrain, VisionSystem, OI, Sensors, and Claw objects
	// public static final VisionSystem visionsystem = new VisionSystem();
	public static final DriveTrain drivetrain = new DriveTrain();
	public static final Claw claw = new Claw();
	public static final Climber climber = new Climber();
	public static final OI oi = new OI();
	public static final Sensors sensors = new Sensors();
	public static final VisionSystem vision = new VisionSystem();
	// Creates SendableChooser objects
	//@SuppressWarnings("unused")
	public static SendableChooser<String> autonomousChooser = new SendableChooser<String>();
	// Defines Command object for Auto
	public static Command autonomous;
	
	// Public method that runs once on robot startup.
	@Override
	public void robotInit()
	{
		// Clears all commands
		Scheduler.getInstance().removeAll();
		// Configures SendableChooser to select Autonomous
		Robot.setupAutonomous();
	}
	// Public method that runs once at the beginning of autonomous.
	@Override
	public void autonomousInit()
	{
		// Clears all commands
		Scheduler.getInstance().removeAll();
		// Creates the autonomous with selection
		Robot.autonomous = new Autonomous();
		Robot.autonomous.start();
	}
	// Public method that runs continuously every 20ms during autonomous.
	@Override
	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();
		//added limelight changes
	}
	// Public method that runs once at the beginning of teleop.
	@Override
	public void teleopInit()
	{
		// Clears all commands
		Scheduler.getInstance().removeAll();
		try
		{
			Robot.autonomous.cancel();
		}
		catch(final Exception e)
		{
			// No auto was enabled to be cancelled
		}
	}
	// Public method that runs continuously every 20ms during autonomous.
	@Override
	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();
	}
	private static void setupAutonomous()
	{
		// TODO CHECK FUNCTIONALITY
		autonomousChooser.addDefault("Center Autonomous (DEFAULT)", "CENTER");
		autonomousChooser.addObject("Left Autonomous (Scale Priority)", "LEFTSCALESWITCH");
		autonomousChooser.addObject("Left Autonomous (Switch Priority)", "LEFTSWITCHSCALE");
		autonomousChooser.addObject("Left Autonomous (Switch Only)", "LEFTSWITCHONLY");
		autonomousChooser.addObject("Right Autonomous (Scale Priority)", "RIGHTSCALESWITCH");
		autonomousChooser.addObject("Right Autonomous (Switch Priority)", "RIGHTSWITCHSCALE");
		autonomousChooser.addObject("Right Autonomous (Switch Only)", "RIGHTSWITCHONLY");
		autonomousChooser.addObject("Baseline Cross Autonomous", "BASELINE");
		autonomousChooser.addObject("NO AUTONOMOUS (DANGER)!!!", "NOTHING");
		// Robot.autonomousChooser.addObject("TESTING (DANGER)!!!", "TESTING");
		SmartDashboard.putData("Autonomous Choice", Robot.autonomousChooser);
	}
}