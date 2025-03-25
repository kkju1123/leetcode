import java.util.Scanner;

public class lee14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String str1 = str.replaceAll("[\\[\\]]","");
        String[] strs = str1.split(",");

        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            //string.indexOf("subtring")
            while(strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        System.out.println(prefix);
    }
}
