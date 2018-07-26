package org.usfirst.frc.team3504.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3504.robot.*;
import org.usfirst.frc.team3504.robot.subsystems.*;


/**
 *
 */
public class DriveForward extends Command {

    public DriveForward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.masterLeft.set(0.2);
    	Robot.chassis.masterRight.set(0.2);
    	Robot.drivetrain.forward();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    
    public boolean stop() {
    	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
