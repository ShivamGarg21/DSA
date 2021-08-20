public class ll01{
    private class Node{
        int data = 0;
        Node next = null;
        Node(int data) {
            this.data = data;
        }
    }
    private Node head = null;
    private Node tail = null;
    private int sizeofLL = 0;

    public int size(){
            return this.sizeofLL;
    }
    
    private void isEmptyException() throws Exception{
            if(this.sizeofLL==0){
                    throws new Exception("Linked List is Empty:");
            }
    }
    private Node addFirst(Node node){
            if(this.sizeofLL==0)
            this.head = 0
    }
    public int addFirst(int data){
            Node node = new Node(data);
            addFirst(node);
    }

    private void addLastNode(Node node){
            if(this.head == null){
                    this.head = node;
                    this.tail = node;
            } else{
                this.tail.next = node;
                this.tail=node;
            }

            this.sizeofLL++;
    }
}