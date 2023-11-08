// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;

public class Drivetrain extends SubsystemBase {

    private TalonFX leftMotor1;
    private TalonFX leftMotor2;
    private TalonFX leftMotor3;

    private TalonFX rightMotor1;
    private TalonFX rightMotor2;
    private TalonFX rightMotor3;

  /** Creates a new Drivetrain. */
  public Drivetrain() {
        leftMotor1 = new TalonFX(RobotMap.LEFT_MOTOR_1);
        leftMotor2 = new TalonFX(RobotMap.LEFT_MOTOR_2);
        leftMotor3 = new TalonFX(RobotMap.LEFT_MOTOR_3);

        rightMotor1 = new TalonFX(RobotMap.RIGHT_MOTOR_1);
        rightMotor2 = new TalonFX(RobotMap.RIGHT_MOTOR_2);
        rightMotor3 = new TalonFX(RobotMap.RIGHT_MOTOR_3);

        rightMotor1.setInverted(true);
        rightMotor2.setInverted(true);
        rightMotor3.setInverted(true);

        leftMotor2.follow(leftMotor1);
        leftMotor3.follow(leftMotor1);

        rightMotor2.follow(rightMotor1);
        rightMotor3.follow(rightMotor1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setLeftPower(double power) {
    leftMotor1.set(TalonFXControlMode.PercentOutput, power);
  }

  public void setRightPower(double power) {
    rightMotor1.set(TalonFXControlMode.PercentOutput, power);
  }

  public void stop() {
    setLeftPower(0);
    setRightPower(0);
  }
}
