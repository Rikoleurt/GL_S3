package clock.analog;

import clock.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;

public class DigitalClockPanel extends JPanel {

    private Color bgcolor = Color.white;
    private Font font = new Font("TimesRoman", Font.PLAIN, 10);
    private Font font2 = new Font("randomFont", Font.PLAIN, 25);

    int hour;
    int minute;
    int second;

    /**
     * Creates a new instance of <code>AnalogClockPanel</code>.
     */
    public DigitalClockPanel() {
        setFont(font2);
    }

    /**
     * Sets the clocks current time.
     */
    public void setTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    /**
     * Overrides the superclass method by drawing an analog clock in the panel.
     */
    protected void paintComponent(Graphics g) {
        // Some geometric calculations.
        int width = getWidth();
        int height = getHeight();
        int border = 10;

        Point c = new Point(width / 2, height / 2);
        int r = (Math.min(width, height) / 2) - border;

        // Clear background.
        g.setColor(bgcolor);
        g.fillRect(0, 0, width, height);

        // Draw the clock components.
        drawClockNumbers(g, c, r);
    }

    /**
     * Draws the clock numbers.
     */
    private void drawClockNumbers(Graphics g, Point c, int r) {
        int rectWidth = 125;
        int rectHeight = 50;

        int rectX = c.x - rectWidth / 2;
        int rectY = c.y - rectHeight / 2;

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.GRAY);
        g2.fillRect(rectX, rectY, rectWidth, rectHeight);

        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.BLACK);
        g2.drawRect(rectX, rectY, rectWidth, rectHeight);

        g2.setColor(Color.RED);
        String timeString = String.format("%02d:%02d:%02d", hour, minute, second);

        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(timeString);
        int textHeight = fm.getAscent();

        int textX = rectX + (rectWidth - textWidth) / 2;
        int textY = rectY + (rectHeight + textHeight) / 2 - 5;

        g2.drawString(timeString, textX, textY);
    }
}
