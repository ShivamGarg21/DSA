import java.util.ArrayList;

public class basics {

    public static class Edge {
        int v = 0;
        int w = 0;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public String toString() {
            return "(" + this.v + ", " + this.w + ") ";

        }
    }

    public static int N = 7;
    public static ArrayList<Edge>[] graph = new ArrayList[N];

    public static void addEdge(int u, int v, int w) {
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }

    public static void display() {
        for (int i = 0; i < N; i++) {
            System.out.print(i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print(e);
            }
            System.out.println();
        }
    }

    public static int findEdge(int u, int v) {
        for (int i = 0; i < graph[u].size(); i++) {
            Edge e = graph[u].get(i);
            if (e.v == v)
                return i;
        }

        return -1;
    }

    public static void removeEdge(int u, int v) {
        int idx1 = findEdge(u, v);
        int idx2 = findEdge(v, u);

        // if (idx1 == -1 || idx2 == -1)
        // return;

        graph[u].remove(idx1);
        graph[v].remove(idx2);
    }

    public static void removeVtx(int u) {

        while (graph[u].size() != 0) {
            int n = graph[u].size();
            Edge e = graph[u].get(n - 1);
            removeEdge(u, e.v);
        }
    }

    // public static boolean hasPath(int src, int dest, boolean[] vis) {
    //     if (src == dest) {
    //         return true;
    //     }

    //     boolean res = false;
    //     vis[src] = true;
    //     for (Edge e : graph[src]) {
    //         if (!vis[e.v])
    //             res = res || hasPath(e.v, dest, vis);
    //     }

    //     return res;
    // }

    // public static void allPath(int src, int dest, boolean[] vis,String ans) {
    //     if (src == dest) {
    //         System.out.println(ans+dest);
    //         return;
    //     }
    //     vis[src] = true;
    //     for (Edge e : graph[src]) {
    //         if (!vis[e.v])
    //             hasPath(e.v, dest, vis,ans+src);
    //     }
    //     vis[src] = false;
    // }

    public static void printpreorder(int src, int dest, boolean[] vis,String path,int wsf) {
            System.out.println(src + "-> " +path + " @ " + wsf);
        
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                printpreorder(e.v, dest, vis,path+src,wsf+e.w);
        }
        vis[src] = false;
    }

    public static void dfs(int src, boolean[] vis) {
        vis[src] = true;
        for (Edge e : graph[src])
            if (!vis[e.v])
                dfs(e.v, vis);
    }

    public static boolean isGraphconnected(){
            boolean[] vis = new boolean[N];
            int component = 0;
            for(int i=0;i<N;i++){
                if(!vis[i]){
                    dfs(i,vis);
                    component++;
                }
            }
            return component == 1;
    }

    public static void isisland(int[][] mat,int[][] dir, int i, int j){
        mat[i][j] = 1;      // bcoz 1 is ocean
        for(d=0;i<4;d++){
            int r = dir[d][0];
            int c = dir[d][1];

            if(r>=0 && c>=0 && r<mat.length && c<mat[0].length && mat[r][c]==0){
                isisland(mat,dir,r,c);
            }

        }

    }

    public static int countisland(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        
        int count=0;

        int dir = {(1,0),(-1,0),(0,1),(0,-1)};

        for(int i=0;i<n;i++){
            for(int j=0;i<m;i++){
                if(mat[i][j]==0){
                    isisland(mat,dir,i,j);
                    count++;
                }
            }
        }
        return count;

    }

        public static void hamintonian_dfs(int src, int os, boolean[] vis, int NoOfEdges, String psf) {
        if (NoOfEdges == N - 1) {
            System.out.print(psf + src);
            int idx = findEdge(src, os);
            if (idx != -1)
                System.out.print("*");

            System.out.println();
            return;
        }

        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                hamintonian_dfs(e.v, os, vis, NoOfEdges + 1, psf + src);
        }

        vis[src] = false;
    }

    public static void hamintonianPath() {
        boolean[] vis = new boolean[N];
        hamintonian_dfs(0, 0, vis, 0, "");
    }

    // Moon problem

    public static int moonDFS(ArrayList<Integer>[] graph, int src, boolean[] vis) {
        vis[src] = true;
        int size = 0;
        for (Integer e : graph[src]) {
            if (!vis[e])
                size += moonDFS(graph, e, vis);
        }

        return size + 1;
    }

    public static int journeyToMoon(int n, int[][] astronaut) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] a : astronaut) {
            graph[a[0]].add(a[1]);
            graph[a[1]].add(a[0]);
        }

        ArrayList<Integer> sizeArray = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i])
                sizeArray.add(moonDFS(graph, i, vis));
        }

    }


    public static void main(String[] args) {
        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();
        addEdge(0, 1, 10);
        addEdge(0, 3, 10);
        addEdge(1, 2, 10);
        addEdge(2, 3, 10);
        addEdge(3, 4, 10);
        addEdge(4, 5, 10);
        addEdge(4, 6, 10);
        addEdge(5, 6, 10);

        // display();
        boolean[] vis = new boolean[N];
        //System.out.println(hasPath(0, 6, vis,""));
        printpreorder(0,6,vis,"",0);
    }

}