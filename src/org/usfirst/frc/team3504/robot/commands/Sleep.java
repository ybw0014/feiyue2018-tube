package org.usfirst.frc.team3504.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Sleep extends Command {
	private double startTime;
	private int time;
    public Sleep(int timeInMs) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.time = timeInMs;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (System.currentTimeMillis() - this.startTime) >= this.time;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}