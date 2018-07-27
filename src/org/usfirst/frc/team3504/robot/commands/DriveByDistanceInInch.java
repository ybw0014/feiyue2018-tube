package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveByDistanceInInch extends Command{
	private double distance;
	private double speed;
	private double distanceTravelled;
	private boolean isForward;
	
	public DriveByDistanceInInch(int distanceInInches,double speed,boolean isForward) {
		requires(Robot.chassis);
		this.distance = distanceInInches;
		this.speed = speed;
		if(!isForward)this.speed=-(this.speed);
	}
	@Override
	public void initialize() {
		this.distanceTravelled = 0;
	}

    @Override
    protected void execute() {
    	Robot.chassis.tankDrive(this.speed,this.speed);
    	
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
