public class stack{
    protected int[] arr = null;
    protected int capacity = 0;
    protected int elementcount = 0;
    protected int tos = -1;

    // constructor=============================
    protected void initializeVariable(int capacity){
        this.capacity = capacity;
        this.arr = new int[this.capacity];
        this.elementcount = 0;
        this.tos = -1;
    }
    public stack(){
        initializeVariable(10);
    }

    public stack(int size){
        initializeVariable(size);
    }
    //basic function================================

    public boolean isEmpty(){
        return this.elementcount == 0;
    }
    public int size(){
        return this.elementcount;
    }

    //Exception========================================
    private void overFlowException() throws Exception{
        if(this.capacity == this.elementcount)    
        throw new Exception ("stackIsFull");
    }
    private void underFlowException() throws Exception{
        if(this.capacity == 0)    
        throw new Exception ("stackIsEmpty");
    }
    //Main funtion========================================
    protected void push_(int data){
        this.arr[++this.tos] = data;
        this.elementcount++;
    }
    public void push(int data) throws Exception{
        overFlowException();
        push_(data);
    }
    protected int pop_(){
        int val = this.arr[tos];
        this.arr[tos--] = 0;
        this.elementcount--;
        return val;
    }
    public int pop() throws Exception{
        underFlowException();
        return pop_();
    }
}
