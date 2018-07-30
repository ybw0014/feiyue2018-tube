package org.usfirst.frc.team3504.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommands extends CommandGroup {

    public AutonomousCommands() {

        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        
    	addSequential(new DriveForwardByTime(2000,0.8));
    	addSequential(new Sleep(2000));
    	addSequential(new DriveBackwardByTime(2000,0.8));
    	addSequential(new Sleep(2000));
    }
}
