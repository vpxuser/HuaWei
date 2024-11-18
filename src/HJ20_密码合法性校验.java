import java.util.HashSet;
import java.util.Scanner;

public class HJ20_密码合法性校验 {
    private static String vaild = "NG";

    public static boolean checkLength(String password) {
        return password.length() >= 8;
    }

    public static boolean checkType(String password) {
        int count = 0;
        if (password.matches("^(?=.*[A-Z]).*")) {
            count++;
        }
        if (password.matches("^(?=.*[a-z]).*")) {
            count++;
        }
        if (password.matches("^(?=.*\\d).*")) {
            count++;
        }
        if (password.matches("^(?=.*[!@#$%^&*]).*")) {
            count++;
        }
        return count > 2;
    }

    public static boolean checkSub(String password) {
        for (int len = 3; len <= password.length(); len++) { // 子串长度大于2
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i <= password.length() - len; i++) {
                String sub = password.substring(i, i + len);
                if (set.contains(sub)) {
                    return false;
                }
                set.add(sub);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String password = sc.nextLine();
            if (checkLength(password) && checkType(password) && checkSub(password)) {
                vaild = "OK";
            }
            System.out.println(vaild);
        }
    }
}
