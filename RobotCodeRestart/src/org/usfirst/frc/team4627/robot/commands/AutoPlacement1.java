package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPlacement1 extends CommandGroup {
   
    public  AutoPlacement1() {
    	
    	addSequential(new Wait(1));
    	addSequential(new AutoTurn(36));
    	addSequential(new SetDriveMotors(0,0));
    	addSequential(new Wait(0.42));
    	addSequential(new SetDefenseShotAng());
    	addSequential(new Wait(0.7));
    	addSequential(new AutoTarget());
    	
    	
    }
}
