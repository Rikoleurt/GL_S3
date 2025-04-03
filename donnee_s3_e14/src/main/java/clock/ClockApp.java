package clock;

import clock.analog.AnalogClock;
import clock.analog.DigitalClock;
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
        DigitalClock digitalClock = new DigitalClock();
        ClockTimer timer = new ClockTimer();
        timer.attach(digitalClock);
        timer.attach(analogClock);
        timer.start();
    }
}
