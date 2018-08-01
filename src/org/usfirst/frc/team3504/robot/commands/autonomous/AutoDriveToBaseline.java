package org.usfirst.frc.team3504.robot.commands.autonomous;

import org.usfirst.frc.team3504.robot.commands.DriveByMotionMagicAbsolute;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDriveToBaseline extends CommandGroup {

    public AutoDriveToBaseline() {
    	addSequential(new DriveByMotionMagicAbsolute(160.0, 0, false));
    }
}
