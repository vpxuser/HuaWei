import java.util.*;

public class HJ30_字符串合并按奇偶下标分别升序并转16进制 {
    public static List<Character> sort(String input){
        List<Character> ood = new ArrayList<>();
        List<Character> even = new ArrayList<>();
        for (int i = 0; i < input.length(); i+=2) {
            even.add(input.charAt(i));
            int nextIndex = i + 1;
            if (nextIndex < input.length()) {
                ood.add(input.charAt(nextIndex));
            }
        }
        Collections.sort(ood);
        Collections.sort(even);
        List<Character> result = new ArrayList<>();
        for (int i = 0; i < even.size(); i++) {
            result.add(even.get(i));
            if (i < ood.size()) {
                result.add(ood.get(i));
            }
        }
        return result;
    }

    public static String hex(List<Character> input){
        StringBuilder result = new StringBuilder();
        for (Character ch : input){
            if (ch >= '0' && ch <= '9' || Character.toUpperCase(ch) >= 'A' &&  Character.toUpperCase(ch) <= 'F'){
                int decimal = Integer.parseInt(ch.toString(),16);
                StringBuilder binary = new StringBuilder(Integer.toBinaryString(decimal));
                int padding = 4 - binary.length();
                if (padding > 0) {
                    for (int i = 0; i < padding; i++) {
                        binary.insert(0, "0");
                    }
                }
                StringBuilder convert = new StringBuilder(binary.toString());
                convert.reverse();
                String hex = Integer.toHexString(Integer.parseInt(convert.toString(),2)).toUpperCase();
                result.append(hex);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine().replaceAll(" ","");
            List<Character> result = sort(input);
            System.out.println(hex(result));
        }
    }
}
