package frc.robot;

import frc.robot.Constants.ControllerConstants;
import frc.robot.commands.Collect;
import frc.robot.commands.Index;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
    // create controllers
    private final XboxController driver = new XboxController(ControllerConstants.DRIVER_CONTROLLER_PORT);

    // create subsystems
    private final Collector collector = new Collector();
    private final Indexer indexer = new Indexer();
    //TODO: Instatialize a Shooter Subsystem like the 2 above

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        configureBindings(); // Configure the trigger bindings
    }

    private void configureBindings() {
		new Trigger(driver::getBButton).whileTrue(new Shoot(indexer, shooter));
		new Trigger(driver::getAButton).whileTrue(new Collect(indexer, collector));

        indexer.setDefaultCommand(new Index(indexer, () -> driver.getRightTriggerAxis() - driver.getLeftTriggerAxis()));

    }

	// This is used for autonomous commands we will not be using these for now
    public Command getAutonomousCommand() {
      return null;
    }
}
