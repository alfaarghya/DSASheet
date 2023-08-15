import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Greedy01_ActivitySelection {
        /*---- Activity is already sorted according to end Time */
    public static String maximumActivitySelection(int[] startTime, int[] endTime) { //TC -> O(n)
        StringBuilder activityID = new StringBuilder("");
            //always 1st activity will executed
        int select = endTime[0];
        int count = 1;
        activityID.append("A0"+" ");

        for(int i = 1; i < endTime.length; i++) {
                //non overlapping activities
            if(startTime[i] >= select) {//when start Time of new Activity is greater than end time of last activity 
                select = endTime[i];
                count++;
                activityID.append("A"+i+" ");
            }
        }

        return activityID.append("|| count >> "+ count).toString();

    }
                            /*---- ----*/

    public static String maximumActivitySelection_withoutSorting(int[] startTime, int[] endTime) {
            //store all activity details in 2d array
        int[][] activityTimeLine = new int[endTime.length][3];
        for(int i = 0; i < endTime.length; i++) {
            activityTimeLine[i][0] = i; //0th column stores activity number
            activityTimeLine[i][1] = startTime[i];  //1st colum stores start-time of activity 
            activityTimeLine[i][2] = endTime[i];    //2nd column stores end-time of activity
        }
                //sort the 2d array according to the endTime
        Arrays.sort(activityTimeLine, Comparator.comparingDouble(o -> o[2]));

        StringBuilder activityID = new StringBuilder("");
            //always 1st activity will executed
        int select = activityTimeLine[0][2];
        int count = 1;
        activityID.append("A0"+" ");

        for(int i = 1; i < activityTimeLine.length; i++) {
                //non overlapping activities
            if(activityTimeLine[i][1] >= select) {//when start Time of new Activity is greater than end time of last activity 
                select = activityTimeLine[i][2];
                count++;
                activityID.append("A"+i+" ");
            }
        }

        return activityID.append("|| count >> "+ count).toString();
    }


    public static void main(String[] args) {
        // int[] startTime = {1,3,0,5,8,5};
        // int[] endTime =   {2,4,6,7,9,9};
        int[] startTime = {0,8,5,1,3,5};
        int[] endTime = {6,9,7,2,4,9};

        // System.out.println(maximumActivitySelection(startTime, endTime));
        System.out.println(maximumActivitySelection_withoutSorting(startTime, endTime));
    }
}
