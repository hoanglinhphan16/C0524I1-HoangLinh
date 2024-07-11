package ss4_OOP.bai_tap;

import java.time.LocalDate;

public class StopWatch {
    LocalDate startTime, stopTime;
    static String name = "abc";
    public StopWatch() {}

    public StopWatch(LocalDate startTime, LocalDate stopTime) {
        this.startTime = startTime;
        this.stopTime = stopTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public void setStopTime(LocalDate stopTime) {
        this.stopTime = stopTime;
    }

    public double getElapsedTime() {
        return stopTime.toEpochDay() - startTime.toEpochDay();
    }
}
