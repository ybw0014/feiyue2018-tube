package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;
import org.usfirst.frc.team3504.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class DriveByDistanceInInch extends Command{
	private double distance;
	private double speed;
	private boolean isForward;
	private double leftInitial;
	private double rightInitial;
	private double rotations;
	
	public DriveByDistanceInInch(int distanceInInches,double speed,boolean isForward) {
		requires(Robot.chassis);
		this.distance = distanceInInches;
		this.speed = speed;
		if(!isForward)this.speed = -speed;
	}
	@Override
	public void initialize() {
		RobotMap.chassisMasterLeft.config_kF(0, 0, 0);
		RobotMap.chassisMasterLeft.config_kP(0, 0.02, 0);
		RobotMap.chassisMasterLeft.config_kI(0, 0, 0);
		RobotMap.chassisMasterLeft.config_kD(0, 0.04, 0);
			
		RobotMap.chassisMasterRight.config_kF(0, 0, 0);
		RobotMap.chassisMasterRight.config_kP(0, 0.02, 0);
		RobotMap.chassisMasterRight.config_kI(0, 0, 0);
		RobotMap.chassisMasterRight.config_kD(0, 0.04, 0);

		leftInitial = -RobotMap.chassisMasterLeft.getSelectedSensorPosition(0);
		rightInitial = RobotMap.chassisMasterRight.getSelectedSensorPosition(0);

		RobotMap.chassisMasterLeft.set(ControlMode.Position, -(rotations + leftInitial));
		RobotMap.chassisMasterRight.set(ControlMode.Position, rotations + rightInitial);
	}

    @Override
    protected void execute() {

    	RobotMap.chassisMasterLeft.set(ControlMode.Position, -(rotations + leftInitial));
    	RobotMap.chassisMasterRight.set(ControlMode.Position, rotations + rightInitial);
    }

    @Override
    protected boolean isFinished() {
    	if (rotations > 0) {
			return ((RobotMap.chassisMasterRight.getSelectedSensorPosition(0) > rotations + rightInitial)
					&& (-RobotMap.chassisMasterLeft.getSelectedSensorPosition(0) > rotations + leftInitial));
		} else if (rotations < 0) {
			return ((RobotMap.chassisMasterRight.getSelectedSensorPosition(0) < rotations + rightInitial)
					&& (-RobotMap.chassisMasterLeft.getSelectedSensorPosition(0) < rotations + leftInitial));
		} else
			return true;
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
