class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int i=0,j=1;
        for( i=0,j=1;i<nums.length-1;i++){
            if(nums[i]<0||nums[i]==nums[i+1]|| nums[i]==0){
                continue;
            }
            if(nums[i]==j){
                j++;
                continue;
            }
            else{
                break;
            }
        }
        if(i==nums.length-1){
            if(nums[i]==j)j++;
        }
        return j;
    }
}