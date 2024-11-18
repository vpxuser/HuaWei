import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HJ6_获取一个数字的所有质因子 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            while (n%2==0){
                list.add(2);
                n/=2;
            }
            for (int i = 3; i <= Math.sqrt(n); i+=2) {
                while (n%i==0){
                    list.add(i);
                    n/=i;
                }
            }
            if (n>2){
                list.add(n);
            }
            Collections.sort(list);
            String[] str = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                str[i] = list.get(i).toString();
            }
            System.out.println(String.join(" ", str));
        }
    }
}
