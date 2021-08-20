public class ll01p{
        public class Node{
            int data=0;
            Node next=null;
            Node(int data){
                this.data=data;
            } 
        }
        private Node head =null;
        private Node tail =null;
        private int sizeofLL =0;

        public boolean isempty(){
            return this.sizeofLL==0;
        }
        public int size(){
            return this.siizeofLL;
        }

//Exception============================================================================

        private void EmptyException()throw Exception{
            if(this.sizeofLL==0){
                    throw new Exception("Linked List Is Empty:-1");
            }
        }

        private void IndexoutofboundExclusiveException(int idx) throw Exception{
                if(idx < 0 || idx >=sizeofLL)
                    throw new Exception("Index Out Of Bound:-1");
        }

        private void IndexoutofboundInclusiveException(int idx) throw Exception{
            if(idx<0 || idx > siizeofLL)
                throw new Exception("Index Out of Bound:-1");
        }

//Add====================================================================================

        private void addfirstnode(Node node){
                if(this.head == null){
                    this.head = node;
                    this.tail = node;
                }
                else{
                        node.next = this.head;
                        this.head = node;
                }
                this.size0fLL++;
        }

        public void addfirst(int data){
                Node node = new Node(data);
                addfirstnode(node);
        }

        private void addlastnode(Node node){
                if(this.tail==null){
                        this.head = node;
                        this.tail = node;
                }else {
                        this.tail.next = node;
                        this.tail = node;
                }
                this.sizeofLL++;
        }

        public void addlast(int data){
                Node node = new Node(data);
                addlastnode(node);
        }

        private void addatnode(int idx,Node node){
                
        }
        public void addat(int idx,int data){
                IndexoutofboundInclusiveException(idx);
                Node node = new node(data);
                addatnode(idx,node);
        }
}