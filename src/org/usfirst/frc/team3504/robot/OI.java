package org.usfirst.frc.team3504.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team3504.robot.commands.*;

public class OI {
	private Joystick gamePad;
	private Joystick joyStick;
	
	private Button gbutton1,gbutton2,gbutton3,gbutton4,gbutton5,gbutton6,gbutton7,gbutton8,gbutton9,gbutton10,gbutton11,gbutton12;
	private Button jbutton1,jbutton2,jbutton3,jbutton4,jbutton5,jbutton6,jbutton7,jbutton8,jbutton9,jbutton10,jbutton11,jbutton12;
	
	public OI() {
		gamePad = new Joystick(RobotMap.GAMEPAD_PORT);
		joyStick = new Joystick(RobotMap.JOYSTICK_PORT);
		
		gbutton1 = new JoystickButton(gamePad, 1); 
		gbutton2 = new JoystickButton(gamePad, 2);
		gbutton3 = new JoystickButton(gamePad, 3);
		gbutton4 = new JoystickButton(gamePad, 4);
		gbutton5 = new JoystickButton(gamePad, 5);
		gbutton6 = new JoystickButton(gamePad, 6);
		gbutton7 = new JoystickButton(gamePad, 7);
		gbutton8 = new JoystickButton(gamePad, 8);
		gbutton9 = new JoystickButton(gamePad, 9);
		gbutton10 = new JoystickButton(gamePad, 10);
		gbutton11 = new JoystickButton(gamePad, 11);
		gbutton12 = new JoystickButton(gamePad, 12);
		
		jbutton1 = new JoystickButton(joyStick, 1); 
		jbutton2 = new JoystickButton(joyStick, 2);
		jbutton3 = new JoystickButton(joyStick, 3);
		jbutton4 = new JoystickButton(joyStick, 4);
		jbutton5 = new JoystickButton(joyStick, 5);
		jbutton6 = new JoystickButton(joyStick, 6);
		jbutton7 = new JoystickButton(joyStick, 7);
		jbutton8 = new JoystickButton(joyStick, 8);
		jbutton9 = new JoystickButton(joyStick, 9);
		jbutton10 = new JoystickButton(joyStick, 10);
		jbutton11 = new JoystickButton(joyStick, 11);
		jbutton12 = new JoystickButton(joyStick, 12);
		
		gbutton1.whenPressed(new OpenIntake());
		gbutton4.whenPressed(new ShootIntake());
		
		gbutton2.whenPressed(new OpenPneumatic());
		gbutton3.whenPressed(new ClosePneumatic());
		
		gbutton5.whenPressed(new LiftUp());
		gbutton5.whenReleased(new LiftStop());
		gbutton7.whenPressed(new LiftDown());
		gbutton7.whenReleased(new LiftStop());
		
		gbutton6.whenPressed(new ClimbUp());
		gbutton8.whenPressed(new ClimbDown());
		
		
		jbutton1.whenPressed(new OpenPneumatic());
		jbutton2.whenPressed(new ClosePneumatic());
		
		jbutton4.whenPressed(new LiftUp());
		jbutton4.whenReleased(new LiftStop());
		jbutton6.whenPressed(new LiftDown());
		jbutton6.whenReleased(new LiftStop());
		
		jbutton3.whenPressed(new OpenIntake());
		jbutton5.whenPressed(new ShootIntake());
		
		jbutton11.whenPressed(new ClimbUp());
		jbutton12.whenPressed(new ClimbDown());
	}
	public Joystick getGamePad() {
		return this.gamePad; 
	}
	
	public Joystick getJoyStick() {
		return this.joyStick;
	}
	
}