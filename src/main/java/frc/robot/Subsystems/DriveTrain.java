// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.



package frc.robot.Subsystems;



import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import  com.ctre.phoenix6.hardware.TalonFXS;
import com.studica.frc.AHRS;
public class DriveTrain extends SubsystemBase {

    /** The motors have to be configured! */
  
    private static TalonFXS lf = new TalonFXS(Constants.CANIDS.LEFT_FRONT);
    private static TalonFXS rf = new TalonFXS(Constants.CANIDS.RIGHT_FRONT);
    private static TalonFXS lb = new TalonFXS(Constants.CANIDS.LEFT_BACK);
    private static TalonFXS rb = new TalonFXS(Constants.CANIDS.RIGHT_BACK);
    private static TalonFXS lz = new TalonFXS(Constants.CANIDS.LEFT_Z);
    private static TalonFXS rz = new TalonFXS(Constants.CANIDS.RIGHT_Z);
        
          
    public AHRS m_gyro = new AHRS(AHRS.NavXComType.kUSB1);
    
    void drive(Double xSpeed, Double ySpeed) {
      //X-Drive Movement

      xSpeed *= Constants.MOTORS.standardPower; //80 percent
      ySpeed *= Constants.MOTORS.standardPower;
      
      lf.set(ySpeed - xSpeed);
      rf.set(ySpeed - xSpeed);
      lb.set(ySpeed + xSpeed);
      rb.set(ySpeed + xSpeed);
      
    }
    
    void z_movement(int Voltage) {
        lz.setVoltage(Voltage);
        rz.setVoltage(Voltage);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  @Override
  public void simulationPeriodic() {
    SmartDashboard.putString("Simulation Message", "Hello, Simulation!");

  }
}
