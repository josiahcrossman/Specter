// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class shooters extends SubsystemBase {
  private TalonSRX sl;
  private TalonSRX sr;

  public shooters() {
    sl = new TalonSRX(22);
    sr = new TalonSRX(27);
  }
  public void shoot(double power){
    sl.set(ControlMode.PercentOutput, -power);
    sr.set(ControlMode.PercentOutput, power);
  }
  public void stop(){
    sl.set(ControlMode.PercentOutput, 0);
    sr.set(ControlMode.PercentOutput, 0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
