class Solution {
    int solve(int i,int j,int m,int n,int[][] dp,int[][] grid){
        if(i<=m-1&& j<=n-1 && grid[i][j]==1){
            return 0;
        }
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i>=m || j>=n){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int bottom=solve(i+1,j,m,n,dp,grid);
        int right=solve(i,j+1,m,n,dp,grid);
        return dp[i][j]=bottom+right;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        int x=solve(0,0,m,n,dp,obstacleGrid);
        return x;
    }
}