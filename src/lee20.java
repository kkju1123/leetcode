import java.util.Scanner;

public class lee20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] sArray = { "{}", "[]", "()" };
        int len = s.length();
        for (int i = 0; i < len/2; i++) {
           s =  s.replaceAll("\\[\\]", "");
           s =  s.replaceAll("\\{\\}", "");
           s =  s.replaceAll("\\(\\)", "");
        }
        if (s.length() == 0) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}
