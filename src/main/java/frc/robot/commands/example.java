package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;

public class example extends SequentialCommandGroup {
  /**
     * Tests the drivetrain by driving each module at a given speed and angle
     * 
     * @param drivetrain The drivetrain
     * @param module The module to drive
     * @param speed The speed to drive at
     */
    public example(Drivetrain drivetrain, Indexer indexer, Collector collector, Shooter shooter) {
        super(new WaitCommand(2),
                new Collect(indexer, collector).withTimeout(2),
                new WaitCommand(1),
                new Collect(indexer, collector).withTimeout(3),
                new WaitCommand(1),
                new Index(indexer, () -> 0.5).withTimeout(.1),
                new WaitCommand(1),
                new Shoot(indexer, shooter));
    }
}
