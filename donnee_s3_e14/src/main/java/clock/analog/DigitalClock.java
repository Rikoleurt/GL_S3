package clock.analog;

import clock.Observer;
import clock.util.PositionManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DigitalClock extends JFrame implements Observer {
    private DigitalClockPanel digitalClockPanel = new DigitalClockPanel();

    public DigitalClock(){
        // Create and set up the window.
        setTitle("Digital Clock");
        addWindowListener(new DetachOnClosingWindowListener());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the analog clock panel.
        digitalClockPanel.setPreferredSize(new Dimension(200, 200));

        // Add the panel to the window.
        getContentPane().add(digitalClockPanel, BorderLayout.CENTER);

        // Set screen position.
        setLocation(PositionManager.getUniqueInstance().getClockWindowPosition());

        // Display the window.
        pack();
        setVisible(true);
    }
    @Override
    public void update(int hour, int minute, int second) {
        digitalClockPanel.setTime(hour, minute, second);
        digitalClockPanel.repaint();
    }

    private class DetachOnClosingWindowListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            // Do some cleanup here...
        }
    }
}
