//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Tuple{
    int we;
    int first;
    int second;
    Tuple(int we,int first,int second){
        this.we=we;
        this.first=first;
        this.second=second;
    }
}

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        if(source[0]==destination[0] && source[1]==destination[1]){
            return 0;
        }
        int n=grid.length;
        int m=grid[0].length;
        int[][] distance=new int[n][m];
        for(int [] row:distance){
            Arrays.fill(row,(int)(1e9));
        }
        int[] col={-1,0,+1,0};
        int[] row={0,1,0,-1};
        Queue<Tuple> q=new LinkedList<>();
        q.offer(new Tuple(0,source[0],source[1]));
        distance[source[0]][source[1]]=0;
       while(!q.isEmpty()){
          Tuple it=q.peek();
          int dis=it.we;
          int r=it.first;
          int c=it.second;
          q.remove();
          for(int i=0;i<4;i++){
              int ncol=col[i]+c;
              int nrow=row[i]+r;
              if(ncol>=0 && ncol<m && nrow>=0 && nrow<n && grid[nrow][ncol]==1 && dis+1 < distance[nrow][ncol]){
                  distance[nrow][ncol]=dis+1;
                  
                  if(nrow==destination[0] && ncol==destination[1]){
                      return dis+1;
                  }
                  q.offer(new Tuple(dis+1,nrow,ncol));
              }
          }
          }
          return -1;
    }
}
