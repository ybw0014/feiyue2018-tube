package org.usfirst.frc.team3504.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class RobotMap {
	
	//JoyStick
	public static final int GAMEPAD_PORT = 0;
	public static final int JOYSTICK_PORT = 1;
	
	//Solenoid
	public static final int PNEUMATIC_FORWARD_CHANNEL = 6;
	public static final int PNEUMATIC_BACKWARD_CHANNEL = 7;
	
	//Chassis
	public static WPI_TalonSRX chassisMasterLeft;
	public static WPI_TalonSRX chassisSlaveLeftA;
	public static WPI_TalonSRX chassisSlaveLeftB;
	public static WPI_TalonSRX chassisMasterRight;
	public static WPI_TalonSRX chassisSlaveRightA;
	public static WPI_TalonSRX chassisSlaveRightB;

	public static final double WHEEL_DIAMETER = 6.28;
	
	public static final double CODES_PER_WHEEL_REV = 256.0 * (60.0 / 24.0) * (36.0 / 12.0) * 4;
	
	//CLimber
	public static final int CLIMBER_LEFT = 12;
	public static final int CLIMBER_RIGHT = 13;
	
	//Lift
	public static final int LIFT = 10;
	//public static final int LIMIT_SWITCH = 8;
	
	//Intake
	public static WPI_TalonSRX leftIntake;
	public static WPI_TalonSRX rightIntake;
	
	//DIO
	public static final int DIO_PRIORITY = 0;
	public static final int DIO_LEFT = 1;
	public static final int DIO_MIDDLE = 2;
	public static final int DIO_RIGHT = 3;
	public static final int DIO_SCALE_OVERRIDE = 4;
	public static final int DIO_NO_AUTO = 4;
	
	public static void init() {
		chassisMasterLeft = new WPI_TalonSRX(3);
		chassisSlaveLeftA = new WPI_TalonSRX(6);
		chassisSlaveLeftB = new WPI_TalonSRX(5);
		chassisMasterRight = new WPI_TalonSRX(1);
		chassisSlaveRightA = new WPI_TalonSRX(2);
		chassisSlaveRightB = new WPI_TalonSRX(4);
		
		leftIntake = new WPI_TalonSRX(11);
		rightIntake = new WPI_TalonSRX(9);
		
	}
}
