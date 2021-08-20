import java.util.PriorityQueue;
import java.util.ArrayList;
public class practice{
    public static class Edge{
        int v;
        int w;
        Edge(int v,int w){
            this.v = v;
            this.w = w;
        }
        public String toString() {
            return "(" + this.v + ", " + this.w + ") ";

        }
    }
    public static int N = 7;
    public static ArrayList<Edge>[] graph = new ArrayList[N];

    public static void addEdge(int u, int v, int w){
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    }

    public static int findEdge(int u, int v){
        boolean res = false;
    for(int i=0; i<graph[u].size();i++){
            Edge e = graph[u].get(i);
            if(e.v==v){
                return i;
            }
        }
        return -1;
    }

    public class pair{
        int largestwt = -(int)1e9;
        String largestpath = "";
        String smallestpath = "";
        int smallestwt = (int)1e9;

        int ceil = (int)1e9;
        int floor = -(int)1e9;
    }

    public static class pqpair{
        int wsf = 0;    
        String psf = "";

        pqpair(int wsf,String psf){
            this.wsf = wsf;
            this.psf = psf;
        }
    }

    public static PriorityQueue<pqpair> pq = new PriorityQueue<>((a,b)->{
        return a.wsf-b.wsf;
    });

    public static void allsolution(int src, int dest, boolean[] vis, pair p, String psf,int wsf,int givenwt, int k){
        if(src == dest){
            if(wsf>p.largestwt){
                 p.largestwt = wsf;
                 p.largestpath = psf+dest;
            }
            if(wsf<p.smallestwt){
                 p.smallestwt = wsf;
                 p.smallestpath = psf+dest;
            }
            if(wsf>givenwt) p.ceil = Math.min(wsf,p.ceil);
            if(wsf<givenwt) p.floor = Math.max(wsf,p.floor);
            pqpair a = new pqpair(wsf,psf+dest);
            pq.add(a);
            if(pq.size()>k){
                pq.remove();
            }
        }
        
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.v])
                allsolution(e.v,dest,vis,p,psf+src,wsf + e.w,givenwt,k);
        }

        vis[src] = false;
    }

    public static void dfs(int u,boolean[] vis){
        vis[u] = true;
        for(Edge e : graph[u]){
            if(!vis[e.v])
                dfs(e.v,vis);
        }
    }

    public static void gcc(){   // get connected component
        boolean[] vis = new boolean[N];
        int component = 0;
        for(int i=0;i<N;i++){
            if(!vis[i])){
                component++;
                dfs(i,vis);
            }
        }
        
    }

    
    
    public static void dfs(int src, boolean[] vis,StringBuilder sb) {
        vis[src] = true;
        for (Edge e : graph[src])
            if (!vis[e.v])
                dfs(e.v, vis,sb.append(e.v+", "));
    
        
   }

    public static void Graphconnectedcomp(){
            boolean[] vis = new boolean[N];
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for(int i=0;i<N;i++){
                if(!vis[i]){
                    sb.appand("[");
                    dfs(i,vis,);
                    sb.appand("]");
                }
            }
            return component == 1;
    }

    public static void removeEdge(int u,int v){
        int idx1 = findEdge(u,v);
        int idx2 = findEdge(v,u);
        graph[u].remove(idx1);
        graph[v].remove(idx2);
    }

    public static void removeVtx(int u){
        while(graph[u].size()!=0){
            Edge e = graph[u].get(graph[u].size()-1);
            removeEdge(u,e.v);
        }
    }

    public static boolean hasPath(int src, int dest, boolean[] vis){
        if(src == dest)  return true;
        
        vis[src] = true;
        boolean res = false;
        for(Edge e : graph[src]){
            if(!vis[e.v]){
                res = res || hasPath(e.v,dest,vis);
            }
        }
        return res;
    }

    public static void allPath(int src, int dest, boolean[] vis, String ans){
        if(src==dest){
            System.out.println(ans + dest);
            return;
        }
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.v])
                allPath(e.v, dest, vis, ans+src);
        }
        vis[src] = false;
    }

    public static void printpreorder(int src, int dest, boolean[] vis, String ans, int wsf){
        System.out.println(src+ " -> "+ ans + " @ "+ wsf);
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.v])
                printpreorder(e.v, dest, vis, ans+src,wsf+e.w);
        }
        vis[src] = false;
    }
    public static void printpostorder(int src, int dest, boolean[] vis, String ans, int wsf){
        
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.v])
                printpostorder(e.v, dest, vis, ans+src,wsf+e.w);
        }
        vis[src] = false;
        System.out.println(src+ " -> "+ ans + " @ "+ wsf);
    }

    public static void display(){
         for(int i=0;i<N;i++){
             System.out.println(i+ " -> " + graph[i]);//do see the function in basics
         }
    }
    
    public static void dfs(int sr,int sc,int[][] dir,int[][] mat){
        for(int d=0;d<dir.length;d++){
            int r = sr+dir[d][0];
            int c= sc + dir[d][1];
            if(r>=0&&c>=0&&r<mat.length&&c<mat[0].length&&mat[r][c]==0){
                dfs(r,c,dir,mat);
            }
        }
    }

    public static void noofisland(int[][] mat){
        n = mat.length;
        m = mat[0].length;

        int[][] dir = {(1,0),(-1,0),(0,1),(0,-1)};
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(vis==0){
                    dfs(i,j,dir,mat)
                    count++;
                }
            }
        }
        return count;
    }
    public static boolean hasPath(ArrayList<Edge>[] graph,int src, int dest, boolean[] vis){
        if(src == dest)  return true;
        
        vis[src] = true;
        boolean res = false;
        for(Edge e : graph[src]){
            if(!vis[e.v]){
                res = res || hasPath(e.v,dest,vis);
            }
        }
        return res;
    }
    public static boolean hasPath(ArrayList<Edge>[] graph ,int src, int dest){
        boolean[] vis = new boolean[graph.length];
        return hasPath(graph,src,dest,vis);
    }

    public static void haminton_dfs(int src, int osrc,int noofedges,ArrayList<Edge>[] graph,String path,boolean[] vis){
        if(noofedges==graph.length-1){
                if(hasPatha(graph,src,osrc)){
                    System.out.println(path+src+"*");
                }
                else{
                    System.out.println(path+src+".")
                }
                return;
        }
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.v])
                haminton_dfs(e.v,osrc,noofedges+1,graph,path+src,vis)
        }
        vis[src] = false;
    }

    public static void hamintonpath(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];

            haminton_dfs(0,0,0,graph,"",vis);
    }

    public static void bsf(int src, ArrayList<Edge>[] graph,boolean[] vis){
        int level = 0, cycle = 0;
        LinkedList<Integer> que = new LinkedList<>();

        while(que.size!=0){
            int size = que.size();
            while(size-->0){
                int vrtx = que.removeFirst();
                if(vis[vrtx]){
                    cycle++;
                    continue;
                }
                vis[vrtx] = true;
                for(Edge e : graph[vrtx]){
                    if(!vis[e.v])
                        que.addLast(e.v);
                }
            }
            level++;
        }
    }

    public static void bsf2(int src, ArrayList<Edge>[] graph,boolean[] vis){
        int level = 0, cycle = 0;
        LinkedList<Integer> que = new LinkedList<>();

        while(que.size!=0){
            int size = que.size();
            while(size-->0){
                int vrtx = que.removeFirst();
                for(Edge e : graph[vrtx]){
                    if(!vis[e.v]){
                        que.addLast(e.v);
                        vis[vrtx] = true;
                    }
                }
            }
            level++;
        }
    }

    public static boolean isbyparted(int src, ArrayList<Edge>[] graph){
            LinkedList<Integer> que = new LinkedList<>();
            while(que.size()!=0){
                size = que.size();
                while(size-- > 0){
                    int rvtx = que.removeFirst();
                    for(Edge e: graph[rvtx]){
                        if(vis[e.v] ==-1){
                            que.addLast(e.v);
                            if(vis(rvtx)==0)
                                vis[e.v] = 1;
                            else
                                vis[e.v] = 0;
                        }
                        else if(vis[e.v]==vis[rvtx])
                            return false;
                    }
                }
            }
    }

    public static void main(String [] args){
        for(int i=0;i<N;i++){
            graph[i] = new ArrayList();
        }
        addEdge(0, 1, 10);
        addEdge(0, 3, 10);
        addEdge(1, 2, 10);
        addEdge(2, 3, 10);
        addEdge(3, 4, 10);
        addEdge(4, 5, 10);
        addEdge(4, 6, 10);
        addEdge(5, 6, 10);
        //removeVtx(1);
        boolean[] vis = new boolean[N];
        //System.out.println(hasPath(0,6,vis));
        // allPath(0,6,vis,"");
        printpreorder(0,6,vis,"",0);
        display();
    }
}