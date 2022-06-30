// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import javax.lang.model.util.ElementScanner6;

//import java.sql.Time;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.Talon;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
 * arcade steering.
 */
public class Robot extends TimedRobot {
  Talon m_motorRight = new Talon(1);
  Talon m_motorLeft = new Talon(0);
  DifferentialDrive m_robotDrive = new DifferentialDrive(m_motorLeft, m_motorRight);
  Joystick m_stick = new Joystick(0);

  private double startTime; 

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    //m_motorLeft.setInverted(true);
  }

  @Override
  public void autonomousInit() {
    startTime = Timer.getFPGATimestamp();
  
  }

  @Override
  public void autonomousPeriodic() {
    double time = Timer.getFPGATimestamp();
  
    if (time - startTime < 2) {
      m_motorLeft.set(-0.2);
      m_motorRight.set(0.2);
      //forward
    } else if (time - startTime > 3 & time - startTime < 4.45) {
      m_motorLeft.set(-0.2);
      m_motorRight.set(-0.2);
    }
    //right 1
    else if (time - startTime > 4.5 & time - startTime < 5.4) {
      m_motorLeft.set(-0.2);
      m_motorRight.set(0.2);
    }
    //forward
   else if (time - startTime > 7.5 & time - startTime < 8.9){
      m_motorLeft.set(-0.2);
      m_motorRight.set(-0.2);
    //right 2 
    }else if (time - startTime > 9.5 & time - startTime < 11.5) {
      m_motorLeft.set(-0.2);
      m_motorRight.set(0.2);
    } 
    //forward
    
    else if (time - startTime > 11.6 & time - startTime < 13) {
      m_motorLeft.set(-0.2);
      m_motorRight.set(-0.2);
    }
    //right 3

    else if (time - startTime > 13.1 &  time - startTime < 15.1){
      m_motorLeft.set(-0.2);
      m_motorRight.set(0.2);
    }

    //forward 

    else if (time - startTime > 15.2 & time - startTime < 16.8) {
      m_motorLeft.set(-0.2);
      m_motorRight.set(-0.2);
    }
/*     
*/
    else {
      m_motorLeft.set(0);
      m_motorRight.set(0);
    }

    
    
  }

  @Override
  public void teleopPeriodic() {
    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.
    m_robotDrive.arcadeDrive(-m_stick.getY(), m_stick.getX());
  }


}
