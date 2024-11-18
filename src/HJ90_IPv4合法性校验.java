import java.util.Scanner;
import java.util.regex.Pattern;

public class HJ90_IPv4合法性校验 {
    public static final String rangeRule = "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)";

    public static final String ipv4Rule = "^"+rangeRule+"(\\."+rangeRule+"){3}$";

    public static final Pattern ipv4Pattern = Pattern.compile(ipv4Rule);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String ipv4 = sc.nextLine();
            String vaild = "NO";
            if (ipv4Pattern.matcher(ipv4).find()) {
                vaild = "YES";
            }
            System.out.println(vaild);
        }
    }
}
