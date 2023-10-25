//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends

class tuple{
    int diff;
    int first;
    int second;
    tuple(int diff,int first,int second){
        this.diff=diff;
        this.first=first;
        this.second=second;
    }
}
class Solution {
    
    int MinimumEffort(int heights[][]) {
        PriorityQueue<tuple> pq=new PriorityQueue<>((x,y)->{
            return x.diff-y.diff;
        });
        int n=heights.length;
        int m=heights[0].length;
        
        int[][] dist=new int[n][m];
        for(int[] row:dist){
            Arrays.fill(row,(int)(1e9));
        }
        dist[0][0]=0;
        pq.offer(new tuple(0,0,0));
        int[] row={-1,0,1,0};
        int[] col={0,1,0,-1};
        while(!pq.isEmpty()){
           tuple it=pq.peek();
           int d=it.diff;
           int r=it.first;
           int c=it.second;
           
           pq.remove();
           if(r==n-1 && c==m-1){
               return d;
           }
           for(int i=0;i<4;i++){
               int ro=r+row[i];
               int co=c+col[i];
               if(ro>=0 && ro<n && co>=0 && co<m){
                   int ne=Math.max(Math.abs(heights[ro][co]-heights[r][c]),d);
                   if(ne<dist[ro][co]){
                       dist[ro][co]=ne;
                       pq.offer(new tuple(ne,ro,co));
                   }
               }
           }
           
        }
        return 0;
        
    }
}