public class dynamicstack extends stack{
    public dynamicstack(){
        super();
    }
    public dynamicstack(int size){
        super(size);
    }
    public dynamicstack(int[] arr) {
        super.initializeVariable(arr.length);
        for(int ele : arr){
            super.push_(ele);
        }
    }
    @Override
    public void push(int data) throws Exception{
        if(super.capacity == super.elementcount){
            int[] temp = super.arr;
            super.initializeVariable(2 * this.capacity);
            for(int ele : temp){
                super.push_(ele);
            }
        }
        super.push(data);
    }
}