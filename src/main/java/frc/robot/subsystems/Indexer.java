package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;

public class Indexer extends SubsystemBase {
    public final TalonFX indexMotor;

    public Indexer() {
        indexMotor = new TalonFX(RobotMap.INDEXER_MOTOR);
    }

    @Override
    public void periodic() {
        System.out.println("I AM A GHOST, FIND ME!");
    }
    
    public void setPower(double power) {
        indexMotor.set(TalonFXControlMode.PercentOutput, power);
    }

    public void stop() {
        setPower(0);
    }
}
