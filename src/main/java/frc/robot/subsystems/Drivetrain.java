package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.*;

public class Drivetrain extends SubsystemBase {
	public final Victor leftMotor1;
	public final Victor leftMotor2;

	public final Victor rightMotor1;
	public final Victor rightMotor2;

public Drivetrain(){
		leftMotor1 = new Victor(RobotMap.LEFT1);
		leftMotor2 = new Victor(RobotMap.LEFT2);

		rightMotor1 = new Victor(RobotMap.RIGHT1);
		rightMotor2 = new Victor(RobotMap.RIGHT2);
		rightMotor1.setInverted(true);
		rightMotor2.setInverted(true);

		CommandScheduler.getInstance().registerSubsystem(this);
	}

	public void setLeftPower(double power){
		leftMotor1.set(power);
		leftMotor2.set(power);
	}
	
	public void setRightPower(double power){
		rightMotor1.set(power);
		rightMotor2.set(power);
	}

	public void stop(){
		setLeftPower(0d);
		setRightPower(0d);
	}
}