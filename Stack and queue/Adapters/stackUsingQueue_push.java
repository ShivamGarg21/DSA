import java.util.LinkedList;
import java.util.Queue;

public class stackUsingQueue_push{
    Queue<Integer> que = new LinkedList<>();
    Queue<Integer> temp = new LinkedList<>();
    int peekval=0;
    public int size() {
        return que.size();
    }

    public boolean isEmpty() {
        return que.isEmpty();
    }

    private void transferToAnotherQueue() {
            while(que.size()!=1){
                temp.add(que.remove());
            }
    }

    // O(n)
    public void push(int data) {
            que.add(data);
            peekval = data;
    }

    // O(1)
    public int peek() {
            return peekval;
    }

    // O(1)
    public int pop() {
            transferToAnotherQueue();
            int data = que.remove();
            while(temp.size()!=0){
                que.add(temp.remove());
            }
            return data;
    }
}