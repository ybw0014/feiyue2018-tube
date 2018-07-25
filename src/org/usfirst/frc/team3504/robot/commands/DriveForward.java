package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command{
	public DriveForward() {
		requires(Robot.chassis);
	}
	
	@Override
	public void initialize() {
		
	}

    @Override
    protected void execute() {
    	Robot.chassis.forward();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    	Robot.chassis.stop();
    }

    @Override
    protected void interrupted() {
    	end();
    } 
}
