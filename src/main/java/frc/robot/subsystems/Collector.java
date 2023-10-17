package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;

public class Collector extends SubsystemBase {
    private final TalonFX collectMotor;

    public Collector() {
        collectMotor = new TalonFX(RobotMap.COLLECTOR_MOTOR);
    }

    @Override
    public void periodic() {
        
    }

    public void setPower(double power) {
        collectMotor.set(TalonFXControlMode.PercentOutput, power);
    }

    public void stop() {
        setPower(0);
    }
}
