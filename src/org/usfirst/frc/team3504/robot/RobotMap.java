package org.usfirst.frc.team3504.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;

public class RobotMap {
	
	//JoyStick
	public static final int GAMEPAD_PORT = 0;
	public static final int JOYSTICK_PORT = 1;
	
	//Solenoid
	//DEBUG
	/*
	public static final int SOLENOID_FORWARD_CHANNEL = 0;
	public static final int SOLENOID_BACKWARD_CHANNEL = 1;
	 */
	//NORMAL
	
	public static final int PNEUMATIC_FORWARD_CHANNEL = 6;
	public static final int PNEUMATIC_BACKWARD_CHANNEL = 7;
	
	//Chassis
	public static WPI_TalonSRX chassisMasterLeft;
	public static WPI_TalonSRX chassisSlaveLeftA;
	public static WPI_TalonSRX chassisSlaveLeftB;
	public static WPI_TalonSRX chassisMasterRight;
	public static WPI_TalonSRX chassisSlaveRightA;
	public static WPI_TalonSRX chassisSlaveRightB;

	public static final double WHEEL_DIAMETER = 6.25;
	
	//Encoder
	public static final int ENCODER_LEFT_1 = 0;
	public static final int ENCODER_LEFT_2 = 0;
	public static final int ENCODER_RIGHT_1 = 0;
	public static final int ENCODER_RIGHT_2 = 0;
	
	//CLimber
	public static final int CLIMBER = 8;
	public static final int LIMIT_SWITCH = 9;
	
	//Lift
	public static final int LIFT = 9;
	public static final int LIMIT_SWITCH = 10; 
	
	//Intake
	public static WPI_TalonSRX leftIntake;
	public static WPI_TalonSRX rightIntake;
	
	public static void init() {
		chassisMasterLeft = new WPI_TalonSRX(3);
		chassisSlaveLeftA = new WPI_TalonSRX(6);
		chassisSlaveLeftB = new WPI_TalonSRX(5);
		chassisMasterRight = new WPI_TalonSRX(1);
		chassisSlaveRightA = new WPI_TalonSRX(2);
		chassisSlaveRightB = new WPI_TalonSRX(4);
		
		leftIntake = new WPI_TalonSRX(9);
		rightIntake = new WPI_TalonSRX(10);
	}
}
