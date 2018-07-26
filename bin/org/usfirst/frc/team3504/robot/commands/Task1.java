package org.usfirst.frc.team3504.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Task1 extends CommandGroup {
	
	public Task1() {
		addSequential(new OpenSolenoid());
		addSequential(new DriveForwardByTime(2000));
		addSequential(new CloseSolenoid());
		addSequential(new DriveBackByTime(2000));
	}
}