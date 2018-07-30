package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.*;

public class Intake extends Subsystem {

	private final WPI_TalonSRX leftIntakeMotor = RobotMap.leftIntake;
	private final WPI_TalonSRX rightIntakeMotor = RobotMap.rightIntake;
    public double rotationSpeedOfIntake = 0.2; // change this when a better speed is tested
    
    public Intake() {
    	leftIntakeMotor.setNeutralMode(NeutralMode.Brake);
    	leftIntakeMotor.configContinuousCurrentLimit(1000, 20);
    	rightIntakeMotor.setNeutralMode(NeutralMode.Brake);
    	rightIntakeMotor.configContinuousCurrentLimit(1000, 20);
    	
    	rightIntakeMotor.setSafetyEnabled(false);
    	leftIntakeMotor.setSafetyEnabled(false);
    	
    	this.setInvert(false,false);
    }
    
    public void stop() {
    	leftIntakeMotor.stopMotor();
    	rightIntakeMotor.stopMotor();
    }
    
    public void OpenIntake() {
    	leftIntakeMotor.set(rotationSpeedOfIntake);
    	rightIntakeMotor.set(rotationSpeedOfIntake);
    }
    
    public void ShootIntake() {
    	leftIntakeMotor.set(-rotationSpeedOfIntake);
    	rightIntakeMotor.set(-rotationSpeedOfIntake);
    }
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    public void setInvert(boolean left,boolean right) {
    	leftIntakeMotor.setInverted(left);
    	rightIntakeMotor.setInverted(right);

    }
}

