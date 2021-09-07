// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.shooters;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import  edu.wpi.first.wpilibj.GenericHID.Hand;
public class shoot extends CommandBase {
  private shooters shooters;
  private XboxController controller;


  /** Creates a new shoot. */
  public shoot(shooters shooters, XboxController controller) {
    this.controller = controller;
    this.shooters = shooters;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooters);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double power = controller.getY(Hand.kRight);
    if(power > 0.0){
      power = 0.0;
    }
    shooters.shoot(power);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooters.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
