/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3504.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team3504.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick drivingStick;
	
	private Button button1;
	private Button button2;
	public OI() {
		drivingStick = new Joystick(RobotMap.JOYSTICK_PORT);
		
		button1 = new JoystickButton(drivingStick, 1); 
		button2 = new JoystickButton(drivingStick, 2);
		
		button1.whenPressed(new DriveForward());
		button2.whenPressed(new DriveForwardByTime(2000)); 
	}
	public double getDrivingJoyStickY(){
		return drivingStick.getY();
	}

	public double getDrivingJoyStickX(){
		return drivingStick.getX();
	}

}