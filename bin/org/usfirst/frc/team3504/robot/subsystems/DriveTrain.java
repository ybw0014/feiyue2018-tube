package org.usfirst.frc.team3504.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3504.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3504.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3504.robot.commands.*;

import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.NeutralMode;

/**
 *
 */
public class DriveTrain extends Subsystem {

	private WPI_TalonSRX masterTalon;
	private WPI_TalonSRX slaveTalon;
	
	public DriveTrain() {
		masterTalon = new WPI_TalonSRX(RobotMap.DRIVE_MASTER_PORT);
		slaveTalon = new WPI_TalonSRX(RobotMap.DRIVE_SLAVE_PORT);
		slaveTalon.follow(masterTalon, FollowerType.PercentOutput);
	}

	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new DriveByJoystick());
    }
    
    public void forward() {
    	masterTalon.set(0.1);
    }

    // spins the motor backward
    public void backward() {
    	masterTalon.set(-0.1);
    }

    // stops spinning the motor
    public void stop() {
    	masterTalon.set(0);
    }

}

