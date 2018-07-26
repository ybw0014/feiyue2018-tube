// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.Robot;
import org.usfirst.frc.team3504.robot.RobotMap;
import org.usfirst.frc.team3504.robot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Chassis extends Subsystem {
	//probably should come up with better names
    private final WPI_TalonSRX masterLeft = RobotMap.chassisMasterLeft;
    private final WPI_TalonSRX slaveLeftA = RobotMap.chassisSlaveLeftA;
    private final WPI_TalonSRX slaveLeftB = RobotMap.chassisSlaveLeftB;
    private final WPI_TalonSRX masterRight = RobotMap.chassisMasterRight;
    private final WPI_TalonSRX slaveRightA = RobotMap.chassisSlaveRightA;
    private final WPI_TalonSRX slaveRightB = RobotMap.chassisSlaveRightB;
    
    private DifferentialDrive drive;


    public Chassis() {
    	//This is the constructor
    	
    	//Safety and brakes ----------------------------------
    	masterLeft.setNeutralMode(NeutralMode.Brake);
    	slaveLeftA.setNeutralMode(NeutralMode.Brake);
    	slaveLeftB.setNeutralMode(NeutralMode.Brake);
    	
    	masterRight.setNeutralMode(NeutralMode.Brake);
    	slaveRightA.setNeutralMode(NeutralMode.Brake);
    	slaveRightB.setNeutralMode(NeutralMode.Brake);
    	
    	masterLeft.setSafetyEnabled(false);
    	slaveLeftA.setSafetyEnabled(false);
    	slaveLeftB.setSafetyEnabled(false);
    	
    	masterRight.setSafetyEnabled(false);
    	slaveRightA.setSafetyEnabled(false);
    	slaveRightB.setSafetyEnabled(false);
    	//-----------------------------------------------------
    	
    	//reverse();
    	
    	setFollowerMode();
    	
    	//invert(true); //uncomment if needed
    	//if needed to invert the talons, do before putting into the drive
    	drive = new DifferentialDrive(masterLeft, masterRight);
    	
    	drive.setSafetyEnabled(false);
    	//this line is to set it so the joystick isn't too sensitive to input
    	drive.setExpiration(0.1);
    	drive.setMaxOutput(1.0);

    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DriveByJoystick());

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
    	//if you had something that needed to executed on a periodic sort of time
    	//instead of tiem, this is where you would put the commands
    }
    
    public void driveByJoystick(double yDir, double xDir){
    	SmartDashboard.putString("driveByJoystick?", yDir + "," + xDir);
    	drive.arcadeDrive(yDir,xDir);
    }

    
    public void invert(boolean x) {
    	//if the moters are spinning in opposite directions
    	
    	masterLeft.setInverted(false);
    	slaveLeftA.setInverted(false);
    	slaveLeftB.setInverted(false);
    	
    	masterRight.setInverted(x);
    	slaveRightA.setInverted(x);
    	slaveRightB.setInverted(x);
    }
    
    public void reverse() {
    	//if the motors are together but completely reversed (do not pair with invert)
    	masterLeft.setInverted(true);
    	slaveLeftA.setInverted(true);
    	slaveLeftB.setInverted(true);
    	
    	masterRight.setInverted(true);
    	slaveRightA.setInverted(true);
    	slaveRightB.setInverted(true);
    }
    
    public void setFollowerMode() {
    	//follower code
    	slaveLeftA.follow(masterLeft, FollowerType.PercentOutput);
    	slaveLeftB.follow(masterLeft, FollowerType.PercentOutput);
    	
    	slaveRightA.follow(masterRight, FollowerType.PercentOutput);
    	slaveRightB.follow(masterRight, FollowerType.PercentOutput);
    }
    
    public void forward() {
    	drive.tankDrive(0.1, 0.1);
    }
    
    public void backward() {
    	drive.tankDrive(-0.1, -0.1);
    }
    
    public void stop() {
    	drive.stopMotor();
    }


}

