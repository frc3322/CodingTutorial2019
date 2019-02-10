package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.WideIntake;

import static frc.robot.Robot.wideintake;

/**
 * Add your docs here.
 */
public class TestIntake extends Command {

    public TestIntake() {
        requires(wideintake);
    }

    @Override
    protected void execute() {
        System.out.println("Intake started");
        wideintake.intakeStart();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}