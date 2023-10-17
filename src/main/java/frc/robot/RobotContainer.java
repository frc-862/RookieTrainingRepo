package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import frc.robot.constants.JoystickConstants;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
    private final Shooter shooter = new Shooter();
    private final Indexer indexer = new Indexer();

    public final XboxController driver = new XboxController(JoystickConstants.Ports.COPILOT);

    public RobotContainer() {
        configureBindings();
        indexer.setDefaultCommand(new Index(indexer, () -> driver.getRightTriggerAxis()-driver.getLeftTriggerAxis()));
    }

    private void configureBindings() {
        new Trigger(driver::getAButton).whileTrue(new StartEndCommand(shooter::spin, shooter::stop, shooter));
    }

    public Command getAutonomousCommand() { return null; }
}
