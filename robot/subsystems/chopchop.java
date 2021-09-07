// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class chopchop extends SubsystemBase {
  private TalonSRX rl;
  private TalonSRX ll;
  /** Creates a new chopchop. */
  public chopchop() {
    ll = new TalonSRX(23);
    rl = new TalonSRX(28);
  }
  public void launch(double power){
    ll.set(ControlMode.PercentOutput, power);
    rl.set(ControlMode.PercentOutput, power);
  }
  public void stop(){
    ll.set(ControlMode.PercentOutput, 0);
    rl.set(ControlMode.PercentOutput, 0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
