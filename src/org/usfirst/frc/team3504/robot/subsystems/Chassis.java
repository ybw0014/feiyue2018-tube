package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.RobotMap;
import org.usfirst.frc.team3504.robot.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.*;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;


public class Chassis extends Subsystem implements PIDOutput{
	
    private final WPI_TalonSRX masterLeft = RobotMap.chassisMasterLeft;
    private final WPI_TalonSRX slaveLeftA = RobotMap.chassisSlaveLeftA;
    private final WPI_TalonSRX slaveLeftB = RobotMap.chassisSlaveLeftB;
    private final WPI_TalonSRX masterRight = RobotMap.chassisMasterRight;
    private final WPI_TalonSRX slaveRightA = RobotMap.chassisSlaveRightA;
    private final WPI_TalonSRX slaveRightB = RobotMap.chassisSlaveRightB;
    
    private DifferentialDrive drive;
    
    private PIDController turnController;
    private AHRS ahrs;
    private double rotateToAngleRate; 
    
    private Encoder leftEncoder;
    private Encoder rightEncoder;
    
    public final static int REMOTE_ENCODER = 0;
	public final static int REMOTE_PIGEON = 1;
	public final static int PID_DISTANCE = 0;
	public final static int PID_TURNING = 1;
	public final static int SLOT_DISTANCE = 0;
	public final static int SLOT_TURNING = 1;
	public final static double TURN_UNITS_PER_ROTATION = 3600;
	public final static int PIGEON_UNITS_PER_ROTATION = 8192;


    public Chassis() {
    	//This is the constructor
    	
    	masterLeft.setNeutralMode(NeutralMode.Brake);
    	slaveLeftA.setNeutralMode(NeutralMode.Brake);
    	slaveLeftB.setNeutralMode(NeutralMode.Brake);
    	masterRight.setNeutralMode(NeutralMode.Brake);
    	slaveRightA.setNeutralMode(NeutralMode.Brake);
    	slaveRightB.setNeutralMode(NeutralMode.Brake);
    	
    	masterLeft.setSafetyEnabled(false);
    	slaveLeftA.setSafetyEnabled(false);
    	slaveLeftB.setSafetyEnabled(false);
    	masterRight.setSafetyEnabled(false);
    	slaveRightA.setSafetyEnabled(false);
    	slaveRightB.setSafetyEnabled(false);
    	 
    	//reverse();
    	this.setInvert(false,false);
    	
    	slaveLeftA.follow(masterLeft, FollowerType.PercentOutput);
    	slaveLeftB.follow(masterLeft, FollowerType.PercentOutput);
    	slaveRightA.follow(masterRight, FollowerType.PercentOutput);
    	slaveRightB.follow(masterRight, FollowerType.PercentOutput);
    	
    	this.setInvert(false,true); //uncomment if needed
    	//if needed to invert the talons, do before putting into the drive
    	
    	drive = new DifferentialDrive(masterLeft, masterRight);
    	drive.setSafetyEnabled(false);
    	drive.setExpiration(0.1);
    	drive.setMaxOutput(1.0);

    	try {
    		ahrs = new AHRS(SPI.Port.kMXP);
    	} catch (RuntimeException ex ) {
    		DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
    	}
    	turnController = new PIDController(0.03, 0.0, 0.0, 0.0, ahrs, this);
    	turnController.setInputRange(-180.0f,  180.0f);
    	turnController.setOutputRange(-1.0, 1.0);
    	turnController.setAbsoluteTolerance(2.0f);
    	turnController.setContinuous(true);
    	turnController.enable();
    	
    	masterLeft.setSensorPhase(true);
    	masterRight.setSensorPhase(true);
    	
    	masterLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,0);
    	masterRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,0);
    	
    	
    	
    	/*leftEncoder = new Encoder(RobotMap.ENCODER_LEFT_1, RobotMap.ENCODER_LEFT_2, false, Encoder.EncodingType.k4X);
		leftEncoder.setMaxPeriod(.1);
		leftEncoder.setMinRate(10);
		leftEncoder.setDistancePerPulse(5);
		leftEncoder.setReverseDirection(false);
		leftEncoder.setSamplesToAverage(7);
		
		rightEncoder = new Encoder(RobotMap.ENCODER_RIGHT_1, RobotMap.ENCODER_RIGHT_2, false, Encoder.EncodingType.k4X);
		rightEncoder.setMaxPeriod(.1);
		rightEncoder.setMinRate(10);
		rightEncoder.setDistancePerPulse(5);
		rightEncoder.setReverseDirection(false);
		rightEncoder.setSamplesToAverage(7);*/
    	
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DriveByJoystick());
    }

    @Override
    public void periodic() {
    	
    }
    
    public void driveByJoystick(double yDir, double xDir){
    	SmartDashboard.putString("driveByJoyStick:", "Y: " + yDir + "  X: " + xDir);
    	drive.arcadeDrive(yDir,xDir);
    }
    
    public void setInvert(boolean left,boolean right) {
    	//if the moters are spinning in opposite directions
    	
    	masterLeft.setInverted(left);
    	slaveLeftA.setInverted(left);
    	slaveLeftB.setInverted(left);
    	
    	masterRight.setInverted(right);
    	slaveRightA.setInverted(right);
    	slaveRightB.setInverted(right);
    }
    
    public void reverseAll() {
    	//if the motors are together but completely reversed (do not pair with invert)
    	masterLeft.setInverted(true);
    	slaveLeftA.setInverted(true);
    	slaveLeftB.setInverted(true);
    	
    	masterRight.setInverted(true);
    	slaveRightA.setInverted(true);
    	slaveRightB.setInverted(true);
    }
    
    public void arcadeDrive(double leftV,double rightV) {
    	drive.arcadeDrive(leftV, rightV);
    }
    
    public void tankDrive(double leftV,double rightV) {
    	drive.tankDrive(leftV, rightV);
    }
    
    public DifferentialDrive getDrive() {
    	return this.drive;
    }
    
    public void setFPID(WPI_TalonSRX talon) {
    	talon.setSelectedSensorPosition(0, 0, 0);
    	talon.config_kF(0, 0, 0);
    	talon.config_kP(0, 0.5, 0);
    	talon.config_kI(0, 0, 0);
    	talon.config_kD(0, 0, 0);
    }
    
    @Override
    public void pidWrite(double output) {
    	this.rotateToAngleRate = output;
    }

    public double getRotationAngleRate() {
    	return this.rotateToAngleRate;
    }
    
    public AHRS getAHRS() {
    	return this.ahrs;
    }
    
    public PIDController getTurnController() {
    	return this.turnController;
    }

    public Encoder getLeftEncoder() {
    	return this.leftEncoder;
    }
    
    public Encoder getRightEncoder() {
    	return this.rightEncoder;
    }
    
    public void stop() {
    	drive.stopMotor();
    }

    public WPI_TalonSRX getLeftTalon() {
    	return this.masterLeft;
    }
    
    public WPI_TalonSRX getRightTalon() {
    	return this.masterRight;
    }

    public void zeroSensors() {
		masterLeft.getSensorCollection().setQuadraturePosition(0, 10);
		masterRight.getSensorCollection().setQuadraturePosition(0, 10);
		slaveLeftA.getSensorCollection().setQuadraturePosition(0, 10);
		slaveLeftB.getSensorCollection().setQuadraturePosition(0, 10);
		slaveRightA.getSensorCollection().setQuadraturePosition(0, 10);
		slaveRightB.getSensorCollection().setQuadraturePosition(0, 10);
		// the arguments 0,10 are from GOS; not sure whether to change to 0,0
		System.out.println("HOPEFULLY ALL TALONS IN CHASSIS ARE ZEROED");
	}
    
	public void zeroEncoder() {
		masterLeft.getSensorCollection().setQuadraturePosition(0, 10);
		masterRight.getSensorCollection().setQuadraturePosition(0, 10);
		System.out.println("Chassis: Encoders are zeroed.");
	}
	
    
	public void configForMotionMagic() {
		masterLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, PID_DISTANCE, 10);
		/* Remote 0 will be the other side's Talon */
		masterRight.configRemoteFeedbackFilter(masterLeft.getDeviceID(), RemoteSensorSource.TalonSRX_SelectedSensor, REMOTE_ENCODER, 10);
		/* Remote 1 will be a pigeon */
		//masterRight.configRemoteFeedbackFilter(Robot.collector.getRightCollectorID(), RemoteSensorSource.GadgeteerPigeon_Yaw, REMOTE_PIGEON, 10);
		/* setup sum and difference signals */
		masterRight.configSensorTerm(SensorTerm.Sum0, FeedbackDevice.RemoteSensor0, 10);
		masterRight.configSensorTerm(SensorTerm.Sum1, FeedbackDevice.QuadEncoder, 10);
		masterRight.configSensorTerm(SensorTerm.Diff1, FeedbackDevice.RemoteSensor0, 10);
		masterRight.configSensorTerm(SensorTerm.Diff0, FeedbackDevice.QuadEncoder, 10);
		/* select sum for distance(0), different for turn(1) */
		masterRight.configSelectedFeedbackSensor(FeedbackDevice.SensorSum, PID_DISTANCE, 10);
		masterRight.configSelectedFeedbackCoefficient(1.0, PID_DISTANCE, 10);
		masterRight.configSelectedFeedbackSensor(FeedbackDevice.RemoteSensor1, PID_TURNING, 10);
		masterRight.configSelectedFeedbackCoefficient(TURN_UNITS_PER_ROTATION / PIGEON_UNITS_PER_ROTATION, PID_TURNING, 10);
	
		//telemetry------------------
		masterRight.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 20, 10);
		masterRight.setStatusFramePeriod(StatusFrame.Status_13_Base_PIDF0, 20, 10);
		masterRight.setStatusFramePeriod(StatusFrame.Status_14_Turn_PIDF1, 20, 10);
		masterRight.setStatusFramePeriod(StatusFrame.Status_10_Targets, 20, 10);
		/* speed up the left since we are polling it's sensor */
		masterLeft.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 5, 10);

		masterLeft.configNeutralDeadband(0.001, 10);
		masterRight.configNeutralDeadband(0.001, 10);

		masterRight.configMotionAcceleration(5000, 10); //28000
		masterRight.configMotionCruiseVelocity(10000, 10);

		/* max out the peak output (for all modes).  However you can
		 * limit the output of a given PID object with configClosedLoopPeakOutput().
		 */
		masterLeft.configPeakOutputForward(+1.0, 10);
		masterLeft.configPeakOutputReverse(-1.0, 10);
		masterRight.configPeakOutputForward(+1.0, 10);
		masterRight.configPeakOutputReverse(-1.0, 10);
		
		masterLeft.setNeutralMode(NeutralMode.Brake);
		masterRight.setNeutralMode(NeutralMode.Brake);
		
		//pid loop speed = 1ms
		masterRight.configSetParameter(ParamEnum.ePIDLoopPeriod, 1, 0x00, PID_DISTANCE, 10);
		masterRight.configSetParameter(ParamEnum.ePIDLoopPeriod, 1, 0x00, PID_TURNING, 10);
		
		/**
		 * false means talon's local output is PID0 + PID1, and other side Talon is PID0 - PID1
		 * true means talon's local output is PID0 - PID1, and other side Talon is PID0 + PID1
		 */
		masterRight.configAuxPIDPolarity(false, 10);
		
		masterRight.selectProfileSlot(SLOT_DISTANCE, PID_DISTANCE);
		masterRight.selectProfileSlot(SLOT_TURNING, PID_TURNING);
	}
}

