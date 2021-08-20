public class queue{
    proctected int arr = null;
    proctected int capacity = 0;
    proctected int elementCount = 0;
    proctected int front = 0;
    proctected int back = 0;
    
    proctected void intializeVariables(int capacity){
        this.capacity = capacity;
        this.arr = new int[this.capacity];
        this.elementCount = 0;
        this.front = 0;
        this.back = 0;
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
        this.arr[this.back] = data;
        this.elementCount++;
        this.back = (this.back+1)%capacity;
    }
    
    public void push(int data) throws Exception{
        OverflowException();
        push_(data);
    }
    public int pop_(){
        int val = arr[this.front];
        arr[this.front] = 0;
        this.front = (this.front+1)%this.capacity;
        this.elementCount--;
        return val;
    }
    public int pop() throws Exception{
        UnderflowException();
        return pop_();
    }
}