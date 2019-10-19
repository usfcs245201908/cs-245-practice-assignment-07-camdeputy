
public class LinkedList<T> implements List {

    protected Node head;
    protected int size;

    class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    public LinkedList() {
        head = null;
    }

    @Override
    public void add(Object item) {

        Node node = new Node(item); //create the node
        node.next = null;

        if(head == null)
            head = node;
        else {
            Node tempHead = head;
            while(tempHead.next!=null)
                tempHead = tempHead.next;

            tempHead.next = node;
        }
    }

    void addToStart(Object item) {
        Node node = new Node(item);
        node.next = null;
        node.next = head;
        head = node;
    }

    @Override
    public void add(int pos, Object item) throws Exception {
        if(pos > size || pos < 0)
            throw new Exception("Out of bounds");
        if(pos == 0)
            addToStart(item);
        else {
            Node node = new Node(item);
            node.next = null;

            Node tempHead = head;
            for (int i = 0; i < pos - 1; i++)
                tempHead = tempHead.next;
            node.next = tempHead.next;
            tempHead.next = node;
        }
    }

    @Override
    public Object get(int pos) throws Exception {
        if(pos > size || pos < 0)
            throw new Exception("Out of bounds");

        Node tempHead = head;
        for(int i = 0; i < pos; i++)
            tempHead = tempHead.next;

        return tempHead.data;
    }

    @Override
    public Object remove(int pos) {

        if(pos == 0)
            head = head.next;
        else {
            Node tempHead = head;
            for(int i = 0; i < pos-1; i++)
                tempHead = tempHead.next;

            Node nodeBeingDeleted = tempHead.next;
            tempHead.next = nodeBeingDeleted.next;
            return nodeBeingDeleted.data;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}