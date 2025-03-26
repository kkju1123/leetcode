import java.util.Scanner;

public class lee21 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        //repeat code should build a function
        String[] strs1 = str1.replaceAll("[\\[\\]]","").split(",");
        String[] strs2 = str2.replaceAll("[\\[\\]]","").split(",");

        ListNode list1 = new ListNode(Integer.parseInt(strs1[0]));
        ListNode list2 = new ListNode(Integer.parseInt(strs2[0]));
        ListNode list1Temp = new ListNode(Integer.parseInt(strs1[1]));
        ListNode list2Temp = new ListNode(Integer.parseInt(strs2[1]));
        list1.next = list1Temp;
        list2.next = list2Temp;

        for(int i = 2 ; i < strs1.length ; i++){
            ListNode temp = new ListNode(Integer.parseInt(strs1[i]));
            list1Temp.next = temp;
            list1Temp = temp;
        }
        for(int i = 2 ; i < strs2.length ; i++){
            ListNode temp = new ListNode(Integer.parseInt(strs2[i]));
            list2Temp.next = temp;
            list2Temp = temp;
        }
        Solution solution = new Solution();
        ListNode mergeList = solution.mergeTwoLists(list1, list2);
        while(mergeList != null){
            System.out.print(mergeList.val + " ");
            mergeList = mergeList.next;
        }

    }
}
 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        current.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
}
