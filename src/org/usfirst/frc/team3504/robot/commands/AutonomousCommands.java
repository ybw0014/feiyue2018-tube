package org.usfirst.frc.team3504.robot.commands;

import java.io.File;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommands extends CommandGroup {

    public AutonomousCommands() {

        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
    	
    	
    	//File pathFile = new File(pathFilename, "r+");
    	
    	addSequential(new DriveByDistanceInInch(125, 0.8, true));
    	addSequential(new StopChassis());
    	addSequential(new Sleep(5000));
    	
    }
}
