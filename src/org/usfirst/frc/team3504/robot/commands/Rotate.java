package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Rotate extends Command{
	private double angle;
	private double yaw;
	private boolean isTurningRight = true;
	
	public Rotate(double angle) {
		requires(Robot.chassis);
		if(angle>=0)
			this.angle = angle;
		else {
			this.angle = - angle;
			this.isTurningRight = false;
		}
		
	}
	
	public void initialize() {
		this.yaw = Robot.chassis.getAHRS().getYaw();
		
		while(Robot.chassis.getAHRS().isCalibrating()){
		     Timer.delay(0.05);
		}
		
		Robot.chassis.getTurnController().setSetpoint(this.angle);
		Robot.chassis.getTurnController().enable();
		
		Robot.chassis.pidWrite(0);
	}

    @Override
    protected void execute() {
    	try {
    		double rotationRate = Robot.chassis.getRotationAngleRate();
    		if(Math.abs(Robot.chassis.getAHRS().getYaw()-this.yaw) < this.angle)
    			if(isTurningRight)
    				Robot.chassis.rotate(rotationRate, -rotationRate);
    			else
    				Robot.chassis.rotate(-rotationRate, rotationRate);
    		
    	} catch( RuntimeException ex ) {
    		DriverStation.reportError("Error communicating with drive system:  " + ex.getMessage(), true);
    	}
    }

    @Override
    protected boolean isFinished() {
        return Robot.chassis.getTurnController().onTarget();
    }

    @Override
    protected void end() {
    	Robot.chassis.stop();
    	Robot.chassis.getTurnController().disable();
    }

    @Override
    protected void interrupted() {
    	end(); 
    }
}
