package org.usfirst.frc.team4627.robot.commands;
import org.usfirst.frc.team4627.robot.Robot;
import org.usfirst.frc.team4627.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoShovelTheFries extends Command {

    public AutoShovelTheFries() {
    	requires(Robot.elChupaArms);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
 
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	System.out.println("AutoTeeterTotters is executing");
    	
    	Robot.elChupaArms.motorPosition = 1000;
    	Robot.elChupaArms.setMotor();
    	Timer.delay(1);
    	
    	Robot.driveTrain.setLeftMotors(0.45);
    	Robot.driveTrain.setRightMotors(-0.45);
    	Timer.delay(1.25);
    	
    	Robot.elChupaArms.motorPosition = 75;
    	Robot.elChupaArms.setMotor();
    	Timer.delay(1);
    	
    	Robot.driveTrain.setLeftMotors(0.6);
    	Robot.driveTrain.setRightMotors(-0.6);
    	Timer.delay(1);
    	
    	Robot.elChupaArms.motorPosition = RobotMap.EL_CHUPAS_MAX_POSITION;
    	Timer.delay(1);
    	
    	Robot.driveTrain.setLeftMotors(0);
    	Robot.driveTrain.setRightMotors(0);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	if(Robot.autonomousPlacementStart != null) {
    		Robot.autonomousPlacementStart.start();
    	}
    	
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
