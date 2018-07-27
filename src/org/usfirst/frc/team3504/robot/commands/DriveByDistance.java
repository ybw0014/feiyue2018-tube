package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveByDistance extends Command{
	private double distance;
	private double speed;
	private double distanceTravelled;
	
	public DriveByDistance(int distanceInInches,double speed) {
		requires(Robot.chassis);
		this.distance = distanceInInches;
		this.speed = speed;
	}
	@Override
	public void initialize() {
		this.distanceTravelled = 0;
	}

    @Override
    protected void execute() {
    	Robot.chassis.forward(this.speed);
    	
    }

    @Override
    protected boolean isFinished() {
        
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
