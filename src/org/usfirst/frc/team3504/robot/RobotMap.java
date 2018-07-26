package org.usfirst.frc.team3504.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class RobotMap {
	
	//JoyStick
	public static final int JOYSTICK_PORT = 0;
	
	//Solenoid
	//DEBUG
	/*
	public static final int SOLENOID_FORWARD_CHANNEL = 0;
	public static final int SOLENOID_BACKWARD_CHANNEL = 1;
	 */
	//NORMAL
	
	public static final int SOLENOID_FORWARD_CHANNEL = 6;
	public static final int SOLENOID_BACKWARD_CHANNEL = 7;
	
	//Chassis
	public static WPI_TalonSRX chassisMasterLeft;
	public static WPI_TalonSRX chassisSlaveLeftA;
	public static WPI_TalonSRX chassisSlaveLeftB;
	public static WPI_TalonSRX chassisMasterRight;
	public static WPI_TalonSRX chassisSlaveRightA;
	public static WPI_TalonSRX chassisSlaveRightB;
	
	public static void init() {
		chassisMasterLeft = new WPI_TalonSRX(1);
		chassisSlaveLeftA = new WPI_TalonSRX(2);
		chassisSlaveLeftB = new WPI_TalonSRX(3);
		chassisMasterRight = new WPI_TalonSRX(6);
		chassisSlaveRightA = new WPI_TalonSRX(7);
		chassisSlaveRightB = new WPI_TalonSRX(8);
	}
}
