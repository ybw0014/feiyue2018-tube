package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class LiftUp extends Command {

    public LiftUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lift.setLiftSpeed(0.1);
    	Robot.lift.setPosUp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.lift.holdPosition();
    }

    // Make this return true when this Command no longer n eeds to run execute()
    protected boolean isFinished() {
        return Robot.lift.isInPos(); 
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.liftStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
