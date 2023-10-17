package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.CollectConstants;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;

public class Shoot extends CommandBase {
    /* INFO: 
     * Timer.getFPGATimestamp() gets the current time in seconds since the robot has turned on
     * You have to use this function for logic in this command.
     */


    //TODO: declare indexer and shooter

    //TODO: create a double startTime variable

    public Shoot(Indexer indexer, Shooter shooter) {
        //TODO: populate indexer and shooter variables
        addRequirements(indexer, shooter);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        /*figure out what goes here*/ = Timer.getFPGATimestamp();
        shooter.setPower(ShooterConstants.SHOOTER_SPEED_CAP); //please do not alter this value, voids shooter at full power is dangerous, and not in the fun way
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        //TODO: ~if~ more than {ShooterConstants.SHOOTER_REV_TIME} seconds has passed since the command started, set indexer power to {CollectConstants.INDEX_SPEED}
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        indexer.stop();
        //TODO: stop shooter
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
