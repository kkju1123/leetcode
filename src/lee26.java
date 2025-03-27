import java.util.*;
public class lee26 {
    public static void main(String[] args) {

    }
    class Solution {
        public int removeDuplicates(int[] nums) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(nums[0]);
            for(int i=1;i<nums.length;i++){
                if(temp.get(temp.size()-1)<nums[i]){
                    temp.add(nums[i]);
                }
            }

            for(int i = 0;i < temp.size(); i++){
                nums[i] = temp.get(i);
            }

            return temp.size();
        }
    }
}
