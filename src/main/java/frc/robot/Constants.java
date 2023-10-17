package frc.robot;

/**
 * This class is used to hold constants which the robot uses. We use constants because we may
 * use them in multiple places, and changing this variable will change the value for all
 * references, preventing us from wasting time finding each reference and changing it.
 * 
 * OperatorConstants holds IDs for controller buttons
 * RobotMap holds the motor IDs
 */

// EVERY Thing you need is here use these as constants
public final class Constants {
    public static class ControllerConstants {
        public static final int DRIVER_CONTROLLER_PORT = 0;
    }

    public static class RobotMap {
        public static final int COLLECTOR_MOTOR = 15;
        public static final int INDEXER_MOTOR = 16;
        public static final int FLYWHEEL_MOTOR = 11;
    }

    public static class ShooterConstants {
        public static final double SHOOTER_SPEED_CAP = 0.5; // TODO make sure safe
        public static final double SHOOTER_REV_TIME = 1; 
    }

    public static class CollectConstants {
        public static final double COLLECT_SPEED = 0.8; // TODO GET
        public static final double INDEX_SPEED = 0.7; // TODO GET

    }
}