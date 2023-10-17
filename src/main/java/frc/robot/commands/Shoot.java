package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.CollectConstants;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;

public class Shoot extends CommandBase {
    Indexer indexer;
    Shooter shooter;
    private double startTime;

    public Shoot(Indexer indexer, Shooter shooter) {
        addRequirements(indexer, shooter);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        startTime = Timer.getFPGATimestamp();
        shooter.setPower(ShooterConstants.SHOOTER_SPEED_CAP);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if ((Timer.getFPGATimestamp() - startTime) >= ShooterConstants.SHOOTER_REV_TIME) {
            indexer.setPower(CollectConstants.INDEX_SPEED);
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        indexer.stop();
        shooter.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
