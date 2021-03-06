package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class LiftDown extends Command {

    public LiftDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.lift.setPosDown();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.lift.holdPosition();
    	Robot.lift.setLiftSpeed(-0.6);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
        //return Robot.lift.isInPos();  
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
