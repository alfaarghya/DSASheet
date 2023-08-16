/*
Given an array of jobs where every job has a deadline and profit if the job is finished within deadline. It also given that every job takes a  single unit of time, so the minimum possible deadline for any job is 1. maximum the total profit if only one job can be scheduled at a time
 */

import java.util.Arrays;
import java.util.Comparator;

public class Greedy06_JobSequencingProblem {

    public static String maxProfit(int[][] jobs) {
            //sort job according to profit
        Arrays.sort(jobs, Comparator.comparingDouble(o -> o[2]));

        StringBuilder ans = new StringBuilder("");  //store jobs
        int maxProfit = 0, time = 0;    //to track profit & time

        for(int i = jobs.length-1; i >= 0; i--) {
                //when job start time is greater than time
            if(jobs[i][1] > time) {
                maxProfit += jobs[i][2];    //add the profit
                ans.append("Job"+jobs[i][0]+" ");
                time++; //increase the time
            }
        }

        return ans.append("|| Profit > "+maxProfit).toString();
    }

    public static void main(String[] args) {
        int[][] job = {{0,2,20},{1,2,10},{2,1,40},{3,3,30}}; //pairs of --> {job no,time, profit}
        System.out.println(maxProfit(job));
    }
}
