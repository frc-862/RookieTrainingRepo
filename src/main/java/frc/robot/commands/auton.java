// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Drivetrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class auton extends SequentialCommandGroup {
  /**
     * Tests the drivetrain by driving each module at a given speed and angle
     * 
     * @param drivetrain The drivetrain
     * @param module The module to drive
     * @param speed The speed to drive at
     */
    public auton(Drivetrain drivetrain) {
        super(new WaitCommand(2) //,
                // new TimedCommand(new DriveTest(drivetrain, module, speed), 2), 
                // new WaitCommand(1), 
                // new TimedCommand(new DriveTest(drivetrain, module, -speed), 2), 
                // new WaitCommand(1),
                // new TimedCommand(new TurnTest(drivetrain, module, true), 2), 
                // new WaitCommand(1), 
                // new TimedCommand(new TurnTest(drivetrain, module, false), 2)
                );
    }
}
