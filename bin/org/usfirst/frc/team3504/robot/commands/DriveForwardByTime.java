package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


public class DriveForwardByTime extends Command {
	
    public DriveForwardByTime(int timeInMs) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.masterLeft.set(0.4);
    	Robot.chassis.masterRight.set(0.4);
    	Robot.drivetrain.forward();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        long startTime = System.currentTimeMillis();
        execute();
        long endTime = System.currentTimeMillis();
        if (endTime - startTime == 20)
        	return true;
        else
        	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}