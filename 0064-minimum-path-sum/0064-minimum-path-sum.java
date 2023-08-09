class Solution {
    int solve(int i,int j,int m,int n,int[][] dp,int [][] grid){
        if(i==m-1 && j==n-1){
            return grid[i][j];
        }
        if(i>=m || j>=n){
            return (int)Math.pow(10,9);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int bottom=solve(i+1,j,m,n,dp,grid)+grid[i][j];
        int right=solve(i,j+1,m,n,dp,grid)+grid[i][j];
        return dp[i][j]=Math.min(bottom,right);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        int x=solve(0,0,m,n,dp,grid);
        return x;
    }
}