package frc.robot;

import frc.robot.Constants.ControllerConstants;
import frc.robot.commands.Collect;
import frc.robot.commands.Index;
import frc.robot.commands.Shoot;
import frc.robot.commands.drive;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
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
    private final Joystick right = new Joystick(ControllerConstants.DRIVER_LEFT_PORT);
    private final Joystick left = new Joystick(ControllerConstants.DRIVER_RIGHT_PORT);
    private final XboxController coPilot = new XboxController(ControllerConstants.COPILOT_CONTROLLER_PORT);

    // create subsystems
    private final Drivetrain drivetrain = new Drivetrain();
    private final Collector collector = new Collector();
    private final Indexer indexer = new Indexer();
    private final Shooter shooter = new Shooter();

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        configureBindings(); // Configure the trigger bindings
    }

    private void configureBindings() {
		new Trigger(coPilot::getBButton).whileTrue(new Shoot(indexer, shooter));
		new Trigger(coPilot::getAButton).whileTrue(new Collect(indexer, collector));

        indexer.setDefaultCommand(new Index(indexer, () -> coPilot.getRightTriggerAxis() - coPilot.getLeftTriggerAxis()));
        drivetrain.setDefaultCommand(new drive(drivetrain, () -> right.getY(), () -> left.getX()));
    }

	// This is used for autonomous commands we will not be using these for now
    public Command getAutonomousCommand() {
      return null;
    }
}
