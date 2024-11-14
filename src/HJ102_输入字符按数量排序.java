import java.util.*;

public class HJ102_输入字符按数量排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            HashMap<Character, Integer> count = new HashMap<>();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (count.containsKey(c)) {
                    count.put(c, count.get(c) + 1);
                } else {
                    count.put(c, 1);
                }
            }
            HashMap<Integer, ArrayList<Character>> result = new HashMap<>();
            ArrayList<Integer> numSet = new ArrayList<>();
            for (Character c : count.keySet()) {
                Integer num = count.get(c);
                if (!numSet.contains(num)) {
                    numSet.add(num);
                    Collections.sort(numSet);
                }
                if (result.containsKey(num)) {
                    result.get(num).add(c);
                    Collections.sort(result.get(num));
                } else {
                    ArrayList<Character> list = new ArrayList<>();
                    list.add(c);
                    result.put(num, list);
                }
            }
            StringBuilder output = new StringBuilder();
            for (int i = numSet.size()-1; i >= 0; i--) {
                for (Character c : result.get(numSet.get(i))) {
                    output.append(c);
                }
            }
            System.out.println(output);
        }
    }
}