package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.NeutralMode;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private WPI_TalonSRX masterTalon;
	private WPI_TalonSRX slaveTalon;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public DriveTrain() {
    	masterTalon = new WPI_TalonSRX(RobotMap.DRIVE_MASTER_PORT);
    	slaveTalon = new WPI_TalonSRX(RobotMap.DRIVE_SLAVE_PORT);
    	
    	slaveTalon.follow(masterTalon, FollowerType.PercentOutput);
    }
}

