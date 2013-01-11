/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team1277.robot;

/**
 *
 * @author roboclub
 */
public class DriveTrain {
    /**
     * This function updates the jaguars based on the position of the joysticks
     */
    public void updateDrive() {
        int state = MainRobot.driveMode;
        if (state == 1) {
            updateTank();
        }
        else if (state == 2) {
            updateArcade();
        }
    }
    
    /**
     * Updates for the tank drive
     */
    public void updateTank() {
        double rightJoyY = MainRobot.m_rightStick.getY();
        double leftJoyY = MainRobot.m_leftStick.getY();
        MainRobot.m_rightDrive.set(rightJoyY*MainRobot.driveSpeed);
        MainRobot.m_leftDrive.set(leftJoyY*MainRobot.driveSpeed);
    }
    
    /**
     * Updates for the arcade drive
     */
    public void updateArcade() {
        double joyY, joyX;
        if (MainRobot.ARCADE_JOYSTICK == 1) {
            joyY = MainRobot.m_leftStick.getY();
            joyX = MainRobot.m_leftStick.getX();
        } else if (MainRobot.ARCADE_JOYSTICK == 2) {
            joyY = MainRobot.m_rightStick.getY();
            joyX = MainRobot.m_rightStick.getX();
        }
        if (joyX<0) {
            MainRobot.m_leftDrive.set(joyY*(1+joyX)*MainRobot.driveSpeed);
            MainRobot.m_rightDrive.set(joyY*MainRobot.driveSpeed);
        }
        if (joyX>0) {
            MainRobot.m_rightDrive.set(joyY*(1-joyX)*MainRobot.driveSpeed);
            MainRobot.m_leftDrive.set(joyY*MainRobot.driveSpeed);
        }
        if (joyX==0) {
            MainRobot.m_rightDrive.set(joyY*MainRobot.driveSpeed);
            MainRobot.m_leftDrive.set(joyY*MainRobot.driveSpeed);
        }
    }
    
}