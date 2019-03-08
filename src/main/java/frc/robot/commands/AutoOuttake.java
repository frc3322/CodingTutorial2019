/**
 *  _____    _____     _____     _____   
 * |___  \  |___  \   /  _  \   /  _  \
 *  ___|  |  ___|  | |__| |  | |__| |  |
 * |___   | |___   |     /  /      /  /
 *  ___|  |  ___|  |   /  /__    /  /__
 * |_____/  |_____/   |______|  |______|
 *
 */

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import static frc.robot.Robot.sideouttake;
import static frc.robot.Robot.drivetrain;
import static frc.robot.Robot.oi;
import static frc.robot.Robot.wideintake;

public class AutoOuttake extends Command {

    public boolean outtaking;

    public double lastOuttake;

    // long millisecondsToRun = 1000; // This should run 1000ms = 1 s.
    // long initTime =

    public AutoOuttake() {
        requires(sideouttake);
    }

    protected void execute() {
        drivetrain.outtakeControlling = true;
        if (sideouttake.getRightInfrared()) {
            outtaking = true;
            oi.lowerChassis.setRumble(GenericHID.RumbleType.kRightRumble, 1);
            lastOuttake = System.currentTimeMillis();
            while (outtaking) {
                drivetrain.stop();
                if ((System.currentTimeMillis() - lastOuttake) >= 500) {
                    sideouttake.outtakeStop();
                    outtaking = false;
                    oi.lowerChassis.setRumble(GenericHID.RumbleType.kRightRumble, 0);
                    drivetrain.outtakeControlling = false;
                }
            }
        } else if (sideouttake.getLeftInfrared()) {
            outtaking = true;
            oi.lowerChassis.setRumble(GenericHID.RumbleType.kLeftRumble, 1);
            lastOuttake = System.currentTimeMillis();
            while (outtaking) {
                drivetrain.stop();
                if ((System.currentTimeMillis() - lastOuttake) >= 500) {
                    sideouttake.outtakeStop();
                    outtaking = false;
                    oi.lowerChassis.setRumble(GenericHID.RumbleType.kLeftRumble, 0);
                    drivetrain.outtakeControlling = false;
                }
            }
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
