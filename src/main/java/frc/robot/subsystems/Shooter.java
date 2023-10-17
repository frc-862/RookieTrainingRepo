package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;

public class Shooter extends SubsystemBase {
    //TODO: create shooter motor (type is TalonFX, name should me shooterMotor)

    public Shooter() {
        shooterMotor = new TalonFX(RobotMap.INDEXER_MOTOR);
    }
    
    //TODO: create setPower method that takes in a double power and sets the shooter motor to that power

    //TODO: create stop method that sets the shooter motor to 0 power
}
