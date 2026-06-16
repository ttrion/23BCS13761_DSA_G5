//merge sort for doubly linked list
class Node {
    int data;
    Node next, prev;

    Node(int d) {
        data = d;
        next = prev = null;
    }
}
class Solution {
    static Node split(Node head) {
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node second = slow.next;
        slow.next = null;
        if (second != null) second.prev = null;
        return second;
    }

    static Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        if (a.data <= b.data) {
            a.next = merge(a.next, b);
            if (a.next != null) a.next.prev = a;
            a.prev = null;
            return a;
        } else {
            b.next = merge(a, b.next);
            if (b.next != null) b.next.prev = b;
            b.prev = null;
            return b;
        }
    }

    static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;

        Node second = split(head);

        head = mergeSort(head);
        second = mergeSort(second);

        return merge(head, second);
    }

    static Node sortDoubly(Node head) {
        return mergeSort(head);
    }
}