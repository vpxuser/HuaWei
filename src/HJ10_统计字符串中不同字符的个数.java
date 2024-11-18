import java.util.HashSet;
import java.util.Scanner;

public class HJ10_统计字符串中不同字符的个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            HashSet<Character> set = new HashSet<>();
            for (Character c : input.toCharArray()) {
                set.add(c);
            }
            System.out.println(set.size());
        }
    }
}
