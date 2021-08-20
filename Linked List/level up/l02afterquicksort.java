import java.util.HashMap;

public class l02afterquicksort{
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
    	l1 = reverse(l1);
    	l2 = reverse(l2);
    	ListNode c1 = l1;
    	ListNode c2 = l2;
    	int carry = 0;
    
    	ListNode dummy = new ListNode(-1);
    	ListNode ptr = dummy;
    
    	while(c1 != null || c2 != null || carry !=0){
    		int sum = (c1 != null ? c1.val : 0)  +(c2 != null ? c2.val:0) + carry;
    		carry = sum/10;

    		sum = sum%10;
    	
    		ptr.next = new ListNode(sum);
    		ptr = ptr.next;
    
    		if(c1!=null) c1 = c1.next;
    		if(c2 !=null) c2 = c2.next;
    		
    	}
    	ListNode head = dummy.next;
    	dummy.next = null;
    	head = reverse(head);
    	l1 = reverse(l1);
    	l2 = reverse(l2);
    	return head;
    }
    
	public static boolean isCyclePresentInLL(ListNode head) {
		if(head == null || head.next == null)
			return false;
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow)
				return true;
		}
		return false;
    }

	public static ListNode cycleNode(ListNode head){
		if(head == null || head.next == null)
			return null;

		ListNode fast = head;
		ListNode slow = head;

		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				break;
			}
		}
		if(fast != slow)                                // if its not a loop them fast would next be equal to slow and it will become null means its linear
		    return null;
		ListNode meetingPoint = fast;
		slow = head;
		while(slow != fast){                                     // when fast and slow meet in the loop then that point is meeting point and from that point it we rotate in the cycle as well as on the same speed on the 
			slow = slow.next;                                    // start walking on the tail's head toh jb dono pointer milenge toh vo point cycle ki starting hoga
			fast = fast.next;
		}
		return slow;
	}

	public static ListNode cycleNode2(ListNode head){
		if(head == null || head.next == null)
			return null;

		ListNode fast = head;
		ListNode slow = head;

		while(fast != null && fast.next != null){
			fast = fast.next;
			slow = slow.next;
			if(fast == slow){
				break;
			}
		}
		int a = 1, b = 0, bc = 0, c = 0, nDash = 0, n = 0;        // bc = b+c
		int count = 0;
		ListNode meetingPoint = fast;
		slow = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
			// if(nDash == 0 && fast == meetingPoint)         instead of this we are dont bc++ below
			// 	bc = count;
			if(meetingPoint == fast)
				nDash++;
			//count++;
			a++;
		}
		fast = meetingNode;
        fast = fast.next;

        bc = 1;
        while (fast != meetingNode) {
            fast = fast.next;
            bc++;
        }
		c =   a + nDash*bc;
		n = nDash + 1;
		b = bc - c;
		return slow;
	}

	//=================== intersection of two linked list or rather two lines
		public static ListNode cycleNode(ListNode head){
		if(head == null || head.next == null)
			return null;

		ListNode fast = head;
		ListNode slow = head;

		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				break;
			}
		}
		if(fast != slow)
		    return null;
		ListNode meetingPoint = fast;
		slow = head;

		while(slow != fast){                               
			slow = slow.next;                                   
			fast = fast.next;
		}
		return slow;
	}
    public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode curr = headA;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = headB;                             // making it a cycle and find the stating of the loop
        ListNode ans = cycleNode(headA);
        curr.next = null;
        return ans;
    }

	// ============ leetcode 25 reverse k element at a time from the linkedlist  ==========
	ListNode temphead, temptail;

    public void addFirst(ListNode node){
        if(temphead == null){
            temphead = temptail = node;
        }
        else{
             node.next = temphead;
             temphead = node;
        }
    }

    public int length(ListNode head){
        ListNode curr = head;
        int count = 0;
        while(curr != null){
            curr = curr.next;
            count++;
        }
        return count;
        
    }
	
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head.next == null || k == 1){
            return head;
        }
        
        ListNode curr = head;
        ListNode phead = null, ptail = null;        // permanent head & tail
        int len = length(head);
        
        
        while(curr != null && len >= k){
            int itr = k;             // random number to add exactly k nodes without changing k
            while(itr-- > 0){
                ListNode fowd = curr.next;    //to null curr.next we store rest of list in fowd
                curr.next = null;
                addFirst(curr);
                curr = fowd;                    // make curr next node or rather triversing
            }
            if(phead == null){
                phead = temphead;
                ptail = temptail;
            }
            else{
                ptail.next = temphead;
                ptail = temptail;
            }
            temphead = temptail = null;
            len -= k;
            
        }
        ptail.next = curr;
        return phead;
    }

	//================== LRU chache =======================
	private class ListNode{
        int key;
		int state;
        ListNode next;
		ListNode prev;
        ListNode(int key, int val){
			this.key = key;
            this.state = val;
			this.prev = null;
			this.next = null;
        }
    }

	private HashMap<Integer,ListNode> map = new HashMap<>();
	private int capacity = 0;
	private ListNode head = null;
	private ListNode tail = null;


	public static LRUCache(int capacity) {
		this.capacity = capacity;
		this.head = null;
		this.tail = null;
    }
    
    public static int get(int key) {
        ListNode curr = map.get(key);
		ListNode prev = curr.prev;
		ListNode fowd = curr.next;

		prev.next = fowd;
		
		tail.next = curr;
		curr.prev = tail;
		curr.next = null;

		tail = curr; 
		return curr.state;
    }
    
    public static void put(int key, int value) {
		if(map.containsKey(key)){
			ListNode curr = map.get(key);
			curr.state = value;
			ListNode prev = curr.prev;
			ListNode fowd = curr.next;

			prev.next = fowd;
			
			tail.next = curr;
			curr.prev = tail;
			curr.next = null;

			tail = curr; 		
			
		}
		else if(map.size() == capacity){
			ListNode rnode = head;
			head = head.next;
			head.prev = null;
			map.remove(head.key);

			ListNode curr = new ListNode(key,value);
			curr.next = null;
			curr.prev = tail;
			tail.next = curr;
			tail = curr;  
			map.put(key,curr);

			
		}
		else if(map.size() < capacity){
			ListNode curr = new ListNode(key,value);
			curr.next = null;
			curr.prev = tail;
			tail.next = curr;
			tail = curr;  
			map.put(key,curr);
		}
			
        
    }

	public void removeNode(ListNode head){

	} 

	public void put(int key, int value) {
		if(map.containsKey(key)){
			ListNode curr = map.get(key);
			curr.state = value;
			ListNode prev = curr.prev;
			ListNode fowd = curr.next;

			prev.next = fowd;
			
			tail.next = curr;
			curr.prev = tail;
			curr.next = null;

			tail = curr; 		
			//========
			ListNode node = map.get(key);
			node.state = value;
			makeRecent(node);
			
		}
		else if(map.size() == capacity){
			ListNode rnode = head;
			head = head.next;
			head.prev = null;
			map.remove(head.key);

			ListNode curr = new ListNode(key,value);
			curr.next = null;
			curr.prev = tail;
			tail.next = curr;
			tail = curr;  
			map.put(key,curr);

			
		}
		else if(map.size() < capacity){
			ListNode curr = new ListNode(key,value);
			curr.next = null;
			curr.prev = tail;
			tail.next = curr;
			tail = curr;  
			map.put(key,curr);
		}
			
        
    }


    public static void main(String[] args){

    }
}