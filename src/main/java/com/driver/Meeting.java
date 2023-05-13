package com.driver;

import java.time.LocalTime;

public class Meeting {
    private LocalTime startTime;
    private LocalTime endTime;

    public Meeting(LocalTime startTime, LocalTime endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
      public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Duration getDuration() {
        return Duration.between(startTime, endTime);
    }

    public boolean overlapsWith(Meeting other) {
        if (this.getStartTime().isBefore(other.getStartTime()) && this.getEndTime().isAfter(other.getStartTime())) {
            return true;
        }
        if (this.getStartTime().isAfter(other.getStartTime()) && this.getStartTime().isBefore(other.getEndTime())) {
            return true;
        }
        return false;
    }

}
