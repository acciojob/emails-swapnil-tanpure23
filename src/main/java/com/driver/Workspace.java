package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private String email;
    private List<Meeting> meetings;
    private int inboxCapacity;

    public Workspace(String email) {
        this.email = email;
        this.meetings = new ArrayList<>();
        this.inboxCapacity = 100;
    }

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    public int findMaxMeetings() {
        int maxMeetings = 0;
        int currentMeetings = 0;
        for (Meeting meeting : meetings) {
            if (meeting.getStartTime().isAfter(meeting.getEndTime())) {
                throw new IllegalArgumentException("Meeting end time cannot be before start time.");
            }
            currentMeetings++;
            for (Meeting otherMeeting : meetings) {
                if (!otherMeeting.equals(meeting)) {
                    if (meeting.getEndTime().isAfter(otherMeeting.getStartTime()) && meeting.getEndTime().isBefore(otherMeeting.getEndTime())) {
                        currentMeetings--;
                        break;
                    }
                }
            }
            if (currentMeetings > maxMeetings) {
                maxMeetings = currentMeetings;
            }
        }
        return maxMeetings;
    }

    public int getInboxCapacity() {
        return inboxCapacity;
    }

    public void setInboxCapacity(int inboxCapacity) {
        this.inboxCapacity = inboxCapacity;
    
    }
}
