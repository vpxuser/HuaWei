
import java.util.*;

public class Hj9_反向输出去重 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            StringBuilder output = new StringBuilder();
            for (int i = input.length()-1; i >= 0; i--) {
                if (output.indexOf(Character.toString(input.charAt(i))) == -1 ){
                    output.append(input.charAt(i));
                }
            }
            System.out.println(output);
        }
    }
}
