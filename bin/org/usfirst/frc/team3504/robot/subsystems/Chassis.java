package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.RobotMap;
import org.usfirst.frc.team3504.robot.commands.DriveByJoystick;

import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * 
 */
public class Chassis extends Subsystem {
	
	public WPI_TalonSRX masterLeft;
	public WPI_TalonSRX slaveLeft_A;
	public WPI_TalonSRX slaveLeft_B;
	public WPI_TalonSRX masterRight;
	public WPI_TalonSRX slaveRight_A;
	public WPI_TalonSRX slaveRight_B;

	public DifferentialDrive drive;
	
	public Chassis() {
		// this part instantiates all the talons
		WPI_TalonSRX masterLeft = new WPI_TalonSRX(RobotMap.DRIVE_MASTER_PORT_LEFT);
		WPI_TalonSRX masterRight = new WPI_TalonSRX(RobotMap.DRIVE_MASTER_PORT_RIGHT);
		WPI_TalonSRX slaveLeft_A = new WPI_TalonSRX(RobotMap.DRIVE_SLAVE_PORT_LEFT_A);
		WPI_TalonSRX slaveLeft_B = new WPI_TalonSRX(RobotMap.DRIVE_SLAVE_PORT_LEFT_B);
		WPI_TalonSRX slaveRight_A = new WPI_TalonSRX(RobotMap.DRIVE_SLAVE_PORT_RIGHT_A);
		WPI_TalonSRX slaveRight_B = new WPI_TalonSRX(RobotMap.DRIVE_SLAVE_PORT_RIGHT_B);
		
		// this part set the neutral mode to brake
		masterLeft.setNeutralMode(NeutralMode.Brake);
		slaveLeft_A.setNeutralMode(NeutralMode.Brake);
		slaveLeft_B.setNeutralMode(NeutralMode.Brake);
		masterRight.setNeutralMode(NeutralMode.Brake);
		slaveRight_A.setNeutralMode(NeutralMode.Brake);
		slaveRight_B.setNeutralMode(NeutralMode.Brake);
		
		// this part set the slave talons to follow the master talons
		slaveLeft_A.follow(masterLeft, FollowerType.PercentOutput);
		slaveLeft_B.follow(masterLeft, FollowerType.PercentOutput);
		slaveRight_A.follow(masterRight, FollowerType.PercentOutput);
		slaveRight_A.follow(masterRight, FollowerType.PercentOutput);
		
		// this part combines the talons on the left and the talons on the right
		drive = new DifferentialDrive(masterLeft, masterRight);
		drive.setSafetyEnabled(false);
		drive.setExpiration(0.1);
		drive.setMaxOutput(1.0);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new DriveByJoystick());
	}

	public void driveByJoystick(double yDir, double xDir){
		SmartDashboard.putString("driveByJoystick?", yDir + "," + xDir);
		drive.arcadeDrive(yDir,xDir);
	}
	
	public void stop() {
		drive.arcadeDrive(0, 0);
	}

}
