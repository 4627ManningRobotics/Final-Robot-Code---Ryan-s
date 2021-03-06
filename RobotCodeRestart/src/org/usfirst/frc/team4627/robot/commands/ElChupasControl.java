package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;
import org.usfirst.frc.team4627.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElChupasControl extends Command {

    public ElChupasControl() {
        requires(Robot.elChupaArms);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
    	
    if(DriverStation.getInstance().isOperatorControl() == true) {
    double leftTrigger = Robot.oi.operatorAxisValue(RobotMap.LEFT_TRIGGER);
    double rightTrigger = Robot.oi.operatorAxisValue(RobotMap.RIGHT_TRIGGER);
    
    Robot.elChupaArms.shootBoulder((rightTrigger - leftTrigger)* RobotMap.EL_CHUPA_SHOOT_SCALING);
    
    
    double leftY = -Robot.oi.operatorAxisValue(RobotMap.LEFT_JOYSTICK_Y_AXIS);

    
    if (leftY > 0.1) {
    	if (Robot.elChupaArms.motorPosition < RobotMap.EL_CHUPAS_MAX_LIFT) {  	
    	Robot.elChupaArms.motorPosition+=5;
    	}
    }
    
    if (leftY < -0.1) {
    	
    	if (Robot.elChupaArms.motorPosition >= RobotMap.EL_CHUPAS_MIN_LIFT) {
    		
    	Robot.elChupaArms.motorPosition-=5;
    	}
    }
    
   
    Robot.elChupaArms.setMotor();
    
    }
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
