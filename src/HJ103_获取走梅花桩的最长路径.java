import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HJ103_获取走梅花桩的最长路径 {
    public static int subMaxStep(int[] input,int offset) {
        for (int i = offset+1; i < input.length; i++) {
            if (input[i] > input[offset]) {
                return 1+subMaxStep(input,i);
            }
        }
        return 1;
    }

    public static int step(int[] nums,ArrayList<Integer> results,int index,int count){
        for(int i=index+1;i<nums.length;i++){
            if(nums[i]>nums[index]){
                int result = step(nums,results,i,count+1);
            }
        }
        results.add(count);
        return count;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] input = sc.nextLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(input[i]);
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> results = new ArrayList<>();
                step(nums,results,i,1);
                int min = Collections.max(results);
                if (min > max) {
                    max = min;
                }
            }
            System.out.println(max);
        }
    }
}
