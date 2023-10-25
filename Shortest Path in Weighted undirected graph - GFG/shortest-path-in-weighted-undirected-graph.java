//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int node;
    int distance;
    Pair(int distance,int node){
        this.node=node;
        this.distance=distance;
    }
}
class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        ArrayList<ArrayList<Pair>> al=new ArrayList<>();
        for(int i=0;i<=n;i++){
            al.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            al.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            al.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->{
            return x.distance-y.distance;
        });
        int[] distance=new int[n+1];
       // Arrays.fill(distance,(int)(1e9));
        int[] parent=new int[n+1];
       for(int i=1;i<=n;i++){
           parent[i]=i;
           distance[i]=(int)(1e9);
       }
        distance[1]=0;
      //  parent[1]=1;
        pq.offer(new Pair(0,1));
        while(!pq.isEmpty()){
            int no=pq.peek().node;
            int dis=pq.peek().distance;
            pq.remove();
            for(Pair k:al.get(no))
            {
                int nodej=k.distance;
                int disj=k.node;
               if(dis+disj<distance[nodej]){
                   distance[nodej]=dis+disj;
                    pq.add(new Pair(dis+disj,nodej));
                   parent[nodej]=no;
                  
               }
            }
        }
        List<Integer> res=new ArrayList<>();
        if(distance[n]==(int)(1e9)){
           res.add(-1);
           return res;
        }
       int node = n;
        // o(N)
        while(parent[node] != node) {
        res.add(node); 
            node = parent[node]; 
        }
        res.add(1); 
        Collections.reverse(res); 
        return res;
        
    }
}