package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.*;

public class Drivetrain extends SubsystemBase {
	private Victor left1;
	private Victor left2;
	private Victor right1;
	private Victor right2;

public Drivetrain(){
		left1 = new Victor(RobotMap.LEFT1);
		left2 = new Victor(RobotMap.LEFT2);
		right1 = new Victor(RobotMap.RIGHT1);
		right2 = new Victor(RobotMap.RIGHT2);
		right1.setInverted(true);
		right2.setInverted(true);

	}

	public void setLeftPower(double power){
		left1.set(power);
		left2.set(power);
	}
	
	Public void setRightPower(double power){
		right1.set(power);
		right2.set(power);
	}

	public void stop(){
		setLeftPower(0d);
		setRightPower(0d);
	}
}