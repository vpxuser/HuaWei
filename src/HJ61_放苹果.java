import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class HJ61_放苹果 {
    public static int count(int num,int szie){
        if (num==0||szie==1){
            return 1;
        }
        if (szie>num){
            return count(num,szie-1);
        } else {
            return count(num,szie-1)+count(num-szie,szie);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int size = sc.nextInt();
            System.out.println(count(num,size));
        }
    }
}
