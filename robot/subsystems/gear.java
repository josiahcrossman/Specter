// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
public class gear extends SubsystemBase {
  private DoubleSolenoid leftPist;


  /** Creates a new gear. */
  public gear() {
    leftPist = new DoubleSolenoid(0, 1);
    // rightPist = new DoubleSolenoid(0, 9);
  }
  public void release(){
    leftPist.set(Value.kForward);
    //rightPist.set(Value.kForward);
  }
  public void grab(){
    leftPist.set(Value.kReverse);
    //rightPist.set(Value.kReverse);
  }
  public void off(){
    leftPist.set(Value.kOff);
    //rightPist.set(Value.kOff);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
