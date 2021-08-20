import java.util.LinkedList;
import java.util.Queue;

public class stackUsingQueue_pop{
    Queue<Integer> que = new LinkedList<>();
    Queue<Integer> temp = new LinkedList<>();
    int peekval;

    public int size() {
        return que.size();
    }

    public boolean isEmpty() {
        return que.isEmpty();
    }

    private void transferToAnotherQueue() {
        while(que.size() != 0)
            temp.add(que.remove());
    }

    // O(n)
    public void push(int data) {
        temp.add(data);
        peekval = data;
        transferToAnotherQueue();
        while(temp.size()!=0){
            que.add(temp.remove());
        }
    }

    // O(1)
    public int peek() {
        return peekval;
    }

    // O(1)
    public int pop() {
        return que.remove();
    }
}