// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Indexer; 
import frc.robot.subsystems.Shooter;

public class Shoot extends CommandBase {

  // TODO: create a Shooter shooter, Indexer indexer, and double startTime
  Shooter shooter;
  Indexer indexer;
  double startTime;

  public Shoot(Shooter shooter, Indexer indexer) {
    // Add requirements for both the shooter and indexer'
    this.shooter = shooter;
    this.indexer = indexer;

    addRequirements(shooter, indexer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // TODO: set startTime to Timer.getFPGATimestamp();
    startTime = Timer.getFPGATimestamp();
    // TODO: set the shooter power to the constant value (Constants.SHOOTER_POWER)
    shooter.setPower(Constants.SHOOTER_POWER);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if ((Timer.getFPGATimestamp() - startTime) >= 1) { // Checks if 1 second has passed (by comparing the difference between now and when the command started)
      // TODO: set indexer power
      indexer.setPower(1d);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // TODO: stop both the shooter and indexer
    shooter.stop();
    indexer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  
}
