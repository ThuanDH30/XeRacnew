/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Bravo
 */
public abstract class Form {
    protected enum EXIT_OPTION {
        UPDATE_EXIT, LOOP_EXIT
    };

    public abstract void setup();

    public abstract EXIT_OPTION update();

    public void loop() {
        while(this.update() != EXIT_OPTION.LOOP_EXIT);
    }
}
