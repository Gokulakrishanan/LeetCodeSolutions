package org.example.dailyChallenges.model;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            /*int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            System.out.printf("Carry of ${sum} : " + carry);
            int digit = sum % 10;
            System.out.printf("Digit of ${sum} : " + digit);
            tail.next = new ListNode(digit);
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;*/

            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
                System.out.println(sum);
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
                System.out.println(sum);
            }

            carry = sum / 10;
            System.out.println(carry);
            sum = sum % 10;
            System.out.println(sum);
            tail.next = new ListNode(sum);
            System.out.println(tail.next);
            tail = tail.next;
            System.out.println(tail);
        }
        return dummyHead.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
