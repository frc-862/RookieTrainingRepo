package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;

public class Indexer extends SubsystemBase {
    public final VictorSPX indexMotor;

    public Indexer() {
        indexMotor = new VictorSPX(RobotMap.INDEXER_MOTOR);
    }

    @Override
    public void periodic() {
        System.out.println("I AM A GHOST, FIND ME!");
    }
    
    public void setPower(double power) {
        indexMotor.set(VictorSPXControlMode.PercentOutput, power);
    }

    public void stop() {
        setPower(0);
    }
}
