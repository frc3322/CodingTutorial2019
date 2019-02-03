/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.WideIntake;

/**
 * Add your docs here.
 */
public class IntakeCargo extends Command{

    public IntakeCargo() {
        requires(Robot.wideintake);
        requires(Robot.sideouttake);
    }

    @Override
    protected void execute() {
        Robot.wideintake.intakeStart();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
