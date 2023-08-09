class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        int start=0;
        int astart=-1,end=-1;
        for(int i=0;i<nums.length;i++){
            if(sum==0){
                start=i;
            }
            sum+=nums[i];
            if(sum<0){
                max=Math.max(max,nums[i]);
                sum=0;
            }
            else{
                max=Math.max(max,sum);
                astart=start;
                end=i;
            }
        }
      //  return end-astart+1;
      return max;
    }
}