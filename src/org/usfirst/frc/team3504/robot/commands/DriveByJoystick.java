package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveByJoystick extends Command{
	public DriveByJoystick() {
		requires(Robot.chassis);
	}
	@Override
	public void initialize() {
		
	}

    @Override
    protected void execute() {
    	
    	//left controller
    	if(Robot.oi.getJoyStick()!=null)
    		Robot.chassis.driveByJoystick(Robot.oi.getJoyStick().getY(), Robot.oi.getJoyStick().getX());
    	else if(Robot.oi.getGamePad()!=null)
    		Robot.chassis.driveByJoystick(Robot.oi.getJoyStick().getY(), Robot.oi.getJoyStick().getX());
    	//right controller
    	//Robot.chassis.driveByJoystick(Robot.oi.getJoyStick().getThrottle(), Robot.oi.getJoyStick().getZ());
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
