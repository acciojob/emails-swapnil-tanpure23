package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings
    
    private static final int DEFAULT_INBOX_CAPACITY = Integer.MAX_VALUE;
    

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId, DEFAULT_INBOX_CAPACITY);
        this.calendar = new ArrayList<>();

    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
         LocalTime newMeetingStartTime = meeting.getStartTime();
        LocalTime newMeetingEndTime = meeting.getEndTime();
        for (Meeting existingMeeting : calendar) {
            LocalTime existingMeetingStartTime = existingMeeting.getStartTime();
            LocalTime existingMeetingEndTime = existingMeeting.getEndTime();
        // check if the new meeting overlaps with an existing meeting
        if (newMeetingStartTime.isBefore(existingMeetingEndTime) && newMeetingEndTime.isAfter(existingMeetingStartTime)) {
            throw new IllegalArgumentException("Meeting overlaps with existing meeting.");
        }
    }
        // add the new meeting to the calendar
        calendar.add(meeting);

    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

         int maxMeetings = 0;
        int currentMeetings = 0;
        List<Meeting> sortedMeetings = new ArrayList<>(calendar);
    // sort the meetings by start time
        sortedMeetings.sort(Comparator.comparing(Meeting::getStartTime));
    // iterate over the sorted meetings and count the maximum number of non-overlapping meetings
        for (Meeting meeting : sortedMeetings) {
            LocalTime meetingStartTime = meeting.getStartTime();
            LocalTime meetingEndTime = meeting.getEndTime();
        // if the meeting ends before the start of the next meeting, it doesn't overlap
            if (currentMeetings == 0 || meetingStartTime.isAfter(sortedMeetings.get(currentMeetings - 1).getEndTime())) {
                currentMeetings++;
                if (currentMeetings > maxMeetings) {
                     maxMeetings = currentMeetings;
            }
        } else {
            // the meeting overlaps with the previous meeting
            // skip this meeting and continue to the next one
            continue;
        }
    }
        return maxMeetings;
        
    }
}
