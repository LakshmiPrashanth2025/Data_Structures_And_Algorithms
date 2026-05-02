// Java program to print maximum meetings in one room using
// Greedy Algorithm

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Meeting {
    int startTime, endTime, meetingPosition;

    Meeting(int startTime, int endTime, int meetingPosition) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.meetingPosition = meetingPosition;
    }
}

// Custom comparator to compare meetings according to end time
class MeetingComparator implements Comparator<Meeting> {
    @Override
    public int compare(Meeting m1, Meeting m2) {
        return Integer.compare(m1.endTime, m2.endTime);
    }
}

// Function for finding maximum meeting in one room
public class MaxMeetingsInOneRoom {

    static List<Integer> maxMeetings(int[] start, int[] end) {
        List<Integer> resultMeetingPositions = new ArrayList<>();
        int n = start.length;

        // Store details of all meetings in a list
        List<Meeting> meets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meets.add(new Meeting(start[i], end[i], i + 1));
        }

        // Sort the meetings according to the ending time
        meets.sort(new MeetingComparator());

        // Initialize current time as -1
        int currTime = -1;
        for (Meeting meeting : meets) {
            
            // Check if the meeting room is free 
            // at the start time of the meeting
            if (meeting.startTime > currTime) {
                currTime = meeting.endTime;
                resultMeetingPositions.add(meeting.meetingPosition);
            }
        }

        // Sort result array
        resultMeetingPositions.sort(Integer::compareTo);
        return resultMeetingPositions;
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        // Meeting Times is [1,2],[3,4], [0,6],[5.7],[8,9],[5,9]
        // So, we can attend I, II, IV, V meetings

        List<Integer> res = maxMeetings(start, end);
        for (int meeting : res) {
            System.out.print(meeting + " ");
        }
    }
}
    

