package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.*;

public class Shooter extends SubsystemBase {
    public final Victor shooterMotor;

    public Shooter() {
        shooterMotor = new Victor(RobotMap.SHOOTER);
        CommandScheduler.getInstance().registerSubsystem(this);
    }

    public void setPower(double power) {
        shooterMotor.set(power);
    }

    public void stop() {
        setPower(0d);
    }
}
