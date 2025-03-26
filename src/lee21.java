import java.util.Scanner;

public class lee21 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
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

        ListNode preNode = new ListNode();
        ListNode firstNode = new ListNode();
        firstNode.next  = preNode;

        while (list1 !=null && list2 !=null){
            ListNode newListNode = new ListNode();
            if(list1.val<=list2.val){
                newListNode.val = list1.val;
                list1 = list1.next;
            }
            else{
                newListNode.val = list2.val;
                list2 = list2.next;
            }
            preNode.next = newListNode;
            preNode = newListNode;
        }

        if(list1!= null){
            preNode.next = list1;
        }
        else if(list2!=null){
            preNode.next = list2;
        }
        return firstNode.next.next;
    }
}