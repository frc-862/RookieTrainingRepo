package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.*;

public class Shooter extends SubsystemBase {

    // TODO: create shooterMotor of type Victor (public final)
    public final Victor shooterMotor;

    public Shooter() {
        shooterMotor = new Victor(RobotMap.SHOOTER);
    
        CommandScheduler.getInstance().registerSubsystem(this);
    }

    // TODO: create the setPower method that takes in a double power and sets the power to motor using shooterMotor.set(...);
    public void setPower(double power) {
        shooterMotor.set(power);
    }

    // TODO: create the stop method that has no parameters and calls setPower with parameter of 0
    public void stop(){
        setPower(0d);
    }

}