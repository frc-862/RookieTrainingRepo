package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

/**
 * Do NOT add any static variables to this class, or any initialization at all. Unless you know what
 * you are doing, do not modify this file except to change the parameter class to the startRobot
 * call.
 */
public final class Main {
  private Main() {}

  /**
   * This is the main initialization of your robot. Nothing should be written in here at all.
   * If you are here, you may want to look at RobotContainer.java
   */
  public static void main(String... args) {
    RobotBase.startRobot(Robot::new);
  }
}
