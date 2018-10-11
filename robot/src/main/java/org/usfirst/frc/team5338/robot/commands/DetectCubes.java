//Package for all of our code.
package org.usfirst.frc.team5338.robot.commands;

//Import all needed classes from WPILib.
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5338.robot.Robot;

public class DetectCubes extends Command
{

	public DetectCubes()
	{
		this.requires(Robot.vision);
	}
	@Override
	protected void execute()
	{
		 Robot.vision.track();
	}
	@Override
	protected boolean isFinished()
	{
		return false;
	}
	@Override
	protected void end()
	{
		; // Never ends tracking
	}
}