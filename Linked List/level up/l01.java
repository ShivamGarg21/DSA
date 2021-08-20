public class l01{
    // ============= fold linked List===========================
        public static ListNode reverse(ListNode head) {
      
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode forw = curr.next; // backup

            curr.next = prev; // link

            prev = curr; // move
            curr = forw;
        }

        head = prev;
        return head;
    }
        
    public static ListNode mid(ListNode head){
        if(head == null || head.next != null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static void fold(ListNode head) {
        if(head == null || head.next != null)
            return head;
        ListNode mid = mid(head);
        ListNode nhead = mid.next;
        mid.next = null;
        ListNode nhead = reverse(nhead);
        
        ListNode c1 = head;
        ListNode c2 = nhead;
        while(c2 != null){
            ListNode f1 = c1.next, f2 = c2.next;
            
            c1.next = c2;
            c2.next = f1;
            
            c1 = f1;
            c2 = f2;
        }
    }




    // ================= unfold linked list ========================
        public static ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode fowd = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            curr = fowd;
        }
        return prev;
    }
    
    // what we are doing is taking to pointers and dividing them in 2list my odd are c1 and even are c2 bcoz
    // when we fold 1,2,3,4,5,6,7 they become 1,7,2,6,3,5,4 so now c1 = head and c2 = next one and f1 and f2 jo h vo 
    // 3rd and 4th mtlb next ones so just merge c1 and f1 and c2 and f2 and make c2 = f2 and c1 = f1 so than we make next f1 and f2
    //
 
    public static void unfold(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;
        
        ListNode c1 = head;
        ListNode c2 = head.next;
        ListNode p = head.next;
        
        while(c2!=null && c2.next != null){         // c2 != null bcoz if its null then c1 = 4 and c2 = null target achieved and                   
            ListNode f1 = c2.next, f2 = f1.next;    // c2.next != null if linked list even size then f1 = null and f2 = null.next null point exception
            
            c1.next = f1;
            c2.next= f2;
            
            c1 = f1;
            c2 = f2;
        }
        ListNode nhead = reverse(p);
        c1.next = nhead;
    }

    // merge two sorted and k sorted list=========================================
    public ListNode mergeTwoSortedList(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null)                  // if 1 is empty send other one complete
                return l1 == null ? l2 : l1;
        ListNode dummy = new ListNode(-1);           // making a dummy node so that that the head can be fixed toh hum confuse nahi honge li head 1 h ya 2 bad mey remove
        ListNode prev = dummy;                       // isko hum travel krvaenge or head safe rahega dummy k sath
        ListNode c1 = l1;                              // ye hmara forwd hoga isse hum l1 k node ko point krvaenge
        ListNode c2 = l2;                                // same for l2
        
        while(c1 != null && c2 != null){                    // jb tak ek null nhi hota tb tak koi hum c1 or c2 ko travel krvaenge and c1 and c2 mey se jo chota h
            if(c1.val <= c2.val){
                prev.next = c1;                              // vo add krliya
                c1 = c1.next;
            }
            else{
                prev.next = c2;                                 
                c2 = c2.next;
            }   
            prev = prev.next;                                  // jb hum c1 ya c2 mein se ek ko add kr lenge toh toh prev ko aage bhda denge taki prev last node bni rahe and or node ko attach krti rahe
        }
        prev.next = c1== null ? c2 :c1;
        ListNode head = dummy.next;                             // dummy k  next  head mey dal liya now i have pointer to point 1st node
        dummy.next = null;                                       // so now i revome dummy node
        return head;
    }
    public ListNode mergeKLists(ListNode[] lists) {                        // time complexity = lembda.k^2     or t = nk  bcoz  n = k.lembda k = length of array and lembda average size of linked list    
        ListNode res = null;                                        
        for(int i=0;i<lists.length;i++){
            res = mergeTwoSortedList(res,lists[i]);
        }
        return res;
    }


        public ListNode optimergeksort(ListNode[] lists , int si, int ei){
        if(si == ei){
            return lists[si];
        }
        int mid = (si + ei)/2;
        ListNode leftmerged = optimergeksort(lists,si,mid);                              // adhi adhi krke merge kr rahe h isme time complexity = nlog(k)
        ListNode rightmerged = optimergeksort(lists,mid+1,ei);
        return mergeTwoSortedList(leftmerged,rightmerged);

    }
    public ListNode mergeKLists(ListNode[] lists) {
        // ListNode res = null;
        // for(int i=0;i<lists.length;i++){
        //     res = mergeTwoSortedList(res,lists[i]);
        // }
        // return res;
        if(lists.length == 0 ){
            return null;
        }
        return optimergeksort(lists,0,lists.length-1);
    }

    // =================== segregate data of node with first even and then odd ======================
        public static ListNode segregateEvenOdd(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        
        ListNode evennode = dummy1;
        ListNode oddnode = dummy2;
        
        ListNode curr = head;
        
        while(curr != null){
            if(curr.val %2 == 0){
                evennode.next = curr;
                evennode = evennode.next;
            }
            else{
                oddnode.next = curr;
                oddnode = oddnode.next;
            }
            curr = curr.next;
        }
        evennode.next = dummy2.next;                
        oddnode.next = null;                    // stoping from making loop of last odd node and last even segement 
        
        dummy2.next = null;                             //odd node we add is now being removed
        head = dummy1.next;
        dummy1.next = null;                              //even node we add is now being removed   
        return head;
    }

    // =========================== Segregate 0 and 1 Node Of Linkedlist Over Swapping Nodes =================================
    // same as even odd but with 0 and 1
        public static ListNode segregate01(ListNode head) {
        if(head == null || head.next == null)
            return head;
            
        ListNode dummy0 = new ListNode(-1);
        ListNode dummy1 = new ListNode(-1);
        
        ListNode node0 = dummy0;
        ListNode node1 = dummy1;
        
        ListNode curr = head;
        
        while(curr != null){
            if(curr.val == 0){
                node0.next = curr;
                node0 = node0.next;
            }
            else{
                node1.next = curr;
                node1 = node1.next;
            }
            curr = curr.next;
        }
        node0.next = dummy1.next;
        dummy1.next = null;
        
        node1.next = null;
        
        head = dummy0.next;
        dummy0.next = null;
        
        return head;
    }

    // ======================= seprating small and large number according to last number =================
    // ex = 4,3,0,2,1,8,6,5,7,4 will be 4,3,0,2,1,4,8,6,5,7     mean last number which is 4 is on it real position
        public static ListNode segregateOnLastIndex(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummysmall = new ListNode(-1);
        ListNode dummylarge = new ListNode(-1);
        
        ListNode smallnode = dummysmall;
        ListNode largenode = dummylarge;
        
        ListNode pivotnode = head;
        while(pivotnode.next != null)
            pivotnode = pivotnode.next;
            
        ListNode curr = head;
        while(curr != null){
            if(curr.val <= pivotnode.val){
                smallnode.next = curr;
                smallnode = smallnode.next;
            }
            else{
                largenode.next = curr;
                largenode = largenode.next;
            }
            curr = curr.next;
        }
        smallnode.next = dummylarge.next;
        largenode.next = null;
        
        head = dummysmall.next;
        dummysmall.next = null;
        dummylarge.next = null;
        return head;
    }

    //pepcoding vala version
    //Segregate Node Of Linkedlist Over Last Index.
        public static ListNode segregateOnLastIndex(ListNode head) {
        if(head == null || head.next == null)
            return head;
        //ListNode dummysmall = new ListNode(-1);
        //ListNode dummylarge = new ListNode(-1);
        
        //ListNode smallnode = dummysmall;
        //ListNode largenode = dummylarge;
        
        ListNode pivotnode = head;
        while(pivotnode.next != null)
            pivotnode = pivotnode.next;
            
        ListNode firstnode = new ListNode(pivotnode.val);
        ListNode temp = firstnode;
            
        ListNode curr = head;
        while(curr != null){
            if(curr.val > pivotnode.val){
                temp.next = curr;
                temp = temp.next;
            }
            curr = curr.next;
        }
        temp.next = null;
        return firstnode;
    }

    //=======================================================
      public static ListNode segregate(ListNode head, int pivotIdx) {
        if(head == null || head.next == null)
            return head;
        ListNode dummysmall = new ListNode(-1);
        ListNode dummylarge = new ListNode(-1);
        
        ListNode smallnode = dummysmall;
        ListNode largenode = dummylarge;
        
        ListNode curr = head;
        
        ListNode pivotnode = head;
        while(pivotIdx-- > 0)
            pivotnode = pivotnode.next;
            
        while(curr != null){
            if(curr.val <= pivotnode.val && curr != pivotnode){
                smallnode.next = curr;
                smallnode = smallnode.next;
            }
            else if(curr != pivotnode){
                largenode.next = curr;
                largenode = largenode.next;
            }
            curr = curr.next;
        }
        smallnode.next = pivotnode;
        pivotnode.next = dummylarge.next;
        largenode.next = null;
        
        dummylarge.next = null;
        head = dummysmall.next;
        dummysmall.next = null;
        return head;
  }

  //=========================================
      public static ListNode segregate012(ListNode head) {
        if(head == null || head.next == null)
            return head;
            
        ListNode dummy0 = new ListNode(-1);
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        
        ListNode node0 = dummy0;
        ListNode node1 = dummy1;
        ListNode node2 = dummy2;
        
        ListNode curr = head;
        
        while(curr != null){
            if(curr.val == 0){
                node0.next = curr;
                node0 = node0.next;
            }
            else if(curr.val == 1){
                node1.next = curr;
                node1 = node1.next;
            }
            else{
                node2.next = curr;
                node2 = node2.next;
            }
            curr = curr.next;
        }

        node1.next = dummy2.next;    // this part is done first bcoz if theres only 2,2,2,2,2,2,2
        dummy2.next = null;            // then 2nd node is saved in 1st and then 1st in zero 
        node2.next = null;              // if not done then 1st saved in 0th first then it will be lost
        
        node0.next = dummy1.next;
        dummy1.next = null;

        head = dummy0.next;
        dummy0.next = null;
        
        return head;
    }

    public static void main(Stringp[] args){
           
    }
}