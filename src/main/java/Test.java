import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String s = "03712832444";
        Pattern p = Pattern.compile("03712832.*");
        System.out.println(p.matcher(s).matches());
    }
}
