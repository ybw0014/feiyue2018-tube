package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;
import org.usfirst.frc.team3504.robot.RobotMap;

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
		Robot.chassis.getLeftEncoder().reset();
	}

    @Override
    protected void execute() {
    	Robot.chassis.tankDrive(this.speed,this.speed);
    	this.distanceTravelled = Robot.chassis.getLeftEncoder().getDistance() * RobotMap.LEFT_ENCODER_RATE;
    }

    @Override
    protected boolean isFinished() {
        return this.distanceTravelled >= this.distance;
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
