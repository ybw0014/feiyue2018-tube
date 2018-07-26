package org.usfirst.frc.team3504.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team3504.robot.commands.*;


public class OI {
	private Joystick drivingStick;
	
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button8;
	private Button button9;
	private Button button10;
	private Button button11;
	private Button button12;
	
	public OI() {
		drivingStick = new Joystick(RobotMap.JOYSTICK_PORT);
		
		button1 = new JoystickButton(drivingStick, 1); 
		button2 = new JoystickButton(drivingStick, 2);
		button3 = new JoystickButton(drivingStick, 3);
		button4 = new JoystickButton(drivingStick, 4);
		button5 = new JoystickButton(drivingStick, 5);
		button6 = new JoystickButton(drivingStick, 6);
		button7 = new JoystickButton(drivingStick, 7);
		button8 = new JoystickButton(drivingStick, 8);
		button9 = new JoystickButton(drivingStick, 9);
		button10 = new JoystickButton(drivingStick, 10);
		button11 = new JoystickButton(drivingStick, 11);
		button12 = new JoystickButton(drivingStick, 12);
		
		//button1.whenPressed(new DriveForwardByTime(2000,0.8));
		//button2.whenPressed(new DriveBackwardByTime(2000,0.8));
		//button3.whenPressed(new OpenSolenoid());
		//button4.whenPressed(new CloseSolenoid());
		
		button4.whenPressed(new DriveForwardByTime(2000,0.8));
		button2.whenPressed(new DriveBackwardByTime(2000,0.8));

		button1.whenPressed(new OpenSolenoid());
		button3.whenPressed(new CloseSolenoid());
		
	}
	public Joystick getJoyStick() {
		return this.drivingStick;
	}

}