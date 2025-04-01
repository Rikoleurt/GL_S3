package clock;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    List<Observer> observers = new ArrayList<>();

    /**
     * Adds an observer.
     * @param observer
     */

    public void attach(Observer observer) {
        try {
            if (!observers.contains(observer)) {
                observers.add(observer);
            }
        } catch (Exception e) {
            System.out.println("Error adding observer caused by : " + e.getMessage());
        }
    }

    /**
     * Removes an observer.
     * @param observer
     */
    public void detach(Observer observer) {
        try {
            if (observers.contains(observer)) {
                observers.add(observer);
            }
        } catch (Exception e) {
            System.out.println("Error removing observer caused by : " + e.getMessage());
        }
    }

    /**
     * Notify the observers that the hour, minutes and second are changing.
     * @param hour
     * @param minute
     * @param second
     */
    public void notifyObservers(int hour, int minute, int second) {
        for (Observer observer : observers) {
            observer.update(hour, minute, second);
        }
    }
}
