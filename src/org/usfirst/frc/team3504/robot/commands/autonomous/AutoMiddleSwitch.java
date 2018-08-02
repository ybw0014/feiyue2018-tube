package org.usfirst.frc.team3504.robot.commands.autonomous;

import org.usfirst.frc.team3504.robot.GameData.*;
import org.usfirst.frc.team3504.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoMiddleSwitch extends CommandGroup{
	public final static double RIGHT_ANGLE = 53.0;
	public final static double RIGHT_DISTANCE = 81.0;
	public final static double LEFT_ANGLE = 65.0;
	public final static double LEFT_DISTANCE = 81.0;
	public final static double BACK_UP = -30.0;
	
	public AutoMiddleSwitch(FieldSide switchSide) {
	    // get lift to position
	    addSequential(new LiftToSwitch());
	    
	    //move robot into position
    	if(switchSide == FieldSide.right)
    	{
    		addSequential(new DriveByMotionMagic(RIGHT_DISTANCE, -RIGHT_ANGLE));
    		addSequential(new DriveByMotionMagic(RIGHT_DISTANCE, RIGHT_ANGLE));
    	}
    	else if (switchSide == FieldSide.left)
    	{
    		addSequential(new DriveByMotionMagic(LEFT_DISTANCE, LEFT_ANGLE));
    		addSequential(new DriveByMotionMagic(LEFT_DISTANCE, -LEFT_ANGLE));
    	}
    	
    	//release and back up
    	addSequential(new ReleaseCollector());
    	addSequential(new Sleep(10));
    	addSequential(new DriveByMotionMagic(BACK_UP, 0));

    	// put lift down
    	addSequential(new LiftDown());
	}
}