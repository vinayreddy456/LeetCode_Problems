class Solution {
    public int mySqrt(int x) {
       int left=1,right=x,ans=0;
       while(left<=right){
           int mid=left+(right-left)/2;
           if(mid<=x/mid){
              ans=(int)mid;
              left=(int)mid+1;
           }
           else{
               right=(int)mid-1;

           }
          
       } 
       return ans;
    }
}