package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import frc.robot.constants.JoystickConstants;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
    private final Shooter shooter = new Shooter();
    private final Indexer indexer = new Indexer();
    private final Drivetrain drivetrain = new Drivetrain();

    public final Joystick driverLeft = new Joystick(JoystickConstants.Ports.DRIVER_LEFT);
    public final Joystick driverRight = new Joystick(JoystickConstants.Ports.DRIVER_RIGHT);
    public final XboxController coPilot = new XboxController(JoystickConstants.Ports.COPILOT);

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {
        new Trigger(coPilot::getAButton).whileTrue(new Shoot(shooter, indexer));

        indexer.setDefaultCommand(new Index(indexer, () -> coPilot.getRightTriggerAxis()-coPilot.getLeftTriggerAxis()));

        drivetrain.setDefaultCommand(new Drive(drivetrain, () -> driverLeft.getY(), () -> driverRight.getY()));
    }

    public Command getAutonomousCommand() { return null; }
}
