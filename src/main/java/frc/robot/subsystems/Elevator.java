// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.controller.ElevatorFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.simulation.BatterySim;
import edu.wpi.first.wpilibj.simulation.ElevatorSim;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import edu.wpi.first.wpilibj.simulation.RoboRioSim;
import edu.wpi.first.wpilibj.smartdashboard.Mechanism2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismLigament2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismRoot2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.util.Color8Bit;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
  // This gearbox represents a gearbox containing 4 Vex 775pro motors.
  private final DCMotor elevatorGearbox = DCMotor.getNEO(1);

  double targetExtension = 10;
  // Standard classes for controlling our elevator
  private final PIDController controller = new PIDController(20, 0, 0, 0.03);
  ElevatorFeedforward feedforward = new ElevatorFeedforward(0, 0, 0);
  private final Encoder encoder = new Encoder(8 ,9);
  private final PWMSparkMax motor = new PWMSparkMax(10);

  // Simulation classes help us simulate what's going on, including gravity.
  private final ElevatorSim elevatorSim =
      new ElevatorSim(
          elevatorGearbox,
          3,
          1,
          0.0508,
          0,
          0.61,
          true,
          VecBuilder.fill(0.0001));
  private final EncoderSim encoderSim = new EncoderSim(encoder);

   private final Mechanism2d mech2d = new Mechanism2d(90, 90);
    private final MechanismRoot2d eleRoot = mech2d.getRoot("Elevator Root", 45, 5);
  private final MechanismLigament2d elevatorMech2d = eleRoot.append(new MechanismLigament2d("Elevator", 37, 90));
    private final MechanismLigament2d stageOne = eleRoot.append(new MechanismLigament2d("Stage One", 37, 90, 12, new Color8Bit(Color.kRed)));
   

  /** Subsystem constructor. */
  public Elevator() {
    encoder.setDistancePerPulse(2.0 * Math.PI / 4096);

    SmartDashboard.putData("Ele Sim", mech2d);
  }

  /** Advance the simulation. */
  // In this method, we update our simulation of what our elevator is doing
  @Override
  public void simulationPeriodic() {
    // update mechanism display 
    elevatorMech2d.setLength(getExtension() + 37);

    // set  "inputs" (voltages)
    if(DriverStation.isEnabled()) {
      elevatorSim.setInput(motor.get() * RobotController.getBatteryVoltage());
    } else {
      elevatorSim.setInput(0);
    }

    
    // set simulated encoder's readings (based on mech simulator) and simulated battery voltage
    encoderSim.setDistance(elevatorSim.getPositionMeters());
    
    // SimBattery estimates loaded battery voltages
    RoboRioSim.setVInVoltage(BatterySim.calculateDefaultBatteryLoadedVoltage(elevatorSim.getCurrentDrawAmps()));

    // update the simulation. The standard loop time is 20ms.
    elevatorSim.update(0.030);

      }

  @Override
  public void periodic() {
      
    setTarget(LightningShuffleboard.getDouble("Elevator", "target", 10));
    LightningShuffleboard.setDouble("Elevator", "position", getExtension());
        LightningShuffleboard.setDouble("Elevator", "veloc", elevatorSim.getVelocityMetersPerSecond());


    controller.setP(LightningShuffleboard.getDouble("Elevator", "kP", 0));
    controller.setI(LightningShuffleboard.getDouble("Elevator", "kI", 0));
    controller.setD(LightningShuffleboard.getDouble("Elevator", "kD", 0));


    doPid();
  }

  /**
   * Run control loop to reach and maintain goal.
   *
   * @param goal the position to maintain
   */
  public void setTarget(double target) {
    targetExtension = Units.inchesToMeters(target);
  }

  private void doPid() {
    // With the setpoint value we run PID control like normal
    double pidOutput = controller.calculate(elevatorSim.getPositionMeters(), targetExtension);
    double feedforwardOutput = feedforward.calculate(elevatorSim.getVelocityMetersPerSecond());
    
    motor.set(MathUtil.clamp(pidOutput + feedforwardOutput, -1, 1));
  }

  public double getExtension() {
    return Units.metersToInches(elevatorSim.getPositionMeters());
  }

  /** Stop the control loop and motor output. */
  public void stop() {
    motor.set(0.0);
  }

}
