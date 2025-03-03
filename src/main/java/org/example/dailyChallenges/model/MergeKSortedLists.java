package org.example.dailyChallenges.model;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        return mergeSort(lists, 0, lists.length - 1);

    }

    private ListNode mergeSort(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];

        if (start + 1 == end) return mergeListNodes(lists[start], lists[end]);

        int mid = (start + end) / 2;
        ListNode leftNode = mergeSort(lists, start, mid);
        ListNode rightNode = mergeSort(lists, mid + 1, end);
        return mergeListNodes(leftNode, rightNode);
    }

    private ListNode mergeListNodes(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        current.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
