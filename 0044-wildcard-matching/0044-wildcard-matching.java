class Solution {
    boolean isAllStars(String S1, int i) {
    for (int j = 0; j <= i; j++) {
      if (S1.charAt(j) != '*')
        return false;
    }
    return true;
  }
    boolean solve(String s,String p,int r,int l,Boolean[][] dp){
        if(l<0 && r<0){
            return true;
        }
        if(l<0 && r>=0){
            return false;
        }
        if(r<0 && l>=0){
         //   System.out.println("lll");
            return isAllStars(p, l);
        }   
        if(dp[r][l]!=null){
            return dp[r][l];
        }
        if(s.charAt(r)==p.charAt(l) || p.charAt(l)=='?'){
           //  System.out.println("lll");
            return dp[r][l]=solve(s,p,r-1,l-1,dp);
        }
        else{
            if(p.charAt(l)=='*'){
           //     System.out.println(r);
                return dp[r][l]=(solve(s,p,r-1,l,dp) || solve(s,p,r,l-1,dp));
            }
            else{
                return false;
            }
        }
        
    }
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        Boolean[][] dp=new Boolean[n][m];
        boolean x=solve(s,p,n-1,m-1,dp);
        return x;
    }
}