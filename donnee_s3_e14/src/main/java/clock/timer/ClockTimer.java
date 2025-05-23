package clock.timer;

import clock.Observer;
import clock.Subject;
import clock.analog.AnalogClock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.*;

/**
 * <code>ClockTimer</code> is a subject for storing and maintaining the time of 
 * day. It notifies its observers every second. The class provides an interface 
 * for retrieving individual time units such as hour, minute and second.
 * 
 * @author Quentin Nater
 */
public class ClockTimer extends Subject implements Runnable {
    private long time;
    
    private Calendar calendar;
    
    // delay in milliseconds
    private long delay = 1000;
    
    private Thread thread;

	private static Logger loggingService = Logger.getLogger("ClockTimer");

    /**
	 * 
	 * @uml.property name="analogClock"
	 * @uml.associationEnd multiplicity="(1 1)"
	 */
	AnalogClock analogClock;

	
    /**
     * Creates a new instance of <code>ClockTimer</code>.
     */
    public ClockTimer() {
//		this.analogClock = analogClock;
        // We removed analogClock of the constructor to use the observer pattern
        calendar = new GregorianCalendar();
    }

    /**
     * Returns the current hour.
     */
    private int getHour() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * Returns the current minute.
     */
    private int getMinute() {
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * Returns the current second.
     */
    private int getSecond() {
        return calendar.get(Calendar.SECOND);
    }



    /**
     * Notifies the observers every second.
     */
    public void run() {
        while (thread != null) {
            try {
                time = System.currentTimeMillis();
                calendar.setTimeInMillis(time);
                notifyObservers(getHour(), getMinute(), getSecond());
                Thread.sleep(delay);
            } catch (InterruptedException e) {
            	loggingService.severe("Timer got interrupted");
            }
        }
    }

    /**
     * Starts the timer.
     */
    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    /**
     * Stops the timer.
     */
    public void stop() {
        if (thread != null) {
            thread = null;
        }
    }
}
