public class l003gt{
    public gettail(Node node){
        Node curr = node;
        while(curr.children.size()!=0){
            curr = curr.children.get(0);
        }
        return curr;
    }
    public static Node linearize(Node node){
        for(Node child : node.children){
           Node tailx = linearize(child);
        }
        for(int i=node.children.size()-2;i>=0;i--){
            Node tail = gettail(node.children.get(i));
            tail.children.add(node.children.get(i+1));
            node.children.remove(i+1);
        }
    }
    public static Node linearize(Node node){
        if(node.children.size()==0)
            return node;
        int n = node.children.size();
        Node gtail = linearize(node.children.get(i));
        for(int i = n-2;i>=0; i--){
            Node tail linearize(node.children.get(i));
            tail.children.add(node.children.get(i+1));
            node.children.remove(i+1);
        }
        return gtail;
    }
}