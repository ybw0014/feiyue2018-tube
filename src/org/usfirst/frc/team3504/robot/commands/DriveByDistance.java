package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveByDistance extends Command{
	private double distance;
	private double speed;
	
	public DriveByDistance(int distanceInInches,double speed) {
		requires(Robot.chassis);
		this.distance = distanceInInches;
		this.speed = speed;
	}
	@Override
	public void initialize() {
	}

    @Override
    protected void execute() {
    	
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
