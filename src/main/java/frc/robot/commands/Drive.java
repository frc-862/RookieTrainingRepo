package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Drive extends CommandBase {
	private Drivetrain drivetrain;
	private DoubleSupplier powerLeft;
	private DoubleSupplier powerRight;

	public Drive(Drivetrain drivetrain, DoubleSupplier powerLeft, DoubleSupplier powerRight){
		this.drivetrain = drivetrain;
		this.powerLeft = powerLeft;
		this.powerRight = powerRight;
		addRequirements(drivetrain);
	}

	@Override
	public void execute(){
		drivetrain.setLeftPower(powerLeft.getAsDouble());
		drivetrain.setRightPower(powerRight.getAsDouble());
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