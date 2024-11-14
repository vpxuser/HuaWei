import java.util.*;

public class HJ80_数组去重排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String firstLength = sc.nextLine();
            String[] firstString = sc.nextLine().split(" ");
            ArrayList<Integer> nums = new ArrayList<>();
            for (String s : firstString) {
                int num = Integer.parseInt(s);
                if (!nums.contains(num)) {
                    nums.add(num);
                }
            }
            String secondLength = sc.nextLine();
            String[] secondString = sc.nextLine().split(" ");
            for (String s : secondString) {
                int num = Integer.parseInt(s);
                if (!nums.contains(num)) {
                    nums.add(num);
                }
            }
            Collections.sort(nums);
            StringBuilder sb = new StringBuilder();
            for (Integer num : nums) {
                sb.append(num);
            }
            System.out.println(sb.toString());
        }
    }
}
