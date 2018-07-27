package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardByTime extends Command{
	private int time;
	private double speed;
	private double startTime;
	public DriveForwardByTime(int timeInMs,double speed) {
		requires(Robot.chassis);
		this.time = timeInMs;
		this.speed = speed;
		this.startTime = 0;
	}
	@Override
	public void initialize() {
		this.startTime = System.currentTimeMillis();
	}

    @Override
    protected void execute() {
    	Robot.chassis.tankDrive(this.speed,this.speed);
    }

    @Override
    protected boolean isFinished() {
        return (System.currentTimeMillis()-this.startTime)>=this.time;
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
