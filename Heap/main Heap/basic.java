import java.util.ArrayList;
public class heap{
    private ArrayList<Integer> arr;
    private int size;
    private boolean ismax = true;
    public void initialize(boolean ismax){
        this.arr = new ArrayList<>();
        this.size = 0;
        this.ismax = ismax;
    }
    public heap(){
        // this.arr = new ArrayList<>();
        // this.size = 0;
        initialize(true);
    }

    public heap(int[] arr, boolean isMax){
        initialize(ismax);
        for(int ele : arr){
            this.arr.add(ele);
        }
        for(int i=arr.length-1;i>=0;i++){
            downheapify(i);
        }

    }

    public int height(int[] arr, int pi){
        if(pi>arr.size())
            return -1;
        return Math.max(height(arr,2*pi+1),height(arr,2*pi+2))+1;
    }
    public void swap(int si, int ei){
        int se = this.arr.get(si);
        int ee = this.arr.get(ei);
        this.arr.set(si,ee);
        this.arr.set(ei,se);
    }
    public void add(int data){
        this.arr.add(data);
        upheapify(this.size);
        this.size++;
    }
    public int remove(){
        int n = this.arr.size();
        int rv = this.arr.get(0);
        swap(0,n-1);
        this.arr.remove(n-1);
        downheapify(0);
        this.size--;
        return rv;
    }

    public int peek(){
        return this.arr.get(0);
    }
    public void downheapify(int pi){
        int lc = 2*pi+1;//leftchild
        int rc = 2*pi+2;//rightchild
        int maxidx = pi;
        if(lc<this.arr.size() && this.arr.get(lc)>this.arr.get(maxidx))
            maxidx = lc;
        if(rc<this.arr.size() && this.arr.get(rc)>this.arr.get(maxidx))
            maxidx = rc;
        if(maxidx!=pi){
            swap(pi,maxidx);
            downheapify(maxidx);
        }
    }
    public void upheapify(int ci){
        int pi = (ci-1)/2;
        if(this.arr.get(pi)>this.arr.get(ci)){
            swap(ci,pi);
            upheapify(pi);
        }
    }

    public void compareTo(int a, int b){
        if(ismax)
            return this.arr.get(a)-this.arr.get(b);
        else
        return this.arr.get(b)-this.arr.get(a);
        
    }

    public void heap(int[] arr){
        for(int ele : arr){
            this.arr.add(ele);
        }
        for(int i = arr.length-1;i>=0;i--)
            downheapify(i);
    }
/* looks like complexity is nlogn bcoz its n loop above and downheapify is log n but its only n */


    public void downheapify(int pi){
        int maxidx = pi;
        int li = 2*pi+1;
        int ri = 2*pi+2;
        if(li<this.arr.length && compareTo(li,pi)>0)
            maxidx = li;
        if(ri<this.arr.length && this.arr.get(ri)>this.arr.get(maxidx))
            maxidx = ri;
        if(maxidx!=pi){
            swap(pi,maxidx);
            downheapify(maxidx);
        }
    }

    public void 

}