import java.util.HashMap;
import java.util.Scanner;

public class HJ88_扑克牌比大小 {
    public static HashMap<String,Integer> map = new HashMap<>();

    public static void init(){
        map.put("J",11);
        map.put("Q",12);
        map.put("K",13);
        map.put("A",14);
        map.put("2",15);
        map.put("joker",16);
        map.put("JOKER",17);
    }

    public static boolean checkInput(String[] input) {
        switch (input.length){
            case 1:
                return true;
            case 2:
            case 3:
            case 4:
                boolean vaild = true;
                for (int i = 1; i < input.length; i++) {
                    if (!input[i].equalsIgnoreCase(input[i - 1])) {
                        vaild = false;
                        break;
                    }
                }
                return vaild;
            case 5:
                int[] ninput = convert(input);
                for (int i = 1; i < ninput.length; i++) {
                    if (ninput[i] != ninput[i - 1] + 1) {
                        return false;
                    }
                }
                return true;
        }
        return false;
    }

    public static int[] convert(String[] input){
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(input[i])) {
                nums[i] = map.get(input[i]);
            } else {
                nums[i] = Integer.parseInt(input[i]);
            }
        }
        if (input.length == 5) {
            switch (input[0]) {
                case "A":
                    nums[0] = 1;
                    nums[1] = 1;
                    break;
                case "2":
                    nums[0] = 2;
                    break;
            }
        }
        return nums;
    }

    public static int checkRule(String[] left,String[] right){
        int[] nleft = convert(left);
        int[] nright = convert(right);
        if (nleft.length!=nright.length) {
            if (nleft[0]==16||nleft[0]==17){
                return 1;
            } else if (nright[0]==16||nright[0]==17){
                return -1;
            } else if (nleft.length == 4){
                return 1;
            } else if (nright.length == 4){
                return -1;
            }
            return 0;
        }
        if (nleft[0] > nright[0]){
            return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        init();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] input = sc.nextLine().split("-");
            String[] left = input[0].split(" ");
            String[] right = input[1].split(" ");
            int result = 0;
            if (checkInput(left) && checkInput(right)) {
                result = checkRule(left,right);
                switch (result){
                    case 1:
                        System.out.println(input[0]);
                        break;
                    case -1:
                        System.out.println(input[1]);
                        break;
                }
            }
            if (result == 0){
                System.out.println("ERROR");
            }
        }
    }
}
