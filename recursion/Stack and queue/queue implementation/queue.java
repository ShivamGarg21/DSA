public class queue{
    proctected int arr = null;
    proctected int capacity = 0;
    proctected int elementCount = 0;
    proctected int front = -1;
    proctected int rear = -1;
    
    proctected void intializeVariables(int capacity){
        this.capacity = capacity;
        this.arr = new int[this.capacity];
        this.elementCount = 0;
        this.tos = -1;
    }

    public queue() {
        intializeVariables(10);
    }
    public queue(int capacity){
        intializeVariables(capacity);
    }

    public boolean isEmpty(){
        return this.elementCount == 0;
    }

    //Exception=======================================
    private void OverflowException() throw Exception{
        if(this.capacity == this.elementCount){
            throw new Exception("QueueIsFull");
        }
    }
    private void UnderflowException() throw Exception{
        if(this.elementCount == 0){
            throw new Exception("QueueIsEmpty");
        }
    }

    //queue function =====================================
    public void push_(int data){
        
    }
    
    public void puch(int data) throws Exception{
        OverflowException();
        push_(data);
    }
}