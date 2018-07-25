package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveByJoystick extends Command{
	public DriveByJoystick() {
		requires(Robot.chassis);
	}
	public void initialize() {
		
	}

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	//uses the one stick, non-twist controller.
    	//get the y to be the mag and the x to be the rotation, the plane is the standard
    	//graph plane, if the plane was put flat on the controller (y is forward back, x
    	//left right)
    	//for some reason on the bot, y negative is forward... (basically check front back)
    	Robot.chassis.driveByJoystick(Robot.oi.getDrivingJoyStickY(), Robot.oi.getDrivingJoyStickX());
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.chassis.stop(); 
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
}
