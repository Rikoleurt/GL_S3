package clock;

import clock.analog.AnalogClock;
import clock.timer.ClockTimer;

/**
 * The <code>ClockApp</code> class represents the application's main window.
 * 
 * @author Quentin Nater
 */
public class ClockApp {
    /**
     * The application's main method.
     */
    public static void main(String[] args) {
        AnalogClock analogClock = new AnalogClock();
        ClockTimer timer = new ClockTimer();
        timer.attach(analogClock);
        timer.start();
    }
}
