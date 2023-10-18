package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;

public class Shooter extends SubsystemBase {
    public final TalonFX shooterMotor;

    public Shooter() {
        shooterMotor = new TalonFX(RobotMap.FLYWHEEL_MOTOR);
    }

    @Override
    public void periodic() {

    }
    
    public void setPower(double power) {
        shooterMotor.set(TalonFXControlMode.PercentOutput, power);
    }

    public void stop() {
        setPower(0d);
    }
}
