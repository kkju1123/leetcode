import java.util.Arrays;
import java.util.Scanner;

public class lee27 {
    public static void main(String[] args) {
        int[] nums = {2,3,3,2};
        Solution27 solution27 = new Solution27();
        int k = solution27.removeElement(nums,2);
        System.out.println(k);
    }
}
class Solution27 {
    public int removeElement(int[] nums, int val) {
        // transform int array to string use Arrays.toString();
        String numsString = Arrays.toString(nums);
        //trans from int to String
        String c = String.valueOf(val);

        String[] temp = numsString.replace("," + c + ",", "").replaceAll("[\\[\\]]", "").split(",");
        //{"","3","3",""}
        int k = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].trim().length() > 0) {
                nums[k] = Integer.parseInt(temp[i].trim());
                k++;
            }
        }
        return k;
    }
}
