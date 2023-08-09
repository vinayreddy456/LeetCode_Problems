class Solution {
    public int[] searchRange(int[] nums, int target) {
       int left=binary( nums,target);
       int right=binaryright( nums, target);
       return new int[] {left,right};
    }
    int binary(int[] nums,int target){
         int low=0,high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                  ans=mid;
                  high=mid-1;
            }
            else if(nums[mid]<target){
                 low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
    int binaryright(int[] nums,int target){
         int low=0,high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                  ans=mid;
                  low=mid+1;
            }
            else if(nums[mid]<target){
                 low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}