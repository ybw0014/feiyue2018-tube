package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lift extends Subsystem {

	private WPI_TalonSRX lift;
	//private DigitalInput limitSwitch;
	
	private double goalLiftPosition;
	
	private final int LIFT_MAX = 30000;
	private final int LIFT_MIN = 0;
	private final int LIFT_ = 400;
	
	public static final double LIFT_SWITCH = 12500; 
	
	public Lift() {
		lift = new WPI_TalonSRX(RobotMap.LIFT);
		//limitSwitch = new DigitalInput(RobotMap.LIMIT_SWITCH);
		
		lift.setNeutralMode(NeutralMode.Brake);
		lift.setInverted(true);
		lift.setSensorPhase(true);
		lift.configAllowableClosedloopError(0, 100, 0);
		lift.configContinuousCurrentLimit(0, 10);
		lift.enableCurrentLimit(false);
		lift.setSelectedSensorPosition(0);
		
		lift.config_kF(0, 0, 10);
		lift.config_kP(0, 0.4, 10);
		lift.config_kI(0, 0, 10);
		lift.config_kD(0, 0, 10);
		
		goalLiftPosition = 0;
	}
	
	public void setPosUp() {
		double goalPosition = goalLiftPosition + LIFT_;
		if (goalPosition >= LIFT_MAX)
			goalLiftPosition = LIFT_MAX;
		else
			goalLiftPosition = goalPosition;
	}
	
	public void setPosDown() {
		double goalPosition = goalLiftPosition - LIFT_;
		if (goalPosition <= LIFT_MIN)
			goalLiftPosition = LIFT_MIN;
		else
			goalLiftPosition = goalPosition;
	}
	 
	public void setLiftSpeed(double speed) {
		lift.set(speed);
	}
	public void liftStop() {
		lift.stopMotor();
	}
	
	public boolean isInPos() {
		return lift.getSelectedSensorPosition(0) == goalLiftPosition;
	}

	public void holdPosition() {
		lift.set(ControlMode.Position, goalLiftPosition);
	}
	
	/*public boolean isAtBottom() {
		return false;//return !limitSwitch.get();
	}*/

	public double getGoalLiftPosition() {
		return goalLiftPosition;
	}

	public void setGoalLiftPosition(double goal) {
		goalLiftPosition = goal;
	}

	public double getLiftPosition() {
		return lift.getSelectedSensorPosition(0);
	}
	
	public void setLiftToSwitch() {
		goalLiftPosition = LIFT_SWITCH;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

