package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class OpenSolenoid extends Command {
	
	public OpenSolenoid() {		
    	requires(Robot.solenoid);
	}
	
    protected void initialize() {
    }

    protected void execute() {
    	Robot.solenoid.openSolenoid();
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