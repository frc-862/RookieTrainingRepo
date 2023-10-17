package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;

public class Index extends CommandBase {
    //TODO: declare indexer

    //this creates a DoubleSupplier, which is a function that returns a double
    //DoubleSuppliers are a kind of supplier, which update their input value every loop cycle, asynchronously
    DoubleSupplier power;
    
    public Index(Indexer indexer, DoubleSupplier power) {
		this.indexer = indexer;
		this.power = power;
		addRequirements(indexer);
    }    
    
    @Override
    public void execute() {
        //TODO: set indexer power to power.getAsDouble()
        System.out.println("This prints every time the code loops");
    }
    @Override
    public void end(boolean interrupted) {
        //TODO: stop indexer
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}