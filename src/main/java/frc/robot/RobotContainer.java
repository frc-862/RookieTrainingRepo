package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import frc.robot.constants.JoystickConstants;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
    
    // TODO: create new private subsystems (indexer and shooter)
    private Indexer indexer = new Indexer();
    private Shooter shooter = new Shooter();

    public final XboxController driver = new XboxController(JoystickConstants.Ports.COPILOT);

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {
        // TODO: map the A button to the Shoot command
        new Trigger(driver::getAButton).whileTrue(new Shoot(shooter, indexer)); 
        
        // TODO: set indexer default command to run the indexer based on the triggers
        
    }

    public Command getAutonomousCommand() { return null; }
}
