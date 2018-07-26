package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.Robot;
import org.usfirst.frc.team3504.robot.RobotMap;
import org.usfirst.frc.team3504.robot.commands.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;


public class Chassis extends Subsystem implements PIDOutput{
	
    private final WPI_TalonSRX masterLeft = RobotMap.chassisMasterLeft;
    private final WPI_TalonSRX slaveLeftA = RobotMap.chassisSlaveLeftA;
    private final WPI_TalonSRX slaveLeftB = RobotMap.chassisSlaveLeftB;
    private final WPI_TalonSRX masterRight = RobotMap.chassisMasterRight;
    private final WPI_TalonSRX slaveRightA = RobotMap.chassisSlaveRightA;
    private final WPI_TalonSRX slaveRightB = RobotMap.chassisSlaveRightB;
    
    private DifferentialDrive drive;
    
    private PIDController turnController;
    private AHRS ahrs;
    private double rotateToAngleRate; 


    public Chassis() {
    	//This is the constructor
    	
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
    	
    	//reverse();
    	
    	slaveLeftA.follow(masterLeft, FollowerType.PercentOutput);
    	slaveLeftB.follow(masterLeft, FollowerType.PercentOutput);
    	
    	slaveRightA.follow(masterRight, FollowerType.PercentOutput);
    	slaveRightB.follow(masterRight, FollowerType.PercentOutput);
    	
    	//invert(true); //uncomment if needed
    	//if needed to invert the talons, do before putting into the drive
    	
    	drive = new DifferentialDrive(masterLeft, masterRight);
    	drive.setSafetyEnabled(false);
    	drive.setExpiration(0.1);
    	drive.setMaxOutput(1.0);


    	try {
    		ahrs = new AHRS(SPI.Port.kMXP);
    	} catch (RuntimeException ex ) {
    		DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
    	}
    	turnController = new PIDController(0.03, 0.0, 0.0, 0.0, ahrs, this);
    	turnController.setInputRange(-180.0f,  180.0f);
    	turnController.setOutputRange(-1.0, 1.0);
    	turnController.setAbsoluteTolerance(2.0f);
    	turnController.setContinuous(true);
    	turnController.enable();
    	
    	

    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DriveByJoystick());

    }

    @Override
    public void periodic() {
    	
    }
    
    public void driveByJoystick(double yDir, double xDir){
    	SmartDashboard.putString("driveByJoyStick:", "Y: " + yDir + "  X: " + xDir);
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
    
    public void forward(double speed) {
    	drive.tankDrive(speed, speed);
    }
    
    public void backward(double speed) {
    	drive.tankDrive(-speed, -speed);
    }
    
    public void rotate(double left,double right) {
    	drive.tankDrive(left, right);
    }
    
    public DifferentialDrive getDrive() {
    	return this.drive;
    }
    
    @Override
    public void pidWrite(double output) {
    	this.rotateToAngleRate = output;
    }

    public double getRotationAngleRate() {
    	return this.rotateToAngleRate;
    }
    
    public AHRS getAHRS() {
    	return this.ahrs;
    }
    
    public PIDController getTurnController() {
    	return this.turnController;
    }
    public void stop() {
    	drive.stopMotor();
    }

}

