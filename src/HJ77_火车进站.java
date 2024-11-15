import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class HJ77_火车进站 {
    public static void result(String[] group,int index,Stack<String> in, Stack<String> out,ArrayList<Stack<String>> result){
        if (out.size() == group.length){
            result.add(out);
        }
        if (index<group.length) {
            in.add(group[index]);
            out.add(group[index]);
            result(group,index+1,in,out,result);
        }
        if (!in.isEmpty()) {
            out.push(in.pop());
            result(group,index+1,in,out,result);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] group = sc.nextLine().split(" ");
            ArrayList<Stack<String>> list = new ArrayList<>();
            result(group,0,new Stack<>(),new Stack<>(),list);
            ArrayList<String> res = new ArrayList<>();
            for (Stack<String> stack : list) {
                String[] strs = new String[stack.size()];
                stack.toArray(strs);
                res.add(String.join(" ",strs));
            }
            Collections.sort(res);
            for (String str : res) {
                System.out.println(str);
            }
        }
    }
}
