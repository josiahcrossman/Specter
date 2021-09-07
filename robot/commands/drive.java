// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import  edu.wpi.first.wpilibj.GenericHID.Hand;
public class drive extends CommandBase {
  private drivetrain drivetrain;
  private XboxController controller;
  /** Creates a new drive. */
  public drive(drivetrain drivetrain, XboxController controller) {
    this.drivetrain = drivetrain;
    this.controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double forwards = controller.getTriggerAxis(Hand.kRight);
    double backwards = controller.getTriggerAxis(Hand.kLeft);
    double turn = controller.getX(Hand.kLeft);

    double power = forwards - backwards;
    double leftPower = power + turn;
    double rightPower = power - turn;
    drivetrain.setLeftPower(leftPower);
    drivetrain.setRightPower(rightPower);
    
    

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
