import java.util.ArrayList;
public class revision{
    public static class Edge{
        int v = 0;
        int w = 0;
        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w){
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    }

    public static int findEdge(ArrayList<Edge>[] graph, int u, int v){
        for(int i=0 ; i< graph[u].size();i++){
            Edge e = graph[u].get(i);
            if(v == e.v)
                return i;
        }
        return -1;
    }

    public static void removeEdge(ArrayList<Edge>[] graph, int u, int v){
        int idx1 = findEdge(graph,u,v);
        int idx2 = findEdge(graph,v,u);

        graph[u].remove(idx1);
        graph[v].remove(idx2);

    }

    public static void removeVtx(ArrayList<Edge>[] graph, int u){
        while(graph[u].size() != 0){
            int n = graph[u].size();
            Edge e = graph[u].get(n-1);
            removeEdge(graph,u,e.v);
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis){
        if(src == dest){
            return true;
        }
        vis[src] = true;
        boolean res = false;
        for(Edge e : graph[src]){
            if(!vis[src])
              res = res || hasPath(graph,e.v,dest,vis);
        }
        return res;
    }

    public static void allPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis, String ans){
        if(src == dest){
            System.out.println(ans +dest);
            return;
        }

        boolean res = false;
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[src]){
                allPath(graph,e.v,dest,vis,ans + src);
            }
        }            
        vis[src] = false;
    }
    public static void printPreOrder(ArrayList<Edge>[] graph, int src, boolean[] vis, String path, int wtf){
        System.out.println(src);
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.v])
                printPreOrder(graph,e.v,vis,path,wtf);
        }
        vis[src] = false;
    }

    public static void main(String[] args){
        int N = 7;
        ArrayList<Edge>[] graph = new ArrayList[N];
        for(int i=0;i < N; i++){
            graph[i] = new ArrayList<>();
        }
        addEdge(graph,0,1,10);
        addEdge(graph,0,3,10);
        addEdge(graph,1,2,10);
        addEdge(graph,3,2,10);
        addEdge(graph,3,4,10);
        addEdge(graph,4,5,10);
        addEdge(graph,4,6,10);
        addEdge(graph,5,6,10);
        boolean[] vis = new boolean[N];
        printPreOrder(graph,0,vis,"",0);

    }

}