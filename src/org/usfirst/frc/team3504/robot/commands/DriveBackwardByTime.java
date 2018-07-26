package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveBackwardByTime extends Command{
	private int time;
	private double startTime;
	public DriveBackwardByTime(int timeInMs) {
		requires(Robot.chassis);
		this.time = timeInMs;
		this.startTime = System.currentTimeMillis();
	}
	public void initialize() {
		Robot.chassis.setSpeed(0.4);
	}

    @Override
    protected void execute() {
    	Robot.chassis.backward();
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
