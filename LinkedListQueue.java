public class LinkedListQueue<E> implements Queue<E> {
    private class Node {
        public Node next;
        public E e;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    /** 向队列的末尾放数据*/
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    /**
     * 从队列中取出数据
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("List is Empty");
        }
        Node delet = head;
        head = head.next;
        delet.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return delet.e;
    }

    @Override
    public E getFornt() {
        if (isEmpty()) {
            throw new IllegalArgumentException("isEmpty");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedListQueue:");
        sb.append("head:");
        Node cur = head;
        while (cur != null) {
            sb.append(cur+"->");
            cur = cur.next;
        }
        sb.append("over");
        return sb.toString();
    }
}
