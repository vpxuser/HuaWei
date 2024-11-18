
import java.util.*;

public class HJ9_反转字符串并去重 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            StringBuilder output = new StringBuilder();
            HashSet<Character> set = new HashSet<>();
            for (int i = input.length()-1; i >= 0; i--) {
                if (!set.contains(input.charAt(i))) {
                    set.add(input.charAt(i));
                    output.append(input.charAt(i));
                }
            }
            System.out.println(output);
        }
    }
}
