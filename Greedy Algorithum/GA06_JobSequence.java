import java.util.Arrays;
import java.util.Comparator;

public class GA06_JobSequence {

    public static int maxProfit(int[][] jobs){
            //step 1 -> sort jobs array according to their profit
        Arrays.sort(jobs, Comparator.comparingDouble(o -> o[1]));

        int maxProfit = 0, time = 0;//to track time and maximum profit
        StringBuilder str = new StringBuilder("");  //store the job id

        for(int i = jobs.length - 1; i >= 0; i--){
            //step 2 -> when job start time is greater than time 
            if(jobs[i][0] > time){
                maxProfit += jobs[i][1]; //add the profit
                str.append("A"+jobs[i][2]+" ");
                time++;//increase the time
            }
        }

        System.out.println("Complete jobs >> "+ str);
        return maxProfit;
    }

    public static void main(String[] args) {
        //1st element -> Job start time || 2nd element -> job profit || 3rd element -> index or id of job
        int[][] jobs1 = {{4,20,0},{1,10,1},{1,40,2},{1,30,4}};

        System.out.println("----------------------------------------");
        System.out.println("maximum profit >> "+maxProfit(jobs1));
        System.out.println("----------------------------------------");
    }
}
