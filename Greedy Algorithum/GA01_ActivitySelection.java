import java.util.Arrays;
import java.util.Comparator;


public class GA01_ActivitySelection{

        /* ---- when activities are already sorted according to the End time ---- */
    public static int maximumActivity(int[] start, int[] end){  //TC -> O(n )
        StringBuilder activityID = new StringBuilder("");   //here store the ActivityID -------- This is optional
            //step 1-> the first activity always executed
        int count = 1, select = end[0]; //so count already 1 cuz >> A0 executed
        activityID.append("A0"+" ");

        for(int i = 1; i < end.length; i++){
                //step 2 -> Non Overlapping Activities
            if(start[i] >= select){ //when start Time of new Activity is greater than end time of last activity 
                select = end[i];//store the end time to compare
                count++;
                activityID.append("A"+i+" ");   //Activity ID
            }
        }

        System.out.println("ID of the activity ->> "+activityID);//printing the ActivityID
        return count;
    }
                                    /* ---- ---- */

        /* ---- When we need to sort activities according to the end time ---- */
    public static int maximumActivity_withSorting(int[] start, int[] end){  //TC -> O(nlog(n))

        int[][] activities = new int[start.length][3];  //it is a 2D array with n rows and 3 columns 
        for(int i = 0; i < start.length; i++){
            activities[i][0] = i; //0th columns stores ->> index of activities 
            activities[i][1] = start[i]; //1th columns stores ->> index of Start Time 
            activities[i][2] = end[i]; //2nd columns stores ->> index of End Time
        }

            //step 1 -> sort 2D array according to the end time
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        StringBuilder activityID = new StringBuilder("");   //here store the ActivityID -------- This is optional
            //step 2-> the first activity always executed
        int count = 1, select = activities[0][2]; //so count already 1 cuz >> A0 executed
        activityID.append("A"+activities[0][0]+" ");

        for(int i = 1; i < activities.length; i++){
                //step 2 -> Non Overlapping Activities
            if(activities[i][1] >= select){ //when start Time of new Activity is greater than end time of last activity 
                select = activities[i][2];//store the end time to compare
                count++;
                activityID.append("A"+activities[i][0]+" ");   //Activity ID
            }
        }

        
        System.out.println("ID of the activity ->> "+activityID);//printing the ActivityID
        return count;
    }
                                    /* ---- ---- */
    public static void main(String[] args) {
        /* when End time is not sorted..... always Step 1 will be sorting start and end Time according to the the end time...But here End time is already sorted */
        int[] startTime = {1,3,0,5,8,5};
        int[] endTime = {2,4,6,7,9,9};

        System.out.println("Maximum Activity ->> "+maximumActivity(startTime, endTime));

    }
}
