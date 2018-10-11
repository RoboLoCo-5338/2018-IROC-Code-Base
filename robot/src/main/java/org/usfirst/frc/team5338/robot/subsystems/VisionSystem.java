//Package for all of our code.
package org.usfirst.frc.team5338.robot.subsystems;

import org.usfirst.frc.team5338.robot.commands.DetectCubes;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class VisionSystem extends Subsystem
{
	// private final NetworkTableInstance instance = NetworkTableInstance.create();
	private final NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
	NetworkTableEntry camMode;
	NetworkTableEntry ledMode;

	public VisionSystem()
	{
		camMode = table.getEntry("camMode");
		ledMode = table.getEntry("ledMode");
	}
	@Override
	public void initDefaultCommand()
	{
		this.setDefaultCommand(new DetectCubes());
	}
	public void track()
	{
		camMode.setNumber(1);
		ledMode.setNumber(1);
	}
}
