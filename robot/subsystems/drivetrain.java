// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
public class drivetrain extends SubsystemBase {
  private TalonSRX fr;
  private TalonSRX fl;
  private TalonSRX bl;
  private TalonSRX br;
  /** Creates a new drivetrain. */
  public drivetrain() {
    fr = new TalonSRX(26);
    fl = new TalonSRX(21);
    br = new TalonSRX(25);
    bl = new TalonSRX(20);
    
  }
  public void setLeftPower(double power){
      fl.set(ControlMode.PercentOutput, power);
      bl.set(ControlMode.PercentOutput, power);
  
  }
  public void setRightPower(double power){
    fr.set(ControlMode.PercentOutput, -power);
    br.set(ControlMode.PercentOutput, -power);
  }
  public void stop(){
    fr.set(ControlMode.PercentOutput, 0);
    fl.set(ControlMode.PercentOutput, 0);
    br.set(ControlMode.PercentOutput, 0);
    bl.set(ControlMode.PercentOutput, 0);
  }
  public void setBothPower(double power){
    fr.set(ControlMode.PercentOutput, -power);
    br.set(ControlMode.PercentOutput, -power);
    fl.set(ControlMode.PercentOutput, power);
    bl.set(ControlMode.PercentOutput, power);    
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
