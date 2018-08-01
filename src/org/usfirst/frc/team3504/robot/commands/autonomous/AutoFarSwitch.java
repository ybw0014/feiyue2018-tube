package org.usfirst.frc.team3504.robot.commands.autonomous;

import org.usfirst.frc.team3504.robot.GameData.FieldSide;
import org.usfirst.frc.team3504.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoFarSwitch extends CommandGroup{
	private final double DISTANCE_FORWARD = 260.0;
	private final double DISTANCE_SIDE = 0.0;
	private final double BACK_UP = -30;
	
	public AutoFarSwitch(FieldSide robotPosition) {
		// get lift to position
	    addSequential(new LiftToSwitch());
	    
	    //move robot into position
    	addSequential(new DriveByMotionMagic(DISTANCE_FORWARD, 0));
    	if (robotPosition == FieldSide.left) addSequential(new AutoTurnRight(25.0));
    	else addSequential(new AutoTurnLeft(25.0));
    	addSequential(new DriveByMotionMagic(DISTANCE_SIDE, 0));
    	
    	//release and back up
    	addSequential(new ReleaseCollector());
    	addSequential(new Sleep(10));
    	addSequential(new DriveByMotionMagic(BACK_UP, 0));

    	// put lift down
    	addSequential(new LiftDown());
	}
}