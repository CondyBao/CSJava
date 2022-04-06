package intro;

public class LinkedList<auto> {
    private class Node {
        auto info;
        Node next;

        public Node(auto i, Node n) {
            info = i;
            next = n;
        }
    }

    private Node head = null;
    private int size = 0;

    public auto get(int n) {
        try {
            Node cur = head;
            for (int i = 0; i < n; i++) {
                cur = cur.next;
            }
            return cur.info;
        }
        catch (NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void delete(int n) {
        try {
            if (n == 0) {
                head = head.next;
                size--;
                return;
            }
            Node cur = head;
            int index = 0;
            while (cur.next != null) {
                if (index + 1 == n) {
                    cur.next = cur.next.next;
                    break;
                }
                cur = cur.next;
                index++;
            }
            size--;
        }
        catch (NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void add(auto info, int n) {
        try {
            Node newNode = new Node(info, null);
            Node cur = head;
            int index = 0;
            if (n == 0) {
                newNode.next = head;
                head = newNode;
                size++;
                return;
            }
            while (true) {
                if (index + 1 == n) {
                    newNode.next = cur.next;
                    cur.next = newNode;
                    break;
                }
                index++;
                cur = cur.next;
            }
            size++;
        }
        catch (NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void add(auto info) {
        size++;
        Node newNode = new Node(info, null);
        if (head == null) {
            head = newNode;
        }
        else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        String v = "";
        Node cur = head;
        while (cur != null) {
            v += cur.info + " ";
            cur = cur.next;
        }
        return v;
    }

    public static void main(String[] args) {
        LinkedList runner = new LinkedList();
        runner.add(3);
        runner.add(5);
        runner.add(2);
        runner.add(6);
        runner.add(4, 1);
        System.out.println(runner.get(0));
        System.out.println(runner.get(1));
        runner.delete(0);
        System.out.println(runner.get(1));
        System.out.println(runner.getSize());
        System.out.println(runner);
    }
}
