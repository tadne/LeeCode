package Util;

import java.util.List;
import java.util.StringJoiner;

public class ListNodeUtil {
    public static void main(String[] args) {

    }
    public static ListNode arrToListNode(int[] arr){
        int n=arr.length;
        if (n<1) return null;
        ListNode head=new ListNode(arr[0]);
        ListNode tmp=head;
        for (int i = 1; i < arr.length; i++) {
            tmp.next=new ListNode(arr[i]);
            tmp=tmp.next;
        }
        return head;
    }

    public static ListNode arrToListNode(List<Integer> list){
        int[] arr=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i]=list.get(i);
        }
        return arrToListNode(arr);
    }

    public static void printLisNode(ListNode listNode){
        StringJoiner sj=new StringJoiner(",","[","]");
        while (listNode!=null){
            sj.add(String.valueOf(listNode.val));
            listNode=listNode.next;
        }
        System.out.println(sj);
    }

}
