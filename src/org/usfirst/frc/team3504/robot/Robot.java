package org.usfirst.frc.team3504.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3504.robot.GameData.*;
import org.usfirst.frc.team3504.robot.commands.*;
import org.usfirst.frc.team3504.robot.commands.autonomous.*;
import org.usfirst.frc.team3504.robot.subsystems.*;

public class Robot extends TimedRobot {
	public static OI oi;
	public static Chassis chassis;
	public static Solenoid solenoid;
	public static Climber climber;
	public static Collector collector;
	public static Lift lift;
	public static GameData gameData;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		DriverStation.reportWarning("Initialzing.", false);
		RobotMap.init();
		
		chassis = new Chassis();
		solenoid = new Solenoid();
		climber = new Climber();
		collector = new Collector();
		lift = new Lift(); 
		
		gameData = new GameData();

		oi = new OI();
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
		
		DriverStation.reportWarning("Program has initialized.", false);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		DriverStation.reportWarning("Program has stopped running.", false);
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run(); 
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		
		Robot.chassis.zeroSensors();
		gameData.reset();
	
		System.out.println("Starting Auto...");
		//Get robot side, switch side, scale side, element priority
		FieldSide robotSide = gameData.getRobotSide();
		FieldElement elementPriority = gameData.getElementPriority();
		FieldSide switchSide = gameData.getSwitchSide(); 
		//FieldSide scaleSide = gameData.getScaleSide();
		//boolean scaleOverride = gameData.getScaleOverride();
		
		if(gameData.getNoAuto()) {
			autonomousCommand = null;
		}
		else if(robotSide == FieldSide.left || robotSide == FieldSide.right) {//if robot in the corner
			
		
			//Robot.shifters.shiftGear(Shifters.Speed.kHigh);

			if (elementPriority == FieldElement.Switch) //switch priority
			{
				if (switchSide == robotSide) autonomousCommand = new AutoNearSwitch(switchSide);
				//else if (scaleSide == robotSide) autonomousCommand = new AutoNearScale(switchSide);
				//else if (scaleOverride) autonomousCommand = new AutoFarScaleAbsolute(switchSide);
				else autonomousCommand = new AutoDriveToBaseline();
			}
			/*	scale priority - probably won't need this since we cannot do scale
			else 
			{
				if (scaleSide == robotSide) autonomousCommand = new AutoNearScale(scaleSide);
				else if (scaleOverride) autonomousCommand = new AutoFarScaleAbsolute(scaleSide);
				else if (switchSide == robotSide) autonomousCommand = new AutoNearSwitch(scaleSide);
				else autonomousCommand = new AutoDriveToBaseline();
			}
			*/
		}
		else if(robotSide == FieldSide.middle) {
			//Robot.shifters.shiftGear(Shifters.Speed.kLow);
			if (switchSide != FieldSide.bad) autonomousCommand = new AutoMiddleSwitch(switchSide);
			else autonomousCommand = new AutoDriveToBaseline();
		}
		else {
			System.out.println("AutoInit: Robot field side from DIO ports invalid!!");
			autonomousCommand = new AutoDriveToBaseline();
		}
		
		System.out.println("Auto: " + autonomousCommand);
		
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
