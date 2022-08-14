import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetCode640 {
    public static void main(String[] args) {
        System.out.println(new LeetCode640().solveEquation("2x=x"));
    }

    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        String left = split[0];
        String right = split[1];
        int sum = 0;
        int index = 0;

        Pattern pn = Pattern.compile("[+-]*\\d*[^x+-]");
        Pattern px = Pattern.compile("[+-]*\\d*x");

        Matcher pnLeft = pn.matcher(left);
        Matcher pnRight = pn.matcher(right);
        Matcher pxLeft = px.matcher(left);
        Matcher pxRight = px.matcher(right);

        while (pnLeft.find()) {
            int i = Integer.parseInt(pnLeft.group());
            sum -= i;
        }

        while (pnRight.find()) {
            int i = Integer.parseInt(pnRight.group());
            sum += i;
        }

        while (pxLeft.find()) {
            String group = pxLeft.group();
            if (Objects.equals(group, "x") || Objects.equals(group, "+x")) {
                index += 1;
            } else if (Objects.equals(group, "-x")) {
                index -= 1;
            } else {
                int i = Integer.parseInt(group.split("x")[0]);
                index += i;
            }
        }

        while (pxRight.find()) {
            String group = pxRight.group();
            if (Objects.equals(group, "x") || Objects.equals(group, "+x")) {
                index -= 1;
            } else if (Objects.equals(group, "-x")) {
                index += 1;
            } else {
                int i = Integer.parseInt(group.split("x")[0]);
                index -= i;
            }
        }

        if (index == 0) {
            if (sum == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }
        return "x=" + sum / index;
    }


//
//    public String solveEquation(String equation) {
//        equation += "+";
//        int res = 0;
//        int sum = 0;
//        int factor = 0;
//        int sign1 = 1;
//        int sign2 = 1;
//
//        for (int i = 0; i < equation.length(); i++) {
//            System.out.println(res);
//            char n = equation.charAt(i);
//            if (Character.isDigit(n)) {
//                sum = sum * 10 + n - '0';
//            } else if (n == 'x') {
//                if (sum == 0) {
//                    factor += sign2;
//                } else {
//                    factor += sign2 * sum;
//                }
//                sum = 0;
//            } else {
//                if (n == '=') {
//                    sign2 = sign1 = -1;
//                }
//                if (sum != 0) {
//                    res -= sign2 * sum;
//                    sum = 0;
//                }
//                if (n == '-') {
//                    sign2 = -sign1;
//                } else if (n == '+') {
//                    sign2 = sign1;
//                }
//            }
//        }
//
//        if (factor == 0) {
//            if (sum == 0) {
//                return "Infinite solutions";
//            } else {
//                return "No solution";
//            }
//        }
//        return "x=" + res / factor;
//    }
}
