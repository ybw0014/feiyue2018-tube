package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class CloseSolenoid extends Command {
	
	public CloseSolenoid() {		
    	requires(Robot.solenoid);
	}
	
    protected void initialize() {
    }

    protected void execute() {
    	Robot.solenoid.closeSolenoid();
    }

    protected boolean isFinished() {
        return false;
    }
    
    protected void stop() {
    	Robot.solenoid.stop();
    }

    protected void interrupted() {
    }
	
}