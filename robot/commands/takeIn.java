// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.intake;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;

public class takeIn extends CommandBase {
  private XboxController controller;
  private intake intake;
  /** Creates a new takeIn. */
  public takeIn(intake intake, XboxController controller) {
    this.controller = controller;
    this.intake = intake;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
  boolean toggleOn = false;
  boolean togglePressed = false;
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    updateToggle();
        if(toggleOn){
          intake.on();
        }else{
            // Do something when toggled off
            intake.off();
        }
  }
  public void updateToggle()
    {
        if(controller.getAButton()){
            if(!togglePressed){
                toggleOn = !toggleOn;
                togglePressed = true;
            }
        }else{
            togglePressed = false;
        }
    }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.off();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
