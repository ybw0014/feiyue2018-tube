package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveByJoystick extends Command{
	public DriveByJoystick() {
		requires(Robot.chassis);
	}
	@Override
	public void initialize() {
		
	}

    @Override
    protected void execute() {
    	//left:Y X  right:Throttle Z
    	Robot.chassis.driveByJoystick(Robot.oi.getGamePad().getY(), -Robot.oi.getGamePad().getZ());
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
