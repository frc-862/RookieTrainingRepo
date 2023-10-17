package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.CollectConstants;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Indexer;

public class Collect extends CommandBase {
    Indexer indexer;
    Collector collector;

    public Collect(Indexer indexer, Collector collector) {
        this.indexer = indexer;
        this.collector = collector;
        addRequirements(indexer, collector);
    }

    @Override
    public void execute() {
        indexer.setPower(CollectConstants.INDEX_SPEED);
        collector.setPower(CollectConstants.COLLECT_SPEED);
    }

    @Override
    public void end(boolean interrupted) {
        collector.stop();
        indexer.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}