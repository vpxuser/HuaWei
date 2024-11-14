import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class HJ103_梅花桩最长路径 {
    public static int step(int index,int[] nums){
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[index]);
        for(int i=index;i<nums.length;i++){
            boolean added = true;
            for (Integer num:set){
                if (nums[i] <= num) {
                    added = false;
                    break;
                }
            }
            if (added){
                set.add(nums[i]);
            }
        }
        int result = set.size();
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for (int i = index;i<nums.length;i++){

        }
        return 1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            sc.hasNextLine();
            String[] input = sc.nextLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(input[i]);
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                int min = step(i,nums);
                if (min > max) {
                    max = min;
                }
            }
        }
    }
}
