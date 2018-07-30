package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class RotateByTime extends Command{
	private int time;
	private double speed;
	private double startTime;
	
	public RotateByTime(int timeInMs, double speed, boolean isTurnRight) {
		requires(Robot.chassis);
		this.speed = speed;
		this.time = timeInMs;
		if(isTurnRight) this.speed = -speed;
	}
	
	public void initialize() {
		this.startTime = System.currentTimeMillis();
	}

    @Override
    protected void execute() {
    	Robot.chassis.tankDrive(this.speed, -this.speed);
    }

    @Override
    protected boolean isFinished() {
        return (System.currentTimeMillis() - this.startTime) >= this.time;
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
