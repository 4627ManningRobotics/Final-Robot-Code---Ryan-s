package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPlacement4 extends CommandGroup {
    
    public  AutoPlacement4() {
    	
    	addSequential(new Wait(1));
    	addSequential(new SetDefenseShotAng());
    	addSequential(new Wait(0.7));
    	addSequential(new AutoTurn(-5));
    	addSequential(new AutoTarget());
    	
    	
    }
}
