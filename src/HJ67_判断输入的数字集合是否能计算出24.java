import java.util.Scanner;

public class HJ67_判断输入的数字集合是否能计算出24 {
    public static boolean dfs(int[] nums,boolean[] visited,int input) {
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (dfs(nums,visited,input+nums[i])
                        ||dfs(nums,visited,input*nums[i])
                        ||dfs(nums,visited,input-nums[i])
                        ||(input%nums[i]==0&&dfs(nums,visited,input/nums[i]))) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return input == 24;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] input = sc.nextLine().split(" ");
            int[] nums = new int[input.length];
            boolean[] visited = new boolean[input.length];
            for (int i = 0; i < input.length; i++) {
                nums[i] = Integer.parseInt(input[i]);
                visited[i] = false;
            }
            boolean result = false;
            for (int i = 0; i < input.length; i++) {
                visited[i] = true;
                if (dfs(nums, visited, nums[i])) {
                    result = true;
                    break;
                }
                visited[i] = false;
            }
            System.out.println(result);
        }
    }
}
