class Solution {
    public int reverse(int x) {
      /*  int sum=0,p=x;
        if(x<0){
            x=x*-1;
            while(x>0){
                int rem=x%10;
                sum=rem+sum*10;
                x=x/10;

            }
          //  return -sum;
          //1534236469
        }
        else{
             while(x>0){
                int rem=x%10;
                sum=rem+sum*10;
                if(sum>=(Math.pow(2,31)-1)|| sum<(Math.pow(-2,31))) return 0;
                x=x/10;

            }
          //  return sum;

        }
        if(sum>=(Math.pow(2,31)-1)) return 0;
        
        return p<0?-sum:sum;*/
        String s = String.valueOf(Math.abs(x));
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        s = sb.toString();
        if(x < 0)
            s = "-"+s;
        try
        {
             x = Integer.parseInt(s);
        }
        catch(Exception e)
        {
            return 0;
        }
        return x;
       
    }
}