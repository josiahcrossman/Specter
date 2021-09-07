// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.gear;
import edu.wpi.first.wpilibj.XboxController;
public class releaseGear extends CommandBase {
  /** Creates a new releaseGear. */
  private gear gear;
  private XboxController controller;
  public releaseGear(gear gear, XboxController controller) {
    this.gear = gear;
    this.controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(gear);
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
      gear.release();
    }else{
        // Do something when toggled off
        gear.grab();
    }

  }
  public void updateToggle()
  {
      if(controller.getBButton()){
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
    gear.off();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
