package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private WPI_TalonSRX climbMotor;
	
	public Climber() {
		climbMotor = new WPI_TalonSRX(RobotMap.CLIMBER);
		
		climbMotor.setNeutralMode(NeutralMode.Brake);
		climbMotor.configContinuousCurrentLimit(200, 10);
		//climbMotor.setInverted(true);
		
		climbMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		climbMotor.setSensorPhase(true);

		climbMotor.config_kF(0, 0, 0);
		climbMotor.config_kP(0, 0.5, 0);
		climbMotor.config_kI(0, 0, 0);
		climbMotor.config_kD(0, 0, 0);
	}
	
	public void climb(double speed) {
		climbMotor.set(speed);
	}
	
	public void stopClimb() {
		climbMotor.set(0.0);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

