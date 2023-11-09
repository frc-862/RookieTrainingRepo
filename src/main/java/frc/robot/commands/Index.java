package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;

public class Index extends CommandBase {
    Indexer indexer;
    DoubleSupplier power;
    
    public Index(Indexer indexer, DoubleSupplier power) {
		this.indexer = indexer;
		this.power = power;
		addRequirements(indexer);
    }
    
    @Override
    public void execute() {
        indexer.setPower(power.getAsDouble());
        // System.out.println("Im another Ghost good luck!");
    }

	@Override
	public void end(boolean interrupted) {
		indexer.stop();
	}

    @Override
    public boolean isFinished() {
        return false;
    }
}