public class quicksortll{
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    static Random rand = new Random();

    public static int length(ListNode head){
        if(head == null)
            return 0;
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        return len;
    }

    public static ListNode[] sagregate(ListNode head, int pivotIdx){
        // if(head == null || head.next == null)
        //     return head;
        ListNode pivotnode = head;
        ListNode dummySmall = new ListNode(-1);
        ListNode dummyLarge = new ListNode(-1);
        ListNode smallnode = dummySmall;
        ListNode largenode = dummyLarge;

        while(pivotIdx-- > 0)
            pivotnode = pivotnode.next;
        ListNode curr = head;
        
        while(curr != null){
            if(curr != pivotnode){
                if(curr.val <= pivotnode.val){
                    smallnode.next = curr;
                    smallnode = pivotnode.next;
                }
                else{
                    largenode.next = curr;
                    largenode = largenode.next;
                }
            }
            curr = curr.next;
        }

        pivotnode.next = null;
        smallnode.next = null;
        largenode.next = null;

        ListNode largehead = dummyLarge.next;
        ListNode smallhead = dummySmall.next;

        dummySmall.next = null;
        dummyLarge.next = null;

        return new ListNode[]{smallhead,pivotnode,largehead};
    }

    public static ListNode[] mergesegregated(ListNode[] smallnode, ListNode pivotnode, ListNode[] largenode){
        ListNode smallhead = smallnode[0];
        ListNode smalltail = smallnode[1];

        ListNode largehead = largenode[0];
        ListNode largetail = largenode[1];

        ListNode head = null;
        ListNode tail = null;

        if(smallhead != null && largehead != null){
            smalltail.next = pivotnode;
            pivotnode.next = largehead;
            head = smallhead;
            tail = largetail;
        }
        else if(largehead != null){                    // means agr smallhead != null then 1st if statement mey jata isme smallhead == null h
            pivotnode.next = largehead;
            head = pivotnode;
            tail = largetail;
        }
        else if(smallhead != null){
            smalltail.next = pivotnode;
            head = smallhead;
            tail = pivotnode;
        }
        else{
            head = tail = pivotnode;
        }
        return new ListNode[]{head,tail};

    }

    public static ListNode[] quickSort(ListNode head){
        if(head == null || head.next == null)
            return new ListNode[]{head, head};
        int len = length(head);
        int pivotIdx = rand.nextInt(len);

        ListNode[] segregate = sagregate(head, pivotIdx);       // tukdo mey tod diya small area and mid and large area mid kuch bhi ho sakta h even large element bhi 

        ListNode[] smalllist = quickSort(segregate[0]);
        ListNode[] largelist = quickSort(segregate[2]);

        return mergesegregated(smalllist,segregate[1],largelist);
    }
    
    public static void main(String[] args){
        
    }
}