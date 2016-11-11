package swingTimerActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cubetimer.Paint;
import fields.Fields;

public class KeepTime implements ActionListener {

    public Fields fields;
    public Paint paint;

    public double startTime;
    public double currentTime;

    public double timeSeconds;
    public int timeMinutes;

    public KeepCountDown keepCountDown;

    public KeepTime(Fields fieldsIn, Paint paintIn,
            KeepCountDown keepCountDownIn) {

        fields = fieldsIn;
        paint = paintIn;

        startTime = (double) System.currentTimeMillis() / 1000.0;

        fields.getDisplayedData().setTime("0.00");

        keepCountDown = keepCountDownIn;
        
        fields.changeSinceLastRepaint();

        paint.repaint();
    }

    public double getEndTimeResult() {

        currentTime = (double) System.currentTimeMillis() / 1000.0;

        timeSeconds = currentTime - startTime;
        timeMinutes = 0;

        double timeInSecondsToBeReturned = timeSeconds;

        timeSeconds = timeSeconds + keepCountDown.getPenalty();

        if (timeSeconds >= 60) {

            timeSeconds -= 60;
            timeMinutes++;
        }

        if (timeMinutes > 0) {

//            fields.getDisplayedData().setTime((String.format("%.2f",
//                timeSeconds) + ":" + Integer.toString(timeMinutes)));
              fields.getDisplayedData().setTime(Integer.toString(timeMinutes) +
                  ":" + (String.format("%.2f", timeSeconds)));
        }

        else {

            fields.getDisplayedData().setTime(String.format("%.2f",
                timeSeconds));
        }
        
        fields.changeSinceLastRepaint();

        paint.repaint();

        return timeInSecondsToBeReturned;
    }

    public void actionPerformed(ActionEvent e) {

        currentTime = (double) System.currentTimeMillis() / 1000.0;

        timeSeconds = currentTime - startTime;
        timeMinutes = 0;

        if (timeSeconds >= 60) {

            timeSeconds -= 60;
            timeMinutes++;
        }

        if (timeMinutes > 0) {

            fields.getDisplayedData().setTime(Integer.toString(timeMinutes)
                + ":" + String.format("%.2f", timeSeconds));
        }

        else {
            fields.getDisplayedData().setTime
                (String.format("%.2f", timeSeconds));
        }
        
        fields.changeSinceLastRepaint();

        paint.repaint();
    }

}
