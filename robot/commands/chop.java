// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.chopchop;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import  edu.wpi.first.wpilibj.GenericHID.Hand;
public class chop extends CommandBase {
  /** Creates a new chop. */
  private XboxController controller;
  private chopchop chopchop;
  public chop(chopchop chopchop, XboxController controller) {
    this.controller = controller;
    this.chopchop = chopchop;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(chopchop);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
  boolean toggleOn = false;
  boolean togglePressed = false;
  @Override
  public void execute() {
    updateToggle();
        if(toggleOn){
          chopchop.launch(.5);
        }else{
            // Do something when toggled off
            chopchop.stop();
        }
  }
  public void updateToggle()
    {
        if(controller.getBumper(Hand.kLeft)){
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
    chopchop.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
