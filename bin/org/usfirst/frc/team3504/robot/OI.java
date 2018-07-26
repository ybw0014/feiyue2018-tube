/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3504.robot;

import edu.wpi.first.wpilibj.buttons.Button;

import org.usfirst.frc.team3504.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick joystickName = new Joystick(RobotMap.JOYSTICK_PORT);
	Button button1 = new JoystickButton(joystickName, 1); 
	Button button2 = new JoystickButton(joystickName, 2);
	
	public OI() {
		button1.whenPressed(new DriveForward()); 
		button2.whenPressed(new DriveStop());   
	}
	
	public double getDrivingJoyStickY(){
		return joystickName.getY();
	}

	public double getDrivingJoyStickX(){
		return joystickName.getX();
	}

}