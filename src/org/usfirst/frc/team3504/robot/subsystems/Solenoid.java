package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.Robot;
import org.usfirst.frc.team3504.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Solenoid extends Subsystem{
	
	private static DoubleSolenoid doublesolenoid;
	
	public Solenoid() {
		doublesolenoid = new DoubleSolenoid(RobotMap.SOLENOID_FORWARD_CHANNEL, RobotMap.SOLENOID_BACKWARD_CHANNEL);
	}
	
	public void openSolenoid() {
		doublesolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void closeSolenoid() {
		doublesolenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void stop() {
		doublesolenoid.set(DoubleSolenoid.Value.kOff);
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}