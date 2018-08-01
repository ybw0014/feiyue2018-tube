package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.*;

public class Collector extends Subsystem {

	private final WPI_TalonSRX leftIntakeMotor = RobotMap.leftIntake;
	private final WPI_TalonSRX rightIntakeMotor = RobotMap.rightIntake;
    public double rotationSpeedOfIntake = 0.4; // change this when a better speed is tested
    
    public Collector() {
    	leftIntakeMotor.setNeutralMode(NeutralMode.Brake);
    	leftIntakeMotor.configContinuousCurrentLimit(1000, 20);
    	rightIntakeMotor.setNeutralMode(NeutralMode.Brake);
    	rightIntakeMotor.configContinuousCurrentLimit(1000, 20);
    	
    	rightIntakeMotor.setSafetyEnabled(false);
    	leftIntakeMotor.setSafetyEnabled(false);
    	
    	this.setInvert(false,true);
    }
    
    public void stop() {
    	leftIntakeMotor.stopMotor();
    	rightIntakeMotor.stopMotor();
    }
    
    public void releaseCollector() {
    	leftIntakeMotor.set(rotationSpeedOfIntake);
    	rightIntakeMotor.set(-rotationSpeedOfIntake);
    }
    
    public void collectCube() {
    	leftIntakeMotor.set(-rotationSpeedOfIntake);
    	rightIntakeMotor.set(rotationSpeedOfIntake);
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

