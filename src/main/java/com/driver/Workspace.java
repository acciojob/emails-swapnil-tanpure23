package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private List<Meeting> calendar;
    
    public Workspace(String emailId) {
        super(emailId);
        this.setInboxCapacity(Integer.MAX_VALUE);
        this.calendar = new ArrayList<>();
    }
    
    public void addMeeting(Meeting meeting) {
        this.calendar.add(meeting);
    }
    
    public int findMaxMeetings() {
        int maxMeetings = 0;
        for (int i = 0; i < calendar.size(); i++) {
            int count = 1;
            LocalTime endTime = calendar.get(i).getEndTime();
            for (int j = i + 1; j < calendar.size(); j++) {
                LocalTime nextStartTime = calendar.get(j).getStartTime();
                if (nextStartTime.isAfter(endTime) || nextStartTime.equals(endTime)) {
                    count++;
                    endTime = calendar.get(j).getEndTime();
                }
            }
            if (count > maxMeetings) {
                maxMeetings = count;
            }
        }
        return maxMeetings;
    }
}
