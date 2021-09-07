// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.subsystems.drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Auto extends CommandBase {
  /** Creates a new Auto. */
  Encoder encoder = new Encoder(0,1);
  private drivetrain drivetrain;
  public Auto(drivetrain drivetrain) {
    this.drivetrain = drivetrain;
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
    encoder.setDistancePerPulse(1./256.);
    encoder.setMaxPeriod(.1);
    encoder.setMinRate(10);
    if (encoder.getDistance() < 5){
      drivetrain.setBothPower(.5);
    }else{
      drivetrain.stop();
      encoder.reset();
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
    encoder.reset();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
