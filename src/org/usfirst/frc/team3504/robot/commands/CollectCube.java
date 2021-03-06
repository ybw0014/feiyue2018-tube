package org.usfirst.frc.team3504.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3504.robot.Robot;

public class CollectCube extends Command {
	
    public CollectCube() {
    	requires(Robot.collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    protected void execute() {
    	Robot.collector.collectCube();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.collector.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end(); 
    }
}
