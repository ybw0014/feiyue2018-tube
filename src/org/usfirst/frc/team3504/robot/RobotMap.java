/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3504.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class RobotMap {
	
	public static final int JOYSTICK_PORT = 1;
	
	public static WPI_TalonSRX chassisMasterLeft;
	public static WPI_TalonSRX chassisSlaveLeftA;
	public static WPI_TalonSRX chassisSlaveLeftB;
	
	public static WPI_TalonSRX chassisMasterRight;
	public static WPI_TalonSRX chassisSlaveRightA;
	public static WPI_TalonSRX chassisSlaveRightB;
	
	public static void init() {
		chassisMasterLeft = new WPI_TalonSRX(1);
		chassisSlaveLeftA = new WPI_TalonSRX(1);
		chassisSlaveLeftB = new WPI_TalonSRX(1);
		chassisMasterRight = new WPI_TalonSRX(1);
		chassisSlaveRightA = new WPI_TalonSRX(1);
		chassisSlaveRightB = new WPI_TalonSRX(1);
		
	}
	
}
