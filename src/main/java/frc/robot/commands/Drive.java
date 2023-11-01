package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Drive extends CommandBase {
	private Drivetrain drivetrain;
	private DoubleSupplier powerLeft;
	private DoubleSupplier powerRight;

	public Drive(){
		this.drivetrain = drivetrain;
		this.power = power;
		addRequirements(drivetrain);
	}

	@Override
	public void execute(){
		drivetrain.setLeftPower(power.getAsDouble);
		drivetrain.setRightPower(power.getAsDouble);
	}

	@Override
	public void end(boolean interrupted){
		drivetrain.stop();
	}

	@Override
	public boolean isFinished(){
		return false;
	}
}