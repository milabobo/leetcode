/**
 * Created by milabobo on 10:48 PM.
 * Email mailto:milabobo@126.com
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("P2");
        ListNode node = new ListNode(2);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(5);

        ListNode node1 = new ListNode(5);
        node1.next = new ListNode(6);
        node1.next.next = new ListNode(4);

        ListNode node2 = new Solution().addTwoNumbers(node, node1);
        System.out.println(node2);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(val);
            ListNode temp = next;
            while (temp != null) {
                builder.append("->").append(temp.val);
                temp = temp.next;
            }
            return builder.toString();
        }
    }

    public static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }

            int singleSum = 0;
            int step = 0;
            ListNode temp1 = l1;
            ListNode temp2 = l2;
            ListNode node = null;
            ListNode currentNode = null;
            while (temp1 != null && temp2 != null) {
                int sum = temp1.val + temp2.val + step;
                if (sum >= 10) {
                    singleSum = sum - 10;
                    step = 1;
                } else {
                    singleSum = sum;
                    step = 0;
                }

                if (node == null) {
                    node = new ListNode(singleSum);
                    currentNode = node;
                } else {
                    currentNode.next = new ListNode(singleSum);
                    currentNode = currentNode.next;
                }

                temp1 = temp1.next;
                temp2 = temp2.next;
            }

            while (temp1 != null) {
                int sum = temp1.val + step;
                if (sum >= 10) {
                    singleSum = sum - 10;
                    step = 1;
                } else {
                    singleSum = sum;
                    step = 0;
                }

                currentNode.next = new ListNode(singleSum);
                currentNode = currentNode.next;
                temp1 = temp1.next;
            }
            if (step == 1) {
                currentNode.next = new ListNode(1);
            }

            while (temp2 != null) {
                int sum = temp2.val + step;
                if (sum >= 10) {
                    singleSum = sum - 10;
                    step = 1;
                } else {
                    singleSum = sum;
                    step = 0;
                }

                currentNode.next = new ListNode(singleSum);
                currentNode = currentNode.next;
                temp2 = temp2.next;
            }
            if (step == 1) {
                currentNode.next = new ListNode(1);
            }

            return node;
        }

        public ListNode reverseListNode(ListNode l1) {
            if (l1 == null) {
                return null;
            }

            ListNode head = new ListNode(l1.val);
            ListNode temp = l1.next;
            ListNode next;
            while (temp != null) {
                next = temp.next;
                temp.next = head;
                head = temp;
                temp = next;
            }
            return head;
        }
    }
}
