import java.util.ArrayList;

public class algo {
        public static class Edge{
        int v = 0, w = 0;
        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w) {
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }

    public static void display(ArrayList<Edge>[] graph) {
        int N = graph.length;
        for(int i = 0; i < N; i++) {
            System.out.print(i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print("(" + e.v + ", " + e.w + ") ");
            }
        }
        System.out.println();
    }
 
    static int[] par, size;

    public static int findPar (int u) {
        if (par[u] == u)
            return u;
        return par[u] = findPar(par[u]);

        // return par[u] == u ? u : (par[u] = findPar(par[u]));
    }

    public static void union (int p1, int p2) {
        if (size[p1] < size[p2]) {
            par[p1] = p2;
            size[p2] += size[p1];
        } else {
            par[p2] = p1;
            size[p1] += size[p2];
        }
    }

    // {{u1, v1, w1}, {u2, v2, w2}, ...}    // O(E + V) if we consider path compression in O(1) else O()
    public static void unionFind (int[][] edges, ArrayList<Edge>[] graph) {
        int N = edges.length;
        par = new int[N];
        size = new int[N];

        for (int i = 0; i < N; i++) {
            par[i] = i;
            size[i] = 1;
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            int p1 = findPar(u);
            int p2 = findPar(v);

            if (p1 != p2) {
                union(p1, p2);
                addEdge(graph, u, v, w);
            }
        }
    }

    public static void kruskalAlgo(int[][] edges) {
        Arrays.sort(edges, (a,b) -> {
            return a[2] - b[2];
        });

        int N = edges.length;
        ArrayList<Edge>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();

        unionFind(edges, graph);
    }

    // Articulation point
    static int[] low, disc;
    static boolean[] articulation, vis;
    static int time = 0, rootCalls = 0;

    public static void dfs(ArrayList<Edge>[] graph, int src, int par) {
        disc[src] = low[src] = time++;
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v]) {
                if (par == -1)
                    rootCalls++;

                dfs(graph, e.v, src);
                if (disc[src] <= low[e.v])
                    articulation[src] = true;
                if (disc[src] < low[e.v])
                    System.out.println("Articulation Edge: " + src + "->" + e.v);

                low[src] = Math.min(low[src], low[e.v]);

            } else if (e.v != par) {
                low[src] = Math.min(low[src], disc[e.v]);
            }

        }

    }

    public static void articulationPointAndBridges(ArrayList<Edge>[] graph) {
        int N = graph.length;
        low = new int[N];
        disc = new int[N];
        articulation = new boolean[N];
        vis = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1);
            }
        }
    }



    public static class pair{
        int vtx, par, w, wsf;

        pair(){
            
        }
    }

    
}